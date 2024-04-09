import React from "react";
import { useState, useEffect } from "react";
import '../../index.css';
import '../../componentes/css/alertas.css'
import imagen from '../../img.png'
import { CiShoppingCart } from "react-icons/ci"
import { CiBadgeDollar } from "react-icons/ci"
import { MoonLoader } from "react-spinners";
import {AgregarCarrito} from '../clientes/carrito'
import Alert from '@mui/material/Alert';
import { ButtomCarrito } from "../clientes/carrito";
import $ from 'jquery';
import ready from 'jquery';
export function Productos() {
    const [productos, setProductos] = useState([])
    async function listarProductos() {
        try {
            const consulta = await fetch('http://localhost/administrador/controlador/producto/listar')
            const respuesta = await consulta.json();
            //   console.log(respuesta)
            setProductos(respuesta)
            // Changed the string concatenation to comma-separated arguments
        } catch (error) {
            console.log("error", error); // Log the error message
        }
    }
    useEffect(() => {
        listarProductos();

    }, []);
    const [contador, setContador] = useState(0);

    $('.id_buttom_carrito').on('click', async function(event) {
        const id_producto = $(this).val();
       const respuestaCarrito = await  AgregarCarrito( {id_producto} ) 
       if(respuestaCarrito === true){
      
        $("#contenedor_alerta").addClass('activarAlerta');
        $("#contenedor_alerta").addClass('respuestaCorrecta');
        $('#mensaje_alerta').text('Producto Agregado Al carrito!')
        setTimeout(function(){
            $("#contenedor_alerta").removeClass('activarAlerta');
         
        }, 3500);
        const count = setContador(contador+1)
        ButtomCarrito({count})
        console.log(contador)
        }else{
            $("#contenedor_alerta").addClass('activarAlerta');
            $("#contenedor_alerta").addClass('respuestaIncorrecta')
            $('#mensaje_alerta').text('Producto No pudo se Agregado!')
            setTimeout(function(){
                $("#contenedor_alerta").removeClass('activarAlerta');
             
            }, 3500);
        }
    });

   if(productos.length>0){
    return (
        <div className="flex gap-4 flex-wrap justify-center mt-8 ">
            <div class="contenedor_alerta  " id="contenedor_alerta">
                <div class="alerta" id="alerta">
                    <div class="icon_alerta">
                    <CiShoppingCart className="mt-auto mb-auto text-2xl"/>
                    </div>
                    <div>
                        <span id="mensaje_alerta"></span>
                    </div>
                </div>
                <div class="slider_alerta"></div>
            </div>


            {productos.map((producto, index) => (
                <div key={index} className=" py-6 w-96 h-56 border rounded  shadow-md">
                    <div className="flex justify-around gap-4 flex justify-around ">
                        <div className="w-24">
                            <img src={imagen} alt="" />
                        </div>
                        <div>
                            <div className="text-center  mb-2">
                                {producto.id_producto}
                            </div>
                            <div className="text-sm flex gap-4 justify-between mb-2">
                                <span>nombre:</span>
                                <span>{producto.nombre_producto}</span>
                            </div>
                            <div className="text-sm flex gap-4  justify-between  mb-2">
                                <span>precio:</span>
                                <span>{producto.precio_unit}</span>
                            </div>
                            <div className="text-sm flex gap-4  justify-between  mb-2">
                                <span>cantidad:</span>
                                <span>S/ {producto.cantidad_stock}</span>
                            </div>
                        </div>
                    </div>
                    <div className="flex gap-2 justify-center mt-2 w-full">
                   
                        <button value={producto.id_producto} className="id_buttom_carrito flex border rounded   bg-black hover:bg-gray-800 text-white py-2 px-6 w-36 cursor-pointer mt-auto mb-auto gap-1" >                      
                        <CiShoppingCart className="mt-auto mb-auto text-2xl"/>
                        Agregar 
                        
                        </button>

                        <div className="">
                            <a className="border rounded py-2 px-4 w-36 flex bg-sky-700 hover:bg-sky-900 text-white cursor-pointer"><span className="mt-auto m-auto">comprar</span> <i className="mt-auto m-auto text-xl"><CiBadgeDollar /></i></a>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    )
   }else{
    return(
        <div>
            no hay productos
        </div>
    )
   }
}

