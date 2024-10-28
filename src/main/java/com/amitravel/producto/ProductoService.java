package com.amitravel.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ResponseEntity<Producto> obtener(String lang, Long id) throws Exception {
        log.info("ProductoService::obtener::lang:{}:id:{}", lang, id);

        Optional<Producto> producto = this.productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new Exception("No existe el producto");
        }

        Producto response = producto.get();
        log.info("ProductoService::obtener::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<List<Producto>> negocio(String lang, Long negocioId) {
        log.info("ProductoService::negocio::lang:{}:negocioId:{}", lang, negocioId);

        List<Producto> response = this.productoRepository.findAllByNegocioId(negocioId);
        log.info("ProductoService::negocio::response:{}", response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
