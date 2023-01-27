package com.company.postgre;


public class CompletedEducationalInstitution {

  private long completedEducationalInstitutionId;
  private long educationalInstitutionId;
  private long studentId;
  private java.sql.Date yearEnd;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getCompletedEducationalInstitutionId() {
    return completedEducationalInstitutionId;
  }

  public void setCompletedEducationalInstitutionId(long completedEducationalInstitutionId) {
    this.completedEducationalInstitutionId = completedEducationalInstitutionId;
  }


  public long getEducationalInstitutionId() {
    return educationalInstitutionId;
  }

  public void setEducationalInstitutionId(long educationalInstitutionId) {
    this.educationalInstitutionId = educationalInstitutionId;
  }


  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }


  public java.sql.Date getYearEnd() {
    return yearEnd;
  }

  public void setYearEnd(java.sql.Date yearEnd) {
    this.yearEnd = yearEnd;
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
