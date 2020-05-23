package com.hit.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hit.controller.SignUpController;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Login_S extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
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
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUser = new JLabel("User Name:");
		lblUser.setBounds(40, 93, 89, 15);
		frame.getContentPane().add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(40, 140, 89, 15);
		frame.getContentPane().add(lblPassword);

		JLabel lblLogin = new JLabel("Login System");
		lblLogin.setBounds(183, 12, 131, 15);
		frame.getContentPane().add(lblLogin);

		txtUser = new JTextField();
		txtUser.setBounds(166, 90, 114, 19);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(166, 138, 114, 19);
		frame.getContentPane().add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				SignUpController signup = new SignUpController(txtUser.getText(), txtPassword.getText(),
						"com.mysql.jdbc.Driver", "jdbc:mysql://localhost/HotelManagement",
						"SELECT username,password FROM users WHERE username = ? AND password=?");
				if (signup.isUserExists() == true) {
					JOptionPane.showMessageDialog(frame, "Successfully loged in");

				} else
					JOptionPane.showMessageDialog(frame, "Wrong username or password");
			}
		});
		btnLogin.setBounds(12, 218, 117, 25);
		frame.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUser.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(166, 218, 117, 25);
		frame.getContentPane().add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}

			}
		});
		btnExit.setBounds(326, 218, 117, 25);
		frame.getContentPane().add(btnExit);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 189, 413, -4);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 46, 461, -4);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 46, 405, 2);
		frame.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(22, 189, 395, -4);
		frame.getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(22, 189, 395, 2);
		frame.getContentPane().add(separator_4);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
              new SignUp();
			}
		});
		btnSignUp.setBounds(356, 154, 117, 25);
		frame.getContentPane().add(btnSignUp);
	}
}
