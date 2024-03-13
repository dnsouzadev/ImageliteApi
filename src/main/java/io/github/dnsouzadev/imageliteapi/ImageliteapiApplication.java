package io.github.dnsouzadev.imageliteapi;

import io.github.dnsouzadev.imageliteapi.domain.entity.Image;
import io.github.dnsouzadev.imageliteapi.infra.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static io.github.dnsouzadev.imageliteapi.domain.enums.ImageExtension.PNG;

@SpringBootApplication
@EnableJpaAuditing
public class ImageliteapiApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ImageRepository imageRepository) {
		return args -> {
			System.out.println("Imagelite API");
			Image image = Image.builder()
					.name("Imagem 1")
					.size(1000L)
					.extension(PNG)
					.tags("imagem, teste")
					.file(new byte[1000])
					.build();
			imageRepository.save(image);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ImageliteapiApplication.class, args);
	}

}
