package com.web.proyecto.ventas.usuarios.clases;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    private String id_usuario;
    
    private int id_documento;
    private String numero_doc;
    private String  nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String  telefono;
    private String  correo;
    private String contrasena_usuario;
    private int   id_genero;
    private String  fecha_nacimiento;
    private int id_rol;
    private int  id_membresia;
    private String fecha_registro;
    private String hora_registro;
    private int  id_estado_usuario;
}

