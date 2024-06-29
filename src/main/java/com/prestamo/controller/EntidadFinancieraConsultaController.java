package com.prestamo.controller;
import com.prestamo.entity.Grupo;
import com.prestamo.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.prestamo.util.AppSettings;

import com.prestamo.entity.EntidadFinanciera;
import com.prestamo.service.EntidadFinancieraService;

import java.util.List;

@RestController
@RequestMapping("/url/consultaEntidadFinanciera")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EntidadFinancieraConsultaController {
    @Autowired
    private EntidadFinancieraService entidadServ;

    @GetMapping("/consultaEntidadCompleja")
    public List<EntidadFinanciera> listaConsulta(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "gerente", required = false) String gerente,
            @RequestParam(value = "idTipo", required = false, defaultValue = "-1") int tipoEntidad,
            @RequestParam(value = "estado", required = false, defaultValue = "-1") int estado
    ){
        List<EntidadFinanciera> lstSalida  =entidadServ.consultarEntidadFinancieraCompleja(nombre != null ? "%" + nombre + "%" : "%",
                gerente != null ? "%" + gerente + "%" : "%", tipoEntidad, estado);
        return lstSalida;
    }
}
