/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.Retotres;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;
    
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Reservaciones> getReservation(int reservationId){
        return metodosCrud.getReservation(reservationId);
    }
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e=metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isPresent()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }    
        }
    }
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e=metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isPresent()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
        
    }    
        
    public boolean deleteReservation(int reservationId){
        Boolean aBoolean=getReservation(reservationId).map(reservation ->{
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
     public List<CountCliente> getTopClientes(){
        return metodosCrud.getTopClientes();
    }

    public DescriptionAmount getStatusReport(){
        List<Reservaciones> completed=metodosCrud.getReservationByDescription("completed");
        List<Reservaciones> cancelled=metodosCrud.getReservationByDescription("cancelled");

        DescriptionAmount descAmt=new DescriptionAmount(completed.size(),cancelled.size());
        return descAmt;
    }
    public List<Reservaciones> getReservacionesPeriod(String d1, String d2){

        // yyyy-MM-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return metodosCrud.getReservationPeriod(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
    
}
