package org.nimap.productmanagement;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService ;
	
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) {
		
		Optional<Category> category = categoryService.getCategory(id);
		if(!category.isPresent()) {
			throw new RuntimeErrorException(null, "there is no data for provided category id ");
		}
		
		return category.get();
	}
	
	@GetMapping("/")
	public Page<Category> getAllCategory(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		return  categoryService.getCategories(pageable);
	
	}
	
	@PostMapping("/")
	public Category addCategory(@RequestBody Category category ) {
		
		return  categoryService.createCategory(category);
	
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category ) {
		
		return  categoryService.updateCategory(id,category);
	
	}
	
	
	@DeleteMapping("/{id}")
	public String removeCategory(@PathVariable Long id) {
		categoryService.removeCategory(id);
		return "Category removed successfully";
		
	}
	
	

}
