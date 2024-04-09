import { CiBag1 } from "react-icons/ci"
import '../../index.css';
import { MoonLoader } from "react-spinners";
import { useEffect, useState } from "react";
export function ButtomCarrito ({count}){
    useEffect(()=>{
        
    })
    return(
        <div className="fixed bottom-8 right-8 text-4xl border rounded-full p-2 bg-violet-800 text-white shadow-md">
        <button  className="relative"><i><CiBag1 /></i> 
         <a className="text-sm  absolute top-2.5 left-4 text-black-900"> </a></button>       
       </div> 
    )
}


export async function AgregarCarrito({ id_producto }) {
    var bool = true;

    try {
        const consulta = await fetch('http://localhost/administrador/controlador/producto/agregar/carrito/121' +id_producto + '')
        const respuesta = await consulta.json();
        if(respuesta != null || respuesta != ""){
            bool  = true;
        }else{
            bool = false;
        }
    } catch (error) {
        bool = false;
    }
    return bool;

}