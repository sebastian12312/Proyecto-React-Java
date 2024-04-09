import React from "react";
import { useState, useEffect } from "react";
import '../../index.css';
import '../../componentes/css/cliente.css'

import $ from 'jquery';

export function ValidacionCliente() {
    const [modalOpen, setModalOpen] = useState(false);
    const [idUsuario, setIdUsuario] = useState('');
    const [contrasena, setContrasena] = useState('');
    const [cliente, setCliente] = useState([]);

    const idUsuarioChange = (event) => {
        setIdUsuario(event.target.value);
    };

    const contrasenaChange = (event) => {
        setContrasena(event.target.value);
    };

    const openModal = () => {
        setModalOpen(true);
    };

    const closeModal = () => {
        setModalOpen(false);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const consulta = await ConsultaCliente({ idUsuario, contrasena });
            if (consulta && consulta.nombre) {
                setCliente(consulta);
                localStorage.setItem("nombre", consulta.nombre);
                closeModal();
            } else {
                setCliente(null);
            }
           
        } catch (error) {
            setCliente(null);
            console.error('Error al consultar el cliente:', error);
            // Manejar el error, si es necesario
        }
    };

    //inactividad

    const results = localStorage.getItem("nombre");
    const [inactividad, setInactividad] = useState(false);
    let timeoutId;

    useEffect(() => {
        const resetTimeout = () => {
            clearTimeout(timeoutId);
            timeoutId = setTimeout(() => {
                localStorage.removeItem("nombre");
                setInactividad(true);
            }, 1000 * 10 ); // 5 segundos (para propósitos de prueba)
        };
        // Reiniciar el temporizador cuando se realiza una acción en la pantalla
        const handleClick = () => {
            setInactividad(false);
            resetTimeout();
        };
        window.addEventListener('click', handleClick);
        // Iniciar el temporizador
        resetTimeout();
        // Limpiar el event listener al desmontar el componente
        return () => {
            clearTimeout(timeoutId);
            window.removeEventListener('click', handleClick);
        };
    }, []); // Sin dependencias para ejecutar solo una vez al montar el componente

    useEffect(() => {
        if (inactividad) {
            // Aquí puedes realizar la acción que deseas después de 3 minutos de inactividad
            console.log('Se ha alcanzado la inactividad durante 5 segundos');
            // Por ejemplo, cerrar sesión, mostrar un mensaje, etc.
        }
    }, [inactividad]);

    if (results == null) {
        return (
            <>
                <div>
                    <div className="flex gap-2 text-sm">
                        <a onClick={openModal} className="border rounded-lg px-4 py-2 bg-purple-800 hover:bg-purple-900 text-white font-bold">
                            Iniciar sesión
                        </a>
                        <a href="#" className="border  rounded-lg  rounded px-4 py-2 bg-white border-purple-800  hover:bg-purple-300 text-purple-800 font-bold">
                            Registrarse
                        </a>
                    </div>
                    {modalOpen && (
                        <ModalLogin
                            respuesta = {results}
                            idUsuario={idUsuario}
                            contrasena={contrasena}
                            idUsuarioChange={idUsuarioChange}
                            contrasenaChange={contrasenaChange}
                            closeModal={closeModal}
                            handleSubmit={handleSubmit}
                        />
                    )}
                </div>
            </>
        );
    } else {
        return (
            <>
                <div className="flex gap-2 text-sm">
                    <a className="border rounded px-4 py-2">
                        {results}
                    </a>
                </div>

            </>
        );
    }
}
function ModalLogin({respuesta, closeModal, idUsuario, contrasena, idUsuarioChange, contrasenaChange, handleSubmit }) {
    const [rpta, setrpta] = useState(false)
    if(respuesta != null || respuesta != "" || respuesta != undefined){      
        $('#mensaje_login').html('<p className="text-red-700 text-sm">Credenciales incorrectas</p>')     
        setTimeout(() => {
            $('#mensaje_login').html('')     
        }, 3000);
        }else{            
            $('#mensaje_login').html('')     
        }
    return (
        <div className="fixed inset-0 flex justify-center items-center bg_modal text-black">
            <form onSubmit={handleSubmit} className="w-full max-w-md bg-white p-8 rounded-lg shadow-md">
                <div>
                    <h1>Inicie sesión para continuar</h1>
                </div>
                <div className="mb-4">
             
                        <p  id="mensaje_login"></p>
             
                    <label htmlFor="id_usuario" className="block">
                        ID de usuario:
                    </label>
                    <input
                        id="id_usuario"
                        value={idUsuario}
                        onChange={idUsuarioChange}
                        type="text"
                        className="border rounded w-full px-4 py-2"
                        placeholder="Ingrese su ID"
                    />
                </div>

                <div className="mb-4">
                    <label htmlFor="contrasena" className="block">
                        Contraseña:
                    </label>
                    <input
                        id="contrasena"
                        value={contrasena}
                        onChange={contrasenaChange}
                        type="password"
                        className="border rounded w-full px-4 py-2"
                        placeholder="Ingrese su contraseña"
                    />
                </div>

                <div className="flex justify-center">
                    <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-4">
                        Iniciar sesión
                    </button>
                    <button onClick={closeModal} className="bg-gray-300 hover:bg-gray-400 text-gray-800 font-bold py-2 px-4 rounded">
                        Cerrar
                    </button>
                </div>
            </form>
        </div>
    );
}
async function ConsultaCliente({ idUsuario, contrasena }) {
    try {
        const respuesta = await fetch('http://localhost/autenticacion/login?numero_doc=' + idUsuario + '&contrasena_usuario=' + contrasena + '', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const data = await respuesta.json();
        // Verificar si la respuesta contiene datos válidos
        if (respuesta.ok && data && data.nombre) {
            return data;
        } else {
            return null;
        }
    } catch (error) {
        console.error('Error:', error);
        return null;
    }
}

