package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "reserva_carrito_pcs")
@Service
public class ReservaCarritoPcs
{

    @EmbeddedId
    private ReservaCarritoPcsId reservaCarritoPcsId;
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_carrito_pcs")
    @MapsId("idCarritoPcs")
    private CarritoPcs idCarritoPcs;
    @Column(length = 25)
    private String ubicacionPrestamo;

    public ReservaCarritoPcs()
    {

    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public CarritoPcs getIdCarritoPcs() {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(CarritoPcs idCarritoPcs) {
        this.idCarritoPcs = idCarritoPcs;
    }

    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacionPrestamo) {
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
