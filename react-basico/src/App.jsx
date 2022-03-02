import React, { Component } from "react";
import Avatar from './Componentes/recursos/imagenes/avatar.png';
import Usuarios from "./Componentes/recursos/archivos/usuarios.json"
import Formulario from "./Componentes/Formulario"
import Usuario from './Componentes/Usuario';
import avatar from './Componentes/recursos/imagenes/avatar.png'
class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            usuarios: []
        }
    }

    //metodo heredado de component que se activa cuando se carga el componente
    componentDidMount() {
        this.buscarUsuario();

    }

    buscarUsuario = () => {
        //promesas para obtener los usuarios
        const URL = "https://reqres.in/api/users";
        fetch(URL).then((response) => response.json()).
            then((json) => this.setState({
                usuarios: json.data
            })).
            catch((error) => console.log("Error"))


    }

    agregarUsuarioArreglo = (correo, nombre, apellido) => {
        const usuario = {
            email: correo,
            first_name: nombre,
            last_name: apellido,
            avatar: avatar

        }
        this.agregarUsuarioApi(usuario);
    }

    agregarUsuarioApi = (usuario) => {
        const URL = "https://reqres.in/api/users";
        const HEADER = {
            method: "POST",
            body: JSON.stringify(usuario),
            headers: { "Content-Type": "application/json" }
        }

        fetch(URL, HEADER).then((response) => response.json())
            .then((json) => this.setState({usuarios:[...this.state.usuarios,json]}))
            .catch((error) => console.log("Error"))

    }

    render() {

        return (<>
            <Formulario agregarUsuario={this.agregarUsuarioArreglo} />

            {

                this.state.usuarios.map((e) =>
                    <Usuario
                        key={e.id}
                        id={e.id}
                        email={e.email}
                        user_name={e.user_name}
                        first_name={e.first_name}
                        last_name={e.last_name}
                        avatar={e.avatar}
                        mostrarEmail={e.mostrarEmail}

                    />)}



        </>)
    }

}
export default App;