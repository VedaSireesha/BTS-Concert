package com.btsbooking.btsconcert.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vip_package")
public class VipPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vip_package_seq")
    @SequenceGenerator(name = "vip_package_seq", sequenceName = "VIP_PACKAGE_SEQ", allocationSize = 1)
    @Column(name = "vip_package_id")
    private Long vipPackageId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;

    // Getters and Setters
    public Long getVipPackageId() {
        return vipPackageId;
    }

    public void setVipPackageId(Long vipPackageId) {
        this.vipPackageId = vipPackageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
