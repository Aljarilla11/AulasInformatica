package es.iesjandula.AulasInformatica.rest;


import es.iesjandula.AulasInformatica.models.*;
import es.iesjandula.AulasInformatica.repository.*;
import es.iesjandula.AulasInformatica.result.Reservas;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.PackageElement;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping(value = "/reserva", produces = {"application/json"})
public class RestHandlerReservas
{
    @Autowired
    private IAulaRepository iAulaRepository;
    @Autowired
    private ICarritoPcs iCarritoPcs;
    @Autowired
    private ICarritoTablets iCarritoTablets;
    @Autowired
    private IProfesorRepository iProfesorRepository;
    @Autowired
    private IReservaAula iReservaAula;
    @Autowired
    private IReservaCarritoPcs iReservaCarritoPcs;
    @Autowired
    private IReservaCarritoTablets iReservaCarritoTablets;




    @RequestMapping(method = RequestMethod.GET, value = "/visualizacionReservas")
    public ResponseEntity<?> visualizacionReservas()
    {
        List<ReservaAula> listaReservasAulas = new ArrayList<>();
        List<ReservaCarritoTablets> listaReservasTablets = new ArrayList<>();
        List<ReservaCarritoPcs> listaReservasPcs = new ArrayList<>();

        listaReservasAulas = iReservaAula.findAll();
        listaReservasPcs = iReservaCarritoPcs.findAll();
        listaReservasTablets = iReservaCarritoTablets.findAll();

        Reservas allReservas = new Reservas(listaReservasAulas,listaReservasTablets,listaReservasPcs);

        return ResponseEntity.ok().body(allReservas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seleccionAulas")
    public ResponseEntity<?> seleccionAulas(HttpSession session,
                                            @RequestParam(value="idProfesor", required=true) final Long idProfesor,
                                            @RequestParam(value="idAula", required=true) final Long idAula,
                                            @RequestParam(value="fecha", required=true) final Long fecha)
    {
        ReservaAula reservaAula = new ReservaAula();
        ReservaAulaId reservaAulaId = new ReservaAulaId();
        Profesor profesor = new Profesor();
        Aula aula = new Aula();


        reservaAulaId.setIdAula(idAula);
        Date fechaDate = new Date(fecha);
        reservaAulaId.setIdProfesor(idProfesor);
        reservaAulaId.setFecha(fechaDate);

        Optional<Profesor> optionalProfesor = this.iProfesorRepository.findById(idProfesor);
        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        Optional<Aula> optionalAula = this.iAulaRepository.findById(idAula);
        aula.setId(optionalAula.get().getId());
        aula.setNumeroAula(optionalAula.get().getNumeroAula());
        aula.setPlanta(optionalAula.get().getPlanta());

        reservaAula.setReservaAulaId(reservaAulaId);
        reservaAula.setIdProfesor(profesor);
        reservaAula.setIdAula(aula);

        this.iReservaAula.saveAndFlush(reservaAula);

        return  ResponseEntity.ok().body("Se ha realizado la reserva del aula");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seleccionTablets")
    public ResponseEntity<?> seleccionTablets(HttpSession session,
                                              @RequestParam(value="idProfesor", required=true) final Long idProfesor,
                                              @RequestParam(value="idCarritoTablets", required=true) final Long idCarritoTablets,
                                              @RequestParam(value="fecha", required=true) final Long fecha,
                                              @RequestParam(value = "ubicacionPrestamo") final String ubicacion)
    {
        ReservaCarritoTablets reservaCarritoTablets = new ReservaCarritoTablets();
        ReservaCarritoTabletsId reservaCarritoTabletsId = new ReservaCarritoTabletsId();
        Profesor profesor = new Profesor();
        CarritoTablets carritoTablets = new CarritoTablets();
        Date fechaDate = new Date(fecha);

        reservaCarritoTabletsId.setIdCarritoTablets(idCarritoTablets);
        reservaCarritoTabletsId.setIdProfesor(idProfesor);
        reservaCarritoTabletsId.setFecha(fechaDate);

        Optional<Profesor> optionalProfesor = this.iProfesorRepository.findById(idProfesor);
        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        Optional<CarritoTablets> optionalCarritoTablets = this.iCarritoTablets.findById(idCarritoTablets);
        carritoTablets.setId(optionalCarritoTablets.get().getId());
        carritoTablets.setNumeroTablets(optionalCarritoTablets.get().getNumeroTablets());
        carritoTablets.setPlanta(optionalCarritoTablets.get().getPlanta());

        reservaCarritoTablets.setIdCarritoTablets(carritoTablets);
        reservaCarritoTablets.setIdProfesor(profesor);
        //reservaCarritoTablets
        reservaCarritoTablets.setUbicacionPrestamo(ubicacion);

        this.iReservaCarritoTablets.saveAndFlush(reservaCarritoTablets);

        return  ResponseEntity.ok().body("Se ha realizado la reserva del carrito de las tablets");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seleccionPCs")
    public ResponseEntity<?> seleccionPCs(HttpSession session,
                                          @RequestParam(value="idProfesor", required=true) final Long idProfesor,
                                          @RequestParam(value="idCarritoPcs", required=true) final Long idCarritoPcs,
                                          @RequestParam(value="fecha", required=true) final Long fecha,
                                          @RequestParam(value = "ubicacionPrestamo") final String ubicacion)
    {
        ReservaCarritoPcs reservaCarritoPcs = new ReservaCarritoPcs();
        ReservaCarritoPcsId reservaCarritoPcsId = new ReservaCarritoPcsId();
        Profesor profesor = new Profesor();
        CarritoPcs carritoPcs = new CarritoPcs();
        Date fechaDate = new Date(fecha);

        reservaCarritoPcsId.setIdCarritoPcs(idCarritoPcs);
        reservaCarritoPcsId.setIdProfesor(idProfesor);
        reservaCarritoPcsId.setFecha(fechaDate);

        Optional<Profesor> optionalProfesor = this.iProfesorRepository.findById(idProfesor);
        profesor.setId(optionalProfesor.get().getId());
        profesor.setNombre(optionalProfesor.get().getNombre());
        profesor.setApellidos(optionalProfesor.get().getApellidos());

        Optional<CarritoPcs> optionalCarritoPcs = this.iCarritoPcs.findById(idCarritoPcs);
        carritoPcs.setId(optionalCarritoPcs.get().getId());
        carritoPcs.setNumeroPcs(optionalCarritoPcs.get().getNumeroPcs());
        carritoPcs.setPlanta(optionalCarritoPcs.get().getPlanta());
        carritoPcs.setSistemaOperativo(optionalCarritoPcs.get().getSistemaOperativo());

        reservaCarritoPcs.setIdCarritoPcs(carritoPcs);
        reservaCarritoPcs.setUbicacionPrestamo(ubicacion);
        reservaCarritoPcs.setIdProfesor(profesor);
        //re

        this.iReservaCarritoPcs.saveAndFlush(reservaCarritoPcs);

        return  ResponseEntity.ok().body("Se ha realizado la reserva del carrito de los pcs");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/confirmacionReserva")
    public ResponseEntity<?> confirmacionReserva(HttpSession session,
                                                 @RequestParam(value="confirmacion", required=true) final String confirmacion)
    {

        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cancelarReserva")
    public ResponseEntity<?> cancelarReserva(HttpSession session,
                                            @RequestParam(value="idProfesor", required=true) final Integer idProfesor,
                                            @RequestParam(value="idAula", required=true) final Integer idAula,
                                            @RequestParam(value="fecha", required=true) final Long fecha)
    {

        return null;
    }



}
