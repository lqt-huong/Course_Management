package test;

import java.util.ArrayList;
import DTO.OnlineCourseDTO;

public class TestOnlineCourse {

    private static Test test = new Test();

    private static boolean equals(ArrayList<OnlineCourseDTO> list1, ArrayList<OnlineCourseDTO> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getCourseID() != list2.get(i).getCourseID()
                    || list1.get(i).getTitle() != list2.get(i).getTitle()
                    || list1.get(i).getCredits() != list2.get(i).getCredits()
                    || list1.get(i).getDepartmentID() != list2.get(i).getDepartmentID()
                    || list1.get(i).getUrl() != list2.get(i).getUrl()) {
                return false;
            }
        }
        return true;
    }

    private static void testList(ArrayList<OnlineCourseDTO> result) {
        test.addTest();
        ArrayList<OnlineCourseDTO> list = new ArrayList<OnlineCourseDTO>();
        for (OnlineCourseDTO rs : result) {
            OnlineCourseDTO p = new OnlineCourseDTO();
            p.setCourseID(rs.getCourseID());
            p.setTitle(rs.getTitle());
            p.setCredits(rs.getCredits());
            p.setDepartmentID(rs.getDepartmentID());
            p.setUrl(rs.getUrl());
            list.add(p);
        }
        if (list.isEmpty() && result.isEmpty()) {
            test.out("listOnlineCourse()", true, "Đường độc lập 1");
        } else if (!list.isEmpty() && !result.isEmpty() && equals(result, list)) {
            test.out("listOnlineCourse()", true, "Đường độc lập 2");
        } else {
            if (!list.isEmpty() && result.isEmpty() || list.isEmpty() && equals(result, list)) {
                test.out("listOnlineCourse()", false, "Đường độc lập 1");
            } else if ((!list.isEmpty() && !result.isEmpty()) || (list.isEmpty() && !result.isEmpty())) {
                test.out("listOnlineCourse()", false, "Đường độc lập 2");
            }
        }
    }

    private static void testValidate(ArrayList<OnlineCourseDTO> listOnlCourse, String id, String title, String credits, String depid, String url, boolean isEditing) {
        test.addTest();
        boolean returnValue = true;
        boolean isDuplicated = false;
        int loop = 0;
        boolean pass = false;
        if (id.equals("") || title.equals("") || credits.equals("") || depid.equals("") || url.equals("")) {
            returnValue = false;
        }

        if (!id.matches("^\\d+")) {
            returnValue = false;
        }

        if (!isEditing) {
            for (OnlineCourseDTO p : listOnlCourse) {
                if (id.equals(String.valueOf(p.CourseID))) {
                    returnValue = false;
                    isDuplicated = true;
                }
                loop++;
            }
        }

        if (!credits.matches("^\\d+")) {
            returnValue = false;
        }

        if (Integer.parseInt(credits) < 1) {
            returnValue = false;
        }
        returnValue = true;

        if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && id.matches("^\\d+") && isEditing && credits.matches("^\\d+") && Integer.parseInt(credits) > 1 && returnValue == true) {
            test.out("validate()", true, "Đường độc lập 1");
            pass = true;
        } else if (id.equals("") || title.equals("") || credits.equals("") || depid.equals("") || url.equals("") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 2");
            pass = true;
        } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && !id.matches("^\\d+") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 3");
            pass = true;
        } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && id.matches("^\\d+") && !isEditing && listOnlCourse.isEmpty() && loop <= 1 && returnValue == true && isDuplicated == false) {
            test.out("validate()", true, "Đường độc lập 4");
            pass = true;
        } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && id.matches("^\\d+") && !isEditing && !listOnlCourse.isEmpty() && loop > 1 && returnValue == true && isDuplicated == false) {
            test.out("validate()", true, "Đường độc lập 5");
            pass = true;
        } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && id.matches("^\\d+") && !isEditing && !listOnlCourse.isEmpty() && loop > 1 && returnValue == false && isDuplicated == true) {
            test.out("validate()", true, "Đường độc lập 6");
            pass = true;
        } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && id.matches("^\\d+") && isEditing && !credits.matches("^\\d+") && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 7");
            pass = true;
        } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                && id.matches("^\\d+") && isEditing && credits.matches("^\\d+") && Integer.parseInt(credits) >= 1 && returnValue == false) {
            test.out("validate()", true, "Đường độc lập 8");
            pass = true;
        }
        if (pass == false) {
            if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && id.matches("^\\d+") && isEditing && credits.matches("^\\d+") && Integer.parseInt(credits) > 1 && returnValue == false) {
                test.out("validate()", false, "Đường độc lập 1");
            } else if (id.equals("") || title.equals("") || credits.equals("") || depid.equals("") || url.equals("") && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 2");
            } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && !id.matches("^\\d+") && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 3");
            } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && id.matches("^\\d+") && !isEditing && listOnlCourse.isEmpty() && (loop > 1 || returnValue == false || isDuplicated == true)) {
                test.out("validate()", false, "Đường độc lập 4");
            } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && id.matches("^\\d+") && !isEditing && !listOnlCourse.isEmpty() && (loop <= 1 || returnValue == false || isDuplicated == true)) {
                test.out("validate()", false, "Đường độc lập 5");
            } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && id.matches("^\\d+") && !isEditing && !listOnlCourse.isEmpty() && (loop <= 1 || returnValue == true || isDuplicated == false)) {
                test.out("validate()", false, "Đường độc lập 6");
            } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && id.matches("^\\d+") && isEditing && !credits.matches("^\\d+") && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 7");
            } else if (!id.equals("") && !title.equals("") && !credits.equals("") && !depid.equals("") && !url.equals("")
                    && id.matches("^\\d+") && isEditing && credits.matches("^\\d+") && Integer.parseInt(credits) < 1 && returnValue == true) {
                test.out("validate()", false, "Đường độc lập 8");
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Tạo test data 
        ArrayList<OnlineCourseDTO> list1 = new ArrayList<OnlineCourseDTO>();
        ArrayList<OnlineCourseDTO> list2 = new ArrayList<OnlineCourseDTO>();
        ArrayList<OnlineCourseDTO> list3 = new ArrayList<OnlineCourseDTO>();

        list1.add(new OnlineCourseDTO(9, "Công nghệ phần mềm", 4, 1, "cnpm"));
        list1.add(new OnlineCourseDTO(10, "Thương mại điện tử", 4, 1, "tmdt"));
        list2.add(new OnlineCourseDTO(11, "Toán rời rạc", 3, 2, "trr"));
        list2.add(new OnlineCourseDTO(12, "Lập trình web", 3, 2, "ltw"));

        //Gọi test case
        testList(list1);
        testList(list3);

        testValidate(list1, "13", "Hệ điều hành", "3", "2", "hdh", true);
        //testValidate(list1, "", "", "", "", "", true);
        testValidate(list1, "^", "Hệ điều hành", "3", "2", "hdh", true);
        testValidate(list3, "6", "Công nghệ phần mềm", "4", "1", "cnpm", false);
        testValidate(list1, "9", "Công nghệ phần mềm", "4", "1", "cnpm", false);
        testValidate(list2, "16", "Giáo dục thể chất", "5", "3", "gdtc", false);
        //testValidate(list1, "9", "Công nghệ phần mềm", "^", "1", "cnpm", true);
        testValidate(list1, "9", "Công nghệ phần mềm", "0", "2", "cnpm", true);

        //Tổng kết
        test.result();
    }
}
