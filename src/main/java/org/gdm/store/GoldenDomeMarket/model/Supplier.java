package org.gdm.store.GoldenDomeMarket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	private int supplierNumber;
	private String name;
	private String contactPhoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
	private List<Product> products;
	
	public Supplier() {
		
	}

	public Supplier(int supplierId, int supplierNumber, String name, String contactPhoneNumber,
			List<Product> products) {
	
		this.supplierId = supplierId;
		this.supplierNumber = supplierNumber;
		this.name = name;
		this.contactPhoneNumber = contactPhoneNumber;
		this.products = products;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(int supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierNumber=" + supplierNumber + ", name=" + name
				+ ", contactPhoneNumber=" + contactPhoneNumber + ", products=" + products + "]";
	}	
	
}
