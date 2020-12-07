<%-- 
    Document   : ListagemAlunos
    Created on : 29/11/2020, 20:33:09
    Author     : Jamilly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="style/global.css">
        <link rel="stylesheet" type="text/css" href="style/listagem.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        

        <title>Cadastro de aluno</title>
    </head>
    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="CadastroTurmas" class="new-class">
                    <i class="fas fa-chalkboard-teacher"> &nbsp;Turmas</i>
                </a>
                <div class = "icon"> 
                    <i class="fas fa-address-book"></i>
                </div>
            </div>

            <div class="header-content">
                <strong>Estes são os alunos cadastrados!</strong>
            </div>
            
        </header>
        <main>
           <div class="lista">
                <a href="CadastroAlunos">+ Novo aluno</a>
                
                <table class = "striped centered">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Idade</th>
                            <th>Turma</th>
                            <th>Registro Acadêmico</th>
                            <th>Ação</th>

                        </tr>
                    </thead>
            
                    <tbody> 
                        <c:forEach var="aluno" items="${alunos}">  
                            <tr>
                                <td>${aluno.nome}</td>
                                <td>${aluno.age}</td>
                                <td>${aluno.turma}</td>
                                <td>${aluno.matricula}</td>
                                <td>
                                    <a class="editar" href="CadastroAlunos?id=${aluno.id}">Editar dados</a>
                                </td>

                            </tr>
                        </c:forEach> 
                   
                    </tbody>
                </table> 
           </div>
        </main>
    </body>
</html>