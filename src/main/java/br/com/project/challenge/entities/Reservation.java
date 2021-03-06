package br.com.project.challenge.entities;

import java.io.Serializable;
import java.time.LocalDate;
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

import br.com.project.challenge.entities.enums.ReservationStatus;

@Entity
@Table(name = "tb_reservation")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate reservationDay;
	private LocalDate reservationDelivery;

	private Integer reservationStatus;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "id.reservation")
	private Set<ReservationItem>  resItems = new HashSet<>();

	public Reservation() {

	}

	public Reservation(Long id, LocalDate reservationDay, LocalDate reservationDelivery,
			ReservationStatus reservationStatus, Client client) {
		super();
		this.id = id;
		this.reservationDay = reservationDay;
		this.reservationDelivery = reservationDelivery;
		setReservationStatus(reservationStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getReservationDay() {
		return reservationDay;
	}

	public void setReservationDay(LocalDate reservationDay) {
		this.reservationDay = reservationDay;
	}

	public LocalDate getReservationDelivery() {
		return reservationDelivery;
	}

	public void setReservationDelivery(LocalDate reservationDelivery) {
		this.reservationDelivery = reservationDelivery;
	}

	public ReservationStatus getReservationStatus() {
		return ReservationStatus.valueOf(reservationStatus);
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		if (reservationStatus != null) {
			this.reservationStatus = reservationStatus.getCode();
		}
	}
	
	public Set<ReservationItem> getItems(){
		return resItems;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
