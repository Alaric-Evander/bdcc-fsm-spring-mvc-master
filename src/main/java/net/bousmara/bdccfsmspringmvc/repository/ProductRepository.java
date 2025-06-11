package net.bousmara.bdccfsmspringmvc.repository;

import net.bousmara.bdccfsmspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
