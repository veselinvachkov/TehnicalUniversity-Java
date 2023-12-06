package TU_Java.Server_Client.week_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) {

        int port = 1234;
        ServerSocket serverSocket = null;
        Socket connection = null;
        Scanner socketIn = null;
        PrintWriter socketOut = null;
        try {
            serverSocket = new ServerSocket(port);

            while (true) {

                System.out.println("Сървърът очаква свързване...");
                connection = serverSocket.accept();

                System.out.println("Свърза се клиент: " + connection.getInetAddress().getHostName());
                System.out.println("Подавам съобщение на клиента...");
                socketOut = new PrintWriter(connection.getOutputStream(), true);
                System.out.println("Сървърът очаква подаване на съобщение...");
                socketOut.println("Въведете вашето съобщение");

                socketIn = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));

                String message = null;
                do {
                    socketOut.flush();
                    message = socketIn.nextLine();
                    System.out.println("Клиентът изпрати съобщение: " + message);

                    String response = "Вие казахте: " + message;
                    socketOut.println(response);

                } while (!message.equalsIgnoreCase("exit"));
                System.out.println("Затварям връзката с " + connection.getInetAddress().getHostName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socketIn != null)
                    socketIn.close();
                if (socketOut != null)
                    socketOut.close();
                if (connection != null)
                    connection.close();
            } catch (IOException e) {
                System.err.println("Не може да бъде затворен сокет");
            }
        }
    }
}