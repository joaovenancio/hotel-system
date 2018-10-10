/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author joaov
 */
@Entity
@Table(name = "QUARTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quarto.findAll", query = "SELECT q FROM Quarto q")
    , @NamedQuery(name = "Quarto.findByCodigo", query = "SELECT q FROM Quarto q WHERE q.codigo = :codigo")
    , @NamedQuery(name = "Quarto.findByValordiaria", query = "SELECT q FROM Quarto q WHERE q.valordiaria = :valordiaria")
    , @NamedQuery(name = "Quarto.findByNumcamasolteiro", query = "SELECT q FROM Quarto q WHERE q.numcamasolteiro = :numcamasolteiro")
    , @NamedQuery(name = "Quarto.findByNumcamacasal", query = "SELECT q FROM Quarto q WHERE q.numcamacasal = :numcamacasal")
    , @NamedQuery(name = "Quarto.findByBanheira", query = "SELECT q FROM Quarto q WHERE q.banheira = :banheira")
    , @NamedQuery(name = "Quarto.findByFrigobar", query = "SELECT q FROM Quarto q WHERE q.frigobar = :frigobar")
    , @NamedQuery(name = "Quarto.findByTelevisao", query = "SELECT q FROM Quarto q WHERE q.televisao = :televisao")
    , @NamedQuery(name = "Quarto.findByHomeoffice", query = "SELECT q FROM Quarto q WHERE q.homeoffice = :homeoffice")
    , @NamedQuery(name = "Quarto.findByInternet", query = "SELECT q FROM Quarto q WHERE q.internet = :internet")
    , @NamedQuery(name = "Quarto.findByTipoquarto", query = "SELECT q FROM Quarto q WHERE q.tipoquarto = :tipoquarto")})
public class Quarto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORDIARIA")
    private Double valordiaria;
    @Column(name = "NUMCAMASOLTEIRO")
    private Integer numcamasolteiro;
    @Column(name = "NUMCAMACASAL")
    private Integer numcamacasal;
    @Column(name = "BANHEIRA")
    private Boolean banheira;
    @Column(name = "FRIGOBAR")
    private Boolean frigobar;
    @Column(name = "TELEVISAO")
    private Boolean televisao;
    @Column(name = "HOMEOFFICE")
    private Boolean homeoffice;
    @Column(name = "INTERNET")
    private Boolean internet;
    @Size(max = 30)
    @Column(name = "TIPOQUARTO")
    private String tipoquarto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @JoinColumn(name = "FK_STATUS", referencedColumnName = "CODIGO")
    @ManyToOne
    private Tipostatus fkStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quarto")
    private Collection<Reserva> reservaCollection;

    public Quarto() {
    }

    public Quarto(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValordiaria() {
        return valordiaria;
    }

    public void setValordiaria(Double valordiaria) {
        this.valordiaria = valordiaria;
    }

    public Integer getNumcamasolteiro() {
        return numcamasolteiro;
    }

    public void setNumcamasolteiro(Integer numcamasolteiro) {
        this.numcamasolteiro = numcamasolteiro;
    }

    public Integer getNumcamacasal() {
        return numcamacasal;
    }

    public void setNumcamacasal(Integer numcamacasal) {
        this.numcamacasal = numcamacasal;
    }

    public Boolean getBanheira() {
        return banheira;
    }

    public void setBanheira(Boolean banheira) {
        this.banheira = banheira;
    }

    public Boolean getFrigobar() {
        return frigobar;
    }

    public void setFrigobar(Boolean frigobar) {
        this.frigobar = frigobar;
    }

    public Boolean getTelevisao() {
        return televisao;
    }

    public void setTelevisao(Boolean televisao) {
        this.televisao = televisao;
    }

    public Boolean getHomeoffice() {
        return homeoffice;
    }

    public void setHomeoffice(Boolean homeoffice) {
        this.homeoffice = homeoffice;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public String getTipoquarto() {
        return tipoquarto;
    }

    public void setTipoquarto(String tipoquarto) {
        this.tipoquarto = tipoquarto;
    }

    public Tipostatus getFkStatus() {
        return fkStatus;
    }

    public void setFkStatus(Tipostatus fkStatus) {
        this.fkStatus = fkStatus;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quarto)) {
            return false;
        }
        Quarto other = (Quarto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Quarto[ codigo=" + codigo + " ]";
    }
    
}
