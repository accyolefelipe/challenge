package br.com.project.challenge.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.project.challenge.entities.enums.RentStatus;

@Entity
@Table(name = "tb_rent")
public class Rent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	private Integer rentStatus;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "id.rent")
	private Set<RentItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "rent" , cascade = CascadeType.ALL)
	private Payment payment;

	public Rent() {

	}

	public Rent(Long id, Instant moment, RentStatus rentStatus, Client client) {
		super();
		this.id = id;
		this.moment = moment;
		setRentStatus(rentStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public RentStatus getRentStatus() {
		return RentStatus.valueOf(rentStatus);
	}

	public void setRentStatus(RentStatus rentStatus) {
		if (rentStatus != null) {
			this.rentStatus = rentStatus.getCode();
		}
	}
	public Set<RentItem> getItems(){
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (RentItem x : items) {
			sum = sum + x.getPrice();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Rent other = (Rent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
