package entities;

import jakarta.persistence.*;
import java.util.Set;
import enumeration.TipoEvento;

@Entity
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica() {}

    public GaraDiAtletica(String titolo, java.time.LocalDate dataEvento, String descrizione,
                          TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location,
                          Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
