package Graduation.thesis.ECommerce.project.Model;

public class ProductDTO {
    private Long id;
    private String name;
    private Long price;
    private String imageURL;
    private String description;
    private CategoryDTO category;
    private BrandDTO brandDTO;
    private SizesDTO sizesDTO;
    private GenderDTO genderDTO;
    private Long quantity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BrandDTO getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }

    public SizesDTO getSizesDTO() {
        return sizesDTO;
    }

    public void setSizesDTO(SizesDTO sizesDTO) {
        this.sizesDTO = sizesDTO;
    }

    public GenderDTO getGenderDTO() {
        return genderDTO;
    }

    public void setGenderDTO(GenderDTO genderDTO) {
        this.genderDTO = genderDTO;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
