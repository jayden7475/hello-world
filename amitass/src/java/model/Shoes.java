/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "SHOES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoes.findAll", query = "SELECT s FROM Shoes s"),
    @NamedQuery(name = "Shoes.findByShoesId", query = "SELECT s FROM Shoes s WHERE s.shoesId = :shoesId"),
    @NamedQuery(name = "Shoes.findByShoesName", query = "SELECT s FROM Shoes s WHERE s.shoesName = :shoesName"),
    @NamedQuery(name = "Shoes.findByShoesType", query = "SELECT s FROM Shoes s WHERE s.shoesType = :shoesType"),
    @NamedQuery(name = "Shoes.findByShoesPrice", query = "SELECT s FROM Shoes s WHERE s.shoesPrice = :shoesPrice"),
    @NamedQuery(name = "Shoes.findByShoesSize", query = "SELECT s FROM Shoes s WHERE s.shoesSize = :shoesSize"),
    @NamedQuery(name = "Shoes.findByShoesStock", query = "SELECT s FROM Shoes s WHERE s.shoesStock = :shoesStock"),
    @NamedQuery(name = "Shoes.findByShoesPng", query = "SELECT s FROM Shoes s WHERE s.shoesPng = :shoesPng")})
public class Shoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SHOES_ID")
    private String shoesId;
    @Size(max = 50)
    @Column(name = "SHOES_NAME")
    private String shoesName;
    @Size(max = 50)
    @Column(name = "SHOES_TYPE")
    private String shoesType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SHOES_PRICE")
    private Double shoesPrice;
    @Size(max = 7)
    @Column(name = "SHOES_SIZE")
    private String shoesSize;
    @Column(name = "SHOES_STOCK")
    private Integer shoesStock;
    @Size(max = 50)
    @Column(name = "SHOES_PNG")
    private String shoesPng;
    @OneToMany(mappedBy = "shoesId")
    private List<Review> reviewList;
    @OneToMany(mappedBy = "shoesId")
    private List<TransactionDetails> transactionDetailsList;

    public Shoes() {
    }

    public Shoes(String shoesId) {
        this.shoesId = shoesId;
    }
    
    public Shoes(String shoesId, String shoesName, String shoesType, Double shoesPrice, String shoesSize, Integer shoesStock) {
        this.shoesId = shoesId;
        this.shoesName = shoesName;
        this.shoesType = shoesType;
        this.shoesPrice = shoesPrice;
        this.shoesSize = shoesSize;
        this.shoesStock = shoesStock;
    }


    public String getShoesId() {
        return shoesId;
    }

    public void setShoesId(String shoesId) {
        this.shoesId = shoesId;
    }

    public String getShoesName() {
        return shoesName;
    }

    public void setShoesName(String shoesName) {
        this.shoesName = shoesName;
    }

    public String getShoesType() {
        return shoesType;
    }

    public void setShoesType(String shoesType) {
        this.shoesType = shoesType;
    }

    public Double getShoesPrice() {
        return shoesPrice;
    }

    public void setShoesPrice(Double shoesPrice) {
        this.shoesPrice = shoesPrice;
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize;
    }

    public Integer getShoesStock() {
        return shoesStock;
    }

    public void setShoesStock(Integer shoesStock) {
        this.shoesStock = shoesStock;
    }

    public String getShoesPng() {
        return shoesPng;
    }

    public void setShoesPng(String shoesPng) {
        this.shoesPng = shoesPng;
    }

    @XmlTransient
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @XmlTransient
    public List<TransactionDetails> getTransactionDetailsList() {
        return transactionDetailsList;
    }

    public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
        this.transactionDetailsList = transactionDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoesId != null ? shoesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoes)) {
            return false;
        }
        Shoes other = (Shoes) object;
        if ((this.shoesId == null && other.shoesId != null) || (this.shoesId != null && !this.shoesId.equals(other.shoesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoes[ shoesId=" + shoesId + " ]";
    }
    
}
