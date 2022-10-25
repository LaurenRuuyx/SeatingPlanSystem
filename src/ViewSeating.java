import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSeating extends JFrame {

	private JPanel contentPane;

	// Building the window for the ViewSeating frame
	public ViewSeating() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		JLabel viewSeatingLabel = new JLabel("   ");
		panel.add(viewSeatingLabel);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		JLabel viewSeatingLabel_1 = new JLabel("   ");
		panel.add(viewSeatingLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel viewSeatingLabel_2 = new JLabel("Number Of Tickets");
		panel_2.add(viewSeatingLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		panel_2.add(comboBox);
		// the following for loop adds the numbers from 0 to 15 to the combo box for the user to select the amount of tickets they wish to purchase
		for(int i=0; i<=15; ++i) {
			comboBox.addItem(i);
		}
		
		JLabel viewSeatingLabel_3 = new JLabel("         ");
		panel_2.add(viewSeatingLabel_3);
		
		JButton btnNewButton = new JButton("View Seating Plan");
		//add action listener to the view seating plan button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instantiate an instance of the Booking class
				Booking B2 = new Booking();
				//set departure and return flight durations, taking them from the flight1 and flight2 strings provided in the assessment brief
				B2.RetFlightDuration = MainLoop.ConvertToMinutes(MainLoop.flight2_parts[3]);
				B2.DepFlightDuration = MainLoop.ConvertToMinutes(MainLoop.flight1_parts[3]);
				//set departure and return flight numbers, taking them from the flight1 and flight2 strings provided in the assessment brief
				B2.DepFlightNumber= MainLoop.flight1_parts[10];
				B2.RetFlightNumber = MainLoop.flight2_parts[10];
				//add the booking object to the array containing all the bookings
				MainLoop.Bookings.add(B2);
				//the variable No_seats takes the value of the number that has been selected by the user using the combo box
				MainLoop.No_Seats = Integer.valueOf(comboBox.getSelectedItem().toString());
				//open the seating plan frame
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FinalSeatingPLan frame = new FinalSeatingPLan();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				//dispose of this frame
				dispose();
			}
		});
		//change color of the button
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		//add button to the wanted panel
		panel_2.add(btnNewButton);
	}

}
