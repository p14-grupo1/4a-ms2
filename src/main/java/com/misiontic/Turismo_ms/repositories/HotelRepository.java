package com.misiontic.Turismo_ms.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic.Turismo_ms.models.Hotel;
import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String>{
	List<Hotel> findByViceowner ( String viceowner);
    List<Hotel> findByOwner( String owner);
   
}
