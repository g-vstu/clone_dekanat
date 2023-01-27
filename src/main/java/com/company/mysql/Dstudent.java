package com.company.mysql;

import com.company.postgre.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "Dstudent")
@AttributeOverride(name = "idFromSource", column = @Column(name = "dstudent_id"))
public class Dstudent extends MySqlEntity{

    private String pol;
    private String gr;
    @Column(name = "adres")
    private String address;
    private Long dgraj_id;
    private Long dinostr_id;
    private String okonchil;
    private Long dyo_id;
    private String sem_pol;//
    @Column(name = "delo")
    private String numberOfStudentbook;
    @Column(name = "lichni_nomer")
    private String personal_file_number;
    @Column(name = "mesto_roj")
    private String birthplace;
    @Column(name = "fam")
    private String surname;
    private String name;
    @Column(name = "otch")
    private String patronymic;
    @Column(name = "FIOLatin")
    private String surnameLatin;
    private String nameLatin;
    @Column(name = "data_roj")
    private LocalDate birthday;
    @Column(name = "telef")
    private String phone;
    private String adres_city;
    private String adres_oblast;
    private String adres_indeks;
    private String adres_raion;
    @Column(name = "Адрес_тип_пункта")
    private String atp;
    private String adres_gorod;
    @Column(name = "Адрес_улица_префикс")
    private String ayp;
    private String adres_ylica;
    @Column(name = "adres_dom")
    private String streetHouse;
    @Column(name = "adres_korp")
    private String buildingHouse;
    @Column(name = "adres_kv")
    private String flatHome;


    @Column(name = "pasport_serija")
    private String passportSerija;

    @Column(name = "pasport_nomer")
    private String passport_number;
    @Column(name = "pasport_kem_vidan")
    private String passport_seller;
    @Column(name = "pasport_data_vid")
    private LocalDate issue_date;
    private String papa_fio;
    private String papa_rabota;
    private String papa_telef;
    private String mama_fio;
    private String mama_rabota;
    private String mama_telef;
    private String lgoti;
    @Column(name = "oplata_obychen")
    private String paid;
    @Column(name = "adres_email")
    private String email;



}
