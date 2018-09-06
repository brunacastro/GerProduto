/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerproduto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "produto", catalog = "gerloja", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdPRoduto", query = "SELECT p FROM Produto p WHERE p.idPRoduto = :idPRoduto")
    , @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco")
    , @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Produto.findByDisponivel", query = "SELECT p FROM Produto p WHERE p.disponivel = :disponivel")})
public class Produto implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPRoduto")
    private Integer idPRoduto;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Double preco;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "disponivel")
    private Short disponivel;

    public Produto() {
    }

    public Produto(Integer idPRoduto) {
        this.idPRoduto = idPRoduto;
    }

    public Integer getIdPRoduto() {
        return idPRoduto;
    }

    public void setIdPRoduto(Integer idPRoduto) {
        Integer oldIdPRoduto = this.idPRoduto;
        this.idPRoduto = idPRoduto;
        changeSupport.firePropertyChange("idPRoduto", oldIdPRoduto, idPRoduto);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        Double oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Integer oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public Short getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Short disponivel) {
        Short oldDisponivel = this.disponivel;
        this.disponivel = disponivel;
        changeSupport.firePropertyChange("disponivel", oldDisponivel, disponivel);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPRoduto != null ? idPRoduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idPRoduto == null && other.idPRoduto != null) || (this.idPRoduto != null && !this.idPRoduto.equals(other.idPRoduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerproduto.Produto[ idPRoduto=" + idPRoduto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
