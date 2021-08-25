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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Recipe {
	
	
	@Id
	@Column(name = "recipe_id")
	private int rID;

//	@Id
	@Column(name = "recipe_no")
//	@Column(name = "recipe_id")
	private String rNo;

	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "desk_no")
	private Desk desks;
	
	private String pay;

	private String rx;
//
//	@Override
//	public String toString() {
//		return "Recipe [rID=" + rID + ", desks=" + desks + ", pay=" + pay + ", rx=" + rx + "]";
//	}

}