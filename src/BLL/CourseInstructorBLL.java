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
import DAL.CourseInstructorDAL;
import DTO.CourseInstructorDTO;
import java.util.ArrayList;

public class CourseInstructorBLL {
    private ArrayList<CourseInstructorDTO> list;
    
    public CourseInstructorBLL(){

    }    
    
    public ArrayList<CourseInstructorDTO> getList(){
        return list;
    }
    
    public void list() throws Exception {
        CourseInstructorDAL coursedal=new CourseInstructorDAL();
        list=new ArrayList<CourseInstructorDTO>();
        list=coursedal.list();   
    }
    
    public void Add(CourseInstructorDTO p) throws Exception {
        list.add(p);
        CourseInstructorDAL coursedal=new CourseInstructorDAL();
        coursedal.Insert(p);
    }
    
    public void Edit(CourseInstructorDTO p, CourseInstructorDTO old) throws Exception {
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getCourseID()==old.getCourseID()
                    && list.get(i).getPersonID()==old.getPersonID()) {
                list.set(i, p);
                CourseInstructorDAL coursedal = new CourseInstructorDAL();
                coursedal.Update(p, old);
                return;
            }
        }
    }
    
    public ArrayList<CourseInstructorDTO> Search(String CourseID, String PersonID) {
        ArrayList<CourseInstructorDTO> res=new ArrayList<CourseInstructorDTO>(); 	//S1
        boolean course=false, person=false;											//S2,S3
        
        if(CourseID.equals(""))														//C1
            course=true;															//S4
        if(PersonID.equals(""))														//C2
            person=true;															//S5
        
        for(CourseInstructorDTO p: list){												//C3
            if(!CourseID.equals(""))													//C4
                course=(p.getCourseID()==Integer.parseInt(CourseID)) ? true : false;	//C5,S6,S7
            if(!PersonID.equals(""))													//C6
                person=(p.getPersonID()==Integer.parseInt(PersonID)) ? true : false;	//C7,S8,S9
            if(course && person)														//C8
                res.add(p);																//S10
        }
        return res;																		//S11
    }
    
    public void Remove(int CourseID, int PersonID) throws Exception {
        for(CourseInstructorDTO p: list) {
            if(p.getCourseID()==CourseID && p.getPersonID()==PersonID) {
                list.remove(p);
                CourseInstructorDAL coursedal = new CourseInstructorDAL();
                coursedal.Delete(CourseID, PersonID);
                return;
            }
        }
    }
    
}
