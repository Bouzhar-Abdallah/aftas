package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entitie.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting,Integer> {
}
