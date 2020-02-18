package br.com.project.challenge.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.project.challenge.entities.pk.RentItemPk;


@Entity
@Table(name = "tb_rent_item")
public class RentItem {

	@EmbeddedId
	private RentItemPk id = new RentItemPk();

	private Double price;

	public RentItem() {

	}

	public RentItem(Rent rent, Book book, Double price) {
		super();
		id.setRent(rent);
		id.setBook(book);
		this.price = price;
	}
	
	@JsonIgnore
	public Rent getRent() {
		return id.getRent();
	}

	public void setRent(Rent rent) {
		id.setRent(rent);
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
		RentItem other = (RentItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
