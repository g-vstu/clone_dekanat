package com.company.postgre;


public class Threshold {

  private long thresholdId;
  private double lowerGrade;
  private double upperGrade;
  private double coefficient;
  private java.sql.Date created;
  private java.sql.Date updated;
  private String status;


  public long getThresholdId() {
    return thresholdId;
  }

  public void setThresholdId(long thresholdId) {
    this.thresholdId = thresholdId;
  }


  public double getLowerGrade() {
    return lowerGrade;
  }

  public void setLowerGrade(double lowerGrade) {
    this.lowerGrade = lowerGrade;
  }


  public double getUpperGrade() {
    return upperGrade;
  }

  public void setUpperGrade(double upperGrade) {
    this.upperGrade = upperGrade;
  }


  public double getCoefficient() {
    return coefficient;
  }

  public void setCoefficient(double coefficient) {
    this.coefficient = coefficient;
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
