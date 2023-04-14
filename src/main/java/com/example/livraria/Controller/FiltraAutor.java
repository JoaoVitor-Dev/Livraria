package com.example.livraria.Controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.livraria.Model.Xml;

@WebServlet(name = "FiltraAutor", value = "/FiltraAutor")
public class FiltraAutor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho=getServletContext().getRealPath("/WEB-INF/livros.xml");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String textoPesq = request.getParameter("autor");

        Xml manipulaXML = new Xml(caminho);
        out.println(manipulaXML.pesquisaAutor(textoPesq));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
