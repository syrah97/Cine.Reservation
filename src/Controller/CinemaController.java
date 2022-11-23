package Controller;

import Domain.CinemaDTO;
import Domain.DTO;
import Service.CinemaService;

public class CinemaController implements SubController {
	CinemaService service = new CinemaService();

	@Override
	public Object excute(int SN, DTO dto) {
		switch (SN) {
		case 1:
			CinemaDTO c = (CinemaDTO) dto;

			return service.cinemaShowInfoAll();
		case 2:

			break;

		default:
			break;
		}
		return null;
	}

}
