package br.com.project.challenge.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.project.challenge.entities.pk.ReservationItemPk;

@Entity
@Table(name = "tb_reservation_item")
public class ReservationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservationItemPk id = new ReservationItemPk();

	private Double price;

	public ReservationItem() {

	}

	public ReservationItem(Reservation reservation, Book book, Double price) {
		super();
		id.setReservation(reservation);
		id.setBook(book);
		this.price = price;
	}

	@JsonIgnore
	public Reservation getReservation() {
		return id.getReservation();
	}

	public void setReservation(Reservation reservation) {
		id.setReservation(reservation);
	}

	public Book getBook() {
		return id.getBook();
	}

	public void setBook(Book book) {
		id.setBook(book);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		ReservationItem other = (ReservationItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
