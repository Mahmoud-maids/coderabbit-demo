package com.test.testing.repository;

import com.test.testing.entity.Tester;
import com.test.testing.dto.TesterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TesterRepository extends BaseRepository<Tester> {

    @Query("SELECT t FROM Tester t WHERE (:name is NULL OR t.name LIKE %:name%)")
    List<Tester> findWithSearch(String name);

    @Query("SELECT new com.test.testing.dto.TesterDTO(t.id, t.name, t.number) FROM Tester t")
    Page<TesterDTO> findAllTestersWithPagination(Pageable pageable);
}
