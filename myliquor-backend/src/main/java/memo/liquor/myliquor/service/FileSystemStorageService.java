package memo.liquor.myliquor.service;

import memo.liquor.myliquor.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService {
  private final Path rootLocation;

  @Autowired
  public FileSystemStorageService(StorageProperties properties) {
    this.rootLocation = Paths.get(properties.getLocation());
  }

  public void store(MultipartFile file) {
    try {
      if (file.isEmpty()) {
        throw new RuntimeException("failed to store empty file!!!");
      }

      Path destinationFile = this.rootLocation.resolve(
              Paths.get(file.getOriginalFilename()))
          .normalize().toAbsolutePath();

      if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
        throw new RuntimeException(
            "Cannot store file outside current directory.");
      }
      try (InputStream inputStream = file.getInputStream()) {
        Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
      }

    } catch (IOException e) {
      throw new RuntimeException("failed to store file");
    }
  }
}
