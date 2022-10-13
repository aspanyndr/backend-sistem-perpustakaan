package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "data_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_admin")
    @Column(name = " id_admin")
    private Integer idAdmin;

    @Column(name = "nama_admin")
    private String namaAdmin;

    @Column(name = "username")
    private String usernameAdmin;
    @Column(name = "password")
    private String passwordAdmin;
    @Column(name = "status_admin")
    private String statusAdmin;

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getStatusAdmin() {
        return statusAdmin;
    }

    public void setStatusAdmin(String statusAdmin) {
        this.statusAdmin = statusAdmin;
    }
}
