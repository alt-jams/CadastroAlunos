/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Aluno;
import Entities.Turma;

import Models.AlunoModel;
import Models.TurmaModel;

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
@WebServlet(name = "CadastroAlunos", urlPatterns = {"/CadastroAlunos"})
public class CadastroAlunos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        Aluno a = new Aluno();
        
        TurmaModel model = new TurmaModel();
        ArrayList<Turma> turmas = model.getTurmas();  
        
        if(request.getParameter("id") != null) {
            AlunoModel alunoModel = new AlunoModel();
            int id = Integer.parseInt(request.getParameter("id"));
            a = alunoModel.getAluno(id);
        }
     
        request.setAttribute("turmas", turmas); 
        request.setAttribute("aluno", a);
        
        request.getRequestDispatcher("CadastroAlunos.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
                
        try{
            String nome = request.getParameter("nome");
            String turma = request.getParameter("turma");
            String matricula = request.getParameter("matricula");
            int idade = Integer.parseInt(request.getParameter("idade"));

            AlunoModel model = new AlunoModel();
            Aluno a = new Aluno(nome, turma, matricula, idade);
            
           String retorno;
 
            if (request.getParameter("id") != null) {
                a.setId(Integer.parseInt(request.getParameter("id")));
                retorno = model.alterarAluno(a);
            }else{
                retorno = model.adicionarAluno(a);
            }

            if (retorno != null) {
                 if (request.getParameter("id") != null){
                     response.sendRedirect("CadastroAlunos?id=" + request.getParameter("id") + 
                             "&erro=" + retorno);
                 }else{
                    response.sendRedirect("CadastroAlunos?erro=" + retorno);
                 }
            } else {

                response.sendRedirect("ListagemAlunos");
            }
            
        } catch(NumberFormatException e){
             if (request.getParameter("id") != null){
                response.sendRedirect("CadastroAlunos?id=" + request.getParameter("id") + 
                             "&erro=Preencha todos os campos!");
            }else{
                response.sendRedirect("CadastroAlunos?erro=Preencha todos os campos!");
            }
        }
        
    }
    

}
