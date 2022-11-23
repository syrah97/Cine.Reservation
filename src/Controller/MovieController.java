package Controller;

import Domain.DTO;
import Domain.MovieDTO;
import Service.MovieService;

public class MovieController implements SubController {

	MovieService service = new MovieService();

	@Override
	public Object excute(int SN, DTO dto) {
		Object obj = null;

		switch (SN) {
		case 1:
			MovieDTO m = (MovieDTO) dto;

			return service.movieShowInfoAll();

		default:
			System.out.println("잘못된 서비스입니다.");
		}

		return null;
	}

}
