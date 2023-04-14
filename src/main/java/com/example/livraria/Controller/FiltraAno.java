package com.example.livraria.Controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.example.livraria.Model.Xml;

@WebServlet(name = "FiltraAno", value = "/FiltraAno")
public class FiltraAno extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Passar o arquivo .Xml para o Servlet
        String caminho=getServletContext().getRealPath("/WEB-INF/livros.xml");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        int anoPesq = Integer.parseInt(request.getParameter("ano"));
        String operador= request.getParameter("operador");

        //Criar um objeto da Classe Xml
        Xml xml = new Xml(caminho); //Objeto da Classe Xml

        //Chamar o método pesquisaAno e passar o ano como parâmetro
        out.println(xml.pesquisaAno(operador,anoPesq));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
