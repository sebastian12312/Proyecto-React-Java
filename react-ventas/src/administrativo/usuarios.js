import React, { useState, useEffect } from 'react';
export function ListaUsuario(){
const [listaUsuarios, setListaUsuario] = useState([]);    
useEffect(()=>{
    async function obtenerUsuarios(){
      try {
        const consulta =await fetch  ('http://localhost/api/administrador/usuario/listar');     
            const respuestas = await consulta.json();
            setListaUsuario(respuestas)
            console.log(respuestas)        
       // console.log(respuestas)   
      } catch (error) {
        console.log('error no se puedo conectar a la API')
      }
    }
    obtenerUsuarios()
    
},[])


}