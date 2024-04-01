package com.web.proyecto.ventas.usuarios.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="tipo_documento")
public class TipoDocumento {
    @Id
    private int id_documento;
    private String nombre_documento;
    private String descripcion;
}
