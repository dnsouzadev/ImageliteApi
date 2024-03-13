package io.github.dnsouzadev.imageliteapi.infra.repository;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
