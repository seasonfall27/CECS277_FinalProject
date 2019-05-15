
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FinalInvoiceFrame extends JFrame {
	
	protected JButton close ;
	protected JTextArea textArea;
	protected JScrollPane scroll;
	protected JPanel panel = new JPanel ();
	Reservation r;
	
	public FinalInvoiceFrame (Reservation r) {
		this.r = r;
		
		createComponents ();
		this.setTitle("Final Invoice");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
	}
	public void createComponents () 
	{
		close = new JButton("Close");
		ActionListener closeListener = new CloseButtonListener ();
		close.addActionListener(closeListener);
		
		textArea = new JTextArea (20,50);
		scroll = new JScrollPane (textArea);
		
		panel.add(scroll);
		panel.add(close);
		this.add(panel);
	}
	
	class CloseButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.dispose();
		}
	}
	
}
