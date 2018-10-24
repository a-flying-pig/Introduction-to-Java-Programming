package chapter30_web;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewRemoteFile extends JApplet {

	// Button to view the file
	private JButton jbtView = new JButton("View");
	
	// Text field to receive file name 
	private JTextField jtfURL = new JTextField(12);
	
	// Text area to store file 
	private JTextArea jtaFile = new JTextArea();
	
	// Label to display status
	private JLabel jlblStatus = new JLabel();
	
	@Override
	public void init() {
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Filename"), BorderLayout.WEST);
		p1.add(jtfURL, BorderLayout.CENTER);
		p1.add(jbtView, BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(jtaFile), BorderLayout.CENTER);
		add(p1, BorderLayout.NORTH);
		add(jlblStatus, BorderLayout.SOUTH);
		
		jbtView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showFile();
			}
		});
	}
	
	private void showFile() {
		Scanner input = null; // Use scanner for text input
		URL url = null;
		
		try {
			// Obtain URL from the text field
			url = new URL(jtfURL.getText().trim());
			
			// Create a Scanner for input stream
			input = new Scanner(url.openStream());
			
			// Read a line and append the line to the text area
			while (input.hasNext()) {
				jtaFile.append(input.nextLine() + "\n");
			}
			
			jlblStatus.setText("File loaded successfully");
		} catch (Exception e) {
			// TODO: handle exception
			jlblStatus.setText("URL " + url + " not found.");
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
