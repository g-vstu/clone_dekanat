package com.company.postgre;


public class Qualification {

  private long qualificationId;
  private String name;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getQualificationId() {
    return qualificationId;
  }

  public void setQualificationId(long qualificationId) {
    this.qualificationId = qualificationId;
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
