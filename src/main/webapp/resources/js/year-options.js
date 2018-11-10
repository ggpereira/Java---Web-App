
//Gera opções de 2018 até 1900
function initYearOptions(elementId) {
    var date = new Date();
    var currentYear = date.getFullYear();
    var yearOptions = "<option value = 0>" + currentYear + "</options>";
    var asc_index = 0;
    //DESC SORT
    for (var i = currentYear; i >= 1900; i--) {
        yearOptions += "<option value = '" + i + "'}> " + i + " </option>";
    }

    document.getElementById(elementId).innerHTML = yearOptions;
}

