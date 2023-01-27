package com.company.postgre;


public class TypeSubGroup {

  private long typeSubGroupId;
  private String name;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getTypeSubGroupId() {
    return typeSubGroupId;
  }

  public void setTypeSubGroupId(long typeSubGroupId) {
    this.typeSubGroupId = typeSubGroupId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
