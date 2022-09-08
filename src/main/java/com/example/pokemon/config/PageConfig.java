package com.example.pokemon.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("spring.data.web.pageable")
@ConstructorBinding
@RequiredArgsConstructor
@Getter
public class PageConfig {

    private final int defaultPageSize;
    private final int maxPageSize;

}
