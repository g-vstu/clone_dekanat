package com.company.service;

import com.company.mysql.Dotklon;
import com.company.postgre.OrderTypeOfOrderOrderReason;
import com.company.postgre.Student;
import com.company.postgre.StudentOrderTypeOfOrderOrderReason;
import com.company.repository.onedb.OrderTypeOfOrderOrderReasonInterface;
import com.company.repository.onedb.StudentInterface;
import com.company.repository.onedb.StudentOrderTypeOfOrderOrderReasonInterface;
import com.company.repository.twodb.DotklonInterface;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentOrderService {
    DotklonInterface dotklonInterface;
    StudentOrderTypeOfOrderOrderReasonInterface studentOrderTypeOfOrderOrderReasonInterface;
    StudentInterface studentInterface;
    OrderTypeOfOrderOrderReasonInterface orderTypeOfOrderOrderReasonInterface;

    public void addAll(){
        List<Dotklon> dotklonList = dotklonInterface.findAll();
        AtomicInteger i = new AtomicInteger();
        dotklonList.forEach(dotklon -> {
            if (dotklon.getFam() != null && !dotklon.getFam().equals("Новодворская  Вероника  Сергеевна") && !dotklon.getFam().equals("Кушнерова Вероника  Сергеевна")) {
                dotklon.setDelo(dotklon.getDelo().replaceAll("\\s+", ""));
            }
            StudentOrderTypeOfOrderOrderReason studentOrderTypeOfOrderOrderReason = new StudentOrderTypeOfOrderOrderReason();
            Student student = null;
            try {
                student = studentInterface.findByNumberOfStudentbook(dotklon.getDelo());
            } catch (Exception e) {
                List<Dotklon> dotklons = dotklonInterface.findByDeloAndFamLike(dotklon.getDelo(), dotklon.getFam().split(" ")[0] + "%");
                List<Dotklon> dotklons1 = dotklons.stream().filter(dotklon1 -> dotklon1.getGrNew() != null && !dotklon1.getGrNew().equals("")).collect(Collectors.toList());
                List<Timestamp> dates = dotklons1.stream().map(Dotklon::getDataPrik).collect(Collectors.toList());
                dotklons1 = dotklons1.stream().filter(dotklon1 -> dotklon1.getDataPrik().equals(Collections.max(dates))).collect(Collectors.toList());
                if (dotklons1.isEmpty() || dotklons1.get(0).getGrNew()==null || dotklons1.get(0).getGrNew().equals("") || dotklons1.get(0).getGrNew().equals(dotklon.getGr())) {
                    student = studentInterface.findByNumberOfStudentbookAndGroupName(dotklon.getDelo(), dotklon.getGr());
                }
            }
            if (student == null) {
                List<Dotklon> dotklons = dotklonInterface.findByDeloAndFamLike(dotklon.getDelo(), dotklon.getFam().split(" ")[0] + "%");
                List<Dotklon> dotklons1 = dotklons.stream().filter(dotklon1 -> dotklon1.getGrNew() != null && !dotklon1.getGrNew().equals("")).collect(Collectors.toList());
                List<Timestamp> dates = dotklons1.stream().map(Dotklon::getDataPrik).collect(Collectors.toList());
                List<Timestamp> finalDates1 = dates;
                List<Timestamp> finalDates3 = finalDates1;
                dotklons1 = dotklons1.stream().filter(dotklon1 -> dotklon1.getDataPrik().equals(Collections.max(finalDates3))).collect(Collectors.toList());
                student = studentInterface.findByNumberOfStudentbookAndGroupName(dotklon.getDelo(), dotklons1.isEmpty() ? null : dotklons1.get(0).getGrNew());
                if (student == null) {
                    System.out.println(dotklon.getDelo());
                    try {
                        student = studentInterface.findByNumberOfStudentbookAndSurnameLike(dotklon.getDelo(), dotklon.getFam().split(" ")[0] + "%");
                    } catch (Exception e) {
                        dates = dotklons.stream().map(Dotklon::getDataPrik).collect(Collectors.toList());
                        List<Timestamp> finalDates = dates;
                        dotklons1 = dotklons.stream().filter(dotklon1 -> dotklon1.getDataPrik().equals(Collections.max(finalDates))).collect(Collectors.toList());
                        student = studentInterface.findByNumberOfStudentbookAndGroupName(dotklon.getDelo(), dotklons1.isEmpty() ? null : dotklons1.get(0).getGr());
                    }
                    if (student == null) {
                        String[] name = dotklon.getFam().split(" ");
                        if (dotklon.getFamNew() != null) {
                            if (!dotklon.getFamNew().equals("")) {
                                name[0] = dotklon.getFamNew().split(" ")[0];
                            }
                        }
                        //System.out.println(name[0] + "|" + name[1] + "|" + name[2]);
                        if (dotklon.getFam().equals("Середа Елена Сергеевна")) {
                            student = studentInterface.findByNumberOfStudentbookAndSurnameLike("101659", dotklon.getFam().split(" ")[0] + "%");
                        } else if (dotklon.getFam().equals("Бубен Екатерина Иосифовна")) {
                            student = studentInterface.findByNumberOfStudentbookAndSurnameLike("101677", dotklon.getFam().split(" ")[0] + "%");
                        } else if (dotklon.getFam().equals("Панасюк Евгения Михайловна")) {
                            student = studentInterface.findByNumberOfStudentbookAndSurnameLike("101657", dotklon.getFam().split(" ")[0] + "%");
                        } else if (dotklon.getFam().equals("Дыко Александр Дмитриевич")) {
                            student = studentInterface.findByNumberOfStudentbookAndGroupName("14308", "ЗС-39");
                        } else {
                            try {
                                student = studentInterface.findBySurnameLikeAndNameLikeAndPatronymicLike(name[0] + "%", name[1] + "%", name[2] + "%");
                            } catch (Exception exception) {
                                student = studentInterface.findByGroupNameAndSurnameLike(dotklon.getGr(), dotklon.getFam().split(" ")[0] + "%");
                            }
                        }
                        if (student == null) {
                            dotklons = dotklonInterface.findByDeloAndFamLike(dotklon.getDelo(), dotklon.getFam().split(" ")[0] + "%");
                            dotklons = dotklons.stream().filter(dotklon1 -> dotklon1.getFamNew() != null && !dotklon1.getFamNew().equals("")).collect(Collectors.toList());
                            if (dotklons.size() == 1) {
                                student = studentInterface.findBySurnameLikeAndNameLikeAndPatronymicLike(dotklons.get(0).getFamNew() + "%", name[1] + "%", name[2] + "%");
                            } else if (dotklons.size() > 1) {
                                System.exit(-1);
                            }
                            if (student == null) {
                                dotklons = dotklonInterface.findByDelo(dotklon.getDelo());
                                dotklons1 = dotklons.stream().filter(dotklon1 -> dotklon1.getGrNew() != null && !dotklon1.getGrNew().equals("")).collect(Collectors.toList());
                                dates = dotklons1.stream().map(Dotklon::getDataPrik).collect(Collectors.toList());
                                finalDates1 = dates;
                                List<Timestamp> finalDates2 = finalDates1;
                                dotklons1 = dotklons1.stream().filter(dotklon1 -> dotklon1.getDataPrik().equals(Collections.max(finalDates2))).collect(Collectors.toList());
                                if (dotklons1.size() == 1) {
                                    student = studentInterface.findByNumberOfStudentbookAndGroupName(dotklon.getDelo(), dotklons1.get(0).getGrNew());
                                }
                                if (student == null) {
                                    System.out.println(dotklon.getGr());
                                    System.out.println(dotklon.getDelo() + "----------------------------------------------------------------------------");
                                    if (!dotklon.getDelo().equals("0")
                                            /*&& !dotklon.getVidPrik().equals("Отчислить")*/
                                            && !dotklon.getFam().equals("Буткевич Влада Юрьевна")//нету
                                            && !dotklon.getFam().equals("Киптенко Валерия Викторовна")) { // нету
                                        System.exit(-1);
                                    }
                                }
                            }

                        }
                    }
                }
            }
            OrderTypeOfOrderOrderReason orderTypeOfOrderOrderReason = orderTypeOfOrderOrderReasonInterface.findByOrder_PrikazOtklonAndOrder_DataPrikAndDataSAndDataPoAndTypeOfOrder_VidPrikAndOrderReason_IdFromSource(dotklon.getPrikazOtklon(),
                    dotklon.getDataPrik(), dotklon.getDataS(), dotklon.getDataPo(), dotklon.getVidPrik(), dotklon.getNprich());
            studentOrderTypeOfOrderOrderReason.setStudent(student);
            studentOrderTypeOfOrderOrderReason.setOrderTypeOfOrderOrderReason(orderTypeOfOrderOrderReason);
            //studentOrderTypeOfOrderOrderReasonInterface.save(studentOrderTypeOfOrderOrderReason);
            System.out.println(i.incrementAndGet());
        });
    }
}
