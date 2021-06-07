const hamburguer = document.querySelector('.hamburguesa')
const menu = document.querySelector('.menu-navegacion')

console.log(menu);
console.log(hamburguer);

hamburguer.addEventListener('click', ()=>{
    // hago que aparezca el menu
    menu.classList.toggle("spread")
})

window.addEventListener('click', e=>{
    if(menu.classList.contains('spread') && e.target != menu && e.target != hamburguer){
        menu.classList.toggle("spread")
    }
})