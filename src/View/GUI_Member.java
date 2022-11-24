package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FrontController;
import Domain.MemberDTO;

public class GUI_Member extends JFrame {
	FrontController fc = new FrontController();

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;

	public GUI_Member() {

		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setTitle("회원 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		String memberColumn[] = { "회원 ID", "회원 이메일", "회원 생일", "회원 권한" };
		DefaultTableModel memberModel = new DefaultTableModel(null, memberColumn);
		JTable movieTable = new JTable(memberModel);
		JScrollPane scrollPane = new JScrollPane(movieTable);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(12, 10, 410, 170);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBounds(12, 10, 410, 170);
		contentPane.add(table);

		JButton btnNewButton = new JButton("개인 정보 조회");
		btnNewButton.addActionListener(new ActionListener() {
			List<MemberDTO> list = (List<MemberDTO>) fc.MainController("/member", 3, null);

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {

					memberModel.setNumRows(0);

					for (int i = 0; i < list.size(); i++) {
						Object movieData[] = { list.get(i).getmId(), list.get(i).getmEmail(), list.get(i).getmBirth(),
								list.get(i).getmRole(), };

						memberModel.addRow(movieData);

					}
				}
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton.setBounds(12, 190, 200, 61);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("회원 전체 정보 조회");
		btnNewButton_1.addActionListener(new ActionListener() {
			List<MemberDTO> list = (List<MemberDTO>) fc.MainController("/member", 2, null);

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {

					memberModel.setNumRows(0);

					for (int i = 0; i < list.size(); i++) {
						Object movieData[] = { list.get(i).getmId(), list.get(i).getmEmail(), list.get(i).getmBirth(),
								list.get(i).getmRole(), };

						memberModel.addRow(movieData);

					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1.setBounds(224, 190, 200, 61);
		contentPane.add(btnNewButton_1);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Member frame = new GUI_Member();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
