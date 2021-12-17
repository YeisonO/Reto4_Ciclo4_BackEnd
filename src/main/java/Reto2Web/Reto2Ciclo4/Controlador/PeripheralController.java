/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2Web.Reto2Ciclo4.Controlador;

import Reto2Web.Reto2Ciclo4.Servicio.PeripheralService;
import Reto2Web.Reto2Ciclo4.Modelo.Peripheral;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralController {
    @Autowired
    private PeripheralService accesoryService;
    
    @GetMapping("/all")
    public List<Peripheral> getAll(){
        return accesoryService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Peripheral> getPeripheral(@PathVariable("reference") String reference){
        return accesoryService.getPeripheral(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral create(@RequestBody Peripheral gadget){
        return accesoryService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripheral update(@RequestBody Peripheral gadget){
        return accesoryService.update(gadget);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return accesoryService.delete(reference);
    }
}
