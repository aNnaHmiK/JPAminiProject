package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SequenceGenerator(name = "patient_id_seq", sequenceName = "hospital_patient_seq", initialValue = 1, allocationSize = 1)
@NamedQuery(query = "select p from Patient p", name = "Patient.findAll")
@NamedQuery(query = "select p from Patient p where p.name=:name", name = "Patient.findByname")
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq")
	@Column(name = "patient_id")
	private int pID;

	private String name;

	private String gender;

	private String age;

	private String birth;

	private String phone;

	@OneToMany(mappedBy = "patient")
    private List<Desk> desks = new ArrayList<>();

}
