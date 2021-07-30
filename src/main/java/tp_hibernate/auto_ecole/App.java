package tp_hibernate.auto_ecole;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import tp_hibernate.auto_ecole.models.Cd;
import tp_hibernate.auto_ecole.models.Eleve;
import tp_hibernate.auto_ecole.models.Question;
import tp_hibernate.auto_ecole.models.Seance;
import tp_hibernate.auto_ecole.models.Serie;
import tp_hibernate.auto_ecole.models.SeriesQuestion;
import tp_hibernate.auto_ecole.models.SeriesQuestionPK;
import tp_hibernate.auto_ecole.repositories.CdRepository;
import tp_hibernate.auto_ecole.repositories.EleveRepository;
import tp_hibernate.auto_ecole.repositories.QuestionRepository;
import tp_hibernate.auto_ecole.repositories.SeanceRepository;
import tp_hibernate.auto_ecole.repositories.SerieRepository;
import tp_hibernate.auto_ecole.repositories.SeriesQuestionRepository;
import tp_hibernate.auto_ecole.utils.SessionHibernate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       EleveRepository er = new EleveRepository();
       /*Eleve e = new Eleve();
       e.setNom("dujardin");
       e.setPrenom("paul");
       er.save(e);*/
       
       CdRepository cr = new CdRepository();
       /*Cd c = new Cd();
       c.setEditeur("editeur1");
       cr.save(c);*/
        
       SerieRepository sr = new SerieRepository();
       /*Serie s = new Serie();
       s.setName("serie1");
       s.setCd(cr.get(1, Cd.class));
       sr.save(s);*/
       
       QuestionRepository qr = new QuestionRepository();
       /*Question q1 = new Question();
       q1.setIntitule("question1");
       qr.save(q1);
       Question q2 = new Question();
       q2.setIntitule("question2");
       qr.save(q2);
       Question q3 = new Question();
       q3.setIntitule("question3");
       qr.save(q3);*/
       
       SeriesQuestionRepository sqr = new SeriesQuestionRepository();
      /* SeriesQuestion sq = new SeriesQuestion();
       sq.setQuestion(qr.get(1, Question.class));
       sq.setSerie(sr.get(1, Serie.class));
       SeriesQuestionPK sqpk = new SeriesQuestionPK();
       sqpk.setNumero(1);
       sqpk.setQuestionsId(1);
       sqpk.setSeriesId(1);
       sq.setId(sqpk);
       sqr.save(sq);*/
       /*Serie s1 = sr.get(1, Serie.class);
       s1.addQuestion(qr.get(1, Question.class), 3);
       s1.addQuestion(qr.get(2, Question.class), 2);
       s1.addQuestion(qr.get(3, Question.class), 1);*/
       //sr.update(s1);
     //  System.out.println("test ajout question "+ s1.getSeriesQuestions().get(1).getQuestion().getIntitule());
       //Question q1 = qr.get(1, Question.class);
     //  System.out.println("test ajout question "+ q1.getSeriesQuestions().get(0).getSerie().getName());
       //s1 = sr.get(s1.getId(), Serie.class);
       /*s1.getSeriesQuestions().forEach(q -> {
    	   System.out.println(q.getId().getNumero());
       });*/
       //System.out.println(s1.getSeriesQuestions().get(1).getQuestion().getIntitule());
       //System.out.println("test ajout question "+ s1.getSeriesQuestions().get(1).getQuestion().getIntitule());
       SeanceRepository ser = new SeanceRepository();
      /* Seance se = new Seance();
       se.setEleve(er.get(2, Eleve.class));
       se.setSerie(sr.get(1, Serie.class));
       se.setDate(LocalDate.of(2021, 7, 31));
       ser.save(se);*/
       
       
       er.get(2, Eleve.class).getSeances().forEach(seance -> {
    	   seance.getSerie().getSeriesQuestions().forEach(sq ->{
    		   System.out.println(sq.getQuestion().getIntitule());
    	   });
       });
       
       
       
    }
}
