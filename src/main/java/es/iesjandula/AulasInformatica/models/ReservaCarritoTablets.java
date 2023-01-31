package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "reserva_carrito_tablets")
@Service
public class ReservaCarritoTablets
{
    @EmbeddedId
    private ReservaCarritoTabletsId reservaCarritoTabletsId;
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_carrito_tablets")
    @MapsId("idCarritoTablets")
    private CarritoTablets idCarritoTablets;
    @Column(length = 25)
    private String ubicacionPrestamo;

    public ReservaCarritoTablets()
    {

    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public CarritoTablets getIdCarritoTablets() {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(CarritoTablets idCarritoTablets) {
        this.idCarritoTablets = idCarritoTablets;
    }

    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacionPrestamo) {
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
