import React from "react"

export default class Formulario extends React.Component{

constructor(props){
    super(props);
    this.state={
        first_name:"",
        last_name:"",
        email:"",


    }
}

asignarValoresFormulario=(e)=>{

   this.setState({[e.target.name]: e.target.value});
//uso onChange={(e)=> {this.asignarValoresFormularioOld(e)}}


}

asignarValoresFormularioold(NombrePropiedad,valor){

     let estado={};
     estado[NombrePropiedad]=valor;
    this.setState(estado);
//uso onChange={(e)=> {this.asignarValoresFormularioOld(e.target.name,e.target.value)}}


}

enviarValoresFormulario=(e)=>{
    e.preventDefault();
    console.log("HOLA MUNDO");
    this.limpiarValoresFormulario();
}



limpiarValoresFormulario=()=>{
    this.setState({
        first_name:"",
        last_name:"",
        email:""


    })

}

render(){

    return(
    <>
    <form onSubmit={this.enviarValoresFormulario}>
        <input 
        id="first_name"
        name="first_name"
        type="text"
        placeholder="Ingresa un Nombre"
        value={this.state.first_name}
        required={true}
        onChange={this.asignarValoresFormulario}

        />
 <input 
     
       id="last_name"
       name="last_name"
       type="text"
       placeholder="Ingresa un Apellido"
       required={true}
       value={this.state.last_name}
       onChange={this.asignarValoresFormulario}
       />

<input 
     
       id="email"
       name="email"
       type="email"
       placeholder="Email@dominio.ext"
       required={true}
       value={this.state.email}
       onChange={this.asignarValoresFormulario}
       />

    <div>
        <button type="submit">Agregar</button>
        <button onClick={this.limpiarValoresFormulario} type="reset">Limpiar Formulario</button>

    </div>
    

    </form>
    
    
    </>)
}



}