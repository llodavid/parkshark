package be.biggerboat.domain.divisions;

import be.biggerboat.utilities.exceptions.ParksharkException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DIVISIONS")
public class Division {

    @Id
    @SequenceGenerator(name = "division_seq", sequenceName = "division_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq")
    @Column(name = "DIVISION_ID")
    private int id;

    @Column(name = "DIVISION_NAME")
    private String divisionName;

    @Column(name = "ORIGINAL_NAME")
    private String originalName;

    @Column(name = "DIRECTOR")
    private String director;

    @OneToMany (fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="PARENT_DIVISION_ID")
    private List<Division> subDivisions;

    public Division() {
    }

    public Division(String divisionName, String originalName, String director) {
        if (isFilledIn(divisionName) && isFilledIn(originalName) && isFilledIn(director)) {
            this.divisionName = divisionName;
            this.originalName = originalName;
            this.director = director;
            subDivisions = new ArrayList<>();
        }
        else{
            throw new ParksharkException("Please fill in all the required fields.");
        }
    }

    public void addSubDivision(Division subDivision) {
        subDivisions.add(subDivision);
    }

    public String getDivisionName() {
        return divisionName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public int getId() {
        return id;
    }

    public List<Division> getSubDivisions() {
        return subDivisions;
    }

    public boolean isFilledIn(String data){
        return data != null && !data.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return getId() == division.getId() &&
                Objects.equals(getDivisionName(), division.getDivisionName()) &&
                Objects.equals(getOriginalName(), division.getOriginalName()) &&
                Objects.equals(getDirector(), division.getDirector());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDivisionName(), getOriginalName(), getDirector());
    }
}
