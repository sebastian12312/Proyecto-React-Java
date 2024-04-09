import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {HeaderAdministrador} from './componentes/clientes/header';
import reportWebVitals from './reportWebVitals';


const header_administrator = ReactDOM.createRoot(document.getElementById('header-administrator'));
header_administrator.render(
  <React.StrictMode>
    <HeaderAdministrador />
  </React.StrictMode>
);
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
