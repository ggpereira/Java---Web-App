<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Illud</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="resources/css/register-style.css">
        
        <script src="https://use.fontawesome.com/releases/v5.5.0/js/all.js" data-auto-replace-svg="nest"></script>
        <script src="resources/js/menu-sidebar.js"></script>
        <script src="resources/js/jquery-3.3.1.js"></script>
        <script src="resources/js/page-loader.js"></script>
        <script src="resources/js/selector-options.js"></script>
      
        
    </head>
    <body>
        <div id="content">

            <span class="slide" onClick="openSlideMenu()">
                <a href="#">
                    <i class="fas fa-bars"></i>
                </a>
            </span>

            <div id="menu" class="nav">
                <a href="#" class="close" onClick="closeSlideMenu()">
                    <i class="fas fa-times"></i>
                </a>
                <img class="menu-header" src="resources/img/illudlogo.png" heigth="47" width="150">

                <a href="#" class="item" onClick="changeContent('#page-content', 'pages/books-page.jsp')"><i class="fas fa-book icon"></i>Livros</a>
                <a href="#" class="item" onClick="changeContent('#page-content', 'pages/register.jsp')"><i class="fas fa-database icon"></i>Cadastrar</a>
                <a href="#" class="item last"><i class="fas fa-search icon"></i>Buscar</a>

                <ul>
                    <li><a href="#" class="inline"><i class="fab fa-facebook"></i></a></li>
                    <li><a href="#" class="inline"><i class="fab fa-facebook"></i></a></li>
                    <li><a href="https://github.com/ggpereira" class="inline"><i class="fab fa-github"></i></a></li>
                    <li><a href="https://github.com/odcmello" class="inline"><i class="fab fa-github"></i></a></li>
                </ul>
            </div>
            
            <div id="page-content">
                
            </div>
        </div>
    </body>
</html>