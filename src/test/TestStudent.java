/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.Objects;

import DAL.PersonDAL;
import DTO.PersonDTO;
import BLL.PersonBLL;
import javax.swing.JOptionPane;
import test.Test;

public class TestStudent {

    private static Test test = new Test();

    private static boolean equals(ArrayList<PersonDTO> list1, ArrayList<PersonDTO> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getPersonID() != list2.get(i).getPersonID() || !list1.get(i).getFirstname().equals(list2.get(i).getFirstname())
                    || !list1.get(i).getLastname().equals(list2.get(i).getLastname())
                    || !list1.get(i).getEnrollmentDate().equals(list2.get(i).getEnrollmentDate())) {
                return false;
            }
        }
        return true;
    }

    private static void testListStudent(ArrayList<PersonDTO> result) {
        test.addTest();
        ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
        for (PersonDTO rs : result) {
            PersonDTO p = new PersonDTO();
            p.setPersonID(rs.getPersonID());
            p.setLastname(rs.getLastname());
            p.setFirstname(rs.getFirstname());
            p.setEnrollmentDate(rs.getEnrollmentDate());
            list.add(p);
        }
        //list!=null && res != null && res equals list
        if (!list.isEmpty() && !result.isEmpty() && equals(result, list)) {
            test.out("listStudent()", true, "Đường độc lập 1");
        } 
        //list = null && res = null
        else if (list.isEmpty() && result.isEmpty()) {
            test.out("listStudent()", true, "Đường độc lập 2");
        } else {
            //list != null && res != null && res != list
            if (!list.isEmpty() && !result.isEmpty()&& !equals(result, list)) {
                test.out("listStudent()", false, "Đường độc lập 1");
            } else 
                //(list!=null && res=null) || (list=null && res!=null)
                if ((!list.isEmpty() && result.isEmpty()) || (list.isEmpty() && !result.isEmpty())) {
                test.out("listStudent()", false, "Đường độc lập 2");
            }
        }
    }

    private static boolean isLeapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    private static int ValidateDate(String dateInput) {
        if (!dateInput.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return 1;
        }

        String[] date;
        date = dateInput.split("-");
        int day, month, year;
        year = Integer.parseInt(date[0]);
        month = Integer.parseInt(date[1]);
        day = Integer.parseInt(date[2]);

        if (month < 1 || month > 12) {
            return 2;
        }

        if (month == 2) {
            if (isLeapYear(year)) {
                if (day < 1 || day > 29) {
                    return 2;
                }
            } else {
                if (day < 1 || day > 28) {
                    return 2;
                }
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day < 1 || day > 31) {
                return 2;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day < 1 || day > 30) {
                return 2;
            }
        }
        return 0;
    }

    public static void testValidate(ArrayList<PersonDTO> listStudent, String id, String lastname, String firstname, String endate, boolean isEditing) {
        test.addTest();

        boolean returnValue = true;
        boolean isDuplicated = false;
        int loop = 0;
        boolean passed = false;
        if (id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("")) {
            returnValue = false;
        }

        if (!id.matches("^\\d+")) {
            returnValue = false;
        }

        if (!isEditing) {
            for (PersonDTO p : listStudent) {
                if (id.equals(String.valueOf(p.PersonID))) {
                    returnValue = false;
                    isDuplicated = true;
                }
                loop++;
            }
        }

        if (ValidateDate(endate) == 1) {
            returnValue = false;
        } else if (ValidateDate(endate) == 2) {
            returnValue = false;
        }

        if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) != 2 && returnValue == true) {
            test.out("validate()", true, "Đường độc lập 1");
            passed = true;
        } else if (id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 2");
            passed = true;
        } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && !id.matches("^\\d+") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 3");
            passed = true;
        } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && !isEditing && listStudent.isEmpty() && returnValue == true && isDuplicated == false && loop <= 1) {
            test.out("validate()", true, "Đường độc lập 4");
            passed = true;
        } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                && id.matches("^\\d+") && !isEditing && !listStudent.isEmpty() && loop > 1 && returnValue == true && isDuplicated == false) {
            test.out("validate()", true, "Đường độc lập 5");
            passed = true;
        } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                && id.matches("^\\d+") && !isEditing && !listStudent.isEmpty() && loop > 1 && returnValue == false && isDuplicated == true) {
            test.out("validate()", true, "Đường độc lập 6");
            passed = true;
        } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && isEditing && ValidateDate(endate) == 1 && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 7");
            passed = true;
        } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) == 2 && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 8");
            passed = true;
        }

        if (passed == false) {
            if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) != 2 && returnValue == false) {
                test.out("validate()", false, "Đường độc lập 1");
            } else if (id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("") && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 2");
            } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && !id.matches("^\\d+") && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 3");
            } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && !isEditing && listStudent.isEmpty() && (returnValue == false || isDuplicated == true || loop > 1)) {
                test.out("validate()", false, "Đường độc lập 4");
            } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                    && id.matches("^\\d+") && !isEditing && !listStudent.isEmpty() && (loop <= 1 || returnValue == false || isDuplicated == true)) {
                test.out("validate()", false, "Đường độc lập 5");
            } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                    && id.matches("^\\d+") && !isEditing && !listStudent.isEmpty() && (loop <= 1 || returnValue == true || isDuplicated == false)) {
                test.out("validate()", false, "Đường độc lập 6");
            } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && isEditing && ValidateDate(endate) == 1 && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 7");
            } else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) == 2 && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 8");
            }
        }
    }

    public static void main(String[] args) {
        //Tao test data
        ArrayList<PersonDTO> list1 = new ArrayList<PersonDTO>();
        ArrayList<PersonDTO> list2 = new ArrayList<PersonDTO>();
        ArrayList<PersonDTO> list3 = new ArrayList<PersonDTO>();
        ArrayList<PersonDTO> list4 = new ArrayList<PersonDTO>();
        list2.add(new PersonDTO(1, "Josie", "Le", null, "2022-11-17"));
        list2.add(new PersonDTO(2, "Huong", "Le", null, "2022-11-17"));
        list3.add(new PersonDTO(1, "Nhi", "Bui", null, "2022-11-17"));
        list3.add(new PersonDTO(1, "Giang", "Nguyen", null, "2022-12-17"));
        list4.add(new PersonDTO(2, "Giang", "Nguyen", null, "2022-12-17"));
        //Goi test case
        testListStudent(list2);
        testListStudent(list1);

        testValidate(list3, "1", "Nham", "Phat", "2022-11-12", true);
        testValidate(list2, "", "", "", "", true);
        testValidate(list2, "s", "Nham", "Phat", "2022-11-12", true);
        testValidate(list1, "1", "Le", "Huong", "2022-11-12", false);
        testValidate(list2, "5", "Le", "Huong", "2022-11-12", false);
        testValidate(list2, "1", "Le", "Huong", "2022-11-12", false);
        testValidate(list3, "5", "Nguyen", "Giang", "2022", true);
        testValidate(list4, "6", "Bui", "Nhi", "2022-02-30", true);
        test.result();
    }

}
