import React ,{Component} from "react";
import Avatar from './Componentes/recursos/imagenes/avatar.png';

class App extends Component{

constructor(props){
    super(props);
    this.state={
        usuarios:[]
    }
}

//metodo heredado de component que se activa cuando se carga el componente
componentDidMount(){
    this.buscarUsuario()
    
}

buscarUsuario=()=>{
//promesas
const URL="https://reqres.in/api/users";
fetch(URL).then((response)=>response.text())
.then((texto)=>console.log(texto))

}


render(){
return(<>
      
      </>)}

}
export default App;