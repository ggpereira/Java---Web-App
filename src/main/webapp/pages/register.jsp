<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="register-form">
        <script type="text/javascript">
            initYearOptions('yearPicker');
        </script>

        <h1>Cadastro</h1>
        <form action="#" method="post">
            <h2>Livro</h2>
            <input type="text" name="title" placeholder="Ex: As Crônicas de Nárnia">
            <input type="text" name="barcode" placeholder="Ex: 3849C823F">
            <select id="yearPicker" name="year"></select>
            <h2>Autor</h2>
            <input type="text" name="author" placeholder="Ex: J.R.R Tolkien">
            <input type="text" name="nacionalidade" placeholder="Ex: Inglaterra">
            <h2>Editora</h2>
            <input type="text" name="publisher_name" placeholder="Ex: LeYa">
            <input type="text" name="street_name" placeholder="Ex: Rua...">
            <input type="text" name="state_name" placeholder="Ex: Rio Grande do Sul">
            <input type="text" name="country_name" placeholder="Ex: Brasil">
        </form>        
        <div>

            </html>


<!--<h1>Cadastrar livros</h1>-->