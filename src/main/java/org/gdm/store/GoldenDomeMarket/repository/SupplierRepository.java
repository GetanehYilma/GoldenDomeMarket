package org.gdm.store.GoldenDomeMarket.repository;


import org.gdm.store.GoldenDomeMarket.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
