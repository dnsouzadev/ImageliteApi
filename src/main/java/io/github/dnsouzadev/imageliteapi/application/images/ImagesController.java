package io.github.dnsouzadev.imageliteapi.application.images;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;
import io.github.dnsouzadev.imageliteapi.domain.enums.ImageExtension;
import io.github.dnsouzadev.imageliteapi.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesController {

    private final ImageService service;

    @PostMapping()
    public ResponseEntity save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags")List<String> tags
            ) throws IOException {
        log.info("Imagem recebida: name: {}, size: {}, tags: {}", name, file.getSize(), tags);

        Image image = Image.builder()
                .name(name)
                .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                .tags(String.join(",", tags))
                .file(file.getBytes())
                .build();

        service.save(image);
        return ResponseEntity.ok().build();
    }
}
