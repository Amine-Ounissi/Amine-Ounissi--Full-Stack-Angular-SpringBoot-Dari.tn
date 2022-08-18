package tn.Dari.entities;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="announcements")
public class Announcement implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long  idan;
	String object;
	String description;
	String address;
	String articleAn;

	double phone;
	String city;
	String governorate;
	double price;
	
	String lng;
	String lat;
	private int LikesNB;
	private int DislikeNB;
    
	@Temporal(TemporalType.DATE)
	Date date = new Date(System.currentTimeMillis());
	@Lob
	//@Column(columnDefinition = "photo")
	String img;
	@Enumerated(EnumType.STRING)
	Type type;
	

	@OneToMany(mappedBy="announcement")
	@JsonIgnore
	private Set<Reserve> reserves;

	

}
