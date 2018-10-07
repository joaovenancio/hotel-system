/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joaov
 */
@Embeddable
public class ReservaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_CODQUARTO")
    private int fkCodquarto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_CODUSUARIO")
    private int fkCodusuario;

    public ReservaPK() {
    }

    public ReservaPK(int codigo, int fkCodquarto, int fkCodusuario) {
        this.codigo = codigo;
        this.fkCodquarto = fkCodquarto;
        this.fkCodusuario = fkCodusuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFkCodquarto() {
        return fkCodquarto;
    }

    public void setFkCodquarto(int fkCodquarto) {
        this.fkCodquarto = fkCodquarto;
    }

    public int getFkCodusuario() {
        return fkCodusuario;
    }

    public void setFkCodusuario(int fkCodusuario) {
        this.fkCodusuario = fkCodusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (int) fkCodquarto;
        hash += (int) fkCodusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservaPK)) {
            return false;
        }
        ReservaPK other = (ReservaPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.fkCodquarto != other.fkCodquarto) {
            return false;
        }
        if (this.fkCodusuario != other.fkCodusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ReservaPK[ codigo=" + codigo + ", fkCodquarto=" + fkCodquarto + ", fkCodusuario=" + fkCodusuario + " ]";
    }
    
}
