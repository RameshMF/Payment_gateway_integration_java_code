package com.salesmanager.core.model.common.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.http.client.utils.CloneUtils;

@Embeddable
//@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class AuditSection implements Serializable {


	private static final long serialVersionUID = -1934446958975060889L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIFIED")
	private Date dateModified;

	@Column(name = "UPDT_ID", length=20)
	private String modifiedBy;
	
	public AuditSection() {
	}

	public Date getDateCreated() throws CloneNotSupportedException {
		return (Date) CloneUtils.clone(dateCreated);
	}

	public void setDateCreated(Date dateCreated) throws CloneNotSupportedException {
		this.dateCreated = (Date) CloneUtils.clone(dateCreated);
	}

	public Date getDateModified() throws CloneNotSupportedException {
		return (Date) CloneUtils.clone(dateModified);
	}

	public void setDateModified(Date dateModified) throws CloneNotSupportedException {
		this.dateModified = (Date) CloneUtils.clone(dateModified);
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
