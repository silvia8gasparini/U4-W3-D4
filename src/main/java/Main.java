import dao.EventoDao;
import entities.*;
import enumeration.GenereConcerto;
import enumeration.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

        try {
            em.getTransaction().begin();

            Location location = new Location("Arena di Verona", "Verona");
            em.persist(location);

            Concerto concerto = new Concerto(
                    "Concerto di Beethoven",
                    LocalDate.of(2025, 6, 15),
                    "Concerto per piano n.1 in do maggiore op.15",
                    TipoEvento.PUBBLICO,
                    5000,
                    location,
                    GenereConcerto.CLASSICO,
                    true
            );
            em.persist(concerto);

            PartitaDiCalcio partita = new PartitaDiCalcio(
                    "Italia-Giappone",
                    LocalDate.of(2025, 9, 12),
                    "Amichevole",
                    TipoEvento.PUBBLICO,
                    80000,
                    location,
                    "Italia",
                    "Giappone",
                    "Giappone",
                    0,
                    3
            );
            em.persist(partita);

            em.getTransaction().commit();

            System.out.println("Dati inseriti con successo!");

            System.out.println("Concerti in streaming:");
            List<Concerto> streamingConcerts = dao.getConcertiInStreaming(true);
            streamingConcerts.forEach(System.out::println);

            System.out.println("Partite vinte in casa:");
            List<PartitaDiCalcio> vinteInCasa = dao.getPartiteVinteInCasa();
            vinteInCasa.forEach(System.out::println);

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
