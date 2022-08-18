package tn.Dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Dari.entities.Reserve;
import tn.Dari.entities.Announcement;
@Repository
public interface ReserveRepository extends JpaRepository<Reserve,Long> {
	
	List<Reserve> findByAnnouncementIdan(Long idan);
}
