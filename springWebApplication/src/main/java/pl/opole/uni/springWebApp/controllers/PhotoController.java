package pl.opole.uni.springWebApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.opole.uni.springWebApp.services.PhotoService;

import java.io.IOException;

@Controller
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/photos/add")
    public String addPhotoToDatabase(@RequestParam("file") MultipartFile file) throws IOException {
        photoService.savePhoto(file);
        return "redirect:/photos";
    }

    @GetMapping("/photos")
    public String getAllPhotos(Model model) {
        model.addAttribute("photos", photoService.getAllPhotos());
        return "photos";
    }
}