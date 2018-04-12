package be.biggerboat.api.divisions;

import be.biggerboat.domain.divisions.Division;
import be.biggerboat.domain.divisions.DivisionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.SpringApplication.run;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = DivisionControllerIntegrationTest.DivisionControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = DivisionControllerIntegrationTest.DivisionControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DivisionControllerIntegrationTest {

    @LocalServerPort
    private int port;
    private DivisionRepository divisionRepository;
    private DivisionMapper divisionMapper;
    private DivisionController divisionController;

    @Autowired
    public DivisionControllerIntegrationTest(DivisionController divisionController, DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionController = divisionController;
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
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

    @Test
    public void getDivisions_happyPath(){
        Division division1 = new Division("F1", "ONF1", "dirf1");
        Division division2 = new Division("F2", "ONF2", "dirf2");
        Division division3 = new Division("F3", "ONF3", "dirf3");

        divisionRepository.save(division1);
        divisionRepository.save(division2);
        divisionRepository.save(division3);

        DivisionDTO[] divisionDTOs = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        DivisionDTO[].class);
        List<DivisionDTO> divisions = Arrays.asList(divisionDTOs);

        DivisionDTO divisionDTO1 = divisionMapper.divisionToDTO(division1);
        DivisionDTO divisionDTO2 = divisionMapper.divisionToDTO(division2);
        DivisionDTO divisionDTO3 = divisionMapper.divisionToDTO(division3);

        assertThat(divisions).contains(divisionDTO1, divisionDTO2, divisionDTO3);
    }

    @SpringBootApplication(scanBasePackages = "be.biggerboat")
    public static class DivisionControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(DivisionControllerIntegrationTestRunner.class, args);
        }
    }
}