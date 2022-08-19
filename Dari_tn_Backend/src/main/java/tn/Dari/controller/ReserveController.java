package tn.Dari.controller;



import java.util.List;
import java.util.Date;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Dari.entities.Reserve;
import tn.Dari.repository.ReserveRepository;
import tn.Dari.services.ReserveService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/DariTn/reservecontroller")
public class ReserveController { 
	@Autowired
    private ReserveService reserveService;
	@Autowired
	ReserveRepository  reserverepository;
    
    @GetMapping("/Reserves/test")
   	public String test() {
   		return "working fine ! " ; 
   	}

    @GetMapping("/Reserves/{id}")
	@ResponseBody 
	Reserve afficherreserve(@PathVariable("id")Long idV) {
		return reserveService.retrieveById(idV);
	}
    
    @GetMapping("/Reserves")
	@ResponseBody
	 public List<Reserve> afficherReserve() {
		return reserveService.retrieveReserve();
	}
    @PostMapping("/Reserves/addReserve/{idan}/{idU}")
    
	public void addReserve(@RequestBody Reserve Re, @PathVariable("idan") Long idan,
			@PathVariable("idU") Long idU) {
    	reserveService.addReserve(Re, idan, idU);
	}
    
    @PostMapping("/Reserves")
	@ResponseBody
	Reserve ajouterReserve(@RequestBody Reserve Re){
		return (Reserve) reserveService.saveReserve(Re);
    }
   
	@PutMapping("/Reserves/{id}")
	@ResponseBody
	public Reserve updateReserve(@PathVariable("id")Long idV,@RequestBody Reserve Re){ 
		Reserve reserve = reserverepository.getById(idV);
		reserve.setUser(Re.getUser());
		reserve.setAnnouncement(Re.getAnnouncement());
		reserve.setTime(Re.getTime());
		reserve.setPurpose(Re.getPurpose());
		reserve.setMessage(Re.getMessage());
		reserve.setVisitType(Re.getVisitType());
		reserve.setDate(Re.getDate());
		return reserverepository.save(reserve);
		
	}
	
	@DeleteMapping("/Reserves/{id}")
	@ResponseBody
	public void deleteReserve(@PathVariable("id") Long id) {
		reserveService.deleteReserve(id);
	}
	
}
	
	

	


