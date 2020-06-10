package ma.sopra.pocexchange.pocxchangeoffice;

import ma.sopra.pocexchange.pocxchangeoffice.business.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@SpringBootApplication
@EnableSwagger2
public class PocxchangeofficeApplication implements CommandLineRunner {
    @Resource
    FileStorageService storageService;
    public static void main(String[] args) {
        SpringApplication.run(PocxchangeofficeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }
}
