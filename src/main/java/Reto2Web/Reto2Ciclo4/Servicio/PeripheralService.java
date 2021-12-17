/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2Web.Reto2Ciclo4.Servicio;

import Reto2Web.Reto2Ciclo4.Modelo.Peripheral;
import Reto2Web.Reto2Ciclo4.Repositorio.PeripheralRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class PeripheralService {
    @Autowired
    private PeripheralRepositorio peripheralRepository;
    
    public List<Peripheral> getAll(){
        return peripheralRepository.getAll();
    }
    
    public Optional<Peripheral> getPeripheral(String reference){
        return peripheralRepository.getPeripheral(reference);
    }
    
    public Peripheral create(Peripheral accesory){
        if (accesory.getReference() == null){
            return accesory;
        }else{
            return peripheralRepository.create(accesory);
        }
    }
    
    public Peripheral update(Peripheral accesory){
        
        if (accesory.getReference() != null){
            Optional<Peripheral> accesoryDb = peripheralRepository.getPeripheral(accesory.getReference());
            if(!accesoryDb.isEmpty()){
                
                if(accesory.getBrand() != null){
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if(accesory.getCategory() != null){
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if(accesory.getDescription() != null){
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
              
                if(accesory.getPrice() != 0.0){
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                
                if(accesory.getQuantity() != 0){
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                
                if(accesory.getPhotography() != null){
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                peripheralRepository.update(accesoryDb.get());
                return accesoryDb.get();
            }else{
                return accesory;
            }
        }else{
            return accesory;
        }
    }
    
    public boolean delete(String reference){
        Boolean aBoolean = getPeripheral(reference).map(accesory -> {
            peripheralRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
