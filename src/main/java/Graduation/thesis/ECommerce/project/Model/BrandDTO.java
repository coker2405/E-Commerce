package Graduation.thesis.ECommerce.project.Model;

public class BrandDTO {

    private Long id;
    private String name;

    public BrandDTO() {
        super();
    }

    public BrandDTO(String name) {
        super();
        this.name = name;
    }

    public BrandDTO(Long id, String name) {
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
