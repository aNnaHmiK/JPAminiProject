package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Entity
public class Desk {
	
	@Id
	@Column(name = "desk_name")
	private String dName;
	
	@ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
	@ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

	
//	@ManyToOne
//	@JoinColumn(name = "clinic_sign")
//	private Clinic clinic;
	
	
	private String date;


	@Override
	public String toString() {
		return "Desk [dName=" + dName + ", date=" + date + "]";
	}

	
}
