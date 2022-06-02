package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class ResourceController {

    private final FishRepository repository;
    ResourceController(FishRepository repository) {
        this.repository = repository;
    }
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/fish")
    List<FishInfo> all() {
        return repository.findAll();
    }

    @PostMapping("/fish")
    FishInfo newFish(@RequestBody FishInfo newFish) {
        return repository.save(newFish);
    }

    @GetMapping("/fish/{id}")
    FishInfo one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new FishNotFoundException(id));
    }

    @PutMapping("/fish/{id}")
    FishInfo replaceFish(@RequestBody FishInfo newFish, @PathVariable Long id) {

        return repository.findById(id)
                .map(fish -> {
                    fish.setName(newFish.getName());
                    fish.setDescription(newFish.getDescription());
                    return repository.save(fish);
                })
                .orElseGet(() -> {
                    newFish.setId(id);
                    return repository.save(newFish);
                });
    }

    @DeleteMapping("/fish/{id}")
    void deleteFish(@PathVariable Long id) {
        repository.deleteById(id);
    }







    /*
    @GetMapping("/fish")
    ResponseEntity<CollectionModel<EntityModel<FishInfo>>> findAll() {

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

    @GetMapping("/fish/{id}")
    ResponseEntity<EntityModel<FishInfo>> findOne(@PathVariable long id) {

        return repository.findById(id)
                .map(fishInfo -> EntityModel.of(fishInfo,
                        linkTo(methodOn(ResourceController.class).findOne(fishInfo.getId())).withSelfRel()
                                .andAffordance(afford(methodOn(ResourceController.class).updateFish(null, fishInfo.getId())))
                                .andAffordance(afford(methodOn(ResourceController.class).deleteFish(fishInfo.getId()))),
                        linkTo(methodOn(ResourceController.class).findAll()).withRel("fish")))
                .map(ResponseEntity::ok) //
                .orElse(ResponseEntity.notFound().build());
    }
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

    @DeleteMapping("/fish/{id}")
    ResponseEntity<?> deleteFish(@PathVariable long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }*/

}