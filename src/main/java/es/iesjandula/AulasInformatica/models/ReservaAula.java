package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "reserva_aula")
@Service
public class ReservaAula
{

    @EmbeddedId
    private ReservaAulaId reservaAulaId;
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    @MapsId("idAula")
    private Aula idAula;

    public ReservaAula()
    {

    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
    }

    public ReservaAulaId getReservaAulaId() {
        return reservaAulaId;
    }

    public void setReservaAulaId(ReservaAulaId reservaAulaId) {
        this.reservaAulaId = reservaAulaId;
    }
}
