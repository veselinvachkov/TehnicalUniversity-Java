package TU_Java.Exam3;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class QuizClient {
    private static final String SERVER_IP = "172.20.10.3";
    private static final int SERVER_PORT = 3033;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner consoleInput = new Scanner(System.in);

            System.out.println(in.nextLine());  // Welcome message from the server

            System.out.println("Enter your EGN:");
            int egn = consoleInput.nextInt();
            out.println(egn);

            System.out.println("Enter your Faculty Number:");
            int facultyNumber = consoleInput.nextInt();
            out.println(facultyNumber);

            System.out.println("Quiz in progress...");

            while (in.hasNextLine()) {
                String serverMessage = in.nextLine();
                System.out.println(serverMessage);

                if (serverMessage.equals("Quiz completed!")) {
                    break;
                }

                if (serverMessage.equals("Enter your answers in the format: id answer (e.g., 1 A)")) {
                    String clientAnswer = consoleInput.nextLine();
                    out.println(clientAnswer);
                }
            }

            System.out.println(in.nextLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
