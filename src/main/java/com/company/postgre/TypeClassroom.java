package com.company.postgre;


public class TypeClassroom {

  private long typeClassroomId;
  private String name;
  private String shortName;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getTypeClassroomId() {
    return typeClassroomId;
  }

  public void setTypeClassroomId(long typeClassroomId) {
    this.typeClassroomId = typeClassroomId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
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
