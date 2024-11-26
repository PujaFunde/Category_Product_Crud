package org.nimap.productmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Page<Category> getCategories(Pageable pageable) {
		return categoryRepo.findAll(pageable);
		
	
	}
	
	public Optional<Category> getCategory(Long id) {
		return categoryRepo.findById(id);
	}
	
	public void removeCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	public Category createCategory(Category category) {
		 return categoryRepo.save(category);
	}
	
	public Category updateCategory(Long id, Category category) {
		Optional<Category>  savesCategory = categoryRepo.findById(id);
		
		if(!savesCategory.isPresent()) {
			throw new RuntimeException("Category not present");
		}
	
		Category categoryToUpdate = savesCategory.get();
		
		categoryToUpdate.setName(category.getName());
		
		 return categoryRepo.save(categoryToUpdate);
	}
	
	

}
