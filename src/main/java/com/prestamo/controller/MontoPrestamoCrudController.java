package com.prestamo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.MontoPrestamo;
import com.prestamo.service.MontoPrestamoService;
import com.prestamo.util.AppSettings;

@RestController
@RequestMapping("/url/crudmontoprestamo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class MontoPrestamoCrudController {

	@Autowired
	private MontoPrestamoService servicemonto;

	@GetMapping("/listaCapital/{var}")
	@ResponseBody
	public ResponseEntity<?> listaCapital(@PathVariable("var") String var) {
	    List<MontoPrestamo> lstSalida;
	    try {
	        if (var.equalsIgnoreCase("todos")) {
	            lstSalida = servicemonto.ListarMontoPrestamo();
	        } else {
	            try {
	                int capital = Integer.parseInt(var);
	                lstSalida = servicemonto.ListaCapital(capital);
	            } catch (NumberFormatException e) {
	                return ResponseEntity.badRequest().body("Invalid value for capital: " + var);
	            }
	        }
	        return ResponseEntity.ok(lstSalida);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Internal server error");
	    }
	}
	
	
	
	@PostMapping("/registramontoprestamo")
	@ResponseBody
    public ResponseEntity<?> registra(@RequestBody MontoPrestamo obj) {
        HashMap<String, Object> salida = new HashMap<>();
        
       
        obj.setFechaRegistro(new Date());
        obj.setFechaActualizacion(new Date());
        obj.setEstado(AppSettings.ACTIVO);
        
        MontoPrestamo objSalida = servicemonto.Registramontoprestamo(obj);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");                
        } else {
            salida.put("mensaje", "Registro de monto prestamo con el ID >>> " + obj.getIdMontoPrestamo());
            return ResponseEntity.ok(salida);
        }
        return ResponseEntity.ok(salida);
   
 }

	
	@PutMapping("/actualizarmontoprestamo")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizar(@RequestBody MontoPrestamo obm) {
		HashMap<String, Object> salida = new HashMap<>();
	   try {
		   obm.setFechaActualizacion(new Date());
		   	
		   MontoPrestamo objSalida = servicemonto.Registramontoprestamo(obm);
		   	if(objSalida == null) {
		   		salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		   	} else {
		   		salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + "Coordenada ID =>" + obm.getIdMontoPrestamo() + ".");
		   	}
	   } catch (Exception e) {
		   e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
	   	}   
	   return ResponseEntity.ok(salida);
	  }
	
	@GetMapping("/validaactualizamontoprestamo")
    public String validaActualiza(@RequestParam(name = "capital")int capital,
   		                       @RequestParam(name = "idMontoPrestamo")int idMontoPrestamo) {
   	 List<MontoPrestamo> salida = servicemonto.ListaCapitalActualiza(capital, idMontoPrestamo);
   	 if(salida.isEmpty()) {
   		 return "{\"valid\":true}";
   	 }else {
   		 return "{\"valid\":false}";
   	 }
    }
	
	@DeleteMapping("/eliminarmontoprestamo/{id}")
	  @ResponseBody
	  public ResponseEntity<Map<String, Object>> deleteMonto(@PathVariable("id") int id) {
	    	Map<String, Object> salida = new HashMap<>();
	        try {
	        	servicemonto.eliminaMonto(id);
	        	salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + "Monto ID =>" + id);
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR );
			}
	        return ResponseEntity.ok(salida);
	    }
	
}
