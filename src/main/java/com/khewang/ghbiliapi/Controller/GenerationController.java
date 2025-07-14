package com.khewang.ghbiliapi.Controller;

import com.khewang.ghbiliapi.DTO.TextGenerationRequestDTO;
import com.khewang.ghbiliapi.Service.GhibiliArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins ={"http://localhost:5173","http://127.0.0.1:5173"})
@RequiredArgsConstructor
public class GenerationController {
    private final GhibiliArtService ghibiliArtService;

    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateGhibiliArt(@RequestParam("image") MultipartFile image,
                                                     @RequestParam("prompt") String prompt) {
        try{
            byte[] imageBytes = ghibiliArtService.createGhibiliArt(image , prompt);
           return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping(value = "/generate-from-text", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateGhibiliArtFromText(@RequestBody TextGenerationRequestDTO requestDTO) {
        try{
         byte[] imageBytes =   ghibiliArtService.createGhibiliArtFromText(requestDTO.getPrompt(), requestDTO.getStyle());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
