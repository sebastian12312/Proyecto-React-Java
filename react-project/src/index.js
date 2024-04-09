import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {HeaderAdministrador} from './componentes/clientes/header';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter} from 'react-router-dom';
import {Home} from './page/Home'
import App from './App'
import Layout from './page/Layout';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
<React.StrictMode>
      <App/>
</React.StrictMode>
)
reportWebVitals();
