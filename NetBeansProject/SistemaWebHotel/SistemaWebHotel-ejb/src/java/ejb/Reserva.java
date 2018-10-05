/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joaov
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByCodigo", query = "SELECT r FROM Reserva r WHERE r.reservaPK.codigo = :codigo")
    , @NamedQuery(name = "Reserva.findByFkCodquarto", query = "SELECT r FROM Reserva r WHERE r.reservaPK.fkCodquarto = :fkCodquarto")
    , @NamedQuery(name = "Reserva.findByFkCodusuario", query = "SELECT r FROM Reserva r WHERE r.reservaPK.fkCodusuario = :fkCodusuario")
    , @NamedQuery(name = "Reserva.findByValor", query = "SELECT r FROM Reserva r WHERE r.valor = :valor")
    , @NamedQuery(name = "Reserva.findByCheckout", query = "SELECT r FROM Reserva r WHERE r.checkout = :checkout")
    , @NamedQuery(name = "Reserva.findByDiarias", query = "SELECT r FROM Reserva r WHERE r.diarias = :diarias")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservaPK reservaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "CHECKOUT")
    private Boolean checkout;
    @Column(name = "DIARIAS")
    private Integer diarias;
    @JoinTable(name = "RESERVA_SERVICO", joinColumns = {
        @JoinColumn(name = "FK_CODIGORESERVA", referencedColumnName = "CODIGO")
        , @JoinColumn(name = "FK_CODQUARTO", referencedColumnName = "FK_CODQUARTO")
        , @JoinColumn(name = "FK_CODUSUARIO", referencedColumnName = "FK_CODUSUARIO")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_CODIGOSERVICO", referencedColumnName = "CODIGO")})
    @ManyToMany
    private Collection<Servicohotel> servicohotelCollection;
    @JoinColumn(name = "FK_CODQUARTO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quarto quarto;
    @JoinColumn(name = "FK_CODUSUARIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuariohotel usuariohotel;

    public Reserva() {
    }

    public Reserva(ReservaPK reservaPK) {
        this.reservaPK = reservaPK;
    }

    public Reserva(int codigo, int fkCodquarto, int fkCodusuario) {
        this.reservaPK = new ReservaPK(codigo, fkCodquarto, fkCodusuario);
    }

    public ReservaPK getReservaPK() {
        return reservaPK;
    }

    public void setReservaPK(ReservaPK reservaPK) {
        this.reservaPK = reservaPK;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getCheckout() {
        return checkout;
    }

    public void setCheckout(Boolean checkout) {
        this.checkout = checkout;
    }

    public Integer getDiarias() {
        return diarias;
    }

    public void setDiarias(Integer diarias) {
        this.diarias = diarias;
    }

    @XmlTransient
    public Collection<Servicohotel> getServicohotelCollection() {
        return servicohotelCollection;
    }

    public void setServicohotelCollection(Collection<Servicohotel> servicohotelCollection) {
        this.servicohotelCollection = servicohotelCollection;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Usuariohotel getUsuariohotel() {
        return usuariohotel;
    }

    public void setUsuariohotel(Usuariohotel usuariohotel) {
        this.usuariohotel = usuariohotel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservaPK != null ? reservaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.reservaPK == null && other.reservaPK != null) || (this.reservaPK != null && !this.reservaPK.equals(other.reservaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Reserva[ reservaPK=" + reservaPK + " ]";
    }
    
}
