package com.web.proyecto.ventas.usuarios.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuario_saldo")
@Data
public class UsuarioSaldo {
    @Id
    private String id_usuario;
    private double saldo_usuario;
    private int id_moneda;
}
