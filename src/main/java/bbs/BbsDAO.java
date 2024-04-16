package bbs;

import common.JDBConnect;

import java.util.ArrayList;
import java.util.List;

public class BbsDAO extends JDBConnect {
    public List<BbsDTO> list() {
        List<BbsDTO> bbsList = new ArrayList<>();

        String sql = "select idx, title, content, reg_date from tbl_bbs";

        try {
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();

            while(rs.next()) {
                BbsDTO dto = new BbsDTO();
                dto.setIdx(rs.getInt("idx"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setReg_date(rs.getDate("reg_date").toLocalDate());

                bbsList.add(dto);
            }
        } catch (Exception e) {
            System.out.println("dao 실패");
            e.printStackTrace();
        }
        return bbsList;
    }

}
