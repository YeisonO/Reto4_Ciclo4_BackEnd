/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2Web.Reto2Ciclo4.Repositorio;

import Reto2Web.Reto2Ciclo4.Interfaces.InterfacePeripherals;
import Reto2Web.Reto2Ciclo4.Modelo.Peripheral;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACER
 */
@Repository
public class PeripheralRepositorio {
    @Autowired
    private InterfacePeripherals repository;
    
    public List<Peripheral> getAll(){
        return repository.findAll();
    }
    
    public Optional<Peripheral> getPeripheral(String reference){
        return repository.findById(reference);
    }
    
    public Peripheral create(Peripheral peripheral){
        return repository.save(peripheral);
    }
    
    public void update(Peripheral peripheral){
        repository.save(peripheral);
    }
    
    public void delete(Peripheral peripheral){
        repository.delete(peripheral);
    }
    
}
