package com.ayaan.Ecom_project_1.controller;

    import com.ayaan.Ecom_project_1.service.ImageUploadService;
    import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
    @RestController
    @RequestMapping("/api/images")
public class ImageUploadController {

        private final ImageUploadService cloudinaryService;

        public ImageUploadController(ImageUploadService cloudinaryService) {
            this.cloudinaryService = cloudinaryService;
        }

        @PostMapping("/upload")
        public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
            String imageUrl = cloudinaryService.uploadImage(file);
            return ResponseEntity.ok(imageUrl);
        }
    }

