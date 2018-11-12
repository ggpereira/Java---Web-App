
//Gera opções de 2018 até 1900
function initYearOptions(elementId) {
    var date = new Date();
    var currentYear = date.getFullYear();
    var yearOptions = "<option value = " + currentYear +">" + currentYear + "</options>";
    //DESC SORT
    for (var i = currentYear; i >= 1900; i--) {
        yearOptions += "<option value = '" + i + "'}> " + i + " </option>";
    }

    document.getElementById(elementId).innerHTML = yearOptions;
}

//Carrega todos os países
function initCountryOptions(elementId) {
    $.getJSON("resources/js/countries.json", 
        function(data){
            var cOptions = "<option value = Brasil>" + "Brasil" + "</options>";
            countries = data;
            console.log(countries.length);
            countries.forEach((data) => {
                console.log(data.nome_pais);
                cOptions += "<option value = '" + data.nome_pais + "'}> " + data.nome_pais + " </option>";
            });
            
            document.getElementById(elementId).innerHTML = cOptions;
        }
     )
}
