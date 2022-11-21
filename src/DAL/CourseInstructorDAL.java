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
import DTO.CourseInstructorDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class CourseInstructorDAL {
    private MyConnectUnit connect;
    
    public CourseInstructorDAL() {
        connect=DAL.getDAL();
    }
    
    public ArrayList<CourseInstructorDTO> list() throws Exception{
        ResultSet result=this.connect.Select("courseinstructor");     				//S1
        ArrayList<CourseInstructorDTO> list=new ArrayList<CourseInstructorDTO>();	//S2
        while(result.next()){			//C1
            CourseInstructorDTO p=new CourseInstructorDTO();	//S3
            p.setCourseID(result.getInt("CourseID"));			//S4
            p.setPersonID(result.getInt("PersonID"));			//S5
            list.add(p);										//S6
        }
        return list;											//S7
    }
    
    public void Insert(CourseInstructorDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("CourseID", p.getCourseID());
        map.put("PersonID", p.getPersonID());
 
        this.connect.Insert("courseinstructor", map);
    }
    
    public void Update(CourseInstructorDTO p, CourseInstructorDTO old) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("CourseID", p.getCourseID());
        map.put("PersonID", p.getPersonID());
 
        this.connect.Update("courseinstructor", map, "CourseID = '" + old.getCourseID() + "' AND " + "PersonID = '" + old.getPersonID() + "'");
    }
    
    public void Delete(int CourseID, int PersonID) throws Exception{
        this.connect.Delete("courseinstructor", "CourseID = '" + CourseID + "' AND " + "PersonID = '" + PersonID + "'" );    
    }
}

