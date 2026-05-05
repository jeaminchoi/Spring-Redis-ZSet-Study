package sparta.study.api.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sparta.study.api.product.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.name = :name")
    Optional<Product> findByNameFetch(String name);

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.description = :description")
    Optional<Product> findByDescriptionFetch(String description);
}
