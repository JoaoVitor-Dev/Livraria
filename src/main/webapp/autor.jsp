<%--
  Created by IntelliJ IDEA.
  User: JoaoV
  Date: 13/04/2023
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autor</title>
    <link rel="stylesheet" href="boot.css">
    <link rel="stylesheet" href="style.css">

    <script src="App.js"></script>
</head>
<body>

<div class="dash">
    <aside class="dash_sidebar">
            <article class="dash_sidebar_user">
                <div>
                    <img src="livraria.png" alt="" width="50">
                </div>
                <h3 class="dash_sidebar_user_name">
                    <a href="">Livraria</a>
                </h3>
            </article>
        <ul class="dash_sidebar_nav">
            <li class="dash_sidebar_nav_li">
                <a href="titulo.jsp">Título</a>
            </li>
            <li class="dash_sidebar_nav_li">
                <a href="ano.jsp">Ano</a>
            </li>
            <li class="dash_sidebar_nav_li">
                <a href="autor.jsp">Autor</a>
            </li>
            <li class="dash_sidebar_nav_li">
                <a href="categoria.jsp">Categoria</a>
            </li>
        </ul>
    </aside>
    <section class="dash_content">
        <div class="dash_userbar">
            <div class="dash_userbar_box">
                <div class="dash_content_box">
                    <h1>Livros</h1>
                </div>
            </div>
        </div>
        <div class="dash_content_box">
            <div>
                <label>
                    <span>Autor:</span>
                    <input type="text" name="autor" id="autor">
                </label>
                <button onclick="pesquisaAutor()" class="btn btn-green">Pesquisar</button>
            </div>
        </div>
        <table>
            <tbody>

            </tbody>
        </table>
    </section>
</div>
</body>
</html>
