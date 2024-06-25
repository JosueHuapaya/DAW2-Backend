package com.prestamo.controller;

import com.prestamo.entity.Coordenada;
import com.prestamo.service.CoordenadaService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
@RestController
@RequestMapping("/url/coordenadaCRUD")

public class CoordenadaControllerCRUD {

    @Autowired

    private CoordenadaService coordenadaService;

    @PutMapping("/actualizarCoordenada")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarCoordenada(@RequestBody Coordenada coordenada) {
        Map<String, Object> salida = new HashMap<>();
        try {
            coordenada.setFechaActualizacion(new Date());

            Coordenada coordenadaSalida = coordenadaService.actualizarCoordenadas(coordenada);
            if (coordenadaSalida == null) {
                salida.put("mensaje", "Error al actualizar la coordenada");
            } else {
                salida.put("mensaje", "Actualización exitosa. Coordenada ID ==> " + coordenada.getIdCoordenada());
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al actualizar la coordenada");
        }
        return ResponseEntity.ok(salida);
    }


    @DeleteMapping("/eliminarCoordenada/{idCoordenada}")

    public void eliminarCoordenada(@PathVariable("idCoordenada") int idCoordenada) {
        coordenadaService.eliminarCoordenada(idCoordenada);

    }

    @GetMapping("/obtenerCoordenadas/{latitud}")
    public ResponseEntity<List<Coordenada>> obtenerCoordenadas(@PathVariable("latitud") String latitudDigito) {

        List<Coordenada> lstSalida = null;
        try {

            if (latitudDigito.equalsIgnoreCase("todos")) {
                lstSalida = coordenadaService.listarCoordenadas();
            } else {
                lstSalida = coordenadaService.obtenerCoordenadasPorPrimerosDigitosLatitud(latitudDigito);
            }
        } catch (NumberFormatException e) {
            lstSalida = null;
        }
        return ResponseEntity.ok(lstSalida);
    }

}