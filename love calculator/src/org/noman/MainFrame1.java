package org.noman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField output;
	private CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame1() {
		super();
		setTitle("Love calculator");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		card =new CardLayout();
		contentPane.setLayout(card);
		
		//-------- First panel property----------
		
		JPanel firstPanel = new JPanel();
		contentPane.add(firstPanel, "first");
		firstPanel.setLayout(null);
		
		//-------- His name-----------------------
		
		JLabel lblNewLabel = new JLabel("HIS NAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 54, 241, 28);
		firstPanel.add(lblNewLabel);
		
		
		//-------- First textfield----------
		t1 = new JTextField();
		t1.setBounds(10, 93, 241, 34);
		firstPanel.add(t1);
		t1.setColumns(10);
		
		//--------- HER NAME--------------
		
		JLabel lblHerName = new JLabel("HER NAME");
		lblHerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblHerName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHerName.setBounds(10, 138, 241, 28);
		firstPanel.add(lblHerName);
		
		//--------- Second textfield------------
		
		t2 = new JTextField();
		t2.setBounds(10, 177, 241, 34);
		firstPanel.add(t2);
		t2.setColumns(10);
		
		//---------- Calculate button-----------
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hisName = t1.getText();
				String herName = t2.getText();
				
				int counter = 0;
				for(int i=0; i<hisName.length(); i++) {
					char ch = hisName.charAt(i);
					counter += ch -'a' +1;
				}
				
				for(int i=0; i<herName.length(); i++) {
					char ch = herName.charAt(i);
					counter += ch -'a' +1;
				}
				
				counter = counter%100;
				output.setText(String.valueOf(counter) +"%");
				card.show(contentPane, "last");
				
			
		}});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(77, 250, 100, 23);
		firstPanel.add(btnNewButton);
		
		JLabel lblLoveCalculator = new JLabel("Love Calculator");
		lblLoveCalculator.setForeground(Color.RED);
		lblLoveCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoveCalculator.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoveCalculator.setBounds(10, 11, 241, 28);
		firstPanel.add(lblLoveCalculator);
		
		//------------------------- END OF FIRST PANNEL---------------------
		
		
		
		//------------------SECOND PANEL--------------
		
		JPanel lastPanel = new JPanel();
		contentPane.add(lastPanel, "last");
		lastPanel.setLayout(null);
		
		
		//----------------  RESULT------------------
		
		JLabel lblNewLabel_1 = new JLabel("Result");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(61, 11, 120, 30);
		lastPanel.add(lblNewLabel_1);
		
		//--------------- TEXT FIELD FOR RESULT----------------
		
		output = new JTextField();
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setFont(new Font("Tahoma", Font.PLAIN, 40));
		output.setBounds(10, 52, 241, 151);
		lastPanel.add(output);
		output.setColumns(10);
		
		
		// --------------------- BUTTON FOR CALCULATE AGAIN---------------
		
		
		JButton btnNewButton_1 = new JButton("Calculate Again");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				t1.setText(null);
				t2.setText(null);
				card.show(contentPane, "first");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(61, 238, 136, 30);
		lastPanel.add(btnNewButton_1);
	}
}
