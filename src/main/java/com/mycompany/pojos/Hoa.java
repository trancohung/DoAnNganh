/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Levi'H
 */
@Entity
@Table(name = "hoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoa.findAll", query = "SELECT h FROM Hoa h"),
    @NamedQuery(name = "Hoa.findByMaHoa", query = "SELECT h FROM Hoa h WHERE h.maHoa = :maHoa"),
    @NamedQuery(name = "Hoa.findByTenHoa", query = "SELECT h FROM Hoa h WHERE h.tenHoa = :tenHoa"),
    @NamedQuery(name = "Hoa.findByMoTa", query = "SELECT h FROM Hoa h WHERE h.moTa = :moTa"),
    @NamedQuery(name = "Hoa.findByHinhanh", query = "SELECT h FROM Hoa h WHERE h.hinhanh = :hinhanh"),
    @NamedQuery(name = "Hoa.findByGia", query = "SELECT h FROM Hoa h WHERE h.gia = :gia"),
    @NamedQuery(name = "Hoa.findByActive", query = "SELECT h FROM Hoa h WHERE h.active = :active")})
public class Hoa implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maHoa10")
    private Collection<Hoadon> hoadonCollection;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private long gia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaid", fetch = FetchType.EAGER)
    private Collection<Comment> commentCollection;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHoa")
    private Integer maHoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 99)
    @Column(name = "TenHoa")
    private String tenHoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 355)
    @Column(name = "MoTa")
    private String moTa;
    @Size(max = 255)
    @Column(name = "Hinhanh")
    private String hinhanh;
    @Size(max = 45)
    @Column(name = "active")
    @JsonIgnore
    private String active;
    @JoinColumn(name = "MaLoai", referencedColumnName = "MaLoaiHoa")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Loaihoa maLoai;
    @Transient
    private MultipartFile file;

    public Hoa() {
    }

    public Hoa(Integer maHoa) {
        this.maHoa = maHoa;
    }

    public Hoa(Integer maHoa, String tenHoa, String moTa, long gia) {
        this.maHoa = maHoa;
        this.tenHoa = tenHoa;
        this.moTa = moTa;
        this.gia = gia;
    }

    public Integer getMaHoa() {
        return maHoa;
    }

    public void setMaHoa(Integer maHoa) {
        this.maHoa = maHoa;
    }

    public String getTenHoa() {
        return tenHoa;
    }

    public void setTenHoa(String tenHoa) {
        this.tenHoa = tenHoa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Hoadon> getHoadonCollection() {
        return hoadonCollection;
    }

    public void setHoadonCollection(Collection<Hoadon> hoadonCollection) {
        this.hoadonCollection = hoadonCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public Loaihoa getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Loaihoa maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoa != null ? maHoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoa)) {
            return false;
        }
        Hoa other = (Hoa) object;
        if ((this.maHoa == null && other.maHoa != null) || (this.maHoa != null && !this.maHoa.equals(other.maHoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Hoa[ maHoa=" + maHoa + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
