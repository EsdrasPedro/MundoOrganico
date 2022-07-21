package br.com.mundo_organico.Mundo_Organico.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Double value;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String src;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "salesman_id")
	private Salesman salesman;

	@OneToMany(mappedBy = "product")
	private Set<Ordered_Items> items = new HashSet<>();

	public Product() {
		super();
	}
	
	public Product(Integer id, String name, String description, Double value, String type, Category category, Salesman salesman, String src) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.type = type;
		this.category = category;
		this.salesman = salesman;
		this.src = src;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}
	
	public Set<Ordered_Items> getItems() {
		return items;
	}

	public void setItems(Set<Ordered_Items> items) {
		this.items = items;
	}

}
