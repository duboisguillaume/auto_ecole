package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;

import tp_hibernate.auto_ecole.repositories.SeriesQuestionRepository;
import tp_hibernate.auto_ecole.utils.SessionHibernate;

import java.util.List;


/**
 * The persistent class for the series database table.
 * 
 */
@Entity
@Table(name="series")
@NamedQuery(name="Serie.findAll", query="SELECT s FROM Serie s")
public class Serie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Seance
	@OneToMany(mappedBy="serie")
	private List<Seance> seances;

	//bi-directional many-to-one association to Cd
	@ManyToOne
	@JoinColumn(name="cds_id")
	private Cd cd;

	//bi-directional many-to-one association to SeriesQuestion
	@OneToMany(mappedBy="serie", fetch = FetchType.LAZY)
	private List<SeriesQuestion> seriesQuestions;

	public Serie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Seance addSeance(Seance seance) {
		getSeances().add(seance);
		seance.setSerie(this);

		return seance;
	}

	public Seance removeSeance(Seance seance) {
		getSeances().remove(seance);
		seance.setSerie(null);

		return seance;
	}

	public Cd getCd() {
		return this.cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	public List<SeriesQuestion> getSeriesQuestions() {
		return this.seriesQuestions;
	}

	public void setSeriesQuestions(List<SeriesQuestion> seriesQuestions) {
		this.seriesQuestions = seriesQuestions;
	}

	public SeriesQuestion addSeriesQuestion(SeriesQuestion seriesQuestion) {
		getSeriesQuestions().add(seriesQuestion);
		seriesQuestion.setSerie(this);

		return seriesQuestion;
	}

	public SeriesQuestion removeSeriesQuestion(SeriesQuestion seriesQuestion) {
		getSeriesQuestions().remove(seriesQuestion);
		seriesQuestion.setSerie(null);

		return seriesQuestion;
	}

	public Question addQuestion(Question q, int numero) {
		SeriesQuestionRepository sqr = new SeriesQuestionRepository();
		SeriesQuestion sq = new SeriesQuestion();
		sq.setQuestion(q);
		sq.setSerie(this);
		SeriesQuestionPK sqpk = new SeriesQuestionPK();
		sqpk.setNumero(numero);
		sqpk.setQuestionsId(q.getId());
		sqpk.setSeriesId(this.getId());
		sq.setId(sqpk);
		sqr.save(sq);
		addSeriesQuestion(sq);
		return q;
		
	}

}