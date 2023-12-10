package bouzhar.aftas.demo.controller;


import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.dto.fish.FishReq;
import bouzhar.aftas.demo.dto.fish.FishRes;
import bouzhar.aftas.demo.service.FishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "fish")

@AllArgsConstructor
public class FishController {
    private final FishService fishService;

    @PostMapping
    public FishRes create(@RequestBody FishReq fishReq){
        return fishService.create(fishReq);
    }

    @PostMapping(path = "twenty")
    public List<FishRes> createTwenty(@RequestBody List<FishReq> fishReqList){
        return fishService.createTwenty(fishReqList);
    }

    @GetMapping(path = "{name}")
    public FishRes getFish(@PathVariable("name") String name){
        return fishService.getFish(name);
    }

    @GetMapping
    public List<FishRes> getAllFish(){
        return fishService.getAll();
    }

    @PutMapping
    public FishRes updateFish(@RequestBody FishReq fishReq){
        return fishService.update(fishReq);
    }

    @DeleteMapping(path = "{name}")
    public FishRes deleteFish(@PathVariable("name") String name){
        return fishService.delete(name);
    }
}
