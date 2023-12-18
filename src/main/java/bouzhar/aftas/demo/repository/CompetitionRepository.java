package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {
    List<Competition> getAllByOrderByDateAscStartTimeAsc();
}
