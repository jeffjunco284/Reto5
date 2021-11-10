/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Retotres;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud1;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) crud1.findAll();
    }
    public Optional<Categoria> getCategory(int id){
        return crud1.findById(id);
    }
    public Categoria save(Categoria category){
        return crud1.save(category);
    }
    public void delete(Categoria category ){
        crud1.delete(category);
    }
    
}
