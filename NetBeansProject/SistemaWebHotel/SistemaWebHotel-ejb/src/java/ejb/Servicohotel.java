/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SERVICOHOTEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicohotel.findAll", query = "SELECT s FROM Servicohotel s")
    , @NamedQuery(name = "Servicohotel.findByCodigo", query = "SELECT s FROM Servicohotel s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Servicohotel.findByNome", query = "SELECT s FROM Servicohotel s WHERE s.nome = :nome")
    , @NamedQuery(name = "Servicohotel.findByPreco", query = "SELECT s FROM Servicohotel s WHERE s.preco = :preco")})
public class Servicohotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "NOME")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECO")
    private Double preco;
    @ManyToMany(mappedBy = "servicohotelCollection")
    private Collection<Reserva> reservaCollection;

    public Servicohotel() {
    }

    public Servicohotel(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
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
        if (!(object instanceof Servicohotel)) {
            return false;
        }
        Servicohotel other = (Servicohotel) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Servicohotel[ codigo=" + codigo + " ]";
    }
    
}
