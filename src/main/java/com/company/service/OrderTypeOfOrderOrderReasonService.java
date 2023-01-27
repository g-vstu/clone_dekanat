package com.company.service;

import com.company.mapper.Mapper;
import com.company.mysql.Dotklon;
import com.company.postgre.Order;
import com.company.postgre.OrderTypeOfOrderOrderReason;
import com.company.postgre.Student;
import com.company.repository.onedb.*;
import com.company.repository.twodb.DotklonInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderTypeOfOrderOrderReasonService {
    OrderTypeOfOrderOrderReasonInterface orderTypeOfOrderOrderReasonInterface;
    DotklonInterface dotklonInterface;
    OrderInterface orderInterface;
    StudentInterface studentInterface;
    TypeOfOrderInterface typeOfOrderInterface;
    OrderReasonInterface orderReasonInterface;
    Mapper<Order, Dotklon> mapper;

    public List<Order> addAll() {
        List<Order> orders = mapper.toPostgres(dotklonInterface.findAll(), Order.class);
        AtomicInteger i = new AtomicInteger();
        orders.forEach(order -> {
            OrderTypeOfOrderOrderReason orderTypeOfOrderOrderReason =
                    orderTypeOfOrderOrderReasonInterface.findByOrder_PrikazOtklonAndOrder_DataPrikAndDataSAndDataPoAndTypeOfOrder_VidPrikAndOrderReason_IdFromSource(order.getPrikazOtklon(),
                            order.getDataPrik(), order.getDataS(), order.getDataPo(), order.getVidPrik(), order.getNprich());
            if (orderTypeOfOrderOrderReason == null) {
                orderTypeOfOrderOrderReason = new OrderTypeOfOrderOrderReason();
                orderTypeOfOrderOrderReason.setDataPo(order.getDataPo());
                orderTypeOfOrderOrderReason.setDataS(order.getDataS());
                Order order1 = orderInterface.findByPrikazOtklonAndDataPrik(order.getPrikazOtklon(), order.getDataPrik());
                if (order1 == null) {
                    System.out.println(order.getPrikazOtklon() + "|" + order.getDataPrik());
                }
                orderTypeOfOrderOrderReason.setOrder(order1);
                orderTypeOfOrderOrderReason.setOrderReason(orderReasonInterface.findByIdFromSource(order.getNprich()));
                orderTypeOfOrderOrderReason.setTypeOfOrder(typeOfOrderInterface.findByVidPrik(order.getVidPrik()));
            }
            /*
            Student student;
            try {
                student = studentInterface.findByNumberOfStudentbook(order.getDelo());
            } catch (Exception e) {
                student = studentInterface.findByNumberOfStudentbookAndGroupName(order.getDelo(), order.getGr());
            }
            if (student == null) {
                List<Dotklon> dotklons = dotklonInterface.findByDeloAndFamLike(order.getDelo(), order.getFam().split(" ")[0] + "%");
                List<Dotklon> dotklons1 = dotklons.stream().filter(dotklon -> dotklon.getGrNew() != null && !dotklon.getGrNew().equals("")).collect(Collectors.toList());
                List<Timestamp> dates = dotklons1.stream().map(Dotklon::getDataPrik).collect(Collectors.toList());
                List<Timestamp> finalDates1 = dates;
                dotklons1 = dotklons1.stream().filter(dotklon -> dotklon.getDataPrik().equals(Collections.max(finalDates1))).collect(Collectors.toList());
                student = studentInterface.findByNumberOfStudentbookAndGroupName(order.getDelo(), dotklons1.isEmpty() ? null : dotklons1.get(0).getGrNew());
                if (student == null) {
                    System.out.println(order.getDelo());
                    try {
                        student = studentInterface.findByNumberOfStudentbookAndSurnameLike(order.getDelo(), order.getFam().split(" ")[0] + "%");
                    } catch (Exception e) {
                        dates = dotklons.stream().map(Dotklon::getDataPrik).collect(Collectors.toList());
                        List<Timestamp> finalDates = dates;
                        dotklons1 = dotklons.stream().filter(dotklon -> dotklon.getDataPrik().equals(Collections.max(finalDates))).collect(Collectors.toList());
                        student = studentInterface.findByNumberOfStudentbookAndGroupName(order.getDelo(), dotklons1.isEmpty() ? null : dotklons1.get(0).getGr());
                    }
                    if (student == null) {
                        String[] name = order.getFam().split(" ");
                        if (order.getFamNew() != null) {
                            if (!order.getFamNew().equals("")) {
                                name[0] = order.getFamNew().split(" ")[0];
                            }
                        }
                        //System.out.println(name[0] + "|" + name[1] + "|" + name[2]);
                        if (order.getFam().equals("Середа Елена Сергеевна")) {
                            student = studentInterface.findByNumberOfStudentbookAndSurnameLike("101659", order.getFam().split(" ")[0] + "%");
                        } else if (order.getFam().equals("Бубен Екатерина Иосифовна")) {
                            student = studentInterface.findByNumberOfStudentbookAndSurnameLike("101677", order.getFam().split(" ")[0] + "%");
                        } else if (order.getFam().equals("Панасюк Евгения Михайловна")) {
                            student = studentInterface.findByNumberOfStudentbookAndSurnameLike("101657", order.getFam().split(" ")[0] + "%");
                        } else if (order.getFam().equals("Дыко Александр Дмитриевич")) {
                            student = studentInterface.findByNumberOfStudentbookAndGroupName("14308", "ЗС-39");
                        } else {
                            try {
                                student = studentInterface.findBySurnameLikeAndNameLikeAndPatronymicLike(name[0] + "%", name[1] + "%", name[2] + "%");
                            } catch (Exception exception) {
                                student = studentInterface.findByGroupNameAndSurnameLike(order.getGr(), order.getFam().split(" ")[0] + "%");
                            }
                        }
                        if (student == null) {
                            dotklons = dotklonInterface.findByDeloAndFamLike(order.getDelo(), order.getFam().split(" ")[0] + "%");
                            dotklons = dotklons.stream().filter(dotklon -> dotklon.getFamNew() != null && !dotklon.getFamNew().equals("")).collect(Collectors.toList());
                            if (dotklons.size() == 1) {
                                student = studentInterface.findBySurnameLikeAndNameLikeAndPatronymicLike(dotklons.get(0).getFamNew() + "%", name[1] + "%", name[2] + "%");
                            } else if (dotklons.size() > 1) {
                                System.exit(-1);
                            }
                            if (student == null) {
                                System.out.println(order.getGr());
                                System.out.println(order.getDelo() + "----------------------------------------------------------------------------");
                                if (!order.getDelo().equals("0") && !order.getFam().equals("Войтович  Светлана  Константиновна") && !order.getFam().equals("Ступакова Наталья Сергеевна") &&
                                        !order.getFam().equals("Михалёва Ирина Валерьевна") && !order.getFam().equals("Малахов Вячеслав Валерьевич") &&
                                        !order.getFam().equals("Леушонок Анастасия Михайловна") && !order.getFam().equals("Гелдиев Вепа Аразбаевич") &&
                                        !order.getFam().equals("Пушнёв Артём Александрович") && !order.getFam().equals("Шамкова Анастасия Игоревна") &&
                                        !order.getFam().equals("Козлов Дмитрий Александрович") && !order.getFam().equals("Алланназарова Мехрибан Ахмедовна")
                                        && !order.getFam().equals("Русакова Кристина Анатольевна") && !order.getFam().equals("Соловьёва Анастасия Александровна")
                                        && !order.getFam().equals("Золина Марина Валерьевна") && !order.getFam().equals("Симоненко Ирина Геннадьевна")
                                        && !order.getFam().equals("Митчурова Татьяна Анатольевна") && !order.getVidPrik().equals("Отчислить")
                                        && !order.getDelo().equals("061562") && !order.getFam().equals("Буткевич Влада Юрьевна")
                                        && !order.getFam().equals("Киптенко Валерия Викторовна")) {
                                    System.exit(-1);
                                }
                            }
                        }
                    }
                }
            }
            orderTypeOfOrderOrderReason = orderTypeOfOrderOrderReasonInterface.save(orderTypeOfOrderOrderReason);
            Set<OrderTypeOfOrderOrderReason> orderTypeOfOrderOrderReasons = student.getOrderTypeOfOrderOrderReasons() == null ? new HashSet<>() : student.getOrderTypeOfOrderOrderReasons();
            Set<Student> studentSet = orderTypeOfOrderOrderReason.getStudents() == null ? new HashSet<>() : orderTypeOfOrderOrderReason.getStudents();
            studentSet.add(student);
            orderTypeOfOrderOrderReason.setStudents(studentSet);
            orderTypeOfOrderOrderReasons.add(orderTypeOfOrderOrderReason);
            student.setOrderTypeOfOrderOrderReasons(orderTypeOfOrderOrderReasons);
            studentInterface.save(student);

             */
            if (orderTypeOfOrderOrderReason.getId() == null) {
                orderTypeOfOrderOrderReasonInterface.save(orderTypeOfOrderOrderReason);
            }
            System.out.println(i.incrementAndGet());
        });
        return null;
    }
}
