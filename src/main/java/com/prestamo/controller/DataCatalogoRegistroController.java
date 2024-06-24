package com.prestamo.controller;

import com.prestamo.entity.Catalogo;
import com.prestamo.entity.DataCatalogo;
import com.prestamo.repository.CatalogoRepository;
import com.prestamo.service.DataCatalogoService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/url/datacatalogo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class DataCatalogoRegistroController {
    @Autowired

    private DataCatalogoService dataCatalogoService;
    @Autowired

    private CatalogoRepository catalogoRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<DataCatalogo>> lista(){
        List<DataCatalogo> salida = dataCatalogoService.listaDataCatalogo(0);
        return ResponseEntity.ok(salida);
    }
    @GetMapping("/listarCatalogo")
    public ResponseEntity<List<Catalogo>> listaCatalogo(){
        List<Catalogo> salida = catalogoRepository.findAll();
        return ResponseEntity.ok(salida);
    }
    @PostMapping
    public ResponseEntity<?> registra(@RequestBody DataCatalogo bean) {
        HashMap<String, Object> salida = new HashMap<>();
        bean.setFechaRegistro(new Date());
        bean.setFechaActualizacion(new Date());
        bean.setEstado(AppSettings.ACTIVO);

        Optional<Catalogo> optionalCatalogo = catalogoRepository.findById(bean.getCatalogo().getIdCatalogo());
        if (!optionalCatalogo.isPresent()) {
            salida.put("mensaje", "Catálogo no encontrado");
            return ResponseEntity.badRequest().body(salida);
        }
        bean.setCatalogo(optionalCatalogo.get());

        DataCatalogo objSalida = dataCatalogoService.registrar(bean);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Registro de Catalogo con el ID >>> " + bean.getIdDataCatalogo() +
                    " >>> DES >> " + bean.getDescripcion());
        }
        return ResponseEntity.ok(salida);
    }
    @GetMapping("/validarCatalogoRegistro")
    public String validarCatalogo(@RequestParam(name = "descripcion")String descripcion) {
        List<DataCatalogo> salida = dataCatalogoService.listaDataCatalogoPorDescripcionIgual(descripcion);
        if(salida.isEmpty()) {
            return "{\"valid\":true}";
        }else {
            return "{\"valid\":false}";
        }
    }
}
