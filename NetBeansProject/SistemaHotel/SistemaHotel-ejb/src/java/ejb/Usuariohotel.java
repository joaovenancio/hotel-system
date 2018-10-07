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
@Table(name = "USUARIOHOTEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariohotel.findAll", query = "SELECT u FROM Usuariohotel u")
    , @NamedQuery(name = "Usuariohotel.findById", query = "SELECT u FROM Usuariohotel u WHERE u.id = :id")
    , @NamedQuery(name = "Usuariohotel.findByNome", query = "SELECT u FROM Usuariohotel u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuariohotel.findByCpf", query = "SELECT u FROM Usuariohotel u WHERE u.cpf = :cpf")
    , @NamedQuery(name = "Usuariohotel.findByEndereco", query = "SELECT u FROM Usuariohotel u WHERE u.endereco = :endereco")
    , @NamedQuery(name = "Usuariohotel.findByTelefone", query = "SELECT u FROM Usuariohotel u WHERE u.telefone = :telefone")
    , @NamedQuery(name = "Usuariohotel.findByFuncionario", query = "SELECT u FROM Usuariohotel u WHERE u.funcionario = :funcionario")
    , @NamedQuery(name = "Usuariohotel.findByLogin", query = "SELECT u FROM Usuariohotel u WHERE u.login = :login")
    , @NamedQuery(name = "Usuariohotel.findBySenha", query = "SELECT u FROM Usuariohotel u WHERE u.senha = :senha")})
public class Usuariohotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPF")
    private String cpf;
    @Size(max = 60)
    @Column(name = "ENDERECO")
    private String endereco;
    @Size(max = 20)
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUNCIONARIO")
    private Boolean funcionario;
    @Size(max = 30)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 30)
    @Column(name = "SENHA")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariohotel")
    private Collection<Reserva> reservaCollection;

    public Usuariohotel() {
    }

    public Usuariohotel(Integer id) {
        this.id = id;
    }

    public Usuariohotel(Integer id, String nome, String cpf, Boolean funcionario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariohotel)) {
            return false;
        }
        Usuariohotel other = (Usuariohotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Usuariohotel[ id=" + id + " ]";
    }
    
}
