package com.misiontic.Turismo_ms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.misiontic.Turismo_ms.models.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String>  {

}
