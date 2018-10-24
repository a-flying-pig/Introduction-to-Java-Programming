package chapter30_web;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.View;

public class WebBrowser extends JApplet {
	// JEditor pane to view HTML files
	private JEditorPane jep = new JEditorPane();
	
	private JLabel jLabel = new JLabel("URL");
	
	private JTextField jtfURL = new JTextField();
	
	
	@Override
	/** Initialize the applet */
	public void init() {
		JPanel jpURL = new JPanel();
		jpURL.setLayout(new BorderLayout());
		jpURL.add(jLabel, BorderLayout.WEST);
		jpURL.add(jtfURL, BorderLayout.CENTER);
		
		add(new JScrollPane(jspViewer), BorderLayout.CENTER);
		add(jpURL, BorderLayout.NORTH);
		
		jep.setEditable(false);
		
		jep.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				// TODO Auto-generated method stub
				try {
					jep.setPage(e.getURL());
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
			}
		});
		jtfURL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL(jtfURL.getText().trim());
					
					jep.setPage(url);
				} catch (Exception ex) {
					// TODO: handle exception
					System.out.println(ex);
				}
			}
		});
		
	}
 
}
