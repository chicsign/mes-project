//package main.java.com.example.mes.lot;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.mes.util.DBUtil;
//
//public class LotDao {
//	
//    public List<LotDto> selectAll() {
//        List<LotDto> list = new ArrayList<>();
//        String sql = "SELECT * FROM LOT_LIST";
//
//        try (
//            Connection conn = DBUtil.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery()
//        ) {
//            while (rs.next()) {
//                LotDto dto = new LotDto(
//                    rs.getString("LOT_ID"),
//                    rs.getString("LOT_STATUS"),
//                    rs.getString("LOT_CODE"),
//                    rs.getString("PRODUCT_NAME")
//                );
//                list.add(dto); // 리스트에 추가
//            }
//        } catch (SQLException e) {
//            System.out.println("'SYSTEM' : LOT 조회 실패!");
//            e.printStackTrace();
//        }
//
//        return list; // 리스트 반환
//    }
//
//
//    // 제품명으로 조회 (LIKE 조건)
//    public void prefixSelect(String prefix) {
//        String sql = "SELECT * FROM LOT_LIST WHERE PRODUCT_NAME LIKE ?";
//
//        try (
//            Connection conn = DBUtil.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql)
//        ) {
//            pstmt.setString(1, prefix + "%");
//
//            ResultSet rs = pstmt.executeQuery();
//
//        	while (rs.next()) {
//        	    LotDto dto = new LotDto(
//        	        rs.getString("LOT_ID"),
//        	        rs.getString("LOT_STATUS"),
//        	        rs.getString("LOT_CODE"),
//        	        rs.getString("PRODUCT_NAME")
//        	    );
//        	    System.out.println(dto);
//            }
//
//            rs.close();
//        } catch (SQLException e) {
//            System.out.println("'SYSTEM' : LOT 조건 조회 실패!");
//            e.printStackTrace();
//        }
//    }
//
//    // LOT 등록 (INSERT)
//    public int insertLot(LotDto dto) {
//        String sql = "INSERT INTO LOT_LIST (LOT_ID, LOT_STATUS, LOT_CODE, PRODUCT_NAME) VALUES (?, ?, ?, ?)";
//
//        try (
//            Connection conn = DBUtil.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql)
//        ) {
//            pstmt.setString(1, dto.getLotId());
//            pstmt.setString(2, dto.getLotStatus());
//            pstmt.setString(3, dto.getLotCode());
//            pstmt.setString(4, dto.getProductName());
//
//            return pstmt.executeUpdate(); // 성공한 행 수 반환(1이면 성공)
//        } catch (SQLException e) {
//            System.out.println("'SYSTEM' : LOT 등록 실패!");
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    // LOT 수정 (UPDATE)
//    public int updateLot(LotDto dto) {
//        String sql = "UPDATE LOT_LIST SET LOT_STATUS = ?, LOT_CODE = ?, PRODUCT_NAME = ? WHERE LOT_ID = ?";
//
//        try (
//            Connection conn = DBUtil.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql)
//        ) {
//            pstmt.setString(1, dto.getLotStatus());
//            pstmt.setString(2, dto.getLotCode());
//            pstmt.setString(3, dto.getProductName());
//            pstmt.setString(4, dto.getLotId());
//
//            return pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("'SYSTEM' : LOT 수정 실패!");
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    // LOT 삭제 (DELETE)
//    public int deleteLot(String lotId) {
//        String sql = "DELETE FROM LOT_LIST WHERE LOT_ID = ?";
//
//        try (
//            Connection conn = DBUtil.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql)
//        ) {
//            pstmt.setString(1, lotId);
//
//            return pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("'SYSTEM' : LOT 삭제 실패!");
//            e.printStackTrace();
//            return 0;
//        }
//    }
//}
