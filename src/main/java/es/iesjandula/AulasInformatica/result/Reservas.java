package es.iesjandula.AulasInformatica.result;

import es.iesjandula.AulasInformatica.models.ReservaAula;
import es.iesjandula.AulasInformatica.models.ReservaCarritoPcs;
import es.iesjandula.AulasInformatica.models.ReservaCarritoTablets;

import java.util.List;

public class Reservas
{
    private List<ReservaAula> reservaAulas;
    private List<ReservaCarritoTablets> reservaCarritoTablets;
    private List<ReservaCarritoPcs> reservaCarritoPcs;

    public Reservas()
    {

    }

    public Reservas(List<ReservaAula> reservaAulas, List<ReservaCarritoTablets> reservaCarritoTablets,
                    List<ReservaCarritoPcs> reservaCarritoPcs)
    {
        this.reservaAulas = reservaAulas;
        this.reservaCarritoTablets = reservaCarritoTablets;
        this.reservaCarritoPcs = reservaCarritoPcs;
    }

    public List<ReservaAula> getReservaAulas() {
        return reservaAulas;
    }

    public void setReservaAulas(List<ReservaAula> reservaAulas) {
        this.reservaAulas = reservaAulas;
    }

    public List<ReservaCarritoTablets> getReservaCarritoTablets() {
        return reservaCarritoTablets;
    }

    public void setReservaCarritoTablets(List<ReservaCarritoTablets> reservaCarritoTablets) {
        this.reservaCarritoTablets = reservaCarritoTablets;
    }

    public List<ReservaCarritoPcs> getReservaCarritoPcs() {
        return reservaCarritoPcs;
    }

    public void setReservaCarritoPcs(List<ReservaCarritoPcs> reservaCarritoPcs) {
        this.reservaCarritoPcs = reservaCarritoPcs;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "reservaAulas=" + reservaAulas +
                ", reservaCarritoTablets=" + reservaCarritoTablets +
                ", reservaCarritoPcs=" + reservaCarritoPcs +
                '}';
    }
}
