package com.springboot.init;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Version
    @XmlTransient
    @JsonIgnore
    private long version = 1L;

    protected boolean activeStatus = true;

    @Column(name = "created_by_user", updatable = false)
    @CreatedBy
    @XmlTransient
    @JsonIgnore
    private String createdByUser;

    @XmlTransient
    @JsonIgnore
    @Column(name = "creation_date_time", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @XmlTransient
    @JsonIgnore
    @Column(name = "creation_time", updatable = false)
    private String creationTime;

    @Column(name = "modified_by_user")
    @LastModifiedBy
    @XmlTransient
    @JsonIgnore
    private String modifiedByUser;

    @XmlTransient
    @JsonIgnore
    @Column(name = "modification_date_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date modificationDateTime;

    @XmlTransient
    @JsonIgnore
    @Column(name = "modification_time")
    private String modificationTime;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final BaseEntity other = (BaseEntity) obj;
        return this.id == other.id;
    }
}
