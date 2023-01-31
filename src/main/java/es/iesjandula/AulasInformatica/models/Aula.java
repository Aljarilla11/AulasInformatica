package es.iesjandula.AulasInformatica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "aula")
@Service
public class Aula
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 7,nullable = false)
    private int numeroAula;

    @Column(length = 3,nullable = false)
    private int planta;

    public Aula()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }
}
