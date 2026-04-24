package com.ayaan.Ecom_project_1.service;

import com.ayaan.Ecom_project_1.model.Product;
import com.ayaan.Ecom_project_1.repository.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class productService {

    @Autowired
    private ProductData repo;

    @Autowired
    private ImageUploadService imageUploadService;

    // ✅ Get all products
    public List<Product> getProducts() {
        return repo.findAll();
    }

    // ✅ Get product by ID
    public Product getProductById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ Add product with Cloudinary image
    public Product addProduct(Product product, MultipartFile imageFile) {

        try {
            // Upload image → Cloudinary
            String imageUrl = imageUploadService.uploadImage(imageFile);

            // Save only URL
            product.setImageUrl(imageUrl);

            return repo.save(product);

        } catch (Exception e) {
            throw new RuntimeException("Error saving product");
        }
    }

    // ✅ Update product (image optional)
    public Product updateProduct(int id, Product product, MultipartFile imageFile) {

        Product existing = repo.findById(id).orElse(null);

        if (existing == null) return null;

        // Update basic fields
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());

        try {
            // If new image is provided → upload & replace
            if (imageFile != null && !imageFile.isEmpty()) {
                String imageUrl = imageUploadService.uploadImage(imageFile);
                existing.setImageUrl(imageUrl);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error updating image");
        }

        return repo.save(existing);
    }

    // ✅ Delete product
    public void deleteProduct(Integer id) {
        repo.deleteById(id);
    }
}