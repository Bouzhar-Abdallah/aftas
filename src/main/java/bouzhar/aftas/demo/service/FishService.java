package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.dto.fish.FishReq;
import bouzhar.aftas.demo.dto.fish.FishRes;
import bouzhar.aftas.demo.entity.Fish;
import bouzhar.aftas.demo.entity.Level;
import bouzhar.aftas.demo.exceptions.fish.FishNotFoundException;
import bouzhar.aftas.demo.exceptions.level.LevelNotFoundException;
import bouzhar.aftas.demo.repository.FishRepository;
import bouzhar.aftas.demo.repository.LevelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FishService {
    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public FishRes create(FishReq fishReq) {

        Level level = levelRepository.findById(fishReq.getLevel_code()).orElseThrow(LevelNotFoundException::new);
        Fish fish = modelMapper.map(fishReq, Fish.class);
        fish.setLevel(level);
        return modelMapper.map(fishRepository.save(fish),FishRes.class);

    }

    public List<FishRes> createTwenty(List<FishReq> fishReqList) {

        Level level = levelRepository.findById(fishReqList.get(0).getLevel_code()).orElseThrow(LevelNotFoundException::new);
        List<Fish> fishList = fishReqList.stream().map(fishReq -> {
            Fish fish = modelMapper.map(fishReq, Fish.class);
            fish.setLevel(level);
            return fish;
        }).toList();
        return fishRepository.saveAll(fishList).stream().map(fish -> modelMapper.map(fish,FishRes.class)).toList();

    }

    public FishRes getFish(String name) {
        Fish fish = fishRepository.findById(name).orElseThrow(()-> new FishNotFoundException(name));
        return modelMapper.map(fish,FishRes.class);
    }

    public List<FishRes> getAll() {
        return fishRepository.findAll().stream().map(fish -> modelMapper.map(fish,FishRes.class)).toList();
    }

    public FishRes update(FishReq fishReq) {
        Level level = levelRepository.findById(fishReq.getLevel_code()).orElseThrow(LevelNotFoundException::new);
        Fish fish = modelMapper.map(fishReq, Fish.class);
        fish.setLevel(level);
        return modelMapper.map(fishRepository.save(fish),FishRes.class);
    }

    public FishRes delete(String name) {
        Fish fish = fishRepository.findById(name).orElseThrow(()-> new FishNotFoundException(name));
        fishRepository.delete(fish);
        return modelMapper.map(fish,FishRes.class);
    }
}
