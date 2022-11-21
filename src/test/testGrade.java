/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Objects;
import DAL.StudentGradeDAL;
import DTO.StudentGradeDTO;
import test.Test;

/**
 *
 * @author LENOVO
 */
public class testGrade {

    private static Test test = new Test();

    private static boolean equals(ArrayList<StudentGradeDTO> list1, ArrayList<StudentGradeDTO> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getEnrollmentID() != list2.get(i).getEnrollmentID()
                    || list1.get(i).getCourseID() != list2.get(i).getCourseID()
                    || list1.get(i).getStudentID() != list2.get(i).getStudentID()
                    || list1.get(i).getGrade() != list2.get(i).getGrade()) {
                return false;
            }
        }
        return true;
    }

    private static void testListGrade(ArrayList<StudentGradeDTO> result) {
        test.addTest();
        ArrayList<StudentGradeDTO> list = new ArrayList<StudentGradeDTO>();
        result.forEach(rs -> {
            StudentGradeDTO p = new StudentGradeDTO();
            p.setEnrollmentID(rs.getEnrollmentID());
            p.setCourseID(rs.getCourseID());
            p.setStudentID(rs.getStudentID());
            p.setGrade(rs.getGrade());
            list.add(p);
        });

        if (list.isEmpty() && result.isEmpty()) {
            test.out("listGrade()", true, "Duong doc lap 1");
        } else if (!result.isEmpty() && !list.isEmpty() && equals(result, list)) {
            test.out("listGrade()", true, "Duong doc lap 2");
        } else {
            if ((!list.isEmpty() && result.isEmpty())
                    || (list.isEmpty() && !result.isEmpty())) {
                test.out("list()", false, "Duong doc lap 1");
            } else if (!result.isEmpty() && !list.isEmpty() && !equals(result, list)) {
                test.out("list()", false, "Duong doc lap 2");
            }
        }
    }

    private static void testValidate(ArrayList<StudentGradeDTO> listGrade, String id, String course, 
            String student, String grade, boolean isEditing) {
        test.addTest();
        boolean returnValue = true;
        boolean isDuplicated = false;
        int loop = 0;
        boolean passed = false;

        if (id.equals("") || student.equals("") || course.equals("") || grade.equals("")) {
            returnValue = false;
        }
        if (!id.matches("^\\d+")) {
            returnValue = false;
        }
        if (!isEditing) {
            for (StudentGradeDTO p : listGrade) {
                if (id.equals(String.valueOf(p.EnrollmentID))) {
                    returnValue = false;
                    isDuplicated = true;
                }
                loop++;
            }
        }

        if ((id.equals("") || course.equals("") || student.equals("") || grade.equals("")) && returnValue == false) {
            test.out("validate()", true, "Duong doc lap 1");
            passed = true;
        } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals("")) 
                && !id.matches("^\\d+") && returnValue == false) {
            test.out("validate()", true, "Duong doc lap 2");
            passed = true;
        } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals("")) 
                && id.matches("^\\d+") && isEditing && returnValue == true) {
            test.out("validate()", true, "Duong doc lap 3");
            passed = true;
        } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals(""))
                && id.matches("^\\d+") && !isEditing && listGrade.isEmpty() && returnValue == true
                && isDuplicated == false && loop <= 1) {
            test.out("validate()", true, "Duong doc lap 4");
            passed = true;
        } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals(""))
                && id.matches("^\\d+") && !isEditing && !listGrade.isEmpty() && loop > 1
                && returnValue == true && isDuplicated == false) {
            test.out("validate()", true, "Duong doc lap 5");
            passed = true;
        } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals(""))
                && id.matches("^\\d+") && !isEditing && !listGrade.isEmpty() && loop > 1
                && returnValue == false && isDuplicated == true) {
            test.out("validate()", true, "Duong doc lap 6");
            passed = true;
        }
        
        if (passed == false) {
            if ((id.equals("") || course.equals("") || student.equals("") || grade.equals("")) && returnValue == true) {
                test.out("validate()", false, "Duong doc lap 1");
            } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals("")) 
                    && !id.matches("^\\d+") && returnValue == true) {
                test.out("validate()", false, "Duong doc lap 2");
            } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals("")) 
                    && id.matches("^\\d+") && isEditing && returnValue == false) {
                test.out("validate()", false, "Duong doc lap 3");
            } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals(""))
                    && id.matches("^\\d+") && !isEditing && listGrade.isEmpty() && (returnValue == false
                    || isDuplicated == true || loop > 1)) {
                test.out("validate()", false, "Duong doc lap 4");
            } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals(""))
                    && id.matches("^\\d+") && !isEditing && !listGrade.isEmpty() && (loop <= 1
                    || returnValue == false || isDuplicated == true)) {
                test.out("validate()", false, "Duong doc lap 5");
            } else if ((!id.equals("") && !course.equals("") && !student.equals("") && !grade.equals(""))
                    && id.matches("^\\d+") && !isEditing && !listGrade.isEmpty() && (loop <= 1
                    || returnValue == true || isDuplicated == false)) {
                test.out("validate()", false, "Duong doc lap 6");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<StudentGradeDTO> list1 = new ArrayList<StudentGradeDTO>();
        ArrayList<StudentGradeDTO> list2 = new ArrayList<StudentGradeDTO>();
        ArrayList<StudentGradeDTO> list3 = new ArrayList<StudentGradeDTO>();
        ArrayList<StudentGradeDTO> list4 = new ArrayList<StudentGradeDTO>();

        list1.add(new StudentGradeDTO(1, 1, 1, 10));
        list1.add(new StudentGradeDTO(1, 5, 6, 7));

        list2.add(new StudentGradeDTO(2, 2, 2, 9));
        list2.add(new StudentGradeDTO(3, 4, 1, 8));

        testListGrade(list3);
        testListGrade(list1);

        testValidate(list1, "", "", "", "", false);
        testValidate(list1, "asd", "asd", "asd", "asd", true);
        testValidate(list2, "1", "2", "3", "4", true);
        testValidate(list3, "3", "4", "5", "11", false);
        testValidate(list2, "21", "22", "23", "1", false);
        testValidate(list2, "2", "2", "2", "9", false);

        test.result();

    }
}
