import React from "react";
import "./recursos/CSS/usuario.css";


export default class Usuario extends React.Component {

    constructor(props){
        super(props);


        this.state ={

            id: this.props.id,
            email: this.props.email,
            user_name: this.props.user_name,
            first_name: this.props.first_name,
            last_name: this.props.last_name,
            avatar: this.props.avatar,
            mostrarEmail:true


        }

    }

    CambiarUserName =()=>{
        this.setState({

            user_name:this.state.mostrarEmail?(this.state.first_name + ' ' +this.state.last_name) : this.state.email,
            mostrarEmail:!this.state.mostrarEmail

        })
    
    }
    
    
    
    render(){
        return(
        <div className="tarjeta">
            <img src={this.state.avatar}/>    
            <div>
            <h2>{this.state.user_name}</h2>
            <button onClick={this.CambiarUserName} >Mostrar {this.state.mostrarEmail?"Nomnbre" : "Email"} </button>
            
            </div>
            
            
            </div>);
    }


}