package com.misiontic.Turismo_ms.controllers;

import com.misiontic.Turismo_ms.exceptions.GestionNotFoundException;
import com.misiontic.Turismo_ms.models.Turista;
import com.misiontic.Turismo_ms.repositories.TuristaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TurismoController {
	
    private final TuristaRepository turistaRepository;

    public TurismoController(TuristaRepository turistaRepository) {
        this.turistaRepository = turistaRepository;
    }

    @PostMapping("/turistas")
    Turista newTurista(@RequestBody Turista turista){
        return turistaRepository.save(turista);
    }

    @GetMapping("/turistas/{username}")
    Turista getTurista(@PathVariable String username){
        return turistaRepository.findById(username)
                .orElseThrow(() -> new GestionNotFoundException("No se encontró la cuenta"));
    }

    @DeleteMapping("/turistas/{username}")
    void deleteTurista(@PathVariable String username){
    	turistaRepository.deleteById(username);
    }

    @PutMapping("/turistas/{username}")
	Turista updateTurista(@PathVariable String username, @RequestBody Turista new_Turista) {
		Turista old_turista = turistaRepository.findById(username).orElse(null);
		old_turista.setAge(new_Turista.getAge());
		old_turista.setLastChange(new_Turista.getLastChange());
		old_turista.setNombreLugar(new_Turista.getNombreLugar());
		old_turista.setUsername(new_Turista.getUsername());
		return turistaRepository.save(old_turista);
	}
}
