package be.biggerboat.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"be.biggerboat"})
public class ParkShark {
    public static void main(String[] args) {
        SpringApplication.run(ParkShark.class, args);
    }

}
