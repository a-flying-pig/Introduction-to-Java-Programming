package chapter30_web;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame {
	
	private JTextArea jta = new JTextArea();

	public static void main(String[] args) {
		new Server();
	}
	
	public Server() {
		setLayout(new BorderLayout());
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		setTitle("Server");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("Server started at " + new Date() + '\n');
			System.out.println("Server " + "new ServerSocket(8000) ");
			// Listen for a connection request
			Socket socket = serverSocket.accept();
			System.out.println("Server " + "serverSocket.accept() ");
			System.out.println("Server " + "serverSocket.accept() client's IP address is  "
			+ socket.getInetAddress());
			System.out.println("Server " + "serverSocket.accept() client's host name is  "
			+ socket.getInetAddress().getHostName());
			System.out.println("Server " + "serverSocket.accept() client's host address is  "
			+ socket.getInetAddress().getHostAddress());
			// Create data input and output streams
			DataInputStream inputFromClient = new DataInputStream(
					socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());
			while (true) {
				System.out.println("Server " + "while (true) ");
				// Receive radius from the client
				double radius = inputFromClient.readDouble();
				System.out.println("Server " + "inputFromClient.readDouble() radius == " + radius);
				// Compute area
				double area = radius * radius * Math.PI;
				System.out.println("Server " + "outputToClient.writeDouble(area); area == " + radius);
				// Send area back to the client
				outputToClient.writeDouble(area);
				
				jta.append("Radius received from client: " + radius + '\n');
				jta.append("Area found: " + area + '\n');
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
