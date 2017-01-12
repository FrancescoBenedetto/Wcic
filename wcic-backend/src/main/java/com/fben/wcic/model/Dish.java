package com.fben.wcic.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Type;

@Entity
@Table(name="dish")
public class Dish {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="name", unique=true, nullable=false)
	private String name;
	
	@Column(name="instructions", nullable=false)
	@Type(type="text")
	private String instructions;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="time", nullable=true)
	private String time;
	
	@Column(name="persons", nullable=true)
	private String persons;
	
	@Column(name="difficulty", nullable=true)
	private String difficulty;
	
	@Column(name="origin", nullable=true)
	private String origin;
	
	@Column(name="primary_ingredient", nullable=true)
	private String primaryIngredient;
	
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "recipe_composition",
		joinColumns = {@JoinColumn(name = "id_dish", referencedColumnName = "id", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "id_ingredient", referencedColumnName = "id", nullable = false, updatable = false) })
	private Set<Ingredient> ingredients = new HashSet<Ingredient>(0);
	
	protected Dish(){}
	
	public Dish(Long id, String name, String instructions, String type, String time, String persons, String difficulty, String origin, String primaryIngredient){
		this.id = id;
		this.name = name;
		this.instructions = instructions;
		this.type = type;
		this.time = time;
		this.persons = persons;
		this.difficulty = difficulty;
		this.origin = origin;
		this.primaryIngredient = primaryIngredient;
	}
	
	public Dish(Object[] obj){
		this.id = (Long) ((BigInteger)(obj[0])).longValue();
		this.name = (String) obj[1];
		this.instructions = (String) obj[2];
		this.type = (String) obj[3];
		this.time = (String) obj[4];
		this.persons = (String) obj[5];
		this.difficulty = (String) obj[6];
		this.origin = (String) obj[7];
		this.primaryIngredient = (String) obj[8];
	}
	
	public Dish(String name, String instructions, String type){
		this.name = name;
		this.instructions = instructions;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPersons() {
		return persons;
	}

	public void setPersons(String persons) {
		this.persons = persons;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPrimaryIngredient() {
		return primaryIngredient;
	}

	public void setPrimaryIngredient(String primaryIngredient) {
		this.primaryIngredient = primaryIngredient;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredient(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", instructions=" + instructions + ", type=" + type + ", time="
				+ time + ", persons=" + persons + ", difficulty=" + difficulty + ", origin=" + origin
				+ ", primaryIngredient=" + primaryIngredient + ", ingredients=" + ingredients.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
