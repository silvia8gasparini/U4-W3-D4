package dao;

import entities.Concerto;
import entities.PartitaDiCalcio;
import enumeration.GenereConcerto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDao {

    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming", Concerto.class);
        query.setParameter("streaming", streaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.vinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.vinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
