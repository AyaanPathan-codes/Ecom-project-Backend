package com.ayaan.Ecom_project_1.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
@Service
public class ImageUploadService {

        private final Cloudinary cloudinary;

        public ImageUploadService(Cloudinary cloudinary) {
            this.cloudinary = cloudinary;
        }

        public String uploadImage(MultipartFile file) {
            try {
                Map<String, Object> uploadResult = cloudinary.uploader().upload(
                        file.getBytes(),
                        ObjectUtils.emptyMap()
                );


                return uploadResult.get("secure_url").toString();

            } catch (Exception e) {
                throw new RuntimeException("Image upload failed");
            }
        }
    }

