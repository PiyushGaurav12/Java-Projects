package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 192));
		frame.setBounds(100, 100, 711, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculator");
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.ITALIC, 20));
		lblNewLabel.setBounds(267, 36, 181, 37);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(87, 127, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(100, 103, 70, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 127, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number 2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(295, 103, 72, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(502, 127, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Result");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(524, 103, 74, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n,m,c;
			  n=Integer.parseInt(textField.getText()); 
			  m=Integer.parseInt(textField_1.getText()); 
			  c=n+m;
			  textField_2.setText(Integer.toString(c));
			}
		});
		btnNewButton.setBounds(87, 209, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Subtract");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n,m,c;
				  n=Integer.parseInt(textField.getText()); 
				  m=Integer.parseInt(textField_1.getText()); 
				  c=n-m;
				  textField_2.setText(Integer.toString(c));
			}
		});
		btnNewButton_1.setBounds(87, 257, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Multiply");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n,m,c;
				  n=Integer.parseInt(textField.getText()); 
				  m=Integer.parseInt(textField_1.getText()); 
				  c=n*m;
				  textField_2.setText(Integer.toString(c));
			}
		});
		btnNewButton_2.setBounds(87, 311, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Divide");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n,m,c;
				  n=Integer.parseInt(textField.getText()); 
				  m=Integer.parseInt(textField_1.getText()); 
				  c=n/m;
				  textField_2.setText(Integer.toString(c));
			}
		});
		btnNewButton_3.setBounds(87, 369, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
	}
}
