const Imagen= () =><img src="https://www.educacionit.com/svg/medios/clarin.svg"></img>

function Funciones(prop){
return(
    <div>
    <h1>{prop.Titulo}</h1>
    <h2>{prop.Subtitulo}</h2>
    <h2>{prop.Parrafo}</h2>
     <Imagen/>

    </div>
)



}
export default Funciones;