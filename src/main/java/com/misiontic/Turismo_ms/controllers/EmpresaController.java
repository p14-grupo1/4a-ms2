package com.misiontic.Turismo_ms.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.Turismo_ms.exceptions.GestionNotFoundException;
import com.misiontic.Turismo_ms.models.Empresa;
import com.misiontic.Turismo_ms.repositories.EmpresaRepository;

@RestController
public class EmpresaController {

	private final EmpresaRepository empresaRepository;

  
    public EmpresaController(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	@PostMapping("/empresa")
    Empresa newEmpresa(@RequestBody Empresa empresa){
        return empresaRepository.save(empresa);
    }

    @GetMapping("/empresa/{nit}")
    Empresa getEmpresa(@PathVariable String nit){
        return empresaRepository.findById(nit)
                .orElseThrow(() -> new GestionNotFoundException("No se encontró El Nit de la empresa"));
    }

    @DeleteMapping("/empresa/{nit}")
    void deleteEmpresa(@PathVariable String nit){
    	empresaRepository.deleteById(nit);
    }

    @PutMapping("/empresa/{nit}")
    Empresa updateEmpresa(@PathVariable String nit, @RequestBody Empresa new_Empresa) {
    	Empresa old_Empresa = empresaRepository.findById(nit).orElse(null);
    	old_Empresa.setGerente(new_Empresa.getGerente());
    	old_Empresa.setNameEmp(new_Empresa.getNameEmp());
    	old_Empresa.setEstrellas(new_Empresa.getEstrellas());
    	old_Empresa.setSize(new_Empresa.getSize());
    	old_Empresa.setNit(new_Empresa.getNit());
		return empresaRepository.save(old_Empresa);
	}
}
