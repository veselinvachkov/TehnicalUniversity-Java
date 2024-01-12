package TU_Java.Exam2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Server {
    private ServerSocket server;
    private final List<Regex> regexList = Collections.synchronizedList(new ArrayList<>());


    public void start(){
        try {
            server = new ServerSocket(2025);

            while (true){
                Socket client = server.accept();
                Thread clientThread = new Thread(() ->
                {
                    Scanner sc = null;
                    PrintStream out = null;
                    try {
                        sc = new Scanner(client.getInputStream());
                        out = new PrintStream(client.getOutputStream());
                        out.println("Hello");
                        userMenu(sc, out);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        if (sc != null) {
                            sc.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                    }
                });
                clientThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void userMenu(Scanner sc, PrintStream out) {
        while (true) {
            synchronized (regexList) {
                out.println("Type to create a regex / Type to search a regex in file");
                String command = sc.nextLine();
                if (command.equalsIgnoreCase("create")) {
                    String pattern = sc.nextLine();
                    String description = sc.nextLine();
                    Regex regex = new Regex(pattern, description);
                    String[] textToTest = sc.nextLine().split("\n");

                    List<Boolean> testResults = RegexTester.test(regex, textToTest);
                    for (boolean test : testResults) {
                        out.printf("%s, ", test);
                    }

                    out.println();
                    out.println("To create the regex type YES");
                    String commandToCreate = sc.nextLine();
                    if (commandToCreate.equalsIgnoreCase("yes")) {
                        regexList.add(regex);
                        saveRegexToFile(regexList);
                    }
                    break;

                } else if (command.equalsIgnoreCase("search")) {
                    String keyWord = sc.nextLine();
                    List<Regex> keyWordRegex = new ArrayList<>(regexList.stream()
                            .filter(regex -> regex.getDescription().contains(keyWord))
                            .toList());
                    keyWordRegex.sort((d1, d2) -> Integer.compare(d2.getRating(), d1.getRating()));
                    for (Regex wordRegex : keyWordRegex) {
                        out.println(wordRegex.toString());
                    }

                    int clientIdChoice = sc.nextInt();
                    Regex chosenRegex = keyWordRegex.get(clientIdChoice);
                    String[] textToTest = sc.nextLine().split("\n");
                    List<Boolean> testResults = RegexTester.test(chosenRegex, textToTest);
                    for (boolean test : testResults) {
                        out.printf("%s, ", test);
                    }

                    out.println("Do you want to change the rating? Type + or -");
                    String ratingChange = sc.nextLine();
                    if (ratingChange.equals("+")) {
                        chosenRegex.setRating(chosenRegex.getRating() + 1);
                    } else if (ratingChange.equals("-")) {
                        chosenRegex.setRating(chosenRegex.getRating() - 1);
                    }

                    regexList.add(chosenRegex);
                    saveRegexToFile(regexList);
                    break;
                } else {
                    out.println("Wrong input");
                }
            }
        }
    }


    public List<Regex> checkIfRegexExists(List<Regex> regexList) {
        synchronized (regexList) {
            List<Regex> existingRegexList = readRegexFromFile();
            if (existingRegexList != null) {
                for (Regex regex : regexList) {
                    if (!existingRegexList.contains(regex)) {
                        existingRegexList.add(regex);
                    }
                }
            }
            return existingRegexList;
        }
    }


    private void saveRegexToFile(List<Regex> regexList) {
        synchronized (regexList) {
            List<Regex> existingRegexList = checkIfRegexExists(regexList);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("regex.bin"))) {
                out.writeObject(existingRegexList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private List<Regex> readRegexFromFile(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("regex.bin"))){
            return (List<Regex>) in.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
