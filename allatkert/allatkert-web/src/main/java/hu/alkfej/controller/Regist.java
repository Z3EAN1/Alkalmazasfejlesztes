package hu.alkfej.controller;

import hu.alkfej.config.Configuration;
import hu.alkfej.dao.OrokbefogadoDAO;
import hu.alkfej.dao.OrokbefogadoDAOImpl;
import hu.alkfej.model.Orokbefogado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Regist")
public class Regist extends HttpServlet {
    OrokbefogadoDAO dao = new OrokbefogadoDAOImpl();




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Orokbefogado orokbefogado = new Orokbefogado();
        orokbefogado.setNev(req.getParameter("nev"));
        orokbefogado.setEmail(req.getParameter("email"));
        dao.save(orokbefogado);

        resp.sendRedirect("pages/listAllatok.jsp");


    }

}
