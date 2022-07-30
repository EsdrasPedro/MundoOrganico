var contador = document.getElementById('quantidade');
var quantidade = 0;

function increment() {
    quantidade += 1;
    contador.innerHTML = quantidade;
}

function decrement() {
    if(quantidade == 0){
        quantidade = 0;
        contador.innerHTML = quantidade;
        
    } else {
        quantidade -= 1;
        contador.innerHTML = quantidade;
    }
}