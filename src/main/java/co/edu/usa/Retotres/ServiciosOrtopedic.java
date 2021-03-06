/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Retotres;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ServiciosOrtopedic {
    @Autowired
    private RepositorioOrtopedic metodosCrud;
    
    public List<Ortopedic> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Ortopedic> getOrtopedic(int ortopedicId){
        return metodosCrud.getOrtopedic(ortopedicId);
    }
    public Ortopedic save(Ortopedic ortopedic){
        if(ortopedic.getId()==null){
            return metodosCrud.save(ortopedic);
        }else{
            Optional<Ortopedic> e=metodosCrud.getOrtopedic(ortopedic.getId());
            if(!e.isPresent()){
                return metodosCrud.save(ortopedic);
            }else{
                return ortopedic;
            }    
        }
    }
    public Ortopedic update(Ortopedic ortopedic){
        if(ortopedic.getId()!=null){
            Optional<Ortopedic> e=metodosCrud.getOrtopedic(ortopedic.getId());
            if(e.isPresent()){
                if(ortopedic.getName()!=null){
                    e.get().setName(ortopedic.getName());
                }
                if(ortopedic.getBrand()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    e.get().setYear(ortopedic.getYear());
                }
                if(ortopedic.getDescription()!=null){
                    e.get().setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getCategory()!=null){
                    e.get().setCategory(ortopedic.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return ortopedic;
            }
        }else{
            return ortopedic;
        }    
    }
        
    public boolean deleteOrtopedic(int ortopedicId){
            Boolean aBoolean = getOrtopedic(ortopedicId).map(ortopedic ->{
                metodosCrud.delete(ortopedic);
                return true;
            }).orElse(false);
            return aBoolean;
        }
    }       

