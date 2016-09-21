package edu.bsuir.rest.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alesha on 19.09.2016.
 */
@Entity
public class Buy {
    private int id;
    private int idGoodBuy;
    private int idSupManager;
    private Date date;
    private float quantity;
    private float discount;
    private Good goodById;
    private SupManager supManagerById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idGoodBuy", nullable = false)
    public int getIdGoodBuy() {
        return idGoodBuy;
    }

    public void setIdGoodBuy(int idGoodBuy) {
        this.idGoodBuy = idGoodBuy;
    }

    @Basic
    @Column(name = "idSup_manager", nullable = false)
    public int getIdSupManager() {
        return idSupManager;
    }

    public void setIdSupManager(int idSupManager) {
        this.idSupManager = idSupManager;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "quantity", nullable = false, precision = 0)
    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "discount", nullable = false, precision = 0)
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buy buy = (Buy) o;

        if (id != buy.id) return false;
        if (idGoodBuy != buy.idGoodBuy) return false;
        if (idSupManager != buy.idSupManager) return false;
        if (Float.compare(buy.quantity, quantity) != 0) return false;
        if (Float.compare(buy.discount, discount) != 0) return false;
        if (date != null ? !date.equals(buy.date) : buy.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idGoodBuy;
        result = 31 * result + idSupManager;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (quantity != +0.0f ? Float.floatToIntBits(quantity) : 0);
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idGoodBuy", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Good getGoodById() {
        return goodById;
    }

    public void setGoodById(Good goodById) {
        this.goodById = goodById;
    }

    @ManyToOne
    @JoinColumn(name = "idSup_manager", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public SupManager getSupManagerById() {
        return supManagerById;
    }

    public void setSupManagerById(SupManager supManagerById) {
        this.supManagerById = supManagerById;
    }
}
