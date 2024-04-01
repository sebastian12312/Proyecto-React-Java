import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {ListaUsuario} from './administrativo/usuarios';
import {OpcionesAdministrador} from './administrativo/dashboard';
import reportWebVitals from './reportWebVitals';


const opciones_administrador =ReactDOM.createRoot(document.getElementById('opciones_administrador'));
opciones_administrador.render(
  <React.StrictMode>
  <OpcionesAdministrador />
  <ListaUsuario />
</React.StrictMode>
)

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
