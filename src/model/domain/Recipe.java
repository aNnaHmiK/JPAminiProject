package model.domain;

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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Recipe {

	@Id
	@Column(name = "recipe_id")
	private String rID;

	@OneToMany(mappedBy = "recipe")
    private List<Desk> desks = new ArrayList<>();
	
	private String pay;

	private String rx;

	@Override
	public String toString() {
		return "Recipe [rID=" + rID + ", desks=" + desks + ", pay=" + pay + ", rx=" + rx + "]";
	}

}