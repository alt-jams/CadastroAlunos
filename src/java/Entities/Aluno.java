/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Jamilly
 */
public class Aluno {
    
    private int id;
    private String nome;
    private String turma;
    private String matricula;
    private int age;

    public Aluno(String nome, String turma, String matricula, int age) {
        this.nome = nome;
        this.turma = turma;
        this.matricula = matricula;
        this.age = age;
    }
    
    public Aluno(){
        
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    }
