package com.company.postgre;


public class Curator {

  private long curatorId;
  private long departmentId;
  private String fio;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getCuratorId() {
    return curatorId;
  }

  public void setCuratorId(long curatorId) {
    this.curatorId = curatorId;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public String getFio() {
    return fio;
  }

  public void setFio(String fio) {
    this.fio = fio;
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
