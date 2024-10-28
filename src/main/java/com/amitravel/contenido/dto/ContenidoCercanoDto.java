package com.amitravel.contenido.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContenidoCercanoDto {
    private Long id;
    private String logo;
    private String nombre;
    private String descripcion;
    private String imagen;
}
