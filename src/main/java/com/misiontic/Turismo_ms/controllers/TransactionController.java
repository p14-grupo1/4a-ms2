package com.misiontic.Turismo_ms.controllers;
import com.misiontic.Turismo_ms.exceptions.GestionNotFoundException;

import com.misiontic.Turismo_ms.models.Empresa;
import com.misiontic.Turismo_ms.models.Hotel;
import com.misiontic.Turismo_ms.repositories.EmpresaRepository;
import com.misiontic.Turismo_ms.repositories.HotelRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class TransactionController {
	
    private final HotelRepository hotelRepository;
	private final EmpresaRepository empresaRepository;

    public TransactionController(HotelRepository hotelRepository,EmpresaRepository empresaRepository) {
        this.hotelRepository = hotelRepository;
        this.empresaRepository = empresaRepository;
    }

    @GetMapping("/hotel/{id}")
    Optional<Hotel> getHoteles(@PathVariable  String id){
        return hotelRepository.findById(id);
    }

    @GetMapping("/hotel")
    List<Hotel> listHoteles(){
        return hotelRepository.findAll();
    }

    @PostMapping("/hotel")
    Hotel newHoteles(@RequestBody Hotel hotel){
    	Empresa empresaDestiny = empresaRepository.findById(hotel.getViceowner()).orElse(null);
    	Empresa empresaOrigin = empresaRepository.findById(hotel.getOwner()).orElse(null);
        if(empresaDestiny == null || empresaOrigin == null){
            throw new GestionNotFoundException("No se encontró el id destino o el dueño destino");
        }
        empresaOrigin.setEstrellas(empresaOrigin.getEstrellas() - hotel.getQualification());
        empresaDestiny.setEstrellas(empresaDestiny.getEstrellas() + hotel.getQualification());
        empresaRepository.save(empresaOrigin);
        empresaRepository.save(empresaDestiny);
        return hotelRepository.save(hotel);
    }
   
}
