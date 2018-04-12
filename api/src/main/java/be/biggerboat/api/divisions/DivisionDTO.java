package be.biggerboat.api.divisions;

import java.util.Objects;

public class DivisionDTO {

    public int id;
    public String divisionName;
    public String originalName;
    public String director;
    
    public DivisionDTO withId(int id) {
        this.id = id;
        return this;
    }

    public DivisionDTO withDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public DivisionDTO withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public DivisionDTO withDirector(String director) {
        this.director = director;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionDTO that = (DivisionDTO) o;
        return id == that.id &&
                Objects.equals(divisionName, that.divisionName) &&
                Objects.equals(originalName, that.originalName) &&
                Objects.equals(director, that.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, divisionName, originalName, director);
    }
}
