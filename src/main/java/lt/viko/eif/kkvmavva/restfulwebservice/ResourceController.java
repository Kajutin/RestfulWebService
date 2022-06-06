package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


/**
 *
 */
@RestController
public class ResourceController {

    private final FishRepository repository;
    ResourceController(FishRepository repository) {
        this.repository = repository;
    }

    JSON json = new JSON();

    /**
     * Gets all fish
     * @return
     */
    @GetMapping("/fish")
    ResponseEntity<CollectionModel<EntityModel<FishInfo>>> findAll() {

        //json.ReadJSONFile();

        List<EntityModel<FishInfo>> fishResources = StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(fishInfo -> EntityModel.of(fishInfo,
                        linkTo(methodOn(ResourceController.class).findOne(fishInfo.getId())).withSelfRel()
                                .andAffordance(afford(methodOn(ResourceController.class).updateFish(null, fishInfo.getId())))
                                .andAffordance(afford(methodOn(ResourceController.class).deleteFish(fishInfo.getId()))),
                        linkTo(methodOn(ResourceController.class).findAll()).withRel("fish")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of( //
                fishResources, //
                linkTo(methodOn(ResourceController.class).findAll()).withSelfRel()
                        .andAffordance(afford(methodOn(ResourceController.class).newFish(null)))));
    }

    /**
     * Creates new fish
     * @param fishInfo
     * @return
     */
    @PostMapping("/fish")
    ResponseEntity<?> newFish(@RequestBody FishInfo fishInfo) {

        FishInfo savedFish = repository.save(fishInfo);

        return EntityModel.of(savedFish,
                        linkTo(methodOn(ResourceController.class).findOne(savedFish.getId())).withSelfRel()
                                .andAffordance(afford(methodOn(ResourceController.class).updateFish(null, savedFish.getId())))
                                .andAffordance(afford(methodOn(ResourceController.class).deleteFish(savedFish.getId()))),
                        linkTo(methodOn(ResourceController.class).findAll()).withRel("fish")).getLink(IanaLinkRelations.SELF)
                .map(Link::getHref) //
                .map(href -> {
                    try {
                        return new URI(href);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }) //
                .map(uri -> ResponseEntity.noContent().location(uri).build())
                .orElse(ResponseEntity.badRequest().body("Unable to create " + fishInfo));
    }

    /**
     * Finds fish with id
     * @param id
     * @return
     */
    @GetMapping("/fish/{id}")
    ResponseEntity<EntityModel<FishInfo>> findOne(@PathVariable long id) {

        repository.findById(id)
                .orElseThrow(() -> new FishNotFoundException(id));


        return repository.findById(id)
                .map(fishInfo -> EntityModel.of(fishInfo,
                        linkTo(methodOn(ResourceController.class).findOne(fishInfo.getId())).withSelfRel()
                                .andAffordance(afford(methodOn(ResourceController.class).updateFish(null, fishInfo.getId())))
                                .andAffordance(afford(methodOn(ResourceController.class).deleteFish(fishInfo.getId()))),
                        linkTo(methodOn(ResourceController.class).findAll()).withRel("fish")))
                .map(ResponseEntity::ok) //
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates fish information
     * @param fishInfo
     * @param id
     * @return
     */
    @PutMapping("/fish/{id}")
    ResponseEntity<?> updateFish(@RequestBody FishInfo fishInfo, @PathVariable long id) {

        FishInfo fishToUpdate = fishInfo;
        fishToUpdate.setId(id);

        FishInfo updatedFish = repository.save(fishToUpdate);


        return EntityModel.of(updatedFish,
                        linkTo(methodOn(ResourceController.class).findOne(updatedFish.getId())).withSelfRel()
                                .andAffordance(afford(methodOn(ResourceController.class).updateFish(null, updatedFish.getId())))
                                .andAffordance(afford(methodOn(ResourceController.class).deleteFish(updatedFish.getId()))),
                        linkTo(methodOn(ResourceController.class).findAll()).withRel("fish")).getLink(IanaLinkRelations.SELF)
                .map(Link::getHref).map(href -> {
                    try {
                        return new URI(href);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }) //
                .map(uri -> ResponseEntity.noContent().location(uri).build()) //
                .orElse(ResponseEntity.badRequest().body("Unable to update " + fishToUpdate));
    }

    /**
     * Deletes fish
     * @param id
     * @return
     */
    @DeleteMapping("/fish/{id}")
    ResponseEntity<?> deleteFish(@PathVariable long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}