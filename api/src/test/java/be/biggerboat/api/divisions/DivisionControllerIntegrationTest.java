//package be.biggerboat.api.divisions;
//
//import be.biggerboat.domain.divisions.DivisionRepository;
//import be.biggerboat.service.DivisionService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.boot.SpringApplication.run;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DivisionControllerIntegrationTest.DivisionControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class DivisionControllerIntegrationTest {
//
//    private int port=38123;
//    private DivisionController divisionController;
//
//    @Autowired
//    public DivisionControllerIntegrationTest(DivisionController divisionController) {
//        this.divisionController = divisionController;
//    }
//
//    @Test
//    public void createDivision_postForObjectHappyPath(){
//        DivisionDTO divisionDTO = new TestRestTemplate()
//                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
//                        new DivisionDTO().withDivisionName("Division")
//                            .withOriginalName("Original Division")
//                            .withDirector("Division Director"),
//                        DivisionDTO.class);
//
//        assertThat(divisionDTO.divisionName).isEqualTo("Division");
//        assertThat(divisionDTO.originalName).isEqualTo("Original Division");
//        assertThat(divisionDTO.director).isEqualTo("Division Director");
//    }
//
//    @SpringBootApplication(scanBasePackageClasses = {DivisionRepository.class, DivisionService.class, DivisionMapper.class})
//    public static class DivisionControllerIntegrationTestRunner{
//        public static void main(String[] args) {
//            run(DivisionControllerIntegrationTestRunner.class, args);
//        }
//    }
//}