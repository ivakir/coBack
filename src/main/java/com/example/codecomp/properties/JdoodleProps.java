package com.example.codecomp.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component("jdoodleProps")
@ConfigurationProperties("jdoodle.client")
public class JdoodleProps {
    private String id;
    private String secret;
    private String compilerUrl;
}
