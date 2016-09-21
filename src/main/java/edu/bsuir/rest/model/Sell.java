package edu.bsuir.rest.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alesha on 19.09.2016.
 */
@Entity
public class Sell {
    private int id;
    private int idGoodSell;
    private int idClManager;
    private Date date;
    private float quantity;
    private float discount;
    private Good goodById;
    private ClManager clManagerById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idGoodSell", nullable = false)
    public int getIdGoodSell() {
        return idGoodSell;
    }

    public void setIdGoodSell(int idGoodSell) {
        this.idGoodSell = idGoodSell;
    }

    @Basic
    @Column(name = "idCl_manager", nullable = false)
    public int getIdClManager() {
        return idClManager;
    }

    public void setIdClManager(int idClManager) {
        this.idClManager = idClManager;
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

        Sell sell = (Sell) o;

        if (id != sell.id) return false;
        if (idGoodSell != sell.idGoodSell) return false;
        if (idClManager != sell.idClManager) return false;
        if (Float.compare(sell.quantity, quantity) != 0) return false;
        if (Float.compare(sell.discount, discount) != 0) return false;
        if (date != null ? !date.equals(sell.date) : sell.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idGoodSell;
        result = 31 * result + idClManager;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (quantity != +0.0f ? Float.floatToIntBits(quantity) : 0);
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idGoodSell", referencedColumnName = "id", updatable = false, insertable = false, nullable = false)
    public Good getGoodById() {
        return goodById;
    }

    public void setGoodById(Good goodById) {
        this.goodById = goodById;
    }

    @ManyToOne
    @JoinColumn(name = "idCl_manager", referencedColumnName = "id", updatable = false, insertable = false, nullable = false)
    public ClManager getClManagerById() {
        return clManagerById;
    }

    public void setClManagerById(ClManager clManagerById) {
        this.clManagerById = clManagerById;
    }
}
