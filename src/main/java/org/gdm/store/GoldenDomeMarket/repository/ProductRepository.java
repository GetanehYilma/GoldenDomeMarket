package org.gdm.store.GoldenDomeMarket.repository;

import org.gdm.store.GoldenDomeMarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
