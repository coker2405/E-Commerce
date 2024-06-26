package Graduation.thesis.ECommerce.project.Enity;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "buy_date")
    private Date buyDate;

    @Column(name = "price_total")
    private Long priceTotal;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private List<BillProduct> billProducts;

    @Column(name = "pay")
    private String pay;

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Long getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Long priceTotal) {
        this.priceTotal = priceTotal;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public List<BillProduct> getBillProducts() {
        return billProducts;
    }

    public void setBillProducts(List<BillProduct> billProducts) {
        this.billProducts = billProducts;
    }

}
