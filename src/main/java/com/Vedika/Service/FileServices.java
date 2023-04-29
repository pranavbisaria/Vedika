package com.Vedika.Service;
import com.Vedika.Model.Images;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileServices {

    String uploadImage(MultipartFile file) throws IOException;
    @Async
    void deleteFiles(List<Images> imageUrls);
//    InputStream getImage(String path, String fileName) throws FileNotFoundException;
}
