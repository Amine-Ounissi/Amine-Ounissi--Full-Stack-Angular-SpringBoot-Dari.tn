package tn.Dari.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;



import tn.Dari.entities.Announcement;


public interface IAnnouncementService {

	List<Announcement> retrieveAnnouncement();	
	Announcement retrieveById(Long id);
	
//Announcement saveAnnouncement(Announcement An,MultipartFile file);
	Announcement saveAnnouncement(Announcement An);

	//Announcement updateAnnouncement(Announcement An);
	void deleteAnnouncement(Long id);
	
	int nbrlike();

	int mostlikedadd();

	int nbrdislike();

	Announcement Incrementlikes(Long idad);

	Announcement Incrementdislikes(Long idad);

	Announcement findbyid(Long idad);

	int getnblikes(Long idad);

	int getnbdislikes(Long idad);
	
}
