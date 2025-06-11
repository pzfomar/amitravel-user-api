package com.amitravel.usuario;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
	private static final long serialVersionUID = -5529019334801486592L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)", nullable = false)
	private Long id;

	@Setter
	@Getter
	@Column(name = "negocio_id", columnDefinition = "INT(11)", nullable = true)
	private Long negocioId;

	@Setter
	@Getter
	@Column(name = "apodo", columnDefinition = "VARCHAR(150)", nullable = false, unique = true)
	private String apodo;

	@Setter
	@Getter
	@Column(name = "contrasenia", columnDefinition = "VARCHAR(250)", nullable = false)
	private String contrasenia;

	@Setter
	@Getter
	@Enumerated(EnumType.STRING)
	@Column(name = "rol", columnDefinition = "VARCHAR(150)", nullable = false)
	private TipoRol rol;

	@Setter
	@Getter
	@Column(name = "estatus", columnDefinition = "BIT(1)", nullable = false)
	private Boolean estatus;

	@Getter
	@CreationTimestamp
	private LocalDateTime creacion;

	@Getter
	@UpdateTimestamp
	private LocalDateTime actualizacion;
}
