package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entitie.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {
}
