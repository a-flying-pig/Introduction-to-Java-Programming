package chapter30_web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
	
	private ObjectOutputStream outputToFile;
	private ObjectInputStream inputFromClient;
	
	public static void main(String[] args) {
		new StudentServer();
	}

	public StudentServer() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server started");
			
			// Create an object output stream
			outputToFile = new ObjectOutputStream(
					new FileOutputStream("student.dat", true));
			System.out.println("Create an object output stream");
			while (true) {
				System.out.println("while (true)");
				// Listen for a new connection request
				Socket socket = serverSocket.accept();
				System.out.println("serverSocket.accept();");
				
				// Create an input stream from the socket
				inputFromClient =
						new ObjectInputStream(socket.getInputStream());
				
				// Read from input
				Object object = inputFromClient.readObject();
				
				// Write to the file 
				outputToFile.writeObject(object);
				System.out.println("A new student object is stored");
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				inputFromClient.close();
				outputToFile.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
