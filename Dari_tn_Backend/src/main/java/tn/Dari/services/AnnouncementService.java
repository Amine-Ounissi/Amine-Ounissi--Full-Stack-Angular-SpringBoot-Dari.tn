package tn.Dari.services;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.Dari.entities.Announcement;
import tn.Dari.repository.AnnouncementRepository;

@Service
public class AnnouncementService  implements IAnnouncementService  {

	@Autowired
	 AnnouncementRepository  announcementRepository;


	
	@Override
	public List<Announcement> retrieveAnnouncement() {
		return (List<Announcement>) announcementRepository.findAll();
	}

	@Override
	public Announcement retrieveById(Long id) {
		return (Announcement) announcementRepository.findById(id).orElse(null);
	}

	/*
	@Override
	public Announcement saveAnnouncement(Announcement An, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			An.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return announcementRepository.save(An);
	}
	
*/
	

	@Override
	public Announcement saveAnnouncement(Announcement An) {
		return announcementRepository.save(An);
		}
	
	
	
	//@Override
	//public Announcement updateAnnouncement(Announcement An) {
		/*Announcement announcement =announcementRepository.findById(An.getId_an()).get();
		announcement.setDescription(An.getDescription());
		announcement.setCity(An.getCity());
		announcement.setAddress(An.getAddress());
		announcement.setGovernorate(An.getGovernorate());
		announcement.setPhone(An.getPhone());
		announcement.setPrice(An.getPrice());
		announcement.setDate(An.getDate());
		*/
		//return announcementRepository.save(announcement);
//	}

	@Override
	public void deleteAnnouncement(Long id) {
		announcementRepository.deleteById(id);
		
	}
	//@Override
	//public List<Announcement> retriveAnnouncementByDate(Date d1, Date d2) {
		//return (List<Announcement>)announcementRepository.retriveAnnouncementByDate(d1, d2);}
	

	
	@Override
	public int getnblikes(Long idad)
	{	int a;
	Announcement ad=announcementRepository.findById(idad).get();
		return a=ad.getLikesNB();
		}
	@Override
	public int getnbdislikes(Long idad)
	{	int a;
	Announcement ad=announcementRepository.findById(idad).get();
		return a=ad.getDislikeNB();
		}
	
	
	@Override
	public int mostlikedadd() {	
		int k=0;
		List<Announcement> list= (List<Announcement>) announcementRepository.findAll();
		for(Announcement ad: list ) {

			if(ad.getLikesNB() > k) {
				k=ad.getLikesNB();	  
			}  
		}

		return k;

	}

	@Override
	public Announcement Incrementlikes(Long idad) {
		int a;
		Announcement ad=announcementRepository.findById(idad).get();
			a=ad.getLikesNB();
			a++;
			ad.setLikesNB(a);
			announcementRepository.save(ad);
			return ad;
	}

	@Override
	public Announcement Incrementdislikes(Long idad)
	{	int a;
	Announcement ad=announcementRepository.findById(idad).get();
		a=ad.getDislikeNB();
		a++;
		ad.setDislikeNB(a);
		announcementRepository.save(ad);
		return ad;
	}
	
	

	@Override
	public Announcement findbyid(Long idad) {
		return announcementRepository.findById(idad).get();

	}
	
	@Override 
	public int nbrlike() {
		int nb=0;
		List<Announcement> list= (List<Announcement>) announcementRepository.findAll();
		for (Announcement ad: list){
			nb+=ad.getLikesNB();
		}
		return nb;
	}
	
	@Override 
	public int nbrdislike() {
		int nb=0;
		List<Announcement> list= (List<Announcement>) announcementRepository.findAll();
		for (Announcement ad: list){
			nb+=ad.getDislikeNB();
		}
		return nb;
	}
	
	

}
