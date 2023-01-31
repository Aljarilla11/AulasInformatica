package es.iesjandula.AulasInformatica.repository;

import es.iesjandula.AulasInformatica.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{

}
