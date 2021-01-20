package Lesson2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    private boolean running;
    //private ExecutorService executorService;
    private ConcurrentLinkedDeque<SerialHandler> clients = new ConcurrentLinkedDeque<>();

    public EchoServer() {
        // web 8080
        running = true;
        try(ServerSocket server = new ServerSocket(8180)) {
            while (running) {
                System.out.println("Server is waiting connection");
                Socket socket = server.accept();
                SerialHandler handler = new SerialHandler(socket, this);
                clients.add(handler);
                //new Thread(handler).start();
                ExecutorService executorService = Executors.newFixedThreadPool(1);
                executorService.execute(handler);

                System.out.println("Client info: " + socket.getInetAddress());
            }
        } catch (Exception e) {
            System.out.println("Server crashed");
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void broadCast(Message msg) throws IOException {
        for (SerialHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public void sendMessageTo(String from, String nick, String message) throws IOException {
        for (SerialHandler client : clients) {
            if (client.getUserName().equals(nick)) {
                client.sendMessage(Message.of(from, message));
            }
        }
    }

    public void kickMe(SerialHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        new EchoServer();
    }
}