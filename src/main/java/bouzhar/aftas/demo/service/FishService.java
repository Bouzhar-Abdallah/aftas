package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.repository.FishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FishService {
    private final FishRepository fishRepository;
}
