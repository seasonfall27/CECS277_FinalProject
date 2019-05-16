import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class CheckOutFrame extends JFrame{

	protected JList list;
	protected ListModel listModel;
	protected JButton cancel;
	protected JButton checkOut;
	final int FIELD_WIDTH = 20;
	protected JTextField damageDescription = new JTextField (FIELD_WIDTH);
	protected JTextField damageCost = new JTextField (FIELD_WIDTH);
	protected JLabel damageDescriptionLable;
	protected JLabel damageCostLable;
	ReservationCalendar calendar;
	public static ArrayList<String> names;
	
	
	public CheckOutFrame (ReservationCalendar calendar) {
		this.calendar = calendar;
		createComponents ();
		
		this.setTitle("Guest List");
		this.setSize(500, 350);
		//hides the frame without terminating 
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void createComponents () {
	
	/*
	 * this listModel whatever names you want to have in the frame
	 * it can take in Guest objects if needed
	 */
	listModel = new DefaultListModel ();
	names = new ArrayList <String> ();

	for(String name: names)
	{
		((DefaultListModel) listModel).addElement(name);
	}
	
    
    cancel = new JButton ("Cancel");
    ActionListener cancelListener = new CancelButtonListener ();
    cancel.addActionListener(cancelListener);
   
    
    checkOut = new JButton ("Check Out");
    ActionListener checkOutListener = new CheckOutButtonListener ();
    checkOut.addActionListener(checkOutListener);
    
    damageDescriptionLable = new JLabel ("Damage Description:");
    damageCostLable = new JLabel ("Damage Cost:");
    
    
    
	list = new JList(listModel); //data has type Object[]
	list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	list.setLayoutOrientation(JList.VERTICAL);
	list.setVisibleRowCount(-1);
	JScrollPane listScroller = new JScrollPane(list);
	listScroller.setPreferredSize(new Dimension(350, 300));
	
	
	
	JPanel panel = new JPanel ();
	panel.add(listScroller);
	panel.add(checkOut);
	panel.add(cancel);
	panel.add(damageDescriptionLable);
	panel.add(damageDescription);
	panel.add(damageCostLable);
	panel.add(damageCost);
	this.add(panel);
	}
	
	
	class CheckOutButtonListener implements ActionListener 
	{
		public void actionPerformed (ActionEvent click)
		{
	        JOptionPane.showMessageDialog(null, "You Are Checked Out!","Message", JOptionPane.PLAIN_MESSAGE);
	        /*
	         * take out in the checked list 
	         * saves the description of damage and cost 
	         * opens a new final invoice
	         */
	        FinalInvoiceFrame f = new FinalInvoiceFrame(null);
			f.setVisible(true);

		}
	}
	class CancelButtonListener implements ActionListener 
	{
		public void actionPerformed (ActionEvent click)
		{
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.dispose();
		}
	}
}

