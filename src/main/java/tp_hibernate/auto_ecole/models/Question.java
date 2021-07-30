package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String difficulte;

	private String intitule;


	private String reponse;

	private String theme;

	//bi-directional many-to-one association to SeriesQuestion
	@OneToMany(mappedBy="question")
	private List<SeriesQuestion> seriesQuestions;

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDifficulte() {
		return this.difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	
	public String getReponse() {
		return this.reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<SeriesQuestion> getSeriesQuestions() {
		return this.seriesQuestions;
	}

	public void setSeriesQuestions(List<SeriesQuestion> seriesQuestions) {
		this.seriesQuestions = seriesQuestions;
	}

	public SeriesQuestion addSeriesQuestion(SeriesQuestion seriesQuestion) {
		getSeriesQuestions().add(seriesQuestion);
		seriesQuestion.setQuestion(this);

		return seriesQuestion;
	}

	public SeriesQuestion removeSeriesQuestion(SeriesQuestion seriesQuestion) {
		getSeriesQuestions().remove(seriesQuestion);
		seriesQuestion.setQuestion(null);

		return seriesQuestion;
	}

}