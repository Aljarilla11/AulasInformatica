package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "carrito_tablets")
@Service
public class CarritoTablets
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 10,nullable = false)
    private int numeroTablets;

    @Column(length = 3,nullable = false)
    private int planta;

    public CarritoTablets()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroTablets() {
        return numeroTablets;
    }

    public void setNumeroTablets(int numeroTablets) {
        this.numeroTablets = numeroTablets;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }
}
