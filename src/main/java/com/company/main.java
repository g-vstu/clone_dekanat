package com.company;

import com.company.config.DatabaseTwoConfig;
import com.company.mysql.Dzvan;
import com.company.postgre.*;
import com.company.repository.onedb.*;
import com.company.repository.twodb.DotklonInterface;
import com.company.repository.twodb.DstudentInterface;
import com.company.repository.twodb.DvedomInterface;
import com.company.repository.twodb.DzvanInterface;
import com.company.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(main.class, args);
        /*GroupInterface groupInterface = context.getBean(GroupInterface.class);
        groupInterface.saveAll(groupInterface.findAll().stream().peek(group -> {
            try {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(new Date());
                int curYear = calendar.get(Calendar.YEAR);
                calendar.setTime(group.getYear_start());
                short course = Short.parseShort(String.valueOf(curYear - calendar.get(Calendar.YEAR) + 1));
                if (course <= 0) {
                    course = 1;
                } else if (course > 4) {
                    course = 4;
                }
                group.setCourse((int) course);
            } catch (Exception ignored){}
        }).collect(Collectors.toList()));
         */
        /*deleteAll(context);
        AcademicTitleService academicTitleService = context.getBean(AcademicTitleService.class);
        academicTitleService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        //DstudentInterface dstudentInterface = context.getBean(DstudentInterface.class);
        //dstudentInterface.findAll().forEach(System.out::println);
        SexService sexService = context.getBean(SexService.class);
        sexService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        FacultyService facultyService = context.getBean(FacultyService.class);
        facultyService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        SpecialityService specialityService = context.getBean(SpecialityService.class);
        specialityService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        departmentService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        MethodistService methodistService = context.getBean(MethodistService.class);
        methodistService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        GroupService groupService = context.getBean(GroupService.class);
        groupService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        CitizenShipService citizenShipService = context.getBean(CitizenShipService.class);
        citizenShipService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        LanguageService languageService = context.getBean(LanguageService.class);
        languageService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        EducationalInstitutionService educationalInstitutionService = context.getBean(EducationalInstitutionService.class);
        educationalInstitutionService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        PassportSeriesService passportSeriesService = context.getBean(PassportSeriesService.class);
        passportSeriesService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.addAll();
        context.close();
        context = SpringApplication.run(main.class, args);
        DisciplineService disciplineService = context.getBean(DisciplineService.class);
        disciplineService.addAll();

        context.close();
        context = SpringApplication.run(main.class, args);

        StudentService studentService = context.getBean(StudentService.class);
        studentService.addAll();

        context.close();


        /*context.close();
        context = SpringApplication.run(main.class, args);

        ReferenceService referenceService = context.getBean(ReferenceService.class);
        referenceService.addAll();

        context.close();
        context = SpringApplication.run(main.class, args);

        PassService passService = context.getBean(PassService.class);
        passService.addAll();



        //StudentInterface studentInterface = context.getBean(StudentInterface.class);
        //System.out.println(studentInterface.findById(15074L).get());

        //AttestationTypeService attestationTypeService = context.getBean(AttestationTypeService.class);
        //attestationTypeService.addAll();

        //AcademicPlanService academicPlanService = context.getBean(AcademicPlanService.class);
        //academicPlanService.addAll();

        //StatementService statementService = context.getBean(StatementService.class);
        //statementService.addAll();

        //OrderReasonService orderReasonService = context.getBean(OrderReasonService.class);
        //orderReasonService.addAll();

        //TypeOfOrderService typeOfOrderService = context.getBean(TypeOfOrderService.class);
        //typeOfOrderService.addAll();

        //OrderService orderService = context.getBean(OrderService.class);
        //orderService.addAll();

        //OrderTypeOfOrderOrderReasonService orderTypeOfOrderOrderReasonService = context.getBean(OrderTypeOfOrderOrderReasonService.class);
        //orderTypeOfOrderOrderReasonService.addAll();

        //StudentOrderService studentOrderService = context.getBean(StudentOrderService.class);
        //studentOrderService.addAll();

        //context.close();

         */
    }

    static void deleteAll(ConfigurableApplicationContext context){
        StudentOrderTypeOfOrderOrderReasonInterface studentOrderTypeOfOrderOrderReasonInterface = context.getBean(StudentOrderTypeOfOrderOrderReasonInterface.class);
        studentOrderTypeOfOrderOrderReasonInterface.deleteAll();
        OrderTypeOfOrderOrderReasonInterface orderTypeOfOrderOrderReasonInterface = context.getBean(OrderTypeOfOrderOrderReasonInterface.class);
        orderTypeOfOrderOrderReasonInterface.deleteAll();
        OrderInterface orderInterface = context.getBean(OrderInterface.class);
        orderInterface.deleteAll();
        TypeOfOrderInterface typeOfOrderInterface = context.getBean(TypeOfOrderInterface.class);
        typeOfOrderInterface.deleteAll();
        OrderReasonInterface orderReasonInterface = context.getBean(OrderReasonInterface.class);
        orderReasonInterface.deleteAll();
        StatementInterface statementInterface = context.getBean(StatementInterface.class);
        statementInterface.deleteAll();
        AcademicPlanLoadInterface academicPlanLoadInterface = context.getBean(AcademicPlanLoadInterface.class);
        academicPlanLoadInterface.deleteAll();
        LoadInterface loadInterface = context.getBean(LoadInterface.class);
        loadInterface.deleteAll();
        AcademicPlanInterface academicPlanInterface = context.getBean(AcademicPlanInterface.class);
        academicPlanInterface.deleteAll();
        AttestationTypeInterface attestationTypeInterface = context.getBean(AttestationTypeInterface.class);
        attestationTypeInterface.deleteAll();
        PassInterface passInterface = context.getBean(PassInterface.class);
        passInterface.deleteAll();
        ReferenceInterface referenceInterface = context.getBean(ReferenceInterface.class);
        referenceInterface.deleteAll();
        StudentInterface studentInterface = context.getBean(StudentInterface.class);
        studentInterface.deleteAll();
        DisciplineInterface disciplineInterface = context.getBean(DisciplineInterface.class);
        disciplineInterface.deleteAll();
        TeacherInterface teacherInterface = context.getBean(TeacherInterface.class);
        teacherInterface.deleteAll();
        PassportSeriesInterface passportSeriesInterface = context.getBean(PassportSeriesInterface.class);
        passportSeriesInterface.deleteAll();
        EIInterface eiInterface = context.getBean(EIInterface.class);
        eiInterface.deleteAll();
        LanguageInterface languageInterface = context.getBean(LanguageInterface.class);
        languageInterface.deleteAll();
        CitizenshipInterface citizenshipInterface = context.getBean(CitizenshipInterface.class);
        citizenshipInterface.deleteAll();
        GroupInterface groupInterface = context.getBean(GroupInterface.class);
        groupInterface.deleteAll();
        MethodistInterface methodistInterface = context.getBean(MethodistInterface.class);
        methodistInterface.deleteAll();
        DepartmentInterface departmentInterface = context.getBean(DepartmentInterface.class);
        departmentInterface.deleteAll();
        SpecialityInterface specialityInterface = context.getBean(SpecialityInterface.class);
        specialityInterface.deleteAll();
        FacultyInterface facultyInterface = context.getBean(FacultyInterface.class);
        facultyInterface.deleteAll();
        SexInterface sexInterface = context.getBean(SexInterface.class);
        sexInterface.deleteAll();
        AcademicTitleInterface academicTitleInterface = context.getBean(AcademicTitleInterface.class);
        academicTitleInterface.deleteAll();
    }
}
