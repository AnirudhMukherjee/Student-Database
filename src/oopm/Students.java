/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopm;

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
 * @author KEVAL NAGDA
 */
@Entity
@Table(name = "students", catalog = "studentdata", schema = "")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findById", query = "SELECT s FROM Students s WHERE s.id = :id")
    , @NamedQuery(name = "Students.findBySapid", query = "SELECT s FROM Students s WHERE s.sapid = :sapid")
    , @NamedQuery(name = "Students.findByName", query = "SELECT s FROM Students s WHERE s.name = :name")
    , @NamedQuery(name = "Students.findByTt1", query = "SELECT s FROM Students s WHERE s.tt1 = :tt1")
    , @NamedQuery(name = "Students.findByTt2", query = "SELECT s FROM Students s WHERE s.tt2 = :tt2")
    , @NamedQuery(name = "Students.findByFinal1", query = "SELECT s FROM Students s WHERE s.final1 = :final1")})
public class Students implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "SAPID")
    private String sapid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "TT1")
    private Integer tt1;
    @Column(name = "TT2")
    private Integer tt2;
    @Column(name = "FINAL")
    private Integer final1;

    public Students() {
    }

    public Students(Integer id) {
        this.id = id;
    }

    public Students(Integer id, String sapid, String name) {
        this.id = id;
        this.sapid = sapid;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getSapid() {
        return sapid;
    }

    public void setSapid(String sapid) {
        String oldSapid = this.sapid;
        this.sapid = sapid;
        changeSupport.firePropertyChange("sapid", oldSapid, sapid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Integer getTt1() {
        return tt1;
    }

    public void setTt1(Integer tt1) {
        Integer oldTt1 = this.tt1;
        this.tt1 = tt1;
        changeSupport.firePropertyChange("tt1", oldTt1, tt1);
    }

    public Integer getTt2() {
        return tt2;
    }

    public void setTt2(Integer tt2) {
        Integer oldTt2 = this.tt2;
        this.tt2 = tt2;
        changeSupport.firePropertyChange("tt2", oldTt2, tt2);
    }

    public Integer getFinal1() {
        return final1;
    }

    public void setFinal1(Integer final1) {
        Integer oldFinal1 = this.final1;
        this.final1 = final1;
        changeSupport.firePropertyChange("final1", oldFinal1, final1);
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
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oopm.Students[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
