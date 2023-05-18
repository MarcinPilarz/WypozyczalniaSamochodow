package pl.opole.uni.springWebApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.opole.uni.springWebApp.models.Photo;
import pl.opole.uni.springWebApp.repositories.PhotoRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;



@Service
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final String uploadDirectory;

    @Autowired
    public PhotoService(PhotoRepository photoRepository, @Value("${app.photo-upload-directory}") String uploadDirectory) {
        this.photoRepository = photoRepository;
        this.uploadDirectory = uploadDirectory;
    }
    
    public void savePhoto(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path filePath = Path.of(uploadDirectory).resolve(fileName);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            Photo photo = new Photo();
            photo.setNazwa(fileName);
            photo.setSciezka(filePath.toString());
            photo.setZdjecie(file.getBytes());

            photoRepository.save(photo);
        }
    }

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }
}