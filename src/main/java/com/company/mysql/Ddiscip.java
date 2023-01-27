package com.company.mysql;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Ddiscip")
@AttributeOverride(name = "idFromSource", column = @Column(name = "ndis"))
public class Ddiscip extends MySqlEntity {
  @Column(name = "namedis")
  private String name;
  @Column(name = "namedis1")
  private String shortName;
  @Column(name = "dkaf_id")
  private Long dkafId;

}
