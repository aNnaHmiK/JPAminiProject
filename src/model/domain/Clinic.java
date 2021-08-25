package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedQuery(query = "select c from Clinic c", name = "Clinic.findAll")
@NamedQuery(query = "select c from Clinic c where c.sign=:sign", name = "Clinic.findBysign")
@Entity
public class Clinic {

	@Column(name = "clinic_id")
	private String cID;

	@Id
	private String sign;

	private String general;

	private String test;

	private String surgery;

//	@OneToMany(mappedBy = "clinic")
//    private List<Desk> desks = new ArrayList<>();

	@Override
	public String toString() {
		return "Clinic [cID=" + cID + ", sign=" + sign + ", general=" + general 
				+ ", test=" + test + ", surgery=" + surgery + "]";
	}

}