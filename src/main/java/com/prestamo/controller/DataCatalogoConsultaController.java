package com.prestamo.controller;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.service.DataCatalogoService;
import com.prestamo.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/url/consultaDataCatalogo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class DataCatalogoConsultaController {
    @Autowired
    private DataCatalogoService dataCatalogoService;
    @GetMapping("listaConsultaComplejaDataCatalogo")
    public List<DataCatalogo> listaDataCatalogo(
            @RequestParam String descripcion,
            @RequestParam int estado,
            @RequestParam int idCatalogo)
    {
        List<DataCatalogo> response = dataCatalogoService.listaConsultaComplejaDataCatalogo(descripcion,estado,idCatalogo);
        return response;
    }
}
