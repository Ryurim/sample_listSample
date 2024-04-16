package controller;

import bbs.BbsDAO;
import bbs.BbsDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/BbsController", value = "/bbs/list")
public class BbsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BbsDTO> list = new ArrayList<>();
        BbsDAO dao = new BbsDAO();
        try {
            list = dao.list();
            dao.close();
            for (int i=0; i<list.size(); i++) {
                System.out.println(list.get(i).getIdx() + " , " + list.get(i).getTitle() + ", " + list.get(i).getContent() + ", " + list.get(i).getReg_date());
            }
        } catch(Exception e) {
            System.out.println("controller 실패");
            e.printStackTrace();


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
