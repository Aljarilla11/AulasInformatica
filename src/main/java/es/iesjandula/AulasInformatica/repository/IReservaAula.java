package es.iesjandula.AulasInformatica.repository;

import es.iesjandula.AulasInformatica.models.ReservaAula;
import es.iesjandula.AulasInformatica.models.ReservaAulaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaAula extends JpaRepository<ReservaAula, ReservaAulaId>
{

}
