<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.JavaBeans" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Agenda de Contatos</title>
    <style>
     /* Cabeçalho */
        header {
            background-color: #005f86;
            color: white;
            width: 100%;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
        }

        nav ul {
            list-style: none;
            display: flex;
        }

        nav ul li {
            margin: 0 15px;
        }

        nav ul li a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            transition: 0.3s;
        }

        nav ul li a:hover {
            text-decoration: underline;
        }
        /* Estilo geral */
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            color: #333;
        }

        h1, h2 {
            text-align: center;
            color: #005f86;
        }

        h1 {
            margin-top: 20px;
        }

        img {
            display: block;
            margin: 20px auto;
            width: 100px;
            height: auto;
        }

        /* Botões de navegação */
        .botao, .botao1 {
            display: inline-block;
            margin: 10px 15px;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 16px;
            color: #ffffff;
            background-color: #005f86;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.2s;
        }

        .botao:hover, .botao1:hover {
            background-color: #003d5c;
            transform: scale(1.05);
        }

        /* Botão Excluir */
        .botao2 {
            display: inline-block;
            padding: 8px 15px;
            text-decoration: none;
            font-size: 14px;
            color: white;
            background-color: #d9534f;
            border-radius: 5px;
            transition: background-color 0.3s ease, transform 0.2s ease;
            font-weight: bold;
        }

        .botao2:hover {
            background-color: #b52b27;
            transform: scale(1.05);
        }

        /* Botão Editar */
        .botao3 {
            display: inline-block;
            padding: 8px 15px;
            text-decoration: none;
            font-size: 14px;
            color: white;
            background-color: #f0ad4e;
            border-radius: 5px;
            transition: background-color 0.3s ease, transform 0.2s ease;
            font-weight: bold;
        }

        .botao3:hover {
            background-color: #d6891c;
            transform: scale(1.05);
        }

        /* Tabela */
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        table th, table td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #005f86;
            color: white;
            font-weight: bold;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #d7e7f7;
        }

        /* Mensagem de tabela vazia */
        .empty-message {
            text-align: center;
            color: #666;
            font-size: 16px;
            margin: 20px 0;
        }
    </style>
</head>
<body>
 <!-- Cabeçalho -->
    <header>
        <div class="logo">Agenda de Contactos</div>
        <nav>
            <ul>
                <li><a href="#">Início</a></li>
                <li><a href="#">Sobre</a></li>
                <li><a href="#">Contactos</a></li>
                <li><a href="#">Ajuda</a></li>
            </ul>
        </nav>
    </header>
    <img alt="Logo" src="Imagens/relatorio.png">
    <h1>Agenda de Contatos</h1>

    <!-- Links para navegação -->
    <div style="text-align: center;">
        <a href="novo.html" class="botao">Novo Contato</a>
        <a href="index.html" class="botao1">Início</a>
    </div>

    <!-- Tabela para exibir os contatos -->
    <h2>Lista de Contatos</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Fone</th>
            <th>Email</th>
            <th>Opções</th>
        </tr>

        <% 
            // Obtendo os contatos da requisição
            List<JavaBeans> contactos = (List<JavaBeans>) request.getAttribute("contactos");
            
            // Verificando se a lista de contatos está vazia
            if (contactos != null && !contactos.isEmpty()) {
                // Iterando sobre os contatos e exibindo-os na tabela
                for (JavaBeans contacto : contactos) {
        %>
            <tr>
                <td><%= contacto.getIdcon()%></td>
                <td><%= contacto.getNome() %></td>
                <td><%= contacto.getFone() %></td>
                <td><%= contacto.getEmail() %></td>
                <td>
                   <a href="select?idcon=<%= contacto.getIdcon() %>" class="botao3">Editar</a>



                    <a href="excluir?idcon=<%= contacto.getIdcon() %>" class="botao2" onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a>
                </td>
            </tr>
        <% 
                }
            } else {
        %>
            <tr>
                <td colspan="4" class="empty-message">Nenhum contato encontrado.</td>
            </tr>
        <% } %>
    </table>
</body>
</html>
