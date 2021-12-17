/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2Web.Reto2Ciclo4.Servicio;

import Reto2Web.Reto2Ciclo4.Modelo.User;
import Reto2Web.Reto2Ciclo4.Repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yeison Orozco
 * @Class UserService
 */
@Service
public class UserService {
    /**
     * 
     * @Constante Inyeccion de Dependencias userRepository
     */
    @Autowired
    private UserRepositorio userRepository;
    
    /**
     * 
     * @Método Llamado Lista de Usuarios
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    /**
     * 
     * @Método Llamado Lista de Usuarios por Id Ingresado
     */
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    
    /**
     * 
     * @Método Creacion de Nuevo Usuario si este no existe
     */
    public User create(User user){
        
        /**
         * 
         * @Condicional Creacion de Nuevo Usuario por Id e Email
         */
        if(user.getId() == null){
            return user;
        }else{
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()){
                if (emailExists(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }
    
    /**
     * 
     * @Método Validacion y Actualizacion de los datos de un Usuario.
     */
    public User update(User user){
        
        /**
         * 
         * @Condicional Datos de Usuario
         */
        if (user.getId() != null){
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()){
                if (user.getIdentification() != null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null){
                    userDb.get().setName(user.getName());
                }
                if (user.getBirthtDay()!= null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!= null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null){
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null){
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null){
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    /**
     * 
     * @Método Borrar un Usuario por su Id.
     */
    public boolean delete(int userId){
        Boolean aBoolean = getUser(userId).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /**
     * 
     * @Método Llamado del Correo Electronico.
     */
    public boolean emailExists(String email){
        return userRepository.emailExists(email);
    }
    
    /**
     * 
     * @Método Validacion de Autenticacion de Usuario.
     */
    public User authenticateUser(String email, String password){
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        
        if(usuario.isEmpty()){
            return new User();
        }else{
            return usuario.get();
        }
    }
    
}
