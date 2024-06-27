package com.prestamo.controller;

import com.prestamo.entity.Catalogo;
import com.prestamo.entity.DataCatalogo;
import com.prestamo.entity.Ejemplo;
import com.prestamo.repository.CatalogoRepository;
import com.prestamo.service.DataCatalogoService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
@RequestMapping("/url/crudDataCatalogo")

public class DataCatalogoCrudController {
    @Autowired
    private DataCatalogoService dataCatalogoService;
    @Autowired
    private CatalogoRepository catalogoRepository;
    @GetMapping("/listaDataCatalogoPorNombreLike/{descripcion}")
    @ResponseBody
    public ResponseEntity<?> listaDataCatalogoPorNombreLike(@PathVariable("descripcion") String descripcion){
        List<DataCatalogo> response=null;
        if(descripcion.equals("todos")){
            response=dataCatalogoService.listaDataCatalogo();
        }else{
            response=dataCatalogoService.listaDataCatalogoPorDescripcionLike(descripcion+"%");

        }
        return ResponseEntity.ok(response);
    }
    @PutMapping("/actualizarDataCatalogo")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarDataCatalogo(@RequestBody DataCatalogo obj){
        Map<String, Object> response = new HashMap<>();
        try{
            obj.setFechaActualizacion(new Date());
            DataCatalogo salida = dataCatalogoService.registrar(obj);
            if(salida==null){
                response.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
            }
            else {
                response.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + " Ejemplo de ID ==> " + obj.getIdDataCatalogo() + ".");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/eliminaDataCatalogo/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaDataCatalogo(@PathVariable("id") int id){
        Map<String, Object> response = new HashMap<>();
        try{
            dataCatalogoService.eliminarDataCatalogo(id);
            response.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Ejemplo de ID ==> " + id + "." );
        }catch (Exception e){
            e.printStackTrace();
            response.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(response);

    }
    @PutMapping("/insertarDataCatalogo")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> insertarDataCatalogo(@RequestBody DataCatalogo obj){
        Map<String, Object> response = new HashMap<>();
        try {
            obj.setFechaRegistro(new Date());
            obj.setFechaActualizacion(new Date());
            obj.setEstado(AppSettings.ACTIVO);
            Optional<Catalogo> optionalCatalogo = catalogoRepository.findById(obj.getCatalogo().getIdCatalogo());
            if (!optionalCatalogo.isPresent()) {
                response.put("mensaje", "Catálogo no encontrado");
                return ResponseEntity.badRequest().body(response);
            }
            obj.setCatalogo(optionalCatalogo.get());
            DataCatalogo objSalida = dataCatalogoService.registrar(obj);
            if (objSalida == null) {
                response.put("mensaje", "Error en el registro");
            } else {
                response.put("mensaje", "Registro de Catalogo con el ID >>> " + obj.getIdDataCatalogo() +
                        " >>> DES >> " + obj.getDescripcion());
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/validaDescripcionActualiza")
    @ResponseBody
    public String validaDescripcion(@RequestParam(name = "descripcion")String descripcion,
                                    @RequestParam(name = "idDataCatalogo")int idDataCatalogo) {
        List<DataCatalogo> lstSalida =dataCatalogoService.listaDataCatalogoPorDescripcionIgualActualizar(descripcion, idDataCatalogo);
        if (lstSalida.isEmpty()) {
            return "{\"valid\":true}";
        }else {
            return "{\"valid\":false}";
        }

    }
}
