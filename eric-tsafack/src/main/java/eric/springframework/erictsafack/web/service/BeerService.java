package eric.springframework.erictsafack.web.service;

import eric.springframework.erictsafack.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getByBeerId(UUID beerId);
    BeerDto saveNewBeer(BeerDto beerDto);
    void beerUpdate(UUID beerId, BeerDto beerDto);
    void deleteByBeerId(UUID beerId);
}
