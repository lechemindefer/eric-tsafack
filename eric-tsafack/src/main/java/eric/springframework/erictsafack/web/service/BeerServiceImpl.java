package eric.springframework.erictsafack.web.service;

import eric.springframework.erictsafack.web.model.BeerDto;
import eric.springframework.erictsafack.web.service.BeerService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getByBeerId(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Iphone")
                .beerStyle("14 Max")
                .build();
    }
    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
    @Override
    public void beerUpdate(UUID beerId, BeerDto beerDto) {
        return;
    }
    @Override
    public void deleteByBeerId(UUID beerId) {
        log.debug("deleting a beer");
    }
}
