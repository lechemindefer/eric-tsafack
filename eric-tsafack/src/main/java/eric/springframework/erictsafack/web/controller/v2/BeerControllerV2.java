package eric.springframework.erictsafack.web.controller.v2;

import eric.springframework.erictsafack.web.model.v2.BeerDtoV2;
import eric.springframework.erictsafack.web.service.BeerService;
import eric.springframework.erictsafack.web.service.v2.BeerServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2")
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    @Autowired
    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("beer/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getByBeerId(beerId), HttpStatus.OK);
    }
    @PostMapping("beer/create")
    public ResponseEntity<BeerDtoV2> createBeer(@RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 beerSave = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location",beerSave.getId().toString());
        return new ResponseEntity<BeerDtoV2>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/beer/{beerId}")
    public ResponseEntity<BeerDtoV2> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDto){
        beerService.beerUpdate(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/beer/{beerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteByBeerId(beerId);
    }
}
