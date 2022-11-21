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
import DTO.OnlineCourseDTO;
import DTO.OnsiteCourseDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class CourseDAL {
    private MyConnectUnit connect;
    
    public CourseDAL() {
        connect=DAL.getDAL();
    }
    
    public ArrayList<Integer> getAllCourseID() throws Exception{
        ResultSet result=this.connect.Select("course", null, null);
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(result.next()){
            list.add(result.getInt("CourseID"));
        }
        return list;
    }
    
    public ArrayList<OnlineCourseDTO> listOnline() throws Exception{
        ResultSet result=this.connect.Select("course AS c, onlinecourse AS o", "c.CourseID = o.CourseID");
        ArrayList<OnlineCourseDTO> list=new ArrayList<OnlineCourseDTO>();
        while(result.next()){
            OnlineCourseDTO p=new OnlineCourseDTO();
            p.setCourseID(result.getInt("CourseID"));
            p.setTitle(result.getString("Title"));
            p.setCredits(result.getInt("Credits"));
            p.setDepartmentID(result.getInt("DepartmentID"));
            p.setUrl(result.getString("URL"));
            list.add(p);
        }
        return list;
    }
    
    public ArrayList<OnsiteCourseDTO> listOnsite() throws Exception{
        ResultSet result=this.connect.Select("course AS c, onsitecourse AS o", "c.CourseID = o.CourseID");
        ArrayList<OnsiteCourseDTO> list=new ArrayList<OnsiteCourseDTO>();
        while(result.next()){
            OnsiteCourseDTO p=new OnsiteCourseDTO();
            p.setCourseID(result.getInt("CourseID"));
            p.setTitle(result.getString("Title"));
            p.setCredits(result.getInt("Credits"));
            p.setDepartmentID(result.getInt("DepartmentID"));
            p.setLocation(result.getString("Location"));
            p.setDays(result.getString("Days"));
            p.setTime(result.getString("Time"));
            list.add(p);
        }
        return list;
    }
    
    public void InsertOnline(OnlineCourseDTO p) throws Exception{
        HashMap<String, Object> course=new HashMap<String, Object>();
        
        course.put("CourseID", p.getCourseID());
        course.put("Title", p.getTitle());
        course.put("Credits", p.getCredits());
        course.put("DepartmentID", p.getDepartmentID());
 
        this.connect.Insert("course", course);
        
        HashMap<String, Object> onCourse=new HashMap<String, Object>();
        
        onCourse.put("CourseID", p.getCourseID());
        onCourse.put("URL", p.getUrl());
 
        this.connect.Insert("onlinecourse", onCourse);
    }
    
    public void InsertOnsite(OnsiteCourseDTO p) throws Exception{
        HashMap<String, Object> course=new HashMap<String, Object>();
        
        course.put("CourseID", p.getCourseID());
        course.put("Title", p.getTitle());
        course.put("Credits", p.getCredits());
        course.put("DepartmentID", p.getDepartmentID());
 
        this.connect.Insert("course", course);
        
        HashMap<String, Object> onCourse=new HashMap<String, Object>();
        
        onCourse.put("CourseID", p.getCourseID());
        onCourse.put("Location", p.getLocation());
        onCourse.put("Days", p.getDays());
        onCourse.put("Time", p.getTime());
 
        this.connect.Insert("onsitecourse", onCourse);
    }
    
    public void UpdateOnline(OnlineCourseDTO p) throws Exception{
        HashMap<String, Object> course=new HashMap<String, Object>();
        
        course.put("Title", p.getTitle());
        course.put("Credits", p.getCredits());
        course.put("DepartmentID", p.getDepartmentID());
 
        this.connect.Update("course", course, "CourseID = '" + p.getCourseID() + "'");
        
        HashMap<String, Object> onCourse=new HashMap<String, Object>();
        
        onCourse.put("URL", p.getUrl());
        
        this.connect.Update("onlinecourse", onCourse, "CourseID = '" + p.getCourseID() + "'");
    }
    
    public void UpdateOnsite(OnsiteCourseDTO p) throws Exception{
        HashMap<String, Object> course=new HashMap<String, Object>();
        
        course.put("Title", p.getTitle());
        course.put("Credits", p.getCredits());
        course.put("DepartmentID", p.getDepartmentID());
 
        this.connect.Update("course", course, "CourseID = '" + p.getCourseID() + "'");
        
        HashMap<String, Object> onCourse=new HashMap<String, Object>();
        
        onCourse.put("Location", p.getLocation());
        onCourse.put("Days", p.getDays());
        onCourse.put("Time", p.getTime());
        
        this.connect.Update("onsitecourse", onCourse, "CourseID = '" + p.getCourseID() + "'");
    }
    
    public void DeleteOnline(int id) throws Exception{
        this.connect.Delete("onlinecourse", "CourseID = '" + id + "'" );
        this.connect.Delete("course", "CourseID = '" + id + "'" );
    }
    
    public void DeleteOnsite(int id) throws Exception{
        this.connect.Delete("onsitecourse", "CourseID = '" + id + "'" );
        this.connect.Delete("course", "CourseID = '" + id + "'" );
    }
}

