package reactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Client {

  private final String hostIp;

  private final int hostPort;

  public void run() throws IOException {

    try (
      Socket clientSocket = new Socket(hostIp, hostPort);
      PrintWriter out =  new PrintWriter(clientSocket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
    ) {

      System.out.println("Client connected to host : " + hostIp + " port: " + hostPort);
      System.out.println("Say to the Server.....(\"exit\" to quit)");

      String userInput;

      while (Objects.nonNull((userInput = stdIn.readLine()))) {

        out.println(userInput);

        // Break when client says Bye.
        if (userInput.equalsIgnoreCase("exit"))
          break;

        System.out.println("Server says: " + in.readLine());
      }

    } catch (UnknownHostException e) {
      System.err.println("Unknown host: " + hostIp);
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't connect to: " + hostIp);
      System.exit(1);
    }
  }

}
