

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Account {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
    private TournamentFrame tournament;
    private TournamentPanel tourpanel;
    private test test;
    private JLabel lblPleaseEnterYour;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tourpanel = new TournamentPanel();
	//	tournament = new TournamentFrame(tourpanel);
		test = new test();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(424, 251, 10, 10);
		frame.getContentPane().add(panel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(131, 65, 73, 38);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(131, 114, 61, 25);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(214, 74, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(214, 116, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblPleaseEnterYour = new JLabel("Please enter your login information.");
		lblPleaseEnterYour.setBounds(98, 21, 326, 14);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(115, 177, 89, 23);
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(textField.getText().equals("coach") && textField_1.getText().equals("coachpass")){
				lblPleaseEnterYour.setText("It worked, login was successful");
				}
				else if(textField.getText().equals("referee") && textField_1.getText().equals("refereepass")){
					lblPleaseEnterYour.setText("It worked, login was successful");
					}

					else if(textField.getText().equals("organizer") && textField_1.getText().equals("organizerpass")){
					lblPleaseEnterYour.setText("It worked, login was successful");
					}
					else{
					lblPleaseEnterYour.setText(" Wrong username or password, please try again ");
					}
				}
					
				
			
			
		});
		frame.getContentPane().add(btnLogin);
		
		JButton btnGuest = new JButton("Guest");
		btnGuest.setBounds(226, 177, 89, 23);

	btnGuest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
					lblPleaseEnterYour.setText(" Schedule will be displayed for guest");	
				}
		});
		frame.getContentPane().add(btnGuest);
		
	
	}
}
