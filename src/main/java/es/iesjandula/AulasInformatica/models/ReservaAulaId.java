package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Service
public class ReservaAulaId implements Serializable
{
    private static final long serialVersionUID = -2149990752410587470L;
    private Long idProfesor;
    private Long idAula;
    private Date fecha;

    public ReservaAulaId()
    {

    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

