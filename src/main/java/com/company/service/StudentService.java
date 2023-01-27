package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dstudent;
import com.company.mysql.Dyo;
import com.company.postgre.*;
import com.company.repository.onedb.*;
import com.company.repository.twodb.DInostrInterface;
import com.company.repository.twodb.DgrajInterface;
import com.company.repository.twodb.DstudentInterface;
import com.company.repository.twodb.DyoInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentService {
    DstudentInterface dstudentInterface;
    public StudentInterface studentInterface;
    Mapper<Student, Dstudent> mapper;
    StreetInterface streetInterface;
    LocalityInterface localityInterface;
    DistrictInterface districtInterface;
    AreaInterface areaInterface;
    CountyInterface countyInterface;
    GroupInterface groupInterface;
    CitizenshipInterface citizenshipInterface;
    DgrajInterface dgrajInterface;
    LanguageInterface languageInterface;
    EIInterface eiInterface;
    SexInterface sexInterface;
    PassportSeriesInterface passportSeriesInterface;
    DInostrInterface dInostrInterface;
    DyoInterface dyoInterface;
    PrivelegesInterface privelegesInterface;
    FamilyStatusInterface familyStatusInterface;
    GuardianInterface guardianInterface;
    TypeTrainingInterface typeTrainingInterface;

    public List<Student> addAll() {
        AtomicReference<Integer> iteration = new AtomicReference<>(0);
        List<Student> students = mapper.toPostgres(dstudentInterface.findAll(), Student.class);
        students.forEach(student -> {
            Group group = groupInterface.findByName(student.getGr());
            if (group == null) {
                group = groupInterface.findByName(student.getGr().toLowerCase());
            }
            student.setGroup(group);
            Citizenship citizenship = citizenshipInterface.findByName(dgrajInterface.findById(student.getDgraj_id()).get().getName());
            student.setCitizenship(citizenship);
            ForeignLanguage foreignLanguage = languageInterface.findByName(dInostrInterface.findById(student.getDinostr_id()).get().getName());
            student.setForeignLanguage(foreignLanguage);
            EducationalInstitution educationalInstitution = null;
            String institution = student.getOkonchil();
            Long dyoId = student.getDyo_id();
            try {
                if (institution != null && !institution.equals("нет")) {
                    Set<EducationalInstitution> set = eiInterface.findByName(institution);
                    educationalInstitution = set.isEmpty() ? null : new ArrayList<>(set).get(0);
                    if (educationalInstitution == null) {
                        educationalInstitution = new EducationalInstitution();
                        educationalInstitution.setName(institution);
                        educationalInstitution = eiInterface.saveAndFlush(educationalInstitution);
                    }
                } else if (dyoId != null && dyoId > 0) {
                    Dyo dyo = dyoInterface.findById(dyoId).get();
                    institution = dyo.getName();
                    Set<EducationalInstitution> set = eiInterface.findByName(institution);
                    educationalInstitution = set.isEmpty() ? null : new ArrayList<>(set).get(0);
                    if (educationalInstitution == null) {
                        educationalInstitution = new EducationalInstitution();
                        educationalInstitution.setName(institution);
                        educationalInstitution = eiInterface.saveAndFlush(educationalInstitution);
                    }
                    educationalInstitution = educationalInstitution.getName().equals("нет") ? null : educationalInstitution;
                }
            } catch (Throwable e) {
                if (dyoId != null && dyoId > 0) {
                    Dyo dyo = dyoInterface.findById(dyoId).get();
                    institution = dyo.getName();
                    Set<EducationalInstitution> set = eiInterface.findByName(institution);
                    educationalInstitution = set.isEmpty() ? null : new ArrayList<>(set).get(0);
                    if (educationalInstitution == null) {
                        educationalInstitution = new EducationalInstitution();
                        educationalInstitution.setName(institution);
                        educationalInstitution = eiInterface.saveAndFlush(educationalInstitution);
                    }
                    educationalInstitution = educationalInstitution.getName().equals("нет") ? null : educationalInstitution;
                }
            }
            student.setEducationalInstitution(educationalInstitution);
            student.setSex(sexInterface.findByPol(student.getPol()));
            TypeTraining typeTraining = typeTrainingInterface.findByName(student.getPaid());
            if (typeTraining == null) {
                typeTraining = new TypeTraining();
                typeTraining.setName(student.getPaid());
                typeTraining = typeTrainingInterface.saveAndFlush(typeTraining);
            }
            student.setTypeTraining(typeTraining);
            String address = student.getAdres_city();
            Country country = null;
            if (address != null) {
                country = countyInterface.findByName(address);
                if (country == null) {
                    country = new Country();
                    country.setName(address);
                    country = countyInterface.saveAndFlush(country);
                }
            }
            student.setCountry(country);
            address = student.getAdres_oblast();
            Area area = null;
            if (address != null) {
                area = areaInterface.findByName(address);
                if (area == null) {
                    area = new Area();
                    area.setName(address);
                    area = areaInterface.saveAndFlush(area);
                }
            }
            student.setArea(area);
            address = student.getAdres_raion();
            District district = null;
            if (address != null) {
                district = districtInterface.findByName(address);
                if (district == null) {
                    district = new District();
                    district.setName(address);
                    district.setPostcode(student.getAdres_indeks());
                    district = districtInterface.saveAndFlush(district);
                }
            }
            student.setDistrict(district);
            address = student.getAdres_gorod();
            Locality locality = null;
            if (address != null) {
                locality = localityInterface.findByName(address);
                if (locality == null) {
                    locality = new Locality();
                    locality.setName(address);
                    locality = localityInterface.saveAndFlush(locality);
                }
            }
            student.setLocality(locality);
            address = student.getAdres_ylica();
            StreetAddress streetAddress = null;
            if (address != null) {
                streetAddress = streetInterface.findByStreetName(address);
                if (streetAddress == null) {
                    streetAddress = new StreetAddress();
                    streetAddress.setStreetName(address);
                    streetAddress = streetInterface.saveAndFlush(streetAddress);
                }
            }
            student.setStreet_address(streetAddress);
            student.setPassportSeries(passportSeriesInterface.findByPassportSerija(student.getPassportSerija()));
            String familyST = student.getSem_pol();
            FamilyStatus familyStatus = familyStatusInterface.findByName(familyST);
            if (familyStatus == null) {
                familyStatus = new FamilyStatus();
                familyStatus.setName(familyST);
                familyStatus = familyStatusInterface.saveAndFlush(familyStatus);
            }
            student.setFamilyStatus(familyStatus);
            String lgoti = student.getLgoti();
            Privileges privileges = privelegesInterface.findByName(lgoti);
            if (privileges == null) {
                privileges = new Privileges();
                privileges.setName(lgoti);
                privileges = privelegesInterface.saveAndFlush(privileges);
            }
            student.setPrivileges(privileges);
            Guardian guardianMother = guardianInterface.findByFioAndSexPolAndPhoneAndWorkPlace(student.getMama_fio(),
                    "Ж", student.getMama_telef(), student.getMama_rabota());
            Guardian guardianFather = guardianInterface.findByFioAndSexPolAndPhoneAndWorkPlace(student.getPapa_fio(),
                    "М", student.getPapa_telef(), student.getPapa_rabota());
            if (guardianMother == null) {
                guardianMother = new Guardian();
                guardianMother.setFio(student.getMama_fio());
                guardianMother.setSex(sexInterface.findByPol("Ж"));
                guardianMother.setPhone(student.getMama_telef());
                guardianMother.setWorkPlace(student.getMama_rabota());
                /*
                Set<Student> studentSet = guardianMother.getStudents();
                studentSet = studentSet == null ? new HashSet<>() : studentSet;
                studentSet.add(student);
                guardianMother.setStudents(studentSet);
                 */
                guardianMother = guardianInterface.saveAndFlush(guardianMother);
            }
            if (guardianFather == null) {
                guardianFather = new Guardian();
                guardianFather.setFio(student.getPapa_fio());
                guardianFather.setSex(sexInterface.findByPol("М"));
                guardianFather.setPhone(student.getPapa_telef());
                guardianFather.setWorkPlace(student.getPapa_rabota());
                /*Set<Student> studentSet = guardianFather.getStudents();
                studentSet = studentSet == null ? new HashSet<>() : studentSet;
                studentSet.add(student);
                guardianFather.setStudents(studentSet);
                 */
                guardianFather = guardianInterface.saveAndFlush(guardianFather);
            }
            Guardian finalGuardianFather = guardianFather;
            Guardian finalGuardianMother = guardianMother;
            student.setGuardians(new HashSet<Guardian>(){{
                add(finalGuardianFather);
                add(finalGuardianMother);
            }});

            iteration.set(iteration.get() + 1);
            System.out.println(iteration.get());
        });
        return studentInterface.saveAllAndFlush(students);
    }
}
