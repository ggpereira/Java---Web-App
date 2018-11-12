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
        
        <form action="insertlivro" method="post" autocomplete="off">
            
            <h2>Livro</h2>
            <div class="book-form">
                <p>
                    <label for="">Título</label>
                    <input type="text" name="title" placeholder="Ex: As Crônicas de Nárnia">
                </p>
                <p>
                    <label for="">Código de Barras</label>
                    <input type="text" name="barcode" placeholder="Ex: 3U49G23F23">
                </p>
                <p>
                    <label for="">Ano</label>
                    <select id="yearPicker" name="year" style="font-size: 18px; height: 30px; border-radius: 5px"></select>
                </p>
            </div>
            
            <h2>Autor</h2>
            <div class="author-form">
                <p>
                    <label for="">Nome</label>
                    <input type="text" name="author" placeholder="Ex: J.R.R Tolkien">
                </p>
                <p>
                    <label for="">Nacionalidade</label>
                    <input type="text" name="nacionalidade" placeholder="Ex: Inglaterra">
                <p>
            </div>
             
            <h2>Editora</h2>
            <div class="publisher-form">
                <p>
                    <label for="" >Nome</label>
                    <input type="text" name="publisher_name" placeholder="Ex: LeYa">
                </p>
                <p>
                    <label for="" >Rua</label>
                    <input type="text" name="street_name" placeholder="Ex: Rua...">
                </p>
                <p>
                    <label for="" >Estado</label>
                    <input type="text" name="state_name" placeholder="Ex: Rio Grande do Sul">
                </P>
                <p>
                    <label for="" >País</label>
                    <select id="countryPicker" name="country" style="height: 30px; font-size: 18px; border-radius: 5px;"></select>
                </p>
            </div>
            <input type="submit" value="Cadastrar">
        </form>        
    </div>
        
</html>


