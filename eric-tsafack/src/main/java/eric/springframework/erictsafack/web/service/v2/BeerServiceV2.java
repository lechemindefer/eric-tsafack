package eric.springframework.erictsafack.web.service.v2;

import eric.springframework.erictsafack.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getByBeerId(UUID beerId);
    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);
    void beerUpdate(UUID beerId, BeerDtoV2 beerDto);
    void deleteByBeerId(UUID beerId);
}
