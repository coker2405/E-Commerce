package Graduation.thesis.ECommerce.project.Model;

public class SizesDTO {
    private Long id;
    private String name;

    public SizesDTO() {
        super();
    }

    public SizesDTO(String name) {
        super();
        this.name = name;
    }

    public SizesDTO(Long id, String name) {
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
