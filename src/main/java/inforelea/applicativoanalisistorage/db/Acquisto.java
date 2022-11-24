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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WS2
 */
@Entity
@Table(name = "acquisti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acquisto.findAll", query = "SELECT a FROM Acquisto a"),
    @NamedQuery(name = "Acquisto.findById", query = "SELECT a FROM Acquisto a WHERE a.id = :id"),
    @NamedQuery(name = "Acquisto.findByImporto", query = "SELECT a FROM Acquisto a WHERE a.importo = :importo"),
    @NamedQuery(name = "Acquisto.findByProdotto", query = "SELECT a FROM Acquisto a WHERE a.prodotto = :prodotto"),
    @NamedQuery(name = "Acquisto.findByTimestamp", query = "SELECT a FROM Acquisto a WHERE a.timestamp = :timestamp")})
public class Acquisto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "importo")
    private int importo;
    @Basic(optional = false)
    @Column(name = "prodotto")
    private int prodotto;
    @Basic(optional = false)
    @Column(name = "timestamp")
    private String timestamp;
    @JoinColumn(name = "idcliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Acquisto() {
    }

    public Acquisto(Integer id) {
        this.id = id;
    }

    public Acquisto(Integer id, int importo, int prodotto, String timestamp) {
        this.id = id;
        this.importo = importo;
        this.prodotto = prodotto;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getImporto() {
        return importo;
    }

    public void setImporto(int importo) {
        this.importo = importo;
    }

    public int getProdotto() {
        return prodotto;
    }

    public void setProdotto(int prodotto) {
        this.prodotto = prodotto;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
