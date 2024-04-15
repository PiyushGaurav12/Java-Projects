package HospitalManagemetSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class HospitalManagementSystem {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalManagementSystem window = new HospitalManagementSystem();
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
	public HospitalManagementSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 948, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 20));
		lblNewLabel.setBounds(270, 23, 354, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LogIn");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(403, 93, 68, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(439, 216, 299, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(439, 288, 299, 37);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username : ");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		lblNewLabel_2.setBounds(270, 219, 169, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		lblNewLabel_3.setBounds(270, 288, 169, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBounds(403, 416, 150, 37);
		frame.getContentPane().add(btnNewButton);
	}
}
