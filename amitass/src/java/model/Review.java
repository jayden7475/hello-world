/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "REVIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByReviewId", query = "SELECT r FROM Review r WHERE r.reviewId = :reviewId"),
    @NamedQuery(name = "Review.findByRate", query = "SELECT r FROM Review r WHERE r.rate = :rate"),
    @NamedQuery(name = "Review.findByDateReview", query = "SELECT r FROM Review r WHERE r.dateReview = :dateReview"),
    @NamedQuery(name = "Review.findByReplyComm", query = "SELECT r FROM Review r WHERE r.replyComm = :replyComm"),
    @NamedQuery(name = "Review.findByCustomerComm", query = "SELECT r FROM Review r WHERE r.customerComm = :customerComm")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "REVIEW_ID")
    private String reviewId;
    @Column(name = "RATE")
    private Integer rate;
    @Column(name = "DATE_REVIEW")
    @Temporal(TemporalType.DATE)
    private Date dateReview;
    @Size(max = 100)
    @Column(name = "REPLY_COMM")
    private String replyComm;
    @Size(max = 100)
    @Column(name = "CUSTOMER_COMM")
    private String customerComm;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne
    private Customer custId;
    @JoinColumn(name = "SHOES_ID", referencedColumnName = "SHOES_ID")
    @ManyToOne
    private Shoes shoesId;
    @JoinColumn(name = "STAFF_ID", referencedColumnName = "STAFF_ID")
    @ManyToOne
    private Staff staffId;

    public Review() {
    }

    public Review(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getDateReview() {
        return dateReview;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }

    public String getReplyComm() {
        return replyComm;
    }

    public void setReplyComm(String replyComm) {
        this.replyComm = replyComm;
    }

    public String getCustomerComm() {
        return customerComm;
    }

    public void setCustomerComm(String customerComm) {
        this.customerComm = customerComm;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    public Shoes getShoesId() {
        return shoesId;
    }

    public void setShoesId(Shoes shoesId) {
        this.shoesId = shoesId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Review[ reviewId=" + reviewId + " ]";
    }
    
}
