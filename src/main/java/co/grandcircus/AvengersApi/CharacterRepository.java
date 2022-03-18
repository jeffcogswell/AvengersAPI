package co.grandcircus.AvengersApi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<AvCharacter, String> {

}
