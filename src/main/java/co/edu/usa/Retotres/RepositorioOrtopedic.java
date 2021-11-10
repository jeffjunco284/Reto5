/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Retotres;

import co.edu.usa.Retotres.InterfaceOrtopedic;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class RepositorioOrtopedic {
    
    @Autowired
    private InterfaceOrtopedic crud;
    
    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) crud.findAll();
    }
    public Optional<Ortopedic> getOrtopedic(int id){
        return crud.findById(id);
    }
    public Ortopedic save(Ortopedic ortopedic){
        return crud.save(ortopedic);
    }
    public void delete(Ortopedic ortopedic ){
        crud.delete(ortopedic);
    }
    
}
