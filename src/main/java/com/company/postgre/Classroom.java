package com.company.postgre;


public class Classroom {

  private long classroomId;
  private long typeClassroomId;
  private long departmentId;
  private long frame;
  private String location;
  private String seats;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getClassroomId() {
    return classroomId;
  }

  public void setClassroomId(long classroomId) {
    this.classroomId = classroomId;
  }


  public long getTypeClassroomId() {
    return typeClassroomId;
  }

  public void setTypeClassroomId(long typeClassroomId) {
    this.typeClassroomId = typeClassroomId;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public long getFrame() {
    return frame;
  }

  public void setFrame(long frame) {
    this.frame = frame;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public String getSeats() {
    return seats;
  }

  public void setSeats(String seats) {
    this.seats = seats;
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
