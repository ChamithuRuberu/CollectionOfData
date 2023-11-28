package com.GreenCodeSolution.CollectionOfData.repo;
import com.GreenCodeSolution.CollectionOfData.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    public List<Client> findByFullName(String name);

    @Query(value = "SELECT id FROM Client WHERE id like ?% ORDER BY CAST(SUBSTRING(id,?) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    String findLastId(String s, int i);

    @Query(value = "SELECT * FROM client WHERE full_name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
    public List<Client> searchClient(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM client WHERE full_name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
    public Long countClient(String searchText);

}
