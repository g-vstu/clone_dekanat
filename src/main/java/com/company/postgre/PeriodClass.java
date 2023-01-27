package com.company.postgre;


public class PeriodClass {

  private long periodClassId;
  private long numberClass;
  private java.sql.Timestamp timeStart;
  private java.sql.Timestamp timeStop;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getPeriodClassId() {
    return periodClassId;
  }

  public void setPeriodClassId(long periodClassId) {
    this.periodClassId = periodClassId;
  }


  public long getNumberClass() {
    return numberClass;
  }

  public void setNumberClass(long numberClass) {
    this.numberClass = numberClass;
  }


  public java.sql.Timestamp getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(java.sql.Timestamp timeStart) {
    this.timeStart = timeStart;
  }


  public java.sql.Timestamp getTimeStop() {
    return timeStop;
  }

  public void setTimeStop(java.sql.Timestamp timeStop) {
    this.timeStop = timeStop;
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
