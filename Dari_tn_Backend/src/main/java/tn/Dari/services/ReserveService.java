package tn.Dari.services;

import java.util.List;
import java.io.IOException;
import tn.Dari.entities.Reserve;
import java.util.Date;




public interface ReserveService {
	
	void addReserve(Reserve Re, Long idan, Long idU);
    Reserve retrieveById(Long id);
    List<Reserve> retrieveReserve();
    Reserve saveReserve(Reserve Re);
    Reserve findById(Long idre);	
   	void deleteReserve(Long id);

}
