/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Turma;
import java.util.ArrayList;

/**
 *
 * @author Jamilly
 */
public class TurmaModel {
    static ArrayList<Turma> turmas = new ArrayList();
    
    public ArrayList<Turma> getTurmas(){
              
        return turmas;
    }
    
    public String adicionarTurma(Turma t){
        for (Turma turma : turmas){
            if(turma.getNomeTurma().equals(t.getNomeTurma())){
                return "Essa turma já está cadastrada!";
            }
        }
        
        if (t.getNomeTurma().equals("")){
            return "Digite o nome da turma!";
        }
        
        if(turmas.size() == 0) {
            t.setId(1);
        }
        else{
            t.setId(turmas.get(turmas.size() - 1).getId()+1);
        }
        
        turmas.add(t);
        return null;
    }
}
