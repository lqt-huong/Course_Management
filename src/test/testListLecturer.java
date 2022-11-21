/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import DTO.PersonDTO;
import DAL.PersonDAL;
import java.util.Objects;
import java.util.ArrayList;
import test.Test;


/**
 *
 * @author LENOVO
 */
public class testListLecturer {
    private static Test test = new Test();
    private static boolean equals(ArrayList<PersonDTO> list1, ArrayList<PersonDTO> list2) {
        if(list1.size() != list2.size())
            return false;
        for(int i = 0; i < list1.size(); i++) {
            if(list1.get(i).getPersonID() != list2.get(i).getPersonID() || !list1.get(i).getFirstname().equals(list2.get(i).getFirstname())
                    || !list1.get(i).getLastname().equals(list2.get(i).getLastname())
                    || !list1.get(i).getHireDate().equals(list2.get(i).getHireDate()))
                return false;
        }
        return true;
        
    }
    
    private static void testListLecturer(ArrayList<PersonDTO> result) {
        test.addTest();
        ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
        for(PersonDTO rsDTO: result){
            PersonDTO ps = new PersonDTO();
            ps.setPersonID(rsDTO.getPersonID());
            ps.setLastname(rsDTO.getLastname());
            ps.setFirstname(rsDTO.getFirstname());
            ps.setHireDate(rsDTO.getHireDate());
            list.add(ps);
        }
        if(!list.isEmpty() && !result.isEmpty() && equals(result, list))
            test.out("listLecturer()", true, "Đường độc lập 1: S1-S2-C1-S3-S4-S5-S6-S7-S8-C1");
        else if(list.isEmpty() && result.isEmpty())
            test.out("listLecturer()", true, "Đường độc lập 2: S1-S2-C1-S9");
        else{
            if(!list.isEmpty() && !result.isEmpty() || list.isEmpty() && equals(result, list))
                test.out("listLecturer()", false, "Đường độc lập 1");
            else if(list.isEmpty() && !result.isEmpty() || !list.isEmpty() && result.isEmpty())
                test.out("listLecturer()", false, "Đường độc lập 2");
        }
        
        
    }
    
