/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "TRANSACTION_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t"),
    @NamedQuery(name = "TransactionDetails.findByDetailsId", query = "SELECT t FROM TransactionDetails t WHERE t.detailsId = :detailsId"),
    @NamedQuery(name = "TransactionDetails.findByQuantity", query = "SELECT t FROM TransactionDetails t WHERE t.quantity = :quantity")})
public class TransactionDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "DETAILS_ID")
    private String detailsId;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "SHOES_ID", referencedColumnName = "SHOES_ID")
    @ManyToOne
    private Shoes shoesId;
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "TRANSACTION_ID")
    @ManyToOne
    private Transactions transactionId;

    public TransactionDetails() {
    }

    public TransactionDetails(String detailsId) {
        this.detailsId = detailsId;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Shoes getShoesId() {
        return shoesId;
    }

    public void setShoesId(Shoes shoesId) {
        this.shoesId = shoesId;
    }

    public Transactions getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transactions transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsId != null ? detailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetails)) {
            return false;
        }
        TransactionDetails other = (TransactionDetails) object;
        if ((this.detailsId == null && other.detailsId != null) || (this.detailsId != null && !this.detailsId.equals(other.detailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TransactionDetails[ detailsId=" + detailsId + " ]";
    }
    
}
