package io.github.dnsouzadev.imageliteapi.infra.repository;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;
import io.github.dnsouzadev.imageliteapi.domain.enums.ImageExtension;
import io.github.dnsouzadev.imageliteapi.infra.repository.specs.GenericSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.dnsouzadev.imageliteapi.infra.repository.specs.GenericSpecs.conjuction;
import static io.github.dnsouzadev.imageliteapi.infra.repository.specs.ImageSpecs.*;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query) {

        Specification<Image> spec = Specification.where(conjuction());

        if (extension != null) {
            spec = spec.and(extensionEqual(extension));
        }

        if (StringUtils.hasText(query)) {
            spec = spec.and(Specification.anyOf(nameLike(query), tagsLike(query)));
        }

        return findAll(spec);
    }
}
