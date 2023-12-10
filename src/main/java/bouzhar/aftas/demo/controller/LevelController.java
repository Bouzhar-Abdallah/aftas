package bouzhar.aftas.demo.controller;

import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.dto.level.LevelSimple;
import bouzhar.aftas.demo.service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION +"level")
@AllArgsConstructor
public class LevelController {
    private final LevelService levelService;


    @PostMapping
    public LevelSimple createLevel(@RequestBody LevelSimple levelSimple){
        return levelService.create(levelSimple);
    }

    @GetMapping(path = "{id}")
    public LevelSimple getLevel(@PathVariable("id") Integer id){
        System.out.println("'kkkk '" + id);
        return levelService.getLevel(id);
    }

    @GetMapping
    public List<LevelSimple> getLevels(){
        return levelService.getAllLevels();
    }

    @PutMapping
    public LevelSimple updateLevel(@RequestBody LevelSimple levelSimple){
        return levelService.update(levelSimple);
    }

    @DeleteMapping(path = "{id}")
    public LevelSimple deleteLevel(@PathVariable Integer id){
        return levelService.delete(id);
    }
}
