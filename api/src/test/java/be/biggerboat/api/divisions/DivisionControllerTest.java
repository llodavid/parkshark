//package be.biggerboat.api.divisions;
//
//import be.biggerboat.domain.databaseconfig.DatabaseConfig;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import javax.transaction.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringJUnitConfig(DatabaseConfig.class)
//public class DivisionControllerTest {
//    @Autowired
//    DivisionController divisionController;
//
//    @Test
//    @Transactional
//    public void createDivision_happyPath(){
//        DivisionDTO divisionDTO = new DivisionDTO().withDivisionName("Division")
//                .withOriginalName("Original Division")
//                .withDirector("Division Director");
//
//        divisionDTO = divisionController.createDivision(divisionDTO);
//
//        assertThat(divisionDTO.divisionName).isEqualTo("Division");
//        assertThat(divisionDTO.originalName).isEqualTo("Original Division");
//        assertThat(divisionDTO.director).isEqualTo("Division Director");
//        assertThat(divisionDTO.id).isNotEqualTo(0);
//    }
//}
