function changeContent(divname, path) {
    //Troca o código html interno de uma div para o html indicado no path
    $(divname).load(path);
}