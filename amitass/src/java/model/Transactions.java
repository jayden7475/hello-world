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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByTransactionId", query = "SELECT t FROM Transactions t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "Transactions.findByPaymentType", query = "SELECT t FROM Transactions t WHERE t.paymentType = :paymentType"),
    @NamedQuery(name = "Transactions.findByAccountNo", query = "SELECT t FROM Transactions t WHERE t.accountNo = :accountNo"),
    @NamedQuery(name = "Transactions.findByTotalAmount", query = "SELECT t FROM Transactions t WHERE t.totalAmount = :totalAmount"),
    @NamedQuery(name = "Transactions.findByChange", query = "SELECT t FROM Transactions t WHERE t.change = :change"),
    @NamedQuery(name = "Transactions.findByTotalPayment", query = "SELECT t FROM Transactions t WHERE t.totalPayment = :totalPayment"),
    @NamedQuery(name = "Transactions.findByQuantity", query = "SELECT t FROM Transactions t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "Transactions.findByOrderStatus", query = "SELECT t FROM Transactions t WHERE t.orderStatus = :orderStatus"),
    @NamedQuery(name = "Transactions.findByPaymentStatus", query = "SELECT t FROM Transactions t WHERE t.paymentStatus = :paymentStatus")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Size(max = 20)
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
    @Size(max = 20)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;
    @Column(name = "CHANGE")
    private Double change;
    @Column(name = "TOTAL_PAYMENT")
    private Double totalPayment;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "ORDER_STATUS")
    private Integer orderStatus;
    @Column(name = "PAYMENT_STATUS")
    private Integer paymentStatus;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne
    private Customer custId;
    @OneToMany(mappedBy = "transactionId")
    private List<TransactionDetails> transactionDetailsList;

    public Transactions() {
    }

    public Transactions(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
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
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Transactions[ transactionId=" + transactionId + " ]";
    }
    
}
