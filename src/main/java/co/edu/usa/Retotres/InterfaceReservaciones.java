/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Retotres;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author user
 */
public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer>{

    //JPQL
    @Query("select c.clientes, COUNT(c.clientes) from Reservaciones AS c group by c.clientes order by COUNT(c.clientes) desc")
    public List<Object[]> countTotalReservacionesByCliente();

    //QUERY METHODS!
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

    public List<Reservaciones> findAllByDescription(String description);
    
}
