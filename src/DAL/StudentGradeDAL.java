/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Lộc
 */
import DTO.StudentGradeDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class StudentGradeDAL {
    private MyConnectUnit connect;
    
    public StudentGradeDAL() {
        connect=DAL.getDAL();
    }
    
    public ArrayList<StudentGradeDTO> list() throws Exception{
        ResultSet result=this.connect.Select("studentgrade");
        ArrayList<StudentGradeDTO> list=new ArrayList<StudentGradeDTO>();
        while(result.next()){
            StudentGradeDTO p=new StudentGradeDTO();
            p.setEnrollmentID(result.getInt("EnrollmentID"));
            p.setCourseID(result.getInt("CourseID"));
            p.setStudentID(result.getInt("StudentID"));
            p.setGrade(result.getFloat("Grade"));
            list.add(p);
        }
        return list;
    }
    
    public void Insert(StudentGradeDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("EnrollmentID", p.getEnrollmentID());
        map.put("CourseID", p.getCourseID());
        map.put("StudentID", p.getStudentID());
        map.put("Grade", p.getGrade());
 
        this.connect.Insert("studentgrade", map);
    }
    
    public void Update(StudentGradeDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("CourseID", p.getCourseID());
        map.put("StudentID", p.getStudentID());
        map.put("Grade", p.getGrade());
 
        this.connect.Update("studentgrade", map, "EnrollmentID = '" + p.getEnrollmentID() + "'");
    }
    
    public void Delete(int id) throws Exception{
        this.connect.Delete("studentgrade", "EnrollmentID = '" + id + "'" );    
    }
}

