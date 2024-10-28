package com.amitravel.busqueda;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "BUSQUEDAS")
public class Busqueda implements Serializable {
	private static final long serialVersionUID = 8724528873946580265L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)", nullable = false)
	private Long id;

	@Setter
	@Getter
	@Column(name = "usuario_id", columnDefinition = "INT(11)", nullable = false)
	private Long usuarioId;

	@Setter
	@Getter
	@Column(name = "contenido", columnDefinition = "VARCHAR(150)", nullable = false)
	private String contenido;

	@Setter
	@Getter
	@Column(name = "visitada", columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime visitada;

	@Setter
	@Getter
	@Column(name = "estatus", columnDefinition = "BIT(1)", nullable = false)
	private Boolean estatus;

	@Getter
	@CreationTimestamp
	private Timestamp creacion;

	@Getter
	@UpdateTimestamp
	private Timestamp actualizacion;
}
