package com.company.postgre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "student")
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
public class Student extends PostgreEntity{
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "privileges_id")
  private Privileges privileges;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "family_status_id")
  private FamilyStatus familyStatus;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "citizenship_id")
  private Citizenship citizenship;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "foreign_language_id")
  private ForeignLanguage foreignLanguage;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "educational_institution_id")
  private EducationalInstitution educationalInstitution;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "sex_id")
  private Sex sex;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "type_training_id")
  private TypeTraining typeTraining;
  @ToString.Exclude
  @Column(name = "number_of_studentbook")
  private String numberOfStudentbook;
  @ToString.Exclude
  private String personal_file_number;
  @ToString.Exclude
  private String birthplace;
  @ToString.Exclude
  private String surname;
  private String name;
  private String patronymic;
  @Column(name = "id_from_source")
  private Long idFromSource;
  @Column(name = "surname_latin")
  private String surnameLatin;
  @ToString.Exclude
  @Column(name = "name_latin")
  private String nameLatin;
  @ToString.Exclude
  private LocalDate birthday;
  @ToString.Exclude
  private String phone;
  @ToString.Exclude
  private String address;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "country_id")
  private Country country;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "area_id")
  private Area area;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "district_id")
  private District district;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "locality_id")
  private Locality locality;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "street_address_id")
  private StreetAddress street_address;
  @ToString.Exclude
  @Column(name = "street_house")
  private String streetHouse;
  @ToString.Exclude
  @Column(name = "building_house")
  private String buildingHouse;
  @ToString.Exclude
  @Column(name = "flat_home")
  private String flatHome;
  @ToString.Exclude
  @ManyToOne
  @JoinColumn(name = "passport_series_id")
  private PassportSeries passportSeries;
  @ToString.Exclude
  private transient String passportSerija;
  @ToString.Exclude
  private String passport_number;
  @ToString.Exclude
  private String passport_seller;
  @ToString.Exclude
  private LocalDate issue_date;
  @ToString.Exclude
  private String photo;
  @ToString.Exclude
  private String email;
  @ToString.Exclude
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "guardian_student", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {
          @JoinColumn(name = "guardian_id")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "guardian_id"})})
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  private Set<Guardian> guardians;

  @ToString.Exclude
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "student_order_type_of_order_order_reason", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {
          @JoinColumn(name = "order_type_of_order_order_reason_id")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "order_type_of_order_order_reason_id"})})
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  private Set<OrderTypeOfOrderOrderReason> orderTypeOfOrderOrderReasons;

  @ToString.Exclude
  transient private String pol;
  @ToString.Exclude
  transient private String gr;
  @ToString.Exclude
  transient private Long dgraj_id;
  @ToString.Exclude
  transient private Long dinostr_id;
  @ToString.Exclude
  transient private String okonchil;
  @ToString.Exclude
  transient private Long dyo_id;
  @ToString.Exclude
  transient private String sem_pol;//
  @ToString.Exclude
  transient private String lgoti;//
  @ToString.Exclude
  transient private String delo;
  @ToString.Exclude
  transient private String lichni_nomer;
  @ToString.Exclude
  transient private String mesto_roj;
  @ToString.Exclude
  transient private String fam;
  @ToString.Exclude
  transient  private String otch;
  @ToString.Exclude
  transient private String FIOLatin;
  @ToString.Exclude
  transient private LocalDate data_roj;
  @ToString.Exclude
  transient private String telef;
  @ToString.Exclude
  transient private String adres_city;
  @ToString.Exclude
  transient private String adres_oblast;
  @ToString.Exclude
  transient private String adres_indeks;
  @ToString.Exclude
  transient private String adres_raion;
  @ToString.Exclude
  transient  private String atp;
  @ToString.Exclude
  transient private String adres_gorod;
  @ToString.Exclude
  transient private String ayp;
  @ToString.Exclude
  transient private String adres_ylica;
  @ToString.Exclude
  transient private String adres_dom;
  @ToString.Exclude
  transient private String adres_korp;
  @ToString.Exclude
  transient private String adres_kv;
  @ToString.Exclude
  transient private String pasport_nomer;
  @ToString.Exclude
  transient private String pasport_kem_vidan;
  @ToString.Exclude
  transient private LocalDate pasport_data_vid;
  @ToString.Exclude
  transient String papa_fio;
  @ToString.Exclude
  transient String papa_rabota;
  @ToString.Exclude
  transient String papa_telef;
  @ToString.Exclude
  transient String mama_fio;
  @ToString.Exclude
  transient String mama_rabota;
  @ToString.Exclude
  transient String mama_telef;
  @ToString.Exclude
  transient String paid;

}
