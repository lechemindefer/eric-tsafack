package eric.springframework.erictsafack.web.service.v2;

import eric.springframework.erictsafack.web.model.v2.BeerDtoV2;
import eric.springframework.erictsafack.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getByBeerId(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Iphone")
                .beerStyle(BeerStyleEnum.LAGER)
                .build();
    }
    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }
    @Override
    public void beerUpdate(UUID beerId, BeerDtoV2 beerDto) {
        return;
    }
    @Override
    public void deleteByBeerId(UUID beerId) {
        log.debug("deleting a beer");
    }
}
