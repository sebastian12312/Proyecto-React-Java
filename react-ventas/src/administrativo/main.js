import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {Header} from './dashboard';

function redirectToDashboard() {
    window.location.href = '/public/administrador/dashboard';
  }
  ReactDOM.render(
    <React.StrictMode>
      <header />
    </React.StrictMode>,
    document.getElementById('header')
  );
  export { redirectToDashboard };