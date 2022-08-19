package tn.Dari.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Reserve {
    
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long  idV;
   // @OneToOne()
    //User user;
    //@OneToOne()
    //Announcement announcement;
	//@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	Date date = new Date(System.currentTimeMillis());
    String time;
    String purpose;
    String Message;
    @Enumerated(EnumType.STRING)
    VisitType visitType;
    @ManyToOne
	private Announcement announcement;

	@ManyToOne
	private User user;


}
