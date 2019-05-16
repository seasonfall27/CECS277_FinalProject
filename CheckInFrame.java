import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class CheckInFrame extends JFrame{

	protected JList list;
	protected ListModel listModel;
	protected JButton cancel;
	protected JButton checkIn;
	ReservationCalendar calendar;
	public static ArrayList<String> names;
	
	public CheckInFrame (ReservationCalendar calendar) {
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
   
    checkIn = new JButton ("Check In");
    ActionListener checkInListener = new CheckInButtonListener ();
    checkIn.addActionListener(checkInListener);
    
    /*
     * for(int i = 0 ; i <calendar.size()-1; i++){
     * 	calendar.get(i).get(guest).getName();
     * get all names from reservation and then if they click check in put it 
     * in the check in list and check out list
     * 
     */
    
    
    
    
    
	list = new JList(listModel); //data has type Object[]
	list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	list.setLayoutOrientation(JList.VERTICAL);
	list.setVisibleRowCount(-1);
	JScrollPane listScroller = new JScrollPane(list);
	listScroller.setPreferredSize(new Dimension(350, 300));
	
	
	
	JPanel panel = new JPanel ();
	panel.add(listScroller);
	panel.add(checkIn);
	panel.add(cancel);
	this.add(panel);
	}
	
	class CheckInButtonListener implements ActionListener 
	{
		public void actionPerformed (ActionEvent click)
		{
	        JOptionPane.showMessageDialog(null, "You Are Checked In!","Message", JOptionPane.PLAIN_MESSAGE);
	        String name = (String) list.getSelectedValue();
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

