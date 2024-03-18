package io.github.dnsouzadev.imageliteapi.infra.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecs {
    private GenericSpecs() {}

    public static <T> Specification<T> conjuction() {
        return (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
    }
}
