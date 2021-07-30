package tp_hibernate.auto_ecole.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the series_questions database table.
 * 
 */
@Embeddable
public class SeriesQuestionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="series_id", insertable=false, updatable=false)
	private int seriesId;

	@Column(name="questions_id", insertable=false, updatable=false)
	private int questionsId;

	private int numero;

	public SeriesQuestionPK() {
	}
	public int getSeriesId() {
		return this.seriesId;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public int getQuestionsId() {
		return this.questionsId;
	}
	public void setQuestionsId(int questionsId) {
		this.questionsId = questionsId;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SeriesQuestionPK)) {
			return false;
		}
		SeriesQuestionPK castOther = (SeriesQuestionPK)other;
		return 
			(this.seriesId == castOther.seriesId)
			&& (this.questionsId == castOther.questionsId)
			&& (this.numero == castOther.numero);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.seriesId;
		hash = hash * prime + this.questionsId;
		hash = hash * prime + this.numero;
		
		return hash;
	}
}