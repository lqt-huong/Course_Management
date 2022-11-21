package test;

import java.util.ArrayList;
import java.util.Objects;

import DAL.CourseInstructorDAL;
import DTO.CourseInstructorDTO;
import test.Test;

public class TestCourseInstructor {
	private static Test test = new Test();
	
	private static boolean equals(ArrayList<CourseInstructorDTO> list1, ArrayList<CourseInstructorDTO> list2) {
		if (list1.size()!=list2.size())
			return false;
		for (int i = 0 ; i < list1.size() ; i++) {
			if (list1.get(i).getCourseID() != list2.get(i).getCourseID() ||
					list1.get(i).getPersonID() != list2.get(i).getPersonID())
				return false;
		}
		return true;
	}
	
	private static void testList(ArrayList<CourseInstructorDTO> result) {
		test.addTest();
		ArrayList<CourseInstructorDTO> list = new ArrayList<CourseInstructorDTO>();
		result.forEach(rs -> {
			CourseInstructorDTO p = new CourseInstructorDTO();
			p.setCourseID(rs.getCourseID());
			p.setPersonID(rs.getPersonID());
			list.add(p);
		});
		
		if (list.isEmpty() && result.isEmpty()) {
			test.out("list()", true, "Duong doc lap 1");
		}
		else if (!result.isEmpty() && !list.isEmpty() && equals(result,list)) {
			test.out("list()", true, "Duong doc lap 2");
		}
		else {
			if ((!list.isEmpty() && result.isEmpty()) ||
					(list.isEmpty() && !result.isEmpty()))
				test.out("list()", false, "Duong doc lap 1");
			else if (!result.isEmpty() && !list.isEmpty() && !equals(result,list))
				test.out("list()", false, "Duong doc lap 2");
		}
	}
	
	private static void testValidate(ArrayList<CourseInstructorDTO> instructor, String course, String person) {
		test.addTest();
		boolean returnValue = true;
		boolean isDuplicated = false;
		int loop = 0;
		
		if (person.equals("") || course.equals("")) {
			returnValue = false;
		}
		
		for (CourseInstructorDTO p : instructor) {
			if (course.equals(String.valueOf(p.getCourseID()))
					&& person.equals(String.valueOf(p.getPersonID()))) {
				returnValue = false;
				isDuplicated = true;
			}
			loop++;
		}
		
		if ((person.equals("") || course.equals("")) && returnValue == false) {
			test.out("validate()", true, "Duong doc lap 1");
		}
		else if (!person.equals("") && !course.equals("") && instructor.isEmpty() && returnValue == true) {
			test.out("validate()", true, "Duong doc lap 2");
		}
		else if (!person.equals("") && !course.equals("") && instructor.size()>1 && loop > 1 && isDuplicated == false) {
			test.out("validate()", true, "Duong doc lap 3");
		}
		else if (!person.equals("") && !course.equals("") && isDuplicated == true && returnValue == false) {
			test.out("validate()", true, "Duong doc lap 4");
		}
		
		if ((person.equals("") || course.equals("")) && returnValue == true) {
			test.out("validate()", false, "Duong doc lap 1");
		}
		else if (!person.equals("") && !course.equals("") && instructor.isEmpty() && returnValue == false) {
			test.out("validate()", false, "Duong doc lap 2");
		}
		else if (!person.equals("") && !course.equals("") && instructor.size()>1 && loop <= 1 && isDuplicated == false) {
			test.out("validate()", false, "Duong doc lap 3");
		}
		else if (!person.equals("") && !course.equals("") && isDuplicated == true && returnValue == true) {
			test.out("validate()", false, "Duong doc lap 4");
		}
	}
	
	private static void testSearch(ArrayList<CourseInstructorDTO> list, String CourseID, String PersonID) {
		test.addTest();
		ArrayList<CourseInstructorDTO> res= new ArrayList<CourseInstructorDTO>();
		boolean course = false, person = false;
		int loop = 0;
		boolean passed = false;
		
		if (CourseID.equals(""))
			course = true;
		if (PersonID.equals(""))
			person = true;
		
		for (CourseInstructorDTO p : list) {
			if(!CourseID.equals(""))													
                course=(p.getCourseID()==Integer.parseInt(CourseID)) ? true : false;	
            if(!PersonID.equals(""))													
                person=(p.getPersonID()==Integer.parseInt(PersonID)) ? true : false;	
            if(course && person)														
                res.add(p);	
            loop++;
		}
		
		//person == true,course == true, res.add| CourseID!="", PersonID == "", list is not empty
		if (person==true && course == true && res.isEmpty() == false && !CourseID.equals("") && PersonID.equals("")) {
			test.out("search()", true, "Duong doc lap 1");
			passed = true;
		}//course==true,person==true,res.add| CourseID=="", PersonID!="", res is not empty| list is not empty
		else if (course==true && person == true && !PersonID.equals("") && CourseID.equals("") && res.isEmpty() == false) {
			test.out("search()", true, "Duong doc lap 2");
			passed = true;
		}//course==false, person==false, loop > 1, res is empty| CourseID != "", PersonID != "", list.size()>1
		else if (!CourseID.equals("") && !PersonID.equals("") && course==false && person==false && res.isEmpty() == true
				&& loop > 1) {
			test.out("search()", true, "Duong doc lap 3");
			passed = true;
		}//res is empty|CourseID=="", PersonID=="", list is empty
		else if (CourseID.equals("") && PersonID.equals("") && res.isEmpty() == true) {
			test.out("search()", true, "Duong doc lap 4");
			passed = true;
		}//loop > 1| list.size() > 1 | CourseID=="", PersonID==""
		else if (loop > 1) {
			test.out("search()", true, "Duong doc lap 5");
			passed = true;
		}
		
		if (passed == false) {
			//res
			if (person==true && course == true && res.isEmpty() == true && !CourseID.equals("") && PersonID.equals("")) {
				test.out("search()", false, "Duong doc lap 1");
			}//res
			else if (course==true && person == true && !PersonID.equals("") && CourseID.equals("") && res.isEmpty() == true) {
				test.out("search()", false, "Duong doc lap 2");
			}//loop, res
			else if (!CourseID.equals("") && !PersonID.equals("") && course==false && person==false && res.isEmpty() == false
					|| loop <= 1) {
				test.out("search()", false, "Duong doc lap 3");
			}//res
			else if (CourseID.equals("") && PersonID.equals("") && res.isEmpty() == false) {
				test.out("search()", true, "Duong doc lap 4");
			}//loop
			else if (loop <= 1) {
				test.out("search()", true, "Duong doc lap 5");
			}
		}
	}
	
	public static void main(String[] args) {
		//Tao test data
		ArrayList<CourseInstructorDTO> list1 = new ArrayList<CourseInstructorDTO>();
		ArrayList<CourseInstructorDTO> list2 = new ArrayList<CourseInstructorDTO>();
		ArrayList<CourseInstructorDTO> list3 = new ArrayList<CourseInstructorDTO>();
		list2.add(new CourseInstructorDTO(1,2));
		list2.add(new CourseInstructorDTO(3,2));
		list3.add(new CourseInstructorDTO(1,2));
		list3.add(new CourseInstructorDTO(1,3));
		
		//Goi test case
		testList(list1);
		testList(list2);
		
		testValidate(list2,"","");
		testValidate(list1,"2","3");
		testValidate(list2,"2","3");
		testValidate(list2,"1","2");
		
		testSearch(list3,"1","");
		testSearch(list2,"","2");
		testSearch(list2,"4","4");
		testSearch(list1,"","");
		testSearch(list2,"","");
		
		//Tong ket
		test.result();
	}
}
