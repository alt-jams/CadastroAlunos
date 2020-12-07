/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Turma;
import Models.TurmaModel;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jamilly
 */
@WebServlet(name = "CadastroTurmas", urlPatterns = {"/CadastroTurmas"})
public class CadastroTurmas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        TurmaModel model = new TurmaModel();
        ArrayList<Turma> turmas = model.getTurmas();
       
        request.setAttribute("turmas", turmas); 

        request.getRequestDispatcher("CadastroTurmas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String retorno;
        
      
        String nomeTurma = request.getParameter("nome");
          

        TurmaModel model = new TurmaModel();
        Turma t = new Turma(nomeTurma);
 
        retorno = model.adicionarTurma(t);
        
        if (retorno != null){
            String retorno2 = URLEncoder.encode(retorno, "ISO-8859-1");
            response.sendRedirect("CadastroTurmas?erro=" + retorno2);           
        }
        else{
            response.sendRedirect("CadastroTurmas");
        }
    }
}
