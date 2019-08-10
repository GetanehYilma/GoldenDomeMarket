package org.gdm.store.GoldenDomeMarket.service;

import java.util.List;

import org.gdm.store.GoldenDomeMarket.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface SupplierService {
	
	List<Supplier> getAllSuppliers();
	Page<Supplier> getAllSuppliers(int pageNo);

}
