package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.KonyvesboltDao;

public class Main {
	private static KonyvesboltDao kbdao;
	public static void main(String[] args) {
		JFrame login=new JFrame("login");
		login.setLayout(new GridLayout(3, 2));
		JLabel un=new JLabel("username:");
		JLabel pw=new JLabel("password:");
		JButton loginButton=new JButton("login");
		JTextField username=new JTextField();
		JTextField password=new JTextField();
		login.add(un);
		login.add(username);
		login.add(pw);
		login.add(password);
		login.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					kbdao=new KonyvesboltDao(username.getText(), password.getText());
					JOptionPane.showMessageDialog(login,
						    "Siker�lt");
					login.setVisible(false);
					new MainFrame();
					login.dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(login,
						    e1.getMessage());
				}
			}
		});
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.pack();
		login.setVisible(true);
		
	}

}
