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
import  Usuarios from "./Componentes/recursos/archivos/usuarios.json"
import Formulario from "./Componentes/Formulario"


ReactDOM.render(
  <React.StrictMode>
<Formulario/>
<App/>


{
Usuarios.map((e) => 


<Usuario 
key={e.id}
id= {e.id}
email= {e.email}
user_name={e.user_name}
first_name= {e.first_name}
last_name= {e.last_name}
avatar= {e.avatar}
mostrarEmail = {e.mostrarEmail}

/>  )}
                

</React.StrictMode>,

  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
