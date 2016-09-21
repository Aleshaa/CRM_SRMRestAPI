package edu.bsuir.rest.model;

import javax.persistence.*;

/**
 * Created by Alesha on 19.09.2016.
 */
@Entity
@Table(name = "sup_manager", schema = "", catalog = "crm_srm_system")
public class SupManager {
    private int id;
    private int idSupplier;
    private String name;
    private String email;
    private String phone;
    private Supplier supplierById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idSupplier", nullable = false)
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 13)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupManager that = (SupManager) o;

        if (id != that.id) return false;
        if (idSupplier != that.idSupplier) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSupplier;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idSupplier", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Supplier getSupplierById() {
        return supplierById;
    }

    public void setSupplierById(Supplier supplierById) {
        this.supplierById = supplierById;
    }
}
