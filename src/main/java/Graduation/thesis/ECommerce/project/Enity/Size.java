package Graduation.thesis.ECommerce.project.Enity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "size")
public class Size implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Size(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Size() {
        super();
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
