<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda de Contactos</title>
<link rel="icon" href="Imagens/relatorio.png">
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
    /* Estilos gerais */
    body {
        font-family: sans-serif;
        font-size: 1em;
        font-weight: 600;
        background: url('Imagens/fundo.jpg') no-repeat center center fixed;
        background-size: cover;
        color: #fff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    /* Container do formulário */
    .form-container {
        background: rgba(255, 255, 255, 0.8);
        padding: 20px;
        max-width: 400px;
        width: 100%;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    /* Cabeçalho */
    h1 {
        color: #007bb5;
        font-size: 2.5em;
        text-shadow: 2px 2px 5px rgba(0, 123, 181, 0.3);
        text-align: center;
    }

    /* Inputs */
    .input-box {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #007bb5;
        border-radius: 5px;
        font-size: 1em;
        box-sizing: border-box;
    }

    #caixa3 {
        border: 1px solid red;
        background: #f8d7da;
        color: #721c24;
        font-weight: bold;
    }

    /* Botão */
    .botao {
        display: block;
        width: 100%;
        background-color: #007bb5;
        color: white;
        text-align: center;
        border: none;
        border-radius: 5px;
        padding: 12px;
        font-size: 1em;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }

    .botao:hover {
        background-color: #005f87;
    }

    /* Link de Voltar */
    .botao-link {
        display: inline-block;
        margin-top: 10px;
        text-decoration: none;
        color: #007bb5;
        font-weight: bold;
        transition: 0.3s;
    }

    .botao-link:hover {
        color: #005f87;
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
<div class="form-container">
    <h1>Editar Contacto</h1>
    <form name="frmContacto" action="update">
        <label>ID:</label>
        <input type="text" name="idcon" id="caixa3" readonly="readonly" value="<% out.print(request.getAttribute("idcon")); %>" class="input-box">
        
        <label>Nome:</label>
        <input type="text" name="nome" class="input-box" value="<% out.print(request.getAttribute("nome")); %>">
        
        <label>Fone:</label>
        <input type="text" name="fone" class="input-box" value="<% out.print(request.getAttribute("fone")); %>">
        
        <label>E-mail:</label>
        <input type="text" name="email" class="input-box" value="<% out.print(request.getAttribute("email")); %>">

        <input type="button" value="Editar" class="botao" onclick="validar()">
    </form>
    
    <a href="index.html" class="botao-link">← Voltar para o início</a>
</div>

<script src="scripsts/validador.js"></script>

</body>
</html>
