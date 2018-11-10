function changeContent(divname, filename) {
    console.log("trocando para " + filename);
    $(divname).load(filename);
}