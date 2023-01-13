package eric.springframework.erictsafack.web.controller;

import eric.springframework.erictsafack.web.model.BeerDto;
import eric.springframework.erictsafack.web.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.UUID;
@Deprecated
@RestController
@RequestMapping("/api/v1")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("beer/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getByBeerId(beerId), HttpStatus.OK);
    }
    @PostMapping("beer/create")
    public ResponseEntity<BeerDto> createBeer(@RequestBody BeerDto beerDto){
        BeerDto beerSave = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location",beerSave.getId().toString());
        return new ResponseEntity<BeerDto>(headers,HttpStatus.CREATED);
    }

    @PutMapping("/beer/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto){
        beerService.beerUpdate(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/beer/{beerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteByBeerId(beerId);
    }
}