    private static boolean isLeapYear(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            return true;
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

    public static void testValidate(ArrayList<PersonDTO> listLecturer, String id, String lastname, String firstname, String endate, boolean isEditing) {
        test.addTest();
        boolean returnValue = true;
        boolean isDuplicated = false;
        int loop = 0;
        boolean passed = false;
        if (id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("")) 
            returnValue = false;

        if (!id.matches("^\\d+"))
            returnValue = false;

        if (!isEditing) {
            for (PersonDTO p : listLecturer) {
                if (id.equals(String.valueOf(p.PersonID))) {
                    returnValue = false;
                    isDuplicated = true;
                }
                loop++;
            }
        }

        if (ValidateDate(endate) == 1) 
            returnValue = false;
        else if (ValidateDate(endate) == 2) 
            returnValue = false;
        
        if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) != 2 && returnValue == true) {
            test.out("validate()", true, "Đường độc lập 1: S1-S2-S3-S4-S5-C1-C2-C3-C6-C7-S16");
            passed = true;
        } 
        else if (id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 2: S1-S2-S3-S4-S5-C1-S6-S7");
            passed = true;
        } 
        else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && !id.matches("^\\d+") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 3: S1-S2-S3-S4-S5-C1-C2-S8-S9");
            passed = true;
        } 
        else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && !isEditing && listLecturer.isEmpty() && returnValue == true && isDuplicated == false && loop < 1) {
            test.out("validate()", true, "Đường độc lập 4: S1-S2-S3-S4-S5-C1-C2-C3-C4-C3");
            passed = true;
        } 
        else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                && id.matches("^\\d+") && !isEditing && !listLecturer.isEmpty() && loop > 1 && returnValue == true && isDuplicated == false) {
            test.out("validate()", true, "Đường độc lập 5: S1-S2-S3-S4-S5-C1-C2-C3-C4-C5-C4");
            passed = true;
        } 
        else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                && id.matches("^\\d+") && !isEditing && !listLecturer.isEmpty() && loop > 1 && returnValue == false && isDuplicated == true) {
            test.out("validate()", true, "Đường độc lập 6: S1-S2-S3-S4-S5-C1-C2-C3-C4-C5-S10-S11");
            passed = true;
        } 
        else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && isEditing && ValidateDate(endate) == 1 && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 7: S1-S2-S3-S4-S5-C1-C2-C3-C6-S12-S13");
            passed = true;
        } 
        else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) == 2 && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 8: S1-S2-S3-S4-S5-C1-C2-C3-C6-C7-S14-S15");
            passed = true;
        }

        if (passed == false) {
            if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) != 2 && returnValue == true) 
                test.out("validate()", false, "Đường độc lập 1");            
            else if (id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("") && returnValue == true) 
                test.out("validate()", false, "Đường độc lập 2");
            else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && !id.matches("^\\d+") && returnValue == true) 
                test.out("validate()", false, "Đường độc lập 3");            
            else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && !isEditing && listLecturer.isEmpty() && (returnValue == false || isDuplicated == true || loop >= 1)) 
                test.out("validate()", false, "Đường độc lập 4");
            else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                    && id.matches("^\\d+") && !isEditing && !listLecturer.isEmpty() && (loop <= 1 || returnValue == false || isDuplicated == true)) 
                test.out("validate()", false, "Đường độc lập 5"); 
            else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals(""))
                    && id.matches("^\\d+") && !isEditing && !listLecturer.isEmpty() && (loop <= 1 || returnValue == true || isDuplicated == false)) 
                test.out("validate()", false, "Đường độc lập 6"); 
            else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && isEditing && ValidateDate(endate) == 1 && returnValue == true) 
                test.out("validate()", false, "Đường độc lập 7");
            else if ((!id.equals("") && !lastname.equals("") && !firstname.equals("") && !endate.equals("")) && id.matches("^\\d+")
                    && isEditing && ValidateDate(endate) != 1 && ValidateDate(endate) == 2 && returnValue == true)
                test.out("validate()", false, "Đường độc lập 8");
        }
    }

    public static void main(String[] args) {
        
//Tao test data
        
        ArrayList<PersonDTO> list1 = new ArrayList<PersonDTO>();
        ArrayList<PersonDTO> list2 = new ArrayList<PersonDTO>();
        ArrayList<PersonDTO> list3 = new ArrayList<PersonDTO>();
        ArrayList<PersonDTO> list4 = new ArrayList<PersonDTO>();
        list1.add(new PersonDTO(1, "Huong", "Thien", "2020-11-12", null));
        list1.add(new PersonDTO(2, "Huong", "Le", "2020-11-12", null));
        list3.add(new PersonDTO(1, "Nhi", "Yen", "2012-10-11", null));
        list3.add(new PersonDTO(1, "Giang", "Nguyen", "2022-12-11", null));
        list4.add(new PersonDTO(2, "Giang", "Nguyen", "2022-12-11", null));
        
//Goi test case

    //test list
    
        testListLecturer(list1);
        testListLecturer(list2);
        
    //test validate

        testValidate(list3, "1", "Nham", "Phat", "2022-11-12", true);
        testValidate(list1, "", "", "", "", true);
        testValidate(list1, "mot", "Nham", "Phat", "2022-11-12", true);
        testValidate(list2, "1", "Le", "Huong", "2022-11-12", false);
        testValidate(list1, "5", "Le", "Huong", "2022-11-17", false);
        testValidate(list1, "1", "Le", "Huong", "2022-11-17", false);
        testValidate(list3, "5", "Nguyen", "Giang", "11", true);
        testValidate(list4, "6", "Bui", "Nhi", "2022-01-32", true);
        test.result();
    
    }
    
    
}
