package com.amitravel.anuncio;

import java.io.Serializable;
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
@Table(name = "ANUNCIOS")
public class Anuncio implements Serializable {
	private static final long serialVersionUID = 1428397998291624013L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT(11)", nullable = false)
	private Long id;

	@Setter
	@Getter
	@Column(name = "negocio_id", columnDefinition = "INT(11)", nullable = false)
	private Long negocioId;

	@Setter
	@Getter
	@Column(name = "nombre", columnDefinition = "VARCHAR(150)", nullable = false)
	private String nombre;

	@Setter
	@Getter
	@Column(name = "descripcion", columnDefinition = "TEXT", nullable = true)
	private String descripcion;

	@Setter
	@Getter
	@Column(name = "imagen", columnDefinition = "VARCHAR(350)", nullable = false)
	private String imagen;

	@Setter
	@Getter
	@Column(name = "url", columnDefinition = "VARCHAR(150)", nullable = false)
	private String url;

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
