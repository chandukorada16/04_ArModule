package in.acruent.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class CitizenApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appID;
	
	private String fullName;
	
	private String email;
	
	private Long phoneNumber;
	
	private Long ssn;
	
	private Character gender;
	
	private String stateName;
	
	private String updatedBy;
	
	private String createdBy;
	
	@CreationTimestamp
	@Column(name="created_Dt",updatable = false)
	private LocalDate createdDt;
	
	@UpdateTimestamp
	@Column(name="updated_Dt",insertable = false)
	private LocalDate updatedDt;
	


}
