/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Aluno;
import Models.AlunoModel;

import java.io.IOException;
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
@WebServlet(name = "ListagemAlunos", urlPatterns = {"/ListagemAlunos"})
public class ListagemAlunos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
            {
                
        AlunoModel model = new AlunoModel();
        ArrayList<Aluno> alunos = model.getAlunos();
       
        request.setAttribute("alunos", alunos); 
        
        request.getRequestDispatcher("ListagemAlunos.jsp").forward(request, response);
        
    }

}
