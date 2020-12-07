<%-- 
    Document   : CadastroAlunos
    Created on : 29/11/2020, 20:28:19
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
        <link rel="stylesheet" type="text/css" href="style/cadastro.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>

        <title>Cadastro de aluno</title>
    </head>
    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="ListagemAlunos" class="arrow-left">
                   <i class="fas fa-long-arrow-alt-left"> &nbsp; Voltar</i><!-- link para ir para a listagem de alunos -->
                </a>
                <a href="CadastroTurmas" class="new-class">
                    <i class="fas fa-chalkboard-teacher"> &nbsp;Turmas</i><!-- link para ir para a listagem e cadastro de turmas -->
                </a>
                <div class = "icon"> 
                    <i class="fas fa-address-book"></i>
                </div>
            </div>

            <div class="header-content">
                <strong>Cadastre um novo aluno</strong>
            </div>
            
        </header>
        <main>
            <form action="CadastroAlunos" method="post" class="create-form"> 
                
                <fieldset>
                    <legend>Dados</legend>
                    <c:if test="${param.erro != null}">
                        <p>
                            ${param.erro}
                        </p>
                    </c:if>
                    <div class="input-block">
                        <label>Nome</label>
                        <input name="nome" type="text" value="${aluno.nome}"/>
                    </div>

                    <div  class="select-block">
                        <label>Turma</label>
                        <select name="turma" id="turma" value="${aluno.turma}">                           
                            <option id="defaultOp" value="" hidden>
                                <c:if test="${aluno.id == 0}">
                                    Selecione uma opção
                                </c:if>   
                                <c:if test="${aluno.id != 0}">
                                    ${aluno.turma}
                                </c:if> 
                            </option>
                            <c:forEach var="turma" items="${turmas}">                   
                                <option value="${turma.nomeTurma}">
                                    ${turma.nomeTurma}
                                </option>                            
                            </c:forEach> 
                        </select>
                    </div>

                    <div class="input-block">
                        <label>Número de matrícula</label>
                        <input name="matricula" type="text" value="${aluno.matricula}"/>
                    </div>

                    <div class="input-block">
                        <label>Idade</label>
                        <input name="idade" type="number" 
                            <c:if test="${aluno.id == 0}">
                                value=""
                            </c:if>   
                            <c:if test="${aluno.id != 0}">
                                value="${aluno.age}"     
                            </c:if> 
                        />
                    </div>
                    <c:if test="${aluno.id != 0}">
                        <input type="hidden" name="id" value="${aluno.id}" />
                        <script type="text/javascript">
                            document.getElementById("defaultOp").value = "${aluno.turma}";
                        </script>
                    </c:if>

                    
                </fieldset>

                <button class="confirm-button" type="submit" >
                    <c:if test="${aluno.id == 0}">
                        Cadastrar
                    </c:if>   
                    <c:if test="${aluno.id != 0}">
                          Alterar    
                    </c:if> 
                </button>
            </form>
        </main>
    </body>
</html>