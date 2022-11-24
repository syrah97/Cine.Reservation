package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.FrontController;
import Domain.LoginDAO;
import Service.LoginService;

public class GUI_Login extends JFrame {
	FrontController fc = new FrontController();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	// 로그인 관련 변수 선언
	public String mId;
	public String mPw;

	public GUI_Login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("회원 ID");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 10, 70, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("회원 PW");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(12, 40, 70, 20);
		contentPane.add(lblNewLabel_1_1);

		// 회원 ID
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(81, 10, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		// 회원 PW
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(81, 42, 116, 21);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<LoginDAO> list = (List<LoginDAO>) fc.MainController("/login", 1, null);
				LoginService ls = new LoginService();

				mId = textField.getText().trim();
				mPw = textField.getText().trim();

			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setBounds(209, 11, 97, 49);
		contentPane.add(btnNewButton);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Login frame = new GUI_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
