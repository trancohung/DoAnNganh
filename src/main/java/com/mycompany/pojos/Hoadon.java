/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Levi'H
 */
@Entity
@Table(name = "hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h"),
    @NamedQuery(name = "Hoadon.findByMaHoaDon", query = "SELECT h FROM Hoadon h WHERE h.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "Hoadon.findByNgayLapHoaDon", query = "SELECT h FROM Hoadon h WHERE h.ngayLapHoaDon = :ngayLapHoaDon"),
    @NamedQuery(name = "Hoadon.findByNgayGiao", query = "SELECT h FROM Hoadon h WHERE h.ngayGiao = :ngayGiao"),
    @NamedQuery(name = "Hoadon.findByThanhGia", query = "SELECT h FROM Hoadon h WHERE h.thanhGia = :thanhGia"),
    @NamedQuery(name = "Hoadon.findBySoLuong", query = "SELECT h FROM Hoadon h WHERE h.soLuong = :soLuong")})
public class Hoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHoaDon")
    private Integer maHoaDon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayLapHoaDon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayLapHoaDon;
    @Column(name = "NgayGiao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayGiao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThanhGia")
    private long thanhGia;
    @Column(name = "soLuong")
    private Integer soLuong;
    @JoinColumn(name = "MaHDKN1", referencedColumnName = "MaHD")
    @ManyToOne
    private Chitiethd maHDKN1;
    @JoinColumn(name = "MaHoa10", referencedColumnName = "MaHoa")
    @ManyToOne(optional = false)
    private Hoa maHoa10;
    @JoinColumn(name = "MaKH", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User maKH;

    public Hoadon() {
    }

    public Hoadon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Hoadon(Integer maHoaDon, Date ngayLapHoaDon, long thanhGia) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.thanhGia = thanhGia;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public long getThanhGia() {
        return thanhGia;
    }

    public void setThanhGia(long thanhGia) {
        this.thanhGia = thanhGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Chitiethd getMaHDKN1() {
        return maHDKN1;
    }

    public void setMaHDKN1(Chitiethd maHDKN1) {
        this.maHDKN1 = maHDKN1;
    }

    public Hoa getMaHoa10() {
        return maHoa10;
    }

    public void setMaHoa10(Hoa maHoa10) {
        this.maHoa10 = maHoa10;
    }

    public User getMaKH() {
        return maKH;
    }

    public void setMaKH(User maKH) {
        this.maKH = maKH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Hoadon[ maHoaDon=" + maHoaDon + " ]";
    }
    
}
