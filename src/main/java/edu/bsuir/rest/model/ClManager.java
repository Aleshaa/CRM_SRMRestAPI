package edu.bsuir.rest.model;

import javax.persistence.*;

/**
 * Created by Alesha on 19.09.2016.
 */
@Entity
@Table(name = "cl_manager", schema = "", catalog = "crm_srm_system")
public class ClManager {
    private int id;
    private int idClient;
    private String name;
    private String email;
    private String phone;
    private Client clientById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idClient", insertable = false, updatable = false, nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

        ClManager clManager = (ClManager) o;

        if (id != clManager.id) return false;
        if (idClient != clManager.idClient) return false;
        if (name != null ? !name.equals(clManager.name) : clManager.name != null) return false;
        if (email != null ? !email.equals(clManager.email) : clManager.email != null) return false;
        if (phone != null ? !phone.equals(clManager.phone) : clManager.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idClient;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Client getClientById() {
        return clientById;
    }

    public void setClientById(Client clientById) {
        this.clientById = clientById;
    }
}
