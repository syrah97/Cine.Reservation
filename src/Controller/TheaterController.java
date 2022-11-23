package Controller;

import Domain.DTO;
import Domain.TheaterDTO;
import Service.TheaterService;

public class TheaterController implements SubController {

	TheaterService service = new TheaterService();

	@Override
	public Object excute(int SN, DTO dto) {
		Object obj = null;

		switch (SN) {
		case 1:
			TheaterDTO c = (TheaterDTO) dto;

			return service.theaterShowInfoAll();
		case 2: // 좌석 선택
			System.out.println("상영관 영화 조회 서비스 요청");
			break;
		case 3: //
			System.out.println("상영관 좌석 조회 서비스 요청");
			break;
		default:
			System.out.println("잘못된 서비스 요청입니다.");
		}

		return obj;

	}

}
