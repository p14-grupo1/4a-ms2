package com.misiontic.Turismo_ms.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic.Turismo_ms.models.Turista;

public interface TuristaRepository extends MongoRepository<Turista, String>  { }
