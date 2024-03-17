package io.github.dnsouzadev.imageliteapi.application.images;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;
import io.github.dnsouzadev.imageliteapi.domain.enums.ImageExtension;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ImageMapper {
    public Image mapToImage(MultipartFile file, String name, List<String> tags) throws IOException {
        return Image.builder()
                .name(name)
                .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                .tags(String.join(",", tags))
                .file(file.getBytes())
                .build();
    }

    public ImageDTO imageToDTO(Image image, String url) {
        return ImageDTO.builder()
                .url(url)
                .name(image.getName())
                .extension(image.getExtension().name())
                .size(image.getSize())
                .uploadDate(image.getUploadDate().toLocalDate())
                .build();
    }
}
