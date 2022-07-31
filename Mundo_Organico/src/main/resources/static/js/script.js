var contador = document.getElementById('quantidade');
var quantidade = 0;

function increment() {
    quantidade += 1;
    mandar();
    contador.innerHTML = quantidade;
}

function decrement() {
    if(quantidade == 0){
        quantidade = 0;
        mandar();
        contador.innerHTML = quantidade;
        
    } else {
        quantidade -= 1;
        mandar();
        contador.innerHTML = quantidade;
    }
}

function mandar() {
    var myelement = document.querySelector('input[name="quant"]');
    myelement.value = quantidade;
    console.log(myelement.value)
}