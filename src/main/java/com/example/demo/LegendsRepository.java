package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Table(name = "legends")
@Repository
public interface LegendsRepository extends JpaRepository<Legend, Long> {


    // READ

    List<Legend> getAllByLane(String lane);

    @Query(value = "SELECT * FROM legends ORDER BY id", nativeQuery = true)
    List<Legend> getAllByName();

    List<Legend> getByName(String name);

    // delete

    void deleteLegendById(long id);




}
