package org.nimap.productmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {

		return productService.getProduct(id);

	}

	@GetMapping("/")
	public Page<Product> getAllProduct(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
		PageRequest pageable = PageRequest.of(page, size);
		return productService.getAllProduct(pageable);

	}

	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {

		return productService.createProduct(product);

	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

		return productService.updateCategory(id, product);

	}

	@DeleteMapping("/{id}")
	public String removeCategory(@PathVariable Long id) {
		productService.removeProduct(id);
		return "Product  removed successfully";

	}

}
