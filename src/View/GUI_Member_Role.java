package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Member_Role extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public GUI_Member_Role() {
		setTitle("회원 전체 정보 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("관리자 권한 확인을 위해 ID와 PW를 한번 더 입력해 주세요.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 10, 400, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("회원 ID");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(65, 40, 70, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("회원 PW");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(65, 70, 70, 20);
		contentPane.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setBounds(134, 40, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 72, 116, 21);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("권한 확인");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setBounds(262, 41, 97, 49);
		contentPane.add(btnNewButton);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Member_Role frame = new GUI_Member_Role();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
