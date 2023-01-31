package es.iesjandula.AulasInformatica.repository;

import es.iesjandula.AulasInformatica.models.ReservaCarritoPcs;
import es.iesjandula.AulasInformatica.models.ReservaCarritoPcsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaCarritoPcs extends JpaRepository<ReservaCarritoPcs, ReservaCarritoPcsId>
{

}
