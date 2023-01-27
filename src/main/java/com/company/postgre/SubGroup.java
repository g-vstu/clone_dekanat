package com.company.postgre;


public class SubGroup {

  private long subGroupId;
  private long typeSubGroupId;
  private long subGroupNumber;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getSubGroupId() {
    return subGroupId;
  }

  public void setSubGroupId(long subGroupId) {
    this.subGroupId = subGroupId;
  }


  public long getTypeSubGroupId() {
    return typeSubGroupId;
  }

  public void setTypeSubGroupId(long typeSubGroupId) {
    this.typeSubGroupId = typeSubGroupId;
  }


  public long getSubGroupNumber() {
    return subGroupNumber;
  }

  public void setSubGroupNumber(long subGroupNumber) {
    this.subGroupNumber = subGroupNumber;
  }


  public java.sql.Date getCreated() {
    return created;
  }

  public void setCreated(java.sql.Date created) {
    this.created = created;
  }


  public java.sql.Date getUpdated() {
    return updated;
  }

  public void setUpdated(java.sql.Date updated) {
    this.updated = updated;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
