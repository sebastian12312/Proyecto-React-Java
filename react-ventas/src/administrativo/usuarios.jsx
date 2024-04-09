import React, { useState, useEffect } from 'react';
import '../index.css';
export function BuscarUsuario() {
    const [buscarUsuario, setBuscarUsuario] = useState('');
    const [usuarioEncontrado, setUsuarioEncontrado] = useState([]);
  
    // Función para manejar cambios en el input
    const valor = (event) => {
      setBuscarUsuario(event.target.value);
    };
  
    // Función para manejar clic en el botón
    const handleClick = async () => {
      console.log('Valor del input:', buscarUsuario);
        try {
            const consulta = await fetch('http://localhost/api/administrador/usuario/buscar/' + buscarUsuario);
           if(consulta.ok){
            const res = await consulta.json();
            setBuscarUsuario(res)
            console.log(res.user.nombre)
           }else{
            console.log(ErrorEvent)
           }
          
        } catch (error) {
            console.log(console.error())
        }
    
    };
  
    
    return (
      <div className='flex'>
        <button onClick={handleClick} className='border py-2 px-6 rounded'>Obtener valor</button>
        <input 
          type="text" 
          value={buscarUsuario} 
          onChange={valor} 
          className='border py-2 px-6 rounded' 
          placeholder='Buscar usuario por ID' 
        />
      </div>
    );
  }
export function ListaUsuario() {
    const [listaUsuarios, setListaUsuario] = useState([]);
    useEffect(() => {
        async function obtenerListaUsuarios() {
            try {
                const consulta = await fetch('http://localhost/api/administrador/usuario/listar');
                const respuestas = await consulta.json();
                if (respuestas != null) {
                    setListaUsuario(respuestas)
                } else {
                    setListaUsuario(null)
                }  
            } catch (error) {
                setListaUsuario(null)
                console.log('error no se puedo conectar a la API')
            }
        }
        obtenerListaUsuarios();

    }, [])
    return (
        <div className='mx-16'>
            <table class="w-full border-collapse ">
                <thead>
                    <tr class="border-b-2 border_color text-center font-bold">
                        <td class="p-4  ">
                            <div class="flex ">
                                <span>codigo</span> <i class="bi bi-chevron-expand"></i>
                            </div>
                        </td>
                        <td class="p-4 ">
                            <div class="flex"><span>nombre</span> <i class="bi bi-chevron-expand"></i></div>
                        </td>
                        <td class="p-4 ">
                            <div class="flex"><span>apellido</span> <i class="bi bi-chevron-expand"></i>
                            </div>
                        </td>

                        <td class="p-4 ">
                            <div class="flex"><span>correo</span> <i class="bi bi-chevron-expand"></i>
                            </div>
                        </td>
                        <td class="p-4 ">
                            <div class="flex"><span>telefono</span> <i class="bi bi-chevron-expand"></i>
                            </div>
                        </td>
                        <td class="p-4 ">
                            <div class="flex"><span>accion</span> <i class="bi bi-chevron-expand"></i>
                            </div>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    {listaUsuarios != null ? (
                        listaUsuarios.map((listaUsuario, index) => (
                            <tr key={index} className="border-b border_color text-sm">
                                <td className="p-4">{listaUsuario.id_usuario}</td>
                                <td className="p-4">{listaUsuario.nombre}</td>
                                <td className="p-4">{listaUsuario.primer_apellido} {listaUsuario.segundo_apellido}</td>
                                <td className="p-4">{listaUsuario.correo}</td>
                                <td className="p-4">{listaUsuario.telefono}</td>
                                <td className="p-4">
                                    <a><i className="bi bi-list-ul"></i></a>
                                </td>
                            </tr>
                        ))
                    ) : (
                        <td colSpan="6" className="p-4 bg-gray-200" colspan="6">
                            <div className="w-full">No hay usuarios disponibles</div>
                        </td>
                    )}

                </tbody>
            </table>
        </div>

    )

}