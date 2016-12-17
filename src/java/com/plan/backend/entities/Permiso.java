/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.backend.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author Kathe
 */
@Entity
@Table(name = "Permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByPermisosId", query = "SELECT p FROM Permiso p WHERE p.permisosId = :permisosId")
    , @NamedQuery(name = "Permiso.findByDescripcion", query = "SELECT p FROM Permiso p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Permiso.findByTipo", query = "SELECT p FROM Permiso p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Permiso.findByDependencia", query = "SELECT p FROM Permiso p WHERE p.dependencia = :dependencia")
    , @NamedQuery(name = "Permiso.findByUrl", query = "SELECT p FROM Permiso p WHERE p.url = :url")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "permisosId")
    private Integer permisosId;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "Tipo")
    private String tipo;
    @Size(max = 35)
    @Column(name = "Dependencia")
    private String dependencia;
    @Size(max = 20)
    @Column(name = "URL")
    private String url;
    @ManyToMany(mappedBy = "permisoList")
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer permisosId) {
        this.permisosId = permisosId;
    }

    public Integer getPermisosId() {
        return permisosId;
    }

    public void setPermisosId(Integer permisosId) {
        this.permisosId = permisosId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosId != null ? permisosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.permisosId == null && other.permisosId != null) || (this.permisosId != null && !this.permisosId.equals(other.permisosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.plan.backend.entities.Permiso[ permisosId=" + permisosId + " ]";
    }
    
}
