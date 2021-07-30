package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;


/**
 * The persistent class for the seances database table.
 * 
 */
@Entity
@Table(name="seances")
@NamedQuery(name="Seance.findAll", query="SELECT s FROM Seance s")
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private LocalDate date;


	private byte estExamen;


	private Time heure;


	private String lieu;

	private int nombreFautes;

	//bi-directional many-to-one association to Eleve
	@ManyToOne
	@JoinColumn(name="eleves_id")
	private Eleve eleve;

	//bi-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumn(name="series_id")
	private Serie serie;

	public Seance() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	
	public byte getEstExamen() {
		return this.estExamen;
	}

	public void setEstExamen(byte estExamen) {
		this.estExamen = estExamen;
	}


	public Time getHeure() {
		return this.heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}


	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public int getNombreFautes() {
		return this.nombreFautes;
	}

	public void setNombreFautes(int nombreFautes) {
		this.nombreFautes = nombreFautes;
	}

	public Eleve getEleve() {
		return this.eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Serie getSerie() {
		return this.serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}