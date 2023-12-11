package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entity.RankId;
import bouzhar.aftas.demo.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {
}
