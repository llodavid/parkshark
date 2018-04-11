package be.biggerboat.domain.divisions;

import javax.persistence.*;

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

    public Division() {
    }

    public Division(String divisionName, String originalName, String director) {
        this.divisionName = divisionName;
        this.originalName = originalName;
        this.director = director;
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
}
