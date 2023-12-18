package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entity.Competition;
import bouzhar.aftas.demo.entity.Fish;
import bouzhar.aftas.demo.entity.Hunting;
import bouzhar.aftas.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting,Integer> {
    Hunting findByCompetitionAndMemberAndFish(Competition competition, Member member, Fish fish);
}
