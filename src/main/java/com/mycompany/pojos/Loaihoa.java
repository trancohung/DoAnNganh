/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Levi'H
 */
@Entity
@Table(name = "loaihoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaihoa.findAll", query = "SELECT l FROM Loaihoa l"),
    @NamedQuery(name = "Loaihoa.findByMaLoaiHoa", query = "SELECT l FROM Loaihoa l WHERE l.maLoaiHoa = :maLoaiHoa"),
    @NamedQuery(name = "Loaihoa.findByTenLoai", query = "SELECT l FROM Loaihoa l WHERE l.tenLoai = :tenLoai")})
public class Loaihoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaLoaiHoa")
    private Integer maLoaiHoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenLoai")
    private String tenLoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maLoai", fetch = FetchType.EAGER)
    private Collection<Hoa> hoaCollection;

    public Loaihoa() {
    }

    public Loaihoa(Integer maLoaiHoa) {
        this.maLoaiHoa = maLoaiHoa;
    }

    public Loaihoa(Integer maLoaiHoa, String tenLoai) {
        this.maLoaiHoa = maLoaiHoa;
        this.tenLoai = tenLoai;
    }

    public Integer getMaLoaiHoa() {
        return maLoaiHoa;
    }

    public void setMaLoaiHoa(Integer maLoaiHoa) {
        this.maLoaiHoa = maLoaiHoa;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @XmlTransient
    public Collection<Hoa> getHoaCollection() {
        return hoaCollection;
    }

    public void setHoaCollection(Collection<Hoa> hoaCollection) {
        this.hoaCollection = hoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiHoa != null ? maLoaiHoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaihoa)) {
            return false;
        }
        Loaihoa other = (Loaihoa) object;
        if ((this.maLoaiHoa == null && other.maLoaiHoa != null) || (this.maLoaiHoa != null && !this.maLoaiHoa.equals(other.maLoaiHoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Loaihoa[ maLoaiHoa=" + maLoaiHoa + " ]";
    }
    
}
