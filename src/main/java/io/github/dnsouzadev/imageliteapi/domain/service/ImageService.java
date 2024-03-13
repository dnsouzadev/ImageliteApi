package io.github.dnsouzadev.imageliteapi.domain.service;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;

import java.util.Optional;

public interface ImageService {
    Image save(Image image);

    Optional<Image> getById(String id);
}
