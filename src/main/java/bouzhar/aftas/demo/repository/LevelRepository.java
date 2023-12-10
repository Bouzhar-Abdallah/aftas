package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.dto.level.LevelSimple;
import bouzhar.aftas.demo.entitie.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level,Integer> {
    List<Level> getAllByOrderByCodeAsc();
}
