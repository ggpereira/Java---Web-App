<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="register-form">
        <script type="text/javascript">
            initYearOptions('yearPicker');
            initCountryOptions('countryPicker');
        </script>
        
        <div>
        
        <div class="form-header">
            <h1>Cadastro</h1>
        </div>
        
        <form action="#" method="post" autocomplete="off">
            
            
            <h2>Livro</h2>
            
            <label>Título</label>
            <input type="text" name="title" placeholder="Ex: As Crônicas de Nárnia">
            
            <label>Código de Barras</label>
            <input type="text" name="barcode" placeholder="Ex: 3849C823F">
            
            <label>Ano</label>
            <select id="yearPicker" name="year"></select>
            
            
            
            <h2>Autor</h2>
            
            <label>Nome</label>
            <input type="text" name="author" placeholder="Ex: J.R.R Tolkien">
            
            <label>Nacionalidade</label>
            <input type="text" name="nacionalidade" placeholder="Ex: Inglaterra">
            
            
            <h2>Editora</h2>
            
            <label>Nome</label>
            <input type="text" name="publisher_name" placeholder="Ex: LeYa">
            
            <label>Rua</label>
            <input type="text" name="street_name" placeholder="Ex: Rua...">
            
            <label>Estado</label>
            <input type="text" name="state_name" placeholder="Ex: Rio Grande do Sul">
            
            <label>País</label>
            <select id="countryPicker" name="country"></select>
        </form>        
    <div>
        
</html>


