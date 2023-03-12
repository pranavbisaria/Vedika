package com.Vedika.Service.Impl;
import com.Vedika.Service.FileServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServicesImpl implements FileServices {
    @Value("${project.image}")
    private String path;
    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String  filename = file.getOriginalFilename();
        String randomID = UUID.randomUUID().toString();
        assert filename != null;
        String newFileName =  randomID.concat(filename.substring(filename.lastIndexOf(".")));
        String filepath = path + File.separator + newFileName;
        File newFile = new File(path);
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        Files.copy(file.getInputStream(), Paths.get(filepath));
        return newFileName;
    }

//    @Override
//    public InputStream getImage(String path, String fileName) throws FileNotFoundException {
//        String fullPath = path +File.separator + fileName;
//        InputStream is = new FileInputStream(fullPath);
//        return is;
//    }
}
