/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2Web.Reto2Ciclo4.Interfaces;

import Reto2Web.Reto2Ciclo4.Modelo.Peripheral;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ACER
 */
public interface InterfacePeripherals extends MongoRepository<Peripheral, String>{
    
}
