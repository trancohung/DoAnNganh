/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Levi'H
 */
@Entity
@Table(name = "chitiethd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitiethd.findAll", query = "SELECT c FROM Chitiethd c"),
    @NamedQuery(name = "Chitiethd.findByMaHD", query = "SELECT c FROM Chitiethd c WHERE c.maHD = :maHD"),
    @NamedQuery(name = "Chitiethd.findByTongtien", query = "SELECT c FROM Chitiethd c WHERE c.tongtien = :tongtien")})
public class Chitiethd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHD")
    private Integer maHD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tongtien")
    private long tongtien;
    @OneToMany(mappedBy = "maHDKN1")
    private Collection<Hoadon> hoadonCollection;
    @JoinColumn(name = "Id_user", referencedColumnName = "idUser")
    @ManyToOne
    @NotNull
    private User iduser;

    public Chitiethd() {
    }

    public Chitiethd(Integer maHD) {
        this.maHD = maHD;
    }

    public Chitiethd(Integer maHD, long tongtien) {
        this.maHD = maHD;
        this.tongtien = tongtien;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    @XmlTransient
    public Collection<Hoadon> getHoadonCollection() {
        return hoadonCollection;
    }

    public void setHoadonCollection(Collection<Hoadon> hoadonCollection) {
        this.hoadonCollection = hoadonCollection;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHD != null ? maHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitiethd)) {
            return false;
        }
        Chitiethd other = (Chitiethd) object;
        if ((this.maHD == null && other.maHD != null) || (this.maHD != null && !this.maHD.equals(other.maHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Chitiethd[ maHD=" + maHD + " ]";
    }
    
}
