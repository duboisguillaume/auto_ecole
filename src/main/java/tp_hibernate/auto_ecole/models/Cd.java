package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cds database table.
 * 
 */
@Entity
@Table(name="cds")
@NamedQuery(name="Cd.findAll", query="SELECT c FROM Cd c")
public class Cd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;


	private String editeur;

	//bi-directional many-to-one association to Serie
	@OneToMany(mappedBy="cd")
	private List<Serie> series;

	public Cd() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEditeur() {
		return this.editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public List<Serie> getSeries() {
		return this.series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public Serie addSery(Serie sery) {
		getSeries().add(sery);
		sery.setCd(this);

		return sery;
	}

	public Serie removeSery(Serie sery) {
		getSeries().remove(sery);
		sery.setCd(null);

		return sery;
	}

}