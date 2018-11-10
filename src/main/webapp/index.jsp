<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Illud</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="resources/css/style.css">
        
        <script src="https://use.fontawesome.com/releases/v5.5.0/js/all.js" data-auto-replace-svg="nest"></script>
        <script src="resources/js/menu-sidebar.js"></script>
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

                <a href="#" class="item"><i class="fas fa-book icon"></i>Livros</a>
                <a href="resources/pages/register.html" class="item"><i class="fas fa-database icon"></i>Cadastrar</a>
                <a href="#" class="item last"><i class="fas fa-search icon"></i>Buscar</a>

                <ul>
                    <li><a href="#" class="inline"><i class="fab fa-facebook"></i></a></li>
                    <li><a href="#" class="inline"><i class="fab fa-facebook"></i></a></li>
                    <li><a href="https://github.com/ggpereira" class="inline"><i class="fab fa-github"></i></a></li>
                    <li><a href="https://github.com/odcmello" class="inline"><i class="fab fa-github"></i></a></li>
                </ul>
            </div>
        </div>
    </body>
</html>