package com.khewang.ghbiliapi.Service;


import com.khewang.ghbiliapi.DTO.TextToImageRequest;
import com.khewang.ghbiliapi.client.StabilityAiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GhibiliArtService {

    private final StabilityAiClient stabilityAiClient;
    private final String apiKey;

    public GhibiliArtService(StabilityAiClient stabilityAiClient, @Value("${stability.api.key}") String apiKey) {
        this.stabilityAiClient = stabilityAiClient;
        this.apiKey = apiKey;
    }

    public byte[] createGhibiliArt(MultipartFile image, String prompt) throws IOException {
        String finalPrompt = prompt+", turn into ghibili style.";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = "anime";

       return stabilityAiClient.generateImageFromImage(
                "Bearer " + apiKey,
                engineId,
                image,
                finalPrompt,
                stylePreset
        );
    }
    public byte[] createGhibiliArtFromText(String prompt, String style) throws IOException {
        String finalPrompt = prompt+", in the beautiful, detailed anime style of studio ghibli.";
        String engineId = "stable-diffusion-v1-6";
        String stylePreset = style.equals("general")?"anime" : style.replace("_","-");

        TextToImageRequest requestPayLoad = new TextToImageRequest(finalPrompt, stylePreset);
        return stabilityAiClient.generateImageFromText(
                "Bearer " + apiKey,
                engineId,
                requestPayLoad
        );
    }
}

