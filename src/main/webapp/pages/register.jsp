<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="register-form">
        <script type="text/javascript">
            initYearOptions('yearPicker');
            initCountryOptions('countryPicker');
        </script>
        
        <div class="form-header">
            <h1>Cadastro</h1>
        </div>
        
        <form action="#" method="post" autocomplete="off">
            
            <h2 style="font-size: 32px">Livro</h2>
            
            <div class="book-form">
                <label>Título</label>
                <input type="text" name="title" placeholder="Ex: As Crônicas de Nárnia">
                <label>Código de Barras</label>
                <input type="text" name="barcode" placeholder="Ex: 3849C823F">
                <label>Ano</label>
                <select id="yearPicker" name="year"></select>
            </div>
            
            
            <h2 style="font-size: 32px">Autor</h2>
            
            <div class="author-form">
                <label>Nome</label>
                <input type="text" name="author" placeholder="Ex: J.R.R Tolkien">
                <label>Nacionalidade</label>
                <input type="text" name="nacionalidade" placeholder="Ex: Inglaterra">
            </div>
            
            <h2 style="font-size: 32px">Editora</h2>
            
            <div class="publisher-form">
                <label>Nome</label>
                <input type="text" name="publisher_name" placeholder="Ex: LeYa">
                <label>Rua</label>
                <input type="text" name="street_name" placeholder="Ex: Rua...">
                <label>Estado</label>
                <input type="text" name="state_name" placeholder="Ex: Rio Grande do Sul">
                <label>País</label>
                <select id="countryPicker" name="country"></select>
            </div>
        </form>        
    </div>
        
</html>


