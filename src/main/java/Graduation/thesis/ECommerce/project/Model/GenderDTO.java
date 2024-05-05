package Graduation.thesis.ECommerce.project.Model;

public class GenderDTO {

    private Long id;
    private String name;

    public GenderDTO() {
        super();
    }

    public GenderDTO(String name) {
        super();
        this.name = name;
    }

    public GenderDTO(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

