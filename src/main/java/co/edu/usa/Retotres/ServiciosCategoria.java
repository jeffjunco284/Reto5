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


@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;
    
    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Categoria> getCategory(int categoryId){
        return metodosCrud.getCategory(categoryId);
    }
    public Categoria save(Categoria category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<Categoria> cat1=metodosCrud.getCategory(category.getId());
            if(!cat1.isPresent()){
                return metodosCrud.save(category);
            }else{
                return category;
            }    
        }
    }
    public Categoria update(Categoria category){
        if(category.getId()!=null){
            Optional<Categoria> c=metodosCrud.getCategory(category.getId());
            if(c.isPresent()){
                if(category.getDescription()!=null){
                    c.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    c.get().setName(category.getName());
                }
                return metodosCrud.save(c.get());
            }
        }
        return category;
    }    
        
    public boolean deleteCategory(int categoryId){
        Boolean d=getCategory(categoryId).map(category ->{
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}

