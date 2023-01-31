package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
@Embeddable
@Service
public class ReservaCarritoPcsId implements Serializable
{
    private static final long serialVersionUID = -2149990752410587470L;
    private Long idProfesor;
    private Long idCarritoPcs;
    private Date fecha;

    public ReservaCarritoPcsId()
    {

    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdCarritoPcs() {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(Long idCarritoPcs) {
        this.idCarritoPcs = idCarritoPcs;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
