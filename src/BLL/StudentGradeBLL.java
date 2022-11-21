/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Lộc
 */
import DAL.StudentGradeDAL;
import DTO.StudentGradeDTO;
import java.util.ArrayList;

public class StudentGradeBLL {
    private ArrayList<StudentGradeDTO> list;
    
    public StudentGradeBLL(){

    }    
    
    public ArrayList<StudentGradeDTO> getList(){
        return list;
    }
    
    public void list() throws Exception {
        StudentGradeDAL gradedal=new StudentGradeDAL();
        list=new ArrayList<StudentGradeDTO>();
        list=gradedal.list();   
    }
    
    public void Add(StudentGradeDTO p) throws Exception {
        list.add(p);
        StudentGradeDAL gradedal=new StudentGradeDAL();
        gradedal.Insert(p);
    }
    
    public void Edit(StudentGradeDTO p) throws Exception {
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getEnrollmentID()==p.getEnrollmentID()) {
                list.set(i, p);
                StudentGradeDAL gradedal = new StudentGradeDAL();
                gradedal.Update(p);
                return;
            }
        }
    }
    
    public ArrayList<StudentGradeDTO> Search(String EnrollmentID, String CourseID, String StudentID, String Grade) {
        ArrayList<StudentGradeDTO> res=new ArrayList<StudentGradeDTO>();
        boolean id=false, course=false, student=false, grade=false;
        
        if(EnrollmentID.equals(""))
            id=true;
        if(CourseID.equals(""))
            course=true;
        if(StudentID.equals(""))
            student=true;
        if(Grade.equals(""))
            grade=true;
        
        for(StudentGradeDTO p: list){
            if(!EnrollmentID.equals(""))
                id=(p.getEnrollmentID()==Integer.parseInt(EnrollmentID)) ? true : false;
            if(!CourseID.equals(""))
                course=(p.getCourseID()==Integer.parseInt(CourseID)) ? true : false;
            if(!StudentID.equals(""))
                student=(p.getStudentID()==Integer.parseInt(StudentID)) ? true : false;
            if(!Grade.equals(""))
                grade=(p.getGrade()==Float.parseFloat(Grade)) ? true : false;
            if(id && course && student && grade)
                res.add(p);
        }
        return res;
    }
    
    public void Remove(int id) throws Exception {
        for(StudentGradeDTO p: list) {
            if(p.getEnrollmentID()==id) {
                list.remove(p);
                StudentGradeDAL gradedal = new StudentGradeDAL();
                gradedal.Delete(id);
                return;
            }
        }
    }
    
}
