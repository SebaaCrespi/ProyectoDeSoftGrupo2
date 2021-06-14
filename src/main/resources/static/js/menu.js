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

$('#botonBusqueda').on('click', () =>{
    var busquedaData = $('#busquedaData').val();
    $.ajax({method: "GET",url:"/universidad/buscar",data:{ busqueda: busquedaData}})
    .done((response)=>{
        $('#contenedorUniv .univ').css("display","none");
        $('#contenedorUniv').html(response);
        console.log(response)
    })
    .fail(()=>{

    })
    .always(()=>{

    });
});
