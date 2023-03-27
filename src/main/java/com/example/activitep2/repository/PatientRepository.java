package com.example.activitep2.repository;

import com.example.activitep2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
List<Patient> findByMalade(Boolean m);
Page<Patient> findByMalade(Boolean m, Pageable pageable );
    List<Patient> findByMaladeAndScoreLessThan(Boolean m,int score);
    @Query("select p from Patient p where  p.score > :y" )
    List<Patient> chercherPatient(  @Param("y")int score);
}
