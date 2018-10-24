package chapter30_web;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.net.Socket;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppletClient extends JApplet {
	
	private JLabel jlblCount = new JLabel();
	
	// Indicate if it runs as application
	private boolean isStandAlone = false;
	
	// Host name or ip
	private String host = "localhost";
	
	// Initialize the applet
	public void init() {
		add(jlblCount);
		
		try {
			// Create a socket to connect to the server
			Socket socket;
			if (isStandAlone) {
				socket = new Socket(host, 8000);
				System.out.println("AppletClient " + " socket = new Socket(host, 8000);");
			}
			else {
				socket = new Socket(getCodeBase().getHost(), 8000);
				System.out.println("AppletClient " + " socket = new Socket(getCodeBase().getHost(), 8000)");
			}
			
			DataInputStream inputFromServer =
					new DataInputStream(socket.getInputStream());
			
			int count = inputFromServer.readInt();
			jlblCount.setText("You are visitor number " + count);
			
			inputFromServer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Applet Client");
		
		AppletClient applet = new AppletClient();
		applet.isStandAlone = true;
		
		if (args.length == 1) {
			applet.host = args[0];		
		}
		
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		
		applet.init();
		applet.start();
		
		frame.pack();
		frame.setVisible(true);;
	}
}
