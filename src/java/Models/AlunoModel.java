/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Aluno;
import java.util.ArrayList;

/**
 *
 * @author Jamilly
 */
public class AlunoModel {
    static ArrayList<Aluno> alunos = new ArrayList();
    
    public boolean adicionarAluno(Aluno a){
        String idade = "" + a.getAge();
        if (a.getNome().equals("") || idade.equals("") || 
            a.getTurma().equals("") || a.getMatricula().equals("")){
            return false;
        }
        
        if(alunos.size() == 0) {
            a.setId(1);
        }
        else{
            a.setId(alunos.get(alunos.size() - 1).getId()+1);
        }
        
        alunos.add(a);
        return true;
    }
    
    public boolean alterarAluno(Aluno a){
        String idade = "" + a.getAge();
        if (a.getNome().equals("") || idade.equals("") || 
            a.getTurma().equals("") || a.getMatricula().equals("")){
            return false;
        }
        
        for (Aluno aluno : alunos){
            if (aluno.getId() == a.getId()){
                aluno.setNome(a.getNome());
                aluno.setTurma(a.getTurma());
                aluno.setAge(a.getAge());
                aluno.setMatricula(a.getMatricula());
                break;
            }
        }
        
        return true;
    }
    
    public ArrayList<Aluno> getAlunos(){      
        return alunos;
    }   
    
    public Aluno getAluno(int id){
        for(Aluno aluno : alunos){
            if(aluno.getId() == id){
                return aluno;
            }
        }
        return null;
    }
            
}
