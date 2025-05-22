package entities;

import enumeration.GenereConcerto;
import enumeration.TipoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;

    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto() {}

    public Concerto(String titolo, java.time.LocalDate dataEvento, String descrizione,
                    TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location,
                    GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

}
