package com.Vedika.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileServices {

    String uploadImage(MultipartFile file) throws IOException;
//    InputStream getImage(String path, String fileName) throws FileNotFoundException;
}
