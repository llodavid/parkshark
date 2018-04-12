package be.biggerboat.api.divisions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = DivisionControllerIntegrationTest.DivisionControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = DivisionControllerIntegrationTest.DivisionControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DivisionControllerIntegrationTest {

    @LocalServerPort
    private int port;
    private DivisionController divisionController;

    @Autowired
    public DivisionControllerIntegrationTest(DivisionController divisionController) {
        this.divisionController = divisionController;
    }

    @Test
    public void createDivision_postForObjectHappyPath(){
        DivisionDTO divisionDTO = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        new DivisionDTO().withDivisionName("Division")
                            .withOriginalName("Original Division")
                            .withDirector("Division Director"),
                        DivisionDTO.class);

        assertThat(divisionDTO.id).isNotEqualTo(0);
        assertThat(divisionDTO.divisionName).isEqualTo("Division");
        assertThat(divisionDTO.originalName).isEqualTo("Original Division");
        assertThat(divisionDTO.director).isEqualTo("Division Director");
    }

    @SpringBootApplication(scanBasePackages = "be.biggerboat")
    public static class DivisionControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(DivisionControllerIntegrationTestRunner.class, args);
        }
    }
}