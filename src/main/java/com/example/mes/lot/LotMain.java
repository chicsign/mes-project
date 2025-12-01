package main.java.com.example.mes.lot;

import java.util.Scanner;

public class LotMain {

    private static final Scanner sc = new Scanner(System.in);
    private static final LotController controller = new LotController();

    
    // 주석을 추가해보았습니당 ㅋ.ㅋ //
    public static void main(String[] args) {
        runMenu();
    }

    private static void runMenu() {
        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                	MainSelectAll(); 
                    break;
                case "2":
                	MainPrefixSearch();
                    break;
                case "3":
                    MainInsert();
                    break;
                case "4":
                	MainUpdate();
                    break;
                case "5":
                    MainDelete();
                    break;
                case "0":
                    System.out.println("'SYSTEM' : 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("'SYSTEM' : 메뉴 번호를 올바르게 입력하세요.");
            }
            ReloadMenu();
        }
    }

    private static void printMenu() {
        System.out.println("====== LOT 관리 시스템 (CLI) ======");
        System.out.println("1. LOT 전체 조회");
        System.out.println("2. 제품명(prefix)으로 검색");
        System.out.println("3. LOT 등록");
        System.out.println("4. LOT 수정");
        System.out.println("5. LOT 삭제");
        System.out.println("0. 종료");
        System.out.print("메뉴 번호 선택 > ");
    }
    
    // runMenu에서 메뉴를 다시 불러오는 메서드
    private static void ReloadMenu() {
    	System.out.println("'SYSTEM : 메뉴를 다시 불러옵니다'");
    	System.out.println( );
    }
    
    // selectAll 불러오기
    private static void MainSelectAll() {
    	controller.selectAll();
    }
    
    private static void MainPrefixSearch() {
        String prefix = prompt("'SYSTEM' : 검색할 제품명 시작 문자열(prefix)");
        controller.prefixSelect(prefix);
    }

    private static void MainInsert() {
        String lotId = prompt("LOT_ID");
        String lotStatus = prompt("LOT_STATUS");
        String lotCode = prompt("LOT_CODE");
        String productName = prompt("PRODUCT_NAME");

        controller.insertLot(lotId, lotStatus, lotCode, productName);
    }

    private static void MainUpdate() {
        String lotId = prompt("ㅋㅋㅋ");
        String lotStatus = prompt("오호호");
        String lotCode = prompt("아하하");
        String productName = prompt("충돌나라");
        //이것은 주석이다.

        controller.updateLot(lotId, lotStatus, lotCode, productName);
    }

    private static void MainDelete() {
        String lotId = prompt("삭제할 LOT_ID");
        // 간단 확인
        String ok = prompt("정말 삭제할까요? (Y/N)").toUpperCase();
        if (ok.equals("Y")) {
            controller.deleteLot(lotId);
        } else {
            System.out.println("'SYSTEM' : 삭제를 취소했습니다.");
        }
    }

    private static String prompt(String label) {
        while (true) {
            System.out.print(label + " 입력 > ");
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("'SYSTEM' : 값이 비었습니다. 다시 입력해주세요.");
        }
    }
}
