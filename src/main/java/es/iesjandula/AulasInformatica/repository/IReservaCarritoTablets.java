package es.iesjandula.AulasInformatica.repository;

import es.iesjandula.AulasInformatica.models.ReservaCarritoTablets;
import es.iesjandula.AulasInformatica.models.ReservaCarritoTabletsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaCarritoTablets extends JpaRepository<ReservaCarritoTablets, ReservaCarritoTabletsId>
{

}
