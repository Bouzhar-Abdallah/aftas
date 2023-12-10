package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entitie.RankId;
import bouzhar.aftas.demo.entitie.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {
}
