package com.kleio.app.repository;

import com.kleio.app.entities.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoiRepository extends JpaRepository<Poi, Integer> {

    List<Poi> getByUniversityId(int universityId);

    @Query("SELECT poi.name FROM Poi poi WHERE poi.universityId = :universityId")
    List<String> getPoiNamesByUniversityId(@Param("universityId") int universityId);
}
