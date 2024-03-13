package io.github.dnsouzadev.imageliteapi.application.images;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;
import io.github.dnsouzadev.imageliteapi.domain.service.ImageService;
import io.github.dnsouzadev.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceIMPL implements ImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }
}
