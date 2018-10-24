package chapter30_web;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

public class CountServer {
	private RandomAccessFile raf;
	private int count; // Count the access to the server
	
	public static void main(String[] args) {
		new CountServer();
	}
	
	public CountServer() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("CountServer started");
			
			// Creaete or open the count file
			raf = new RandomAccessFile("count.dat", "rw");
			
			// Get the count
			if (raf.length() == 0) 
				count = 0;
			else
				count = raf.readInt();
			
			while (true) {
				// Listen for a new connection request
				System.out.println("CountServer " + " while (true)" );
				Socket socket = serverSocket.accept();
				System.out.println("CountServer " + "serverSocket.accept()" );
				
				// Create a DataOutputStream for the socket
				DataOutputStream outputToClient = 
						new DataOutputStream(socket.getOutputStream());
				// Increase count and send the count to the client
				count++;
				outputToClient.writeInt(count);
				
				// Write new count back to the file
				raf.seek(0);
				raf.writeInt(count);
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
}
