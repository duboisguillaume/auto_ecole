package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the series_questions database table.
 * 
 */
@Entity
@Table(name="series_questions")
@NamedQuery(name="SeriesQuestion.findAll", query="SELECT s FROM SeriesQuestion s")
public class SeriesQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeriesQuestionPK id;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="questions_id",insertable=false, updatable=false)
	private Question question;

	//bi-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumn(name="series_id",insertable=false, updatable=false)
	private Serie serie;

	public SeriesQuestion() {
	}

	public SeriesQuestionPK getId() {
		return this.id;
	}

	public void setId(SeriesQuestionPK id) {
		this.id = id;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Serie getSerie() {
		return this.serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}