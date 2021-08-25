package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@SequenceGenerator(name = "patient_id_seq", sequenceName = "hospital_patient_seq", initialValue = 1, allocationSize = 1)
//@NamedQuery(query = "select p from Patient p", name = "Patient.findAll")
//@NamedQuery(query = "select p from Patient p where p.name=:name", name = "Patient.findByname")
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq")
	@Column(name = "patient_id")
	private long pID;

	private String name;

	private String gender;

	private String age;

	private String birth;

	private String phone;

	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "desk_no")
	private Desk desks2;

//	@Override
//	public String toString() {
//		return "Patient [pID=" + pID + ", name=" + name + ", gender=" + gender + ", age=" + age + ", birth=" + birth
//				+ ", phone=" + phone + ", desks=" + desks2 + "]";
//	}
	
}
