package be.biggerboat.api.divisions;

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
}
