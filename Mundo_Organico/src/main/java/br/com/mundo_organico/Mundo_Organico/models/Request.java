package br.com.mundo_organico.Mundo_Organico.models;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dataHoraAtual = new Date();

	private String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);

	private String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	
	private String status;

	private Double subTotal;

	private Double total;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "request")
	private Set<Ordered_Items> items = new HashSet<>();

	public Request() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public void setData() {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora() {
		this.hora = hora;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Ordered_Items> getItems() {
		return items;
	}

	public void setItems(Set<Ordered_Items> items) {
		this.items = items;
	}

}