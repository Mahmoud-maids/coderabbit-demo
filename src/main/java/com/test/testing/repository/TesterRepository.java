package com.test.testing.repository;

import com.test.testing.entity.Tester;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TesterRepository extends BaseRepository<Tester> {

    @Query("SELECT t FROM Tester t WHERE (:name is NULL OR t.name LIKE %:name%)")
    List<Tester> findWithSearch(String name);
}
