package main.java.com.example.mes.lot;

import java.util.List;

public class LotController {

    private LotDao dao = new LotDao();
    
    // LOT 전체 조회
    public void selectAll() {
        List<LotDto> list = dao.selectAll();

        System.out.println("'SYSTEM' : LOT LIST를 출력합니다");
        System.out.println("===================================================");
        for (LotDto dto : list) {
            System.out.println(dto); // toString() 호출
        }
        System.out.println("===================================================");
        System.out.println("'SYSTEM' : 출력이 완료되었습니다");
        
    }

    // 제품명 prefix 조회
    public void prefixSelect(String prefix) {
        dao.prefixSelect(prefix);
    }
    // LOT 등록
    public void insertLot(String lotId, String lotStatus, String lotCode, String productName) {
        LotDto dto = new LotDto(lotId, lotStatus, lotCode, productName);
        int result = dao.insertLot(dto);

        System.out.println(result > 0 ? "'SYSTEM' : LOT 등록 성공!" : "'SYSTEM' : LOT 등록 실패!");
    }
    // LOT 수정
    public void updateLot(String lotId, String lotStatus, String lotCode, String productName) {
        LotDto dto = new LotDto(lotId, lotStatus, lotCode, productName);
        int result = dao.updateLot(dto);

        System.out.println(result > 0 ? "'SYSTEM' : LOT 수정 성공!" : "'SYSTEM' : LOT 수정 실패!");
    }

    // LOT 삭제
    public void deleteLot(String lotId) {
        int result = dao.deleteLot(lotId);
        System.out.println(result > 0 ? "'SYSTEM' : LOT 삭제 성공!" : "'SYSTEM' : LOT 삭제 실패!");
    }


}
