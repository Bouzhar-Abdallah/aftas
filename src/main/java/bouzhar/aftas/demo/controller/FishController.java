package bouzhar.aftas.demo.controller;


import bouzhar.aftas.demo.ApiConstants;
import bouzhar.aftas.demo.service.FishService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_VERSION + "fish")

public class FishController {
    private static FishService fishService;
}
