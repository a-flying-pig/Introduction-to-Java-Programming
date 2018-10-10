package chapter30_web;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {
	
	private JTextField jtf = new JTextField();
	
	private JTextArea jta = new JTextArea();
	
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	
	public static void main(String[] args) {
		new Client();
	}
	
	public Client() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Enter radius"), BorderLayout.WEST);
		p.add(jtf, BorderLayout.CENTER);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		System.out.println("Client " + " jtf.addActionListener(new TextFieldListener()) ");
		jtf.addActionListener(new TextFieldListener());
		
		setTitle("Client");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // It is necessary to show the frame here!
		
/*		try {
			// Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);
		    
			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(
					socket.getInputStream());
			
			// Create an output stream to send data to the server
			toServer = new DataOutputStream(
					socket.getOutputStream());
			System.out.println("Client " + " get fromServer and  toServer  ");
		} catch (IOException e) {
			// TODO: handle exception
			jta.append(e.toString() + '\n');
		}*/
		
	}

	private class TextFieldListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				// Create a socket to connect to the server
				Socket socket = new Socket("localhost", 8000);
			    
				// Create an input stream to receive data from the server
				fromServer = new DataInputStream(
						socket.getInputStream());
				
				// Create an output stream to send data to the server
				toServer = new DataOutputStream(
						socket.getOutputStream());
				System.out.println("Client " + " get fromServer and  toServer  ");
			} catch (IOException e1) {
				// TODO: handle exception
				jta.append(e1.toString() + '\n');
			}
			
			try {
				// Get the radius from the text field
				double radius = Double.parseDouble(jtf.getText().trim());
				
				// Send the radius to the server
				System.out.println("Client " + " toServer.writeDouble(radius); rdius == " + radius);
				toServer.writeDouble(radius);
				toServer.flush();
				
				// Get area from the server
				double area = fromServer.readDouble();
				System.out.println("Client " + " fromServer.readDouble() area == " + area);
				// Display to the text area
				jta.append("Radius is " + radius + '\n');
				jta.append("Area reveived from the server is " 
				  + area + '\n');
				
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
	}
}
