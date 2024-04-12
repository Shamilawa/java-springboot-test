package com.example.springbootrestapitest.services;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FirebaseStorageService {
    private final Storage storage;

    public FirebaseStorageService() {
        this.storage = StorageOptions.getDefaultInstance().getService();
    }

    public String uploadFile(String fileName, MultipartFile file) throws IOException {
        Bucket bucket = storage.get("trade-log-f9cb7.appspot.com");
        Blob blob = bucket.create(fileName, file.getInputStream(), file.getContentType());
        return blob.getMediaLink();
    }
}
