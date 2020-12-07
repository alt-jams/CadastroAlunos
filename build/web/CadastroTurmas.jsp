<%-- 
    Document   : CadastroTurmas
    Created on : 30/11/2020, 22:50:42
    Author     : Jamilly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="style/cadastroTurmas.css">
        <link rel="stylesheet" type="text/css" href="style/global.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
       
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <script language="JavaScript" src="scripts/biblio.js"></script>

        <title>Cadastro de aluno</title>
    </head>
    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="ListagemAlunos" class="arrow-left">
                   <i class="fas fa-long-arrow-alt-left"> &nbsp; Voltar</i>
                </a>
                <a href="CadastroAlunos" class="new-student">
                    <i class="fas fa-user-graduate">&nbsp; Novo Aluno</i>
                </a>
                <div class = "icon"> 
                    <i class="fas fa-address-book"></i>
                </div>
            </div>

            <div class="header-content">
                <strong>Cadastre uma nova Turma</strong>
            </div>   
        </header>
        
        <main>
            <div class = "create-form">
                <form action="CadastroTurmas" method="post" id="formu">

                    <fieldset id="field">                    
                        <div class="input-block">
                            <label>Nome</label>
                            <input name="nome" type="text"/>
                        </div>    
                    </fieldset>
                    
                    <button class="confirm-button" type="submit" id="botao">
                        Cadastrar
                    </button>
                </form>
                
                <c:if test="${param.erro != null}">
                    <p class="erro">${param.erro}</p>
                </c:if>
                
                <div class="lista">
                    <button onclick="showForm()" class="button-create" id="create-button">+ Nova Turma</button>
                    <table class = "striped centered">
                        <thead>
                            <tr>
                                <th>Nome da Turma</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="turma" items="${turmas}">  
                                <tr>
                                    <td>${turma.nomeTurma}</td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table> 
                </div>
            </div>              
        </main>
        <c:if test="${param.erro != null}">
            <script type="text/javascript">
                showForm();
            </script>
        </c:if>
    </body>
</html>