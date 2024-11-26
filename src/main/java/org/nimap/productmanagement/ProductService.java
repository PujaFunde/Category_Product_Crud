package org.nimap.productmanagement;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	public Product getProduct(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	public Page<Product> getAllProduct(Pageable pageable) {
		return productRepo.findAll( pageable);
	}

	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	public Product updateCategory(Long id, Product productDetails) {
		Product product = productRepo.findById(id).orElse(null);
		if(product != null) {
			product.setName(productDetails.getName());
			product.setCategory(productDetails.getCategory());
		}
		return null;
		
	}

	public void removeProduct(Long id) {
		productRepo.deleteById(id);		
	}

}
