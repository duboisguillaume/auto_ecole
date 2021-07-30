package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the eleves database table.
 * 
 */
@Entity
@Table(name="eleves")
@NamedQuery(name="Eleve.findAll", query="SELECT e FROM Eleve e")
public class Eleve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;


	private String adresse;

	

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;


	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Seance
	@OneToMany(mappedBy="eleve")
	private List<Seance> seances;

	public Eleve() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Seance addSeance(Seance seance) {
		getSeances().add(seance);
		seance.setEleve(this);

		return seance;
	}

	public Seance removeSeance(Seance seance) {
		getSeances().remove(seance);
		seance.setEleve(null);

		return seance;
	}

}