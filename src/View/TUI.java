package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.FrontController;
import Domain.CinemaDTO;
import Domain.MovieDTO;
import Domain.TheaterDTO;

public class TUI {

		private FrontController controller = new FrontController();
		// 생성자
		Scanner sc = new Scanner(System.in);
		int n = 0;

		TUI() {
			mainview();
		}

		void mainview() {
			while (true) {
				System.out.println("-------------------M A I N --------------------");
				System.out.println("1 상영 영화 검색");
				System.out.println("2 영화관 검색");
				System.out.println("3 상영관 검색");
				System.out.println("4 종료");
				System.out.println("-------------------M A I N --------------------");
				System.out.println("번호 : ");
				n = sc.nextInt();
				switch (n) {
				case 1:
					List<MovieDTO> mlist = (ArrayList<MovieDTO>)controller.MainController("/movie", 1, null);
					for(MovieDTO dto : mlist) {
						System.out.println();
					}
					break;
				case 2:		
					List<CinemaDTO> clist = (ArrayList<CinemaDTO>)controller.MainController("/cinema", 1, null);
					for(CinemaDTO dto : clist) {
						System.out.println();
					}
					break;
				case 3:
					List<TheaterDTO> tlist = (ArrayList<TheaterDTO>)controller.MainController("/theater", 1, null);
					for(TheaterDTO dto : tlist) {
						System.out.println();
					}
					break;
				case 4:
					System.out.println("종료합니다.");
					System.exit(-1);
					break;
				default:

				}
			}
		}

		

		

		public static void main(String[] args) {
			new TUI();
		}
}
