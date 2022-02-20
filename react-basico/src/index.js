import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Funciones from './Funciones';
import Clases from './Clases';
import Usuario from './Componentes/Usuario';
import avatar from './Componentes/recursos/imagenes/avatar.png'
import "./Componentes/recursos/CSS/usuario.css"

ReactDOM.render(
  <React.StrictMode>
  <Usuario  id= "3"
            email= "emma.wong@reqres.in"
            user_name="emmaWon"
            first_name= "Emma"
            last_name= "Wong"
            avatar= "https://reqres.in/img/faces/3-image.jpg"
            mostrarEmail = "true"
            
            />  
                
<Funciones/>
</React.StrictMode>,

  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
