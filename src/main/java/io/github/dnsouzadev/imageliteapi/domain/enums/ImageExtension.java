package io.github.dnsouzadev.imageliteapi.domain.enums;

import lombok.Getter;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Arrays;

public enum ImageExtension {
    PNG(MediaType.IMAGE_PNG),
    GIF(MediaType.IMAGE_GIF),
    JPEG(MediaType.IMAGE_JPEG);

    @Getter
    private final MediaType mediaType;

    ImageExtension(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public static ImageExtension valueOf(MediaType mediaType) {
        return Arrays.stream(values())
                .filter(imageExtension -> imageExtension.mediaType.equals(mediaType))
                .findFirst()
                .orElse(null);
    }

    public static ImageExtension ofName(String value) {
        return Arrays.stream(values())
                .filter(imageExtension -> imageExtension.name().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
