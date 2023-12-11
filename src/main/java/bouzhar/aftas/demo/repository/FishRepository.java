package bouzhar.aftas.demo.repository;

import bouzhar.aftas.demo.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<Fish,String> {
}
