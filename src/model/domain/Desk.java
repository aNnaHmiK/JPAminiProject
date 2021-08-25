package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Entity
public class Desk{
	
	@Id
	@Column(name = "desk_no")
	private long n_no;
	
	
//	@Id
	@Column(name = "desk_name")
//	@Column(name = "d_name")
	private String DName;
	
	@OneToMany(mappedBy = "desks2")
	private List<Patient> patients = new ArrayList<>();
	
	@OneToMany(mappedBy = "desks")
	private List<Recipe> recipes = new ArrayList<>();
	
	private String date;

//	@Override
//	public String toString() {
//		return "Desk [DName=" + DName + ", date=" + date + "]";
//	}
//
}
