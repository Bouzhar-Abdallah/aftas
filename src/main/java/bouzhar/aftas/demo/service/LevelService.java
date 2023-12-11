package bouzhar.aftas.demo.service;

import bouzhar.aftas.demo.dto.level.LevelSimple;
import bouzhar.aftas.demo.entity.Level;
import bouzhar.aftas.demo.exceptions.level.LevelAlreadyExistsException;
import bouzhar.aftas.demo.exceptions.level.LevelNotFoundException;
import bouzhar.aftas.demo.exceptions.level.LevelPointsConstraintsException;
import bouzhar.aftas.demo.repository.LevelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public LevelSimple create(LevelSimple newLevel) throws LevelPointsConstraintsException, LevelAlreadyExistsException{

        checkExists(newLevel);
        checkPoints(newLevel);

        return modelMapper.map(
                levelRepository.save(modelMapper.map(newLevel, Level.class))
                , LevelSimple.class);

    }

    public LevelSimple getLevel(Integer id) {
        return modelMapper.map(
                levelRepository.findById(id).orElseThrow(
                        LevelNotFoundException::new
                ),
                LevelSimple.class
        );
    }

    public List<LevelSimple> getAllLevels() {
        return levelRepository.getAllByOrderByCodeAsc().stream().map(
                level -> modelMapper.map(level, LevelSimple.class)
        ).toList();
        // toList return unmodifiable list
        // collect(Collectors.toList() returns modifiable list
    }

    public LevelSimple update(LevelSimple levelSimple) throws LevelNotFoundException{
        levelRepository.findById(levelSimple.getCode()).orElseThrow(
                LevelNotFoundException::new
        );
        checkPoints(levelSimple);
        return modelMapper.map(levelRepository.save(modelMapper.map(levelSimple, Level.class)), LevelSimple.class);
    }

    public LevelSimple delete(Integer id) {
        Level level = levelRepository.findById(id).orElseThrow(
                LevelNotFoundException::new
        );
        levelRepository.deleteById(id);
        return modelMapper.map(level, LevelSimple.class);
    }

    private void checkPoints(LevelSimple levelToCheck) throws LevelPointsConstraintsException{
        List<LevelSimple> levels = new ArrayList<>(getAllLevels());

        Integer lowerPoints = null;
        Integer higherPoints = null;

        for (LevelSimple level : levels) {
            if (level.getCode() < levelToCheck.getCode()) {
                lowerPoints = level.getPoints();
            } else if (level.getCode() > levelToCheck.getCode()) {
                higherPoints = level.getPoints();
                break;
            }
        }

        if (lowerPoints != null && levelToCheck.getPoints() <= lowerPoints) {
            throw new LevelPointsConstraintsException("Level " + levelToCheck.getCode() + " points should be greater than " + lowerPoints);
        }
        if (higherPoints != null && levelToCheck.getPoints() >= higherPoints) {
            throw new LevelPointsConstraintsException("Level " + levelToCheck.getCode() + " points should be less than " + higherPoints);
        }
    }
    private void checkExists(LevelSimple newLevel) {
        if (levelRepository.existsById(newLevel.getCode())) throw new LevelAlreadyExistsException();
    }
}
