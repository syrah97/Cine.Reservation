package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FrontController;
import Domain.CinemaDTO;
import Domain.MovieDTO;
import Domain.TheaterDTO;

public class GUI extends JFrame {
	FrontController fc = new FrontController();
	private JPanel contentPane;

	public GUI() {
		setTitle("Movie Reserve Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Movie Reserve Program");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(12, 0, 660, 36);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("영화 예매하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1.setBounds(243, 257, 200, 71);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_2 = new JButton("로그인");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1_2.setBounds(12, 257, 200, 71);
		contentPane.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("회원 정보");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1_3.setBounds(473, 257, 199, 71);
		contentPane.add(btnNewButton_1_3);

		JButton btnNewButton_1_3_1 = new JButton("상영관 검색");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * dto.setCinemaNum(rs.getInt("cinemaNum"));
				 * dto.setCinemaName(rs.getString("cinemaName"));
				 */
				String theaterColumn[] = { "영화관 이름", "상영관 이름" };
				DefaultTableModel theaterModel = new DefaultTableModel(null, theaterColumn);
				JTable theaterTable = new JTable(theaterModel);
				JScrollPane scrollPane = new JScrollPane(theaterTable);
				scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
				scrollPane.setBounds(12, 46, 660, 180);
				contentPane.add(scrollPane);

				List<TheaterDTO> list = (List<TheaterDTO>) fc.MainController("/theater", 1, null);

				theaterModel.setNumRows(0);

				if (e.getSource() == btnNewButton_1_3_1) {
					for (int i = 0; i < list.size(); i++) {
						Object theaterData[] = { list.get(i).getCinemaName(), list.get(i).getTheaterName() };

						theaterModel.addRow(theaterData);
					}

				}

			}
		});
		btnNewButton_1_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1_3_1.setBounds(473, 338, 199, 71);
		contentPane.add(btnNewButton_1_3_1);

		JButton btnNewButton_1_1 = new JButton("상영 영화 검색");
		btnNewButton_1_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1_1) {

					String movieColumn[] = { "영화 코드", "영화 제목", "영화 개봉일", "영화 종영일", "영화 상영 시간", "영화관 코드" };
					DefaultTableModel movieModel = new DefaultTableModel(null, movieColumn);
					JTable movieTable = new JTable(movieModel);
					JScrollPane scrollPane = new JScrollPane(movieTable);
					scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
					scrollPane.setBounds(12, 46, 660, 180);
					contentPane.add(scrollPane);

					List<MovieDTO> list = (List<MovieDTO>) fc.MainController("/movie", 1, null);

					movieModel.setNumRows(0);

					for (int i = 0; i < list.size(); i++) {
						Object movieData[] = { list.get(i).getMovieCode(), list.get(i).getMovieName(),
								list.get(i).getMovieStartDate(), list.get(i).getMovieEndDate(),
								list.get(i).getMovieTime(), list.get(i).getCinemaNum() };

						movieModel.addRow(movieData);

					}
				}

			}
		});
		btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(12, 338, 200, 71);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2_1 = new JButton("영화관 검색");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * dto.setCinemaNum(rs.getInt("cinemaNum"));
				 * dto.setCinemaName(rs.getString("cinemaName"));
				 */

				String cinemaColumn[] = { "영화관 번호", "영화관 이름" };
				DefaultTableModel cinemaModel = new DefaultTableModel(null, cinemaColumn);
				JTable cinemaTable = new JTable(cinemaModel);
				JScrollPane scrollPane = new JScrollPane(cinemaTable);
				scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
				scrollPane.setBounds(12, 46, 660, 180);
				contentPane.add(scrollPane);

				List<CinemaDTO> list = (List<CinemaDTO>) fc.MainController("/cinema", 1, null);

				cinemaModel.setNumRows(0);

				if (e.getSource() == btnNewButton_1_2_1) {
					for (int i = 0; i < list.size(); i++) {
						Object theaterData[] = { list.get(i).getCinemaNum(), list.get(i).getCinemaName() };

						cinemaModel.addRow(theaterData);
					}

				}

			}
		});
		btnNewButton_1_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		setBounds(100, 100, 700, 470);
		btnNewButton_1_2_1.setBounds(243, 338, 200, 71);
		contentPane.add(btnNewButton_1_2_1);

	}

//	public void paint(Graphics g) {
//		Image background = new ImageIcon(GUI.class.getResource("../View/cinema2.jpg")).getImage();
//		g.drawImage(background, 0, 0, null);
//	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
