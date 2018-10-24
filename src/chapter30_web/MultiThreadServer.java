package chapter30_web;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MultiThreadServer extends JFrame {
	
	private JTextArea jta = new JTextArea();
	
	public static void main(String[] args) {
		new MultiThreadServer();
	}
	
	public MultiThreadServer() {
		// Place text area on the frame
		setLayout(new BorderLayout());
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		setTitle("MultiThreadServer");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // It is necessary to show the frame here
		
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("MultiThreadServer started at " + new Date() + '\n');
			
			// Number a client
			int clientNu = 1;
			
			while (true) {
				// Listen for a new connection request
				System.out.println("Server " + " while (true)");
				Socket socket = serverSocket.accept();
				System.out.println("Server " + " serverSocket.accept() " 
				  + "accepted renote port number" + socket.getPort());
				
				// Display the client number
				jta.append("Starting thread for client " + clientNu 
				  + " at " + new Date() + '\n');
				
				// Find the client's host name, and IP address
				InetAddress inetAddress = socket.getInetAddress();
				jta.append("Client " + clientNu + "'s host name is "
				  + inetAddress.getHostName());
				jta.append("Client " + clientNu + "'s host IP address is "
				  + inetAddress.getHostAddress());
				
				// Create a new thread for the connection
				HandleAClient task = new HandleAClient(socket);
				
				// Start the new thread
				new Thread(task).start();
				
				// Increment clienNu
				clientNu++;
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	// Inner class
	// Define the thread class for handling new connection
	class HandleAClient implements Runnable {
		private Socket socket;
		
		public HandleAClient(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
						socket.getOutputStream());
				
				// Continuously serve the client
				while (true) {
					System.out.println("server handleAClient " + "while (true)");
					double radius = inputFromClient.readDouble();
					System.out.println("server handleAClient " 
					  + "inputFromClient.readDouble() radius:" + radius);
					double area = radius * radius * Math.PI;
					
					outputToClient.writeDouble(area);
					
					jta.append("radius received from client:" + radius + '\n');
					jta.append("Area found: " + area + '\n');
				}
			} catch (IOException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}
		
	}
}
