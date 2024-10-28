package com.amitravel.agenda;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name = "AGENDAS")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 7090575185584871217L;

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
	@Column(name = "evento_id", columnDefinition = "INT(11)", nullable = true)
	private Long eventoId;

	@Setter
	@Getter
	@Column(name = "nombre", columnDefinition = "VARCHAR(150)", nullable = false)
	private String nombre;

	@Setter
	@Getter
	@Column(name = "descripcion", columnDefinition = "VARCHAR(200)", nullable = true)
	private String descripcion;

	@Setter
	@Getter
	@Column(name = "fecha", columnDefinition = "DATE", nullable = false)
	private LocalDate fecha;

	@Setter
	@Getter
	@Column(name = "hora", columnDefinition = "TIME", nullable = true)
	private LocalTime hora;

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
