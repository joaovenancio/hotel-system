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
@Table(name = "TIPOSTATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipostatus.findAll", query = "SELECT t FROM Tipostatus t")
    , @NamedQuery(name = "Tipostatus.findByCodigo", query = "SELECT t FROM Tipostatus t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipostatus.findByNomestatus", query = "SELECT t FROM Tipostatus t WHERE t.nomestatus = :nomestatus")})
public class Tipostatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Size(max = 30)
    @Column(name = "NOMESTATUS")
    private String nomestatus;
    @OneToMany(mappedBy = "fkStatus")
    private Collection<Quarto> quartoCollection;

    public Tipostatus() {
    }

    public Tipostatus(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomestatus() {
        return nomestatus;
    }

    public void setNomestatus(String nomestatus) {
        this.nomestatus = nomestatus;
    }

    @XmlTransient
    public Collection<Quarto> getQuartoCollection() {
        return quartoCollection;
    }

    public void setQuartoCollection(Collection<Quarto> quartoCollection) {
        this.quartoCollection = quartoCollection;
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
        if (!(object instanceof Tipostatus)) {
            return false;
        }
        Tipostatus other = (Tipostatus) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Tipostatus[ codigo=" + codigo + " ]";
    }
    
}
