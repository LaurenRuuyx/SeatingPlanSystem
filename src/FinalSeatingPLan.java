import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalSeatingPLan extends JFrame {

	private JPanel contentPane;
	String seat_alphabet[] = {"A","B","C","D","E","F"};
	static ArrayList<JButton> buttons = new ArrayList<JButton>();
	static ArrayList<String> Seats = new ArrayList<String>();
	static Boolean departure = true;
	int seat_count = MainLoop.No_Seats;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FinalSeatingPLan frame = new FinalSeatingPLan();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FinalSeatingPLan() {
		//the method chooseSeatingPlan is called
		chooseSeatingPlan();
		//the method CheckBookedSeats is called
		CheckBookedSeats();
		//add an action listener for every button inside the buttons arraylist
		for (int i=0; i<buttons.size(); ++i) {
			String y = buttons.get(i).getText();
			int z = i;
			buttons.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//action performed by each button is going to be buttonOnClick(y,z)
					buttonOnClick(y,z);					
				}
			});
	}
		
		
				
	}
	
	//Show the Airbus seating plan
	public void Airbus_SeatingPlan() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		//the following code adds a label depending on whether the user is choosing departure or return seats
		if (departure) {
			JLabel title = new JLabel("Departure Flight");
			panel.add(title);
		}
		else {
			JLabel title = new JLabel("Return Flight");
			panel.add(title);
		}
		JLabel lblNewLabel_1000 = new JLabel("            ");
		panel.add(lblNewLabel_1000);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		// the action performed by the confirm button is the method confirmingSeats()
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmingSeats();
			}
		});
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setForeground(Color.WHITE);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		JLabel lblNewLabel = new JLabel("                                                                             ");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		JLabel lblNewLabel_1 = new JLabel("                                                                             ");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new GridLayout(6, 1, 0, 0));
		//for loop used to create and add seat buttons or labels to the screen
		for (int i=0;i<6;++i) {
			if(i==0) {
				JLabel lblNewLabel_10 = new JLabel("Business Class");
				panel_4.add(lblNewLabel_10);
			}
			else {
				JButton btnNewButton = new JButton(String.valueOf(i)+seat_alphabet[0]);
				btnNewButton.setBackground(Color.BLUE);
				btnNewButton.setForeground(Color.WHITE);
				panel_4.add(btnNewButton);
				//after the buttons are created and named, they are added to the buttons arraylist
				buttons.add(btnNewButton);
			}
		}
		
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new GridLayout(6, 1, 0, 0));
		//for loop used to create and add seat buttons or labels to the screen
		for (int i=0; i<6;++i) {
			if(i==0) {
				JLabel lblNewLabel_10 = new JLabel("Business Class");
				panel_5.add(lblNewLabel_10);
			}
			else {
				JButton btnNewButton = new JButton(String.valueOf(i)+seat_alphabet[1]);
				btnNewButton.setBackground(Color.BLUE);
				btnNewButton.setForeground(Color.WHITE);
				panel_5.add(btnNewButton);
				//buttons are added to the buttons arraylist
				buttons.add(btnNewButton);
			}
		}
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(10, 6, 10, 0));
		
		//for loop used to create and add buttons or labels to the screen
		for (int i=0; i<10;++i) {
			for (int j=0; j<6; ++j) {
				if(i==0) {
					if(j==0) {
						JLabel lblNewLabel_10 = new JLabel("Economy");
						panel_6.add(lblNewLabel_10);
					}
					else {
						JLabel lblNewLabel_10 = new JLabel("");
						panel_6.add(lblNewLabel_10);
					}
				}
				else {
					JButton btnNewButton = new JButton(String.valueOf(i+5)+seat_alphabet[j]);
					btnNewButton.setBackground(Color.BLUE);
					btnNewButton.setForeground(Color.WHITE);
					panel_6.add(btnNewButton);
					//buttons are added to the buttons arraylist
					buttons.add(btnNewButton);
				}
			}
		}
	}
	
	
	//Show the boeing seating plan on screen
	public void Boeing_SeatingPlan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		//the following code adds a label depending on whether the user is choosing departure or return seats
		if (departure) {
			JLabel title = new JLabel("Departure Flight");
			panel.add(title);
		}
		else {
			JLabel title = new JLabel("Return Flight");
			panel.add(title);
		}
		JLabel lblNewLabel_1000 = new JLabel("            ");
		panel.add(lblNewLabel_1000);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		//action performed by the confirm button is the confirmingSeeats() method
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmingSeats();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("                                                                                                                                    ");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JLabel lblNewLabel_1 = new JLabel("                                                                                                                                    ");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new GridLayout(6, 1, 0, 0));
		//for loop to create and add buttons and labels to the screen
		for (int i=0; i<6; ++i) {
			if (i==0) {
				JLabel lblNewLabel_2 = new JLabel("First Class");
				panel_4.add(lblNewLabel_2);				
			}
			else {
				JButton btnNewButton_1 = new JButton(String.valueOf(i) + seat_alphabet[0]);
				btnNewButton_1.setBackground(Color.BLUE);
				btnNewButton_1.setForeground(Color.WHITE);
				panel_4.add(btnNewButton_1);
				buttons.add(btnNewButton_1);
			}
			
		}
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new GridLayout(6, 1, 0, 0));
		//for loop to create and add buttons and labels to the screen
		for (int i=0; i<6; ++i) {
			if (i==0) {
				JLabel lblNewLabel_2 = new JLabel("First Class");
				panel_5.add(lblNewLabel_2);				
			}
			else {
				JButton btnNewButton_1 = new JButton(String.valueOf(i) + seat_alphabet[1]);
				btnNewButton_1.setBackground(Color.BLUE);
				btnNewButton_1.setForeground(Color.WHITE);
				panel_5.add(btnNewButton_1);
				buttons.add(btnNewButton_1);
			}
			
		}
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new GridLayout(6,6,10,0));
		//for loop to create and add buttons and labels to the screen
		for (int i=0; i<6; ++i) {
			int count = 0;
			for (int j=0; j<6; ++j) {
				if (i==0) {
					if (j==0) {
						JLabel lblNewLabel_11 = new JLabel("Business Class");
						panel_7.add(lblNewLabel_11);
					}
					else {
						JLabel lblNewLabel_11 = new JLabel("");
						panel_7.add(lblNewLabel_11);
					}
					
				}
				else {
					if (j==1 || j==4) {
						JLabel lblNewLabel_11 = new JLabel("");
						panel_7.add(lblNewLabel_11);						
					}
					else {
						JButton btnNewButton_1 = new JButton (String.valueOf(i+5)+seat_alphabet[count]);
						btnNewButton_1.setBackground(Color.BLUE);
						btnNewButton_1.setForeground(Color.WHITE);
						panel_7.add(btnNewButton_1);
						count +=1;
						buttons.add(btnNewButton_1);
					}
				}
			}
		}
		
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(10,6,0,0));
		//for loop to create and add buttons and labels to the screen
		for (int i=0; i<10; ++i) {
			for (int j=0; j<6; ++j) {
				if (i==0) {
					if (j==0) {
						JLabel lblNewLabel_11 = new JLabel("Economy");
						panel_8.add(lblNewLabel_11);
					}
					else {
						JLabel lblNewLabel_11 = new JLabel("");
						panel_8.add(lblNewLabel_11);
					}
					
				}
				else {
					JButton btnNewButton_1 = new JButton (String.valueOf(i+10)+seat_alphabet[j]);
					btnNewButton_1.setBackground(Color.BLUE);
					btnNewButton_1.setForeground(Color.WHITE);
					panel_8.add(btnNewButton_1);
					buttons.add(btnNewButton_1);
					
				}
				
			}
		}
	}
	
	//If seats are already booked, this will change the seats color to gray and add an action listener that opens an error message when the seats are selected
	public void BookedSeat(int j) {
		buttons.get(j).setBackground(Color.GRAY);
		buttons.get(j).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BookingError frame = new BookingError();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		//remove the booked seats from the buttons arraylist
		buttons.remove(j);
	}
	
	//check which seats are already booked
	public void CheckBookedSeats() {
		//if the user is selecting departure seats
		if (departure) {
			//for every element in the Bookings arraylist containing all the bookings made so far
			for (int i=0; i<MainLoop.Bookings.size()-1; ++i) {
				//check if the departure flight is the same as this booking's departure flight number
				if (MainLoop.Bookings.get(i).DepFlightNumber == MainLoop.Bookings.get(MainLoop.Bookings.size()-1).DepFlightNumber) {
					for (int j=0; j<buttons.size(); ++j) {
						//check which seats are booked
						if (MainLoop.Bookings.get(i).DepSeats.contains(buttons.get(j).getText())){
							//call the BookedSeat() method for the seats that are already booked
							BookedSeat(j);
							//decrease the value of j by one
							j-=1;
						}
					}
					
				}
				//check if the return flight number is the same as this booking's departure flight number
				if(MainLoop.Bookings.get(i).RetFlightNumber == MainLoop.Bookings.get(MainLoop.Bookings.size()-1).DepFlightNumber) {
					for (int j=0; j<buttons.size(); ++j) {
						if (MainLoop.Bookings.get(i).RetSeats.contains(buttons.get(j).getText())){
							BookedSeat(j);
							j-=1;
						}
					}
					
						
				}
			}
		}
		//if the user is selecting return seats
		else {
			//for every booking made so far
			for (int i=0; i<MainLoop.Bookings.size()-1; ++i) {
				//check if the departure flight number is the same as this booking's return flight number
				if (MainLoop.Bookings.get(i).DepFlightNumber == MainLoop.Bookings.get(MainLoop.Bookings.size()-1).RetFlightNumber) {
					for (int j=0; j<buttons.size(); ++j) {
						if (MainLoop.Bookings.get(i).DepSeats.contains(buttons.get(j).getText())){
							BookedSeat(j);
							j-=1;
						}
					}
					
				}
				//check if the return flight number is the same as this booking's return flight number
				if(MainLoop.Bookings.get(i).RetFlightNumber == MainLoop.Bookings.get(MainLoop.Bookings.size()-1).RetFlightNumber) {
					for (int j=0; j<buttons.size(); ++j) {
						if (MainLoop.Bookings.get(i).RetSeats.contains(buttons.get(j).getText())){
							BookedSeat(j);
							j-=1;
						}
					}
					
						
				}
			}
			
		}
		
	}
	
	//confirm seats button method
	public void confirmingSeats() {
		//check if the amount of seats selected is the same as the amount of tickets selected
		if (seat_count == 0) {
			//if the user is selecting departure seats
			if(departure) {
				//add all the seats inside the Seats arraylist to the departure seats of the booking currently being made, accessing it through the global Bookings arraylist
				for (int i=0; i<Seats.size();++i) {
					MainLoop.Bookings.get(MainLoop.Bookings.size()-1).DepSeats.add(Seats.get(i));
				}
				//change departure to false, clear all arrays, reset seat count
				departure = false;
				Seats.clear();
				buttons.clear();
				seat_count = MainLoop.No_Seats;
				//calling the same frame again
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
				//dispose of the current frame
				dispose();
			}
			//if the user is selecting return seats
			else {
				//add all the seats inside the Seats arraylist to the return seats attribute for this booking object
				for (int i=0; i<Seats.size();++i) {
					MainLoop.Bookings.get(MainLoop.Bookings.size()-1).RetSeats.add(Seats.get(i));
				}
				//departure becomes true, clear all arrays of redundant data, reset seat count
				departure = true;
				Seats.clear();
				buttons.clear();
				seat_count = MainLoop.No_Seats;
				//dispose of this frame
				dispose();
				//call the view seating frame again
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewSeating frame = new ViewSeating();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
		//if the user did not select enough seats
		else {
			//call an error message informing the user that not enough seats have been selected
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ConfirmError frame = new ConfirmError();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	//choose which seating plan to display depending on the flight duration
	public void chooseSeatingPlan() {
		if(departure) {
			if(MainLoop.Bookings.get(MainLoop.Bookings.size()-1).DepFlightDuration<121) {
				Airbus_SeatingPlan();
				
			}
			else {
				Boeing_SeatingPlan();
			}
		}
		else {
			if(MainLoop.Bookings.get(MainLoop.Bookings.size()-1).RetFlightDuration<121) {
				Airbus_SeatingPlan();
				
			}
			else {
				Boeing_SeatingPlan();
			}
		}
	}
	
	//action done by buttons on click
	public void buttonOnClick(String y, int z) {
		//check if the seat has been selected already by this user
		if (Seats.contains(y)) {
			seat_count += 1;						
			Seats.remove(Seats.indexOf(y));
			buttons.get(z).setBackground(Color.BLUE);
		}
		else {
			if(seat_count != 0) {
				seat_count -= 1;
				Seats.add(y);
				buttons.get(z).setBackground(Color.GREEN);
			}
			//if the user already selected the maximum allowed number of seats
			else {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TooManySeats frame = new TooManySeats();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		}
		
	}
	
}
