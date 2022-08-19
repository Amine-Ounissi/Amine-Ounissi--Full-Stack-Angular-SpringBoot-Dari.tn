package tn.Dari.services;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Dari.entities.Reserve;
import tn.Dari.entities.Announcement;
import tn.Dari.entities.User;
import tn.Dari.repository.ReserveRepository;
import tn.Dari.repository.AnnouncementRepository;
import tn.Dari.repository.UserRepository;


@Transactional
@Service
@AllArgsConstructor
public class ReserveServiceImp implements ReserveService{
	@Autowired
    private ReserveRepository reserveRepository;

	@Autowired
	AnnouncementRepository announcementRepository;

	@Autowired
	UserRepository userRepository;


	@Override
	public void addReserve(Reserve Re, Long idan, Long idU) {
		Announcement announcement = announcementRepository.findById(idan).orElse(null);
		User user = userRepository.findById(idU).orElse(null);
		Re.setAnnouncement(announcement);
		Re.setUser(user);
		reserveRepository.save(Re);		
	}
	
	@Override
	public Reserve saveReserve(Reserve Re) {
		return	reserveRepository.save(Re);
	}
	@Override
	public Reserve retrieveById(Long id) {
		return (Reserve) reserveRepository.findById(id).orElse(null);
	}
  
	@Override
	public void deleteReserve(Long id) {
		Optional<Reserve> reserve = reserveRepository.findById(id);
		reserveRepository.deleteById(id);
		} 

	@Override
	public Reserve findById(Long idre) {
		return (Reserve) reserveRepository.findById(idre).orElse(null);
	}
	
	@Override
	public List<Reserve> retrieveReserve() {
		return  (List<Reserve>)  reserveRepository.findAll();
	}
	
}
