function changeContent(divname, path) {
    console.log("trocando para " + path);
    $(divname).load(path);
}