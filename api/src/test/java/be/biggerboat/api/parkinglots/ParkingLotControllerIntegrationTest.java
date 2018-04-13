package be.biggerboat.api.parkinglots;

import be.biggerboat.api.addresses.AddressMapper;
import be.biggerboat.domain.addresses.Address;
import be.biggerboat.domain.addresses.Zipcode;
import be.biggerboat.domain.divisions.Division;
import be.biggerboat.domain.divisions.DivisionRepository;
import be.biggerboat.domain.parkinglots.ParkingLotRepository;
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
@SpringBootTest(classes = ParkingLotControllerIntegrationTest.ParkingLotControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ParkingLotControllerIntegrationTest {

    @LocalServerPort
    private int port;
    private ParkingLotRepository parkingLotRepository;
    private ParkingLotMapper parkingLotMapper;
    private ParkingLotController parkingLotController;
    private DivisionRepository divisionRepository;
    private AddressMapper addressMapper;

    @Autowired
    public ParkingLotControllerIntegrationTest(ParkingLotController parkingLotController, ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper, DivisionRepository divisionRepository, AddressMapper addressMapper) {
        this.parkingLotController = parkingLotController;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
        this.divisionRepository = divisionRepository;
        this.addressMapper = addressMapper;
    }

    @Test
    void createParkingLotDto() {
//        Division division = new Division("khj", "lhhjjh", "kkjjkhj");
//        divisionRepository.save(division);
//        Zipcode zipcode = new Zipcode("dfdfdf", "dddfdf");
//        Address address = new Address.AddressBuilder().withStreet("eerer").withZipcode(zipcode).withHousenumber("5454").build();
//
//
//        ParkingLotDto parkingLotDto = new TestRestTemplate()
//                .postForObject(String.format("http://localhost:%s/%s", port, "parkinglots"),
//                        new ParkingLotDto().withName("ParkingLot")
//                               .withCapacity(0)
//                        .withDivision(division)
//                        .withPricePerHour(52.3)
//                        .withAddress(addressMapper.toDto(address)),
//                        ParkingLotDto.class);
//
//        assertThat(parkingLotDto.id).isNotEqualTo(0);
//        assertThat(parkingLotDto.name).isEqualTo("ParkingLot");
//        assertThat(parkingLotDto.capacity).isEqualTo(0);
//        assertThat(parkingLotDto.division).isEqualTo(division);
//        assertThat(parkingLotDto.pricePerHour).isEqualTo(52.3);
//        assertThat(addressMapper.toDomain(parkingLotDto.address)).isEqualTo(address);
    }

    @SpringBootApplication(scanBasePackages = "be.biggerboat")
    public static class ParkingLotControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(ParkingLotControllerIntegrationTest.ParkingLotControllerIntegrationTestRunner.class, args);
        }
    }
}