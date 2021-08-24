package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@SequenceGenerator
@Entity
public class Patient {
	
	@Id
//	@GeneratedValue
	@Column(name="patient_id")
	private String pID;
	
	private String name;
	
	private String gender;
	
	private String age;
	
	private String birth;
	
	private String phone;
}
