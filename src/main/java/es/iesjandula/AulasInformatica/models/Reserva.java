package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva
{
    @Id
    @Column(length = 4)
    private Profesor idProfesor;

    @Id
    @Column(length = 4)
    private Aula idAula;

    @Id
    @Column(length = 4)
    private Date fecha;

    public Reserva()
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
