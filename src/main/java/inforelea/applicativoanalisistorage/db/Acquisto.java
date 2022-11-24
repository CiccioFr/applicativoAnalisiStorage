/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inforelea.applicativoanalisistorage.db;

import java.io.Serializable;
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

/**
 *
 * @author WS2
 */
@Entity
@Table(name = "acquisti")
@NamedQueries({
    @NamedQuery(name = "Acquisto.findAll", query = "SELECT a FROM Acquisto a"),
    @NamedQuery(name = "Acquisto.findById", query = "SELECT a FROM Acquisto a WHERE a.id = :id"),
    @NamedQuery(name = "Acquisto.findByImporto", query = "SELECT a FROM Acquisto a WHERE a.importo = :importo"),
    @NamedQuery(name = "Acquisto.findByProdotto", query = "SELECT a FROM Acquisto a WHERE a.prodotto = :prodotto")})
public class Acquisto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "importo")
    private Integer importo;
    @Column(name = "prodotto")
    private Integer prodotto;
    @JoinColumn(name = "idcliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idcliente;

    public Acquisto() {
    }

    public Acquisto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImporto() {
        return importo;
    }

    public void setImporto(Integer importo) {
        this.importo = importo;
    }

    public Integer getProdotto() {
        return prodotto;
    }

    public void setProdotto(Integer prodotto) {
        this.prodotto = prodotto;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
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
        if (!(object instanceof Acquisto)) {
            return false;
        }
        Acquisto other = (Acquisto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inforelea.applicativoanalisistorage.db.Acquisto[ id=" + id + " ]";
    }
    
}
