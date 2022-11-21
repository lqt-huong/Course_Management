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
import DAL.CourseDAL;
import DTO.OnlineCourseDTO;
import DTO.OnsiteCourseDTO;
import java.util.ArrayList;

public class CourseBLL {
    private ArrayList<OnlineCourseDTO> listOnline;
    private ArrayList<OnsiteCourseDTO> listOnsite;
    
    public CourseBLL(){

    }

    public ArrayList<Integer> getAllCourseID() throws Exception{
        ArrayList<Integer> list=new ArrayList<Integer>();
        CourseDAL coursedal=new CourseDAL();
        list=coursedal.getAllCourseID();
        return list;
    } 
   
    public void listOnline() throws Exception {
        CourseDAL coursedal=new CourseDAL();
        listOnline=new ArrayList<OnlineCourseDTO>();
        listOnline=coursedal.listOnline();   
    }
    
    public void listOnsite() throws Exception {
        CourseDAL coursedal=new CourseDAL();
        listOnsite=new ArrayList<OnsiteCourseDTO>();
        listOnsite=coursedal.listOnsite();   
    }
    
    public ArrayList<OnlineCourseDTO> getListOnline(){
        return listOnline;
    }
    
    public ArrayList<OnsiteCourseDTO> getListOnsite(){
        return listOnsite;
    }
    
    public void AddOnline(OnlineCourseDTO p) throws Exception {
        listOnline.add(p);
        CourseDAL coursedal=new CourseDAL();
        coursedal.InsertOnline(p);
    }
    
    public void AddOnsite(OnsiteCourseDTO p) throws Exception {
        listOnsite.add(p);
        CourseDAL coursedal=new CourseDAL();
        coursedal.InsertOnsite(p);
    }
    
    public void EditOnline(OnlineCourseDTO p) throws Exception {
        for(int i=0;i<listOnline.size();i++) {
            if(listOnline.get(i).getCourseID()==p.getCourseID()) {
                listOnline.set(i, p);
                CourseDAL coursedal = new CourseDAL();
                coursedal.UpdateOnline(p);
                return;
            }
        }
    }
    
    public void EditOnsite(OnsiteCourseDTO p) throws Exception {
        for(int i=0;i<listOnsite.size();i++) {
            if(listOnsite.get(i).getCourseID()==p.getCourseID()) {
                listOnsite.set(i, p);
                CourseDAL coursedal = new CourseDAL();
                coursedal.UpdateOnsite(p);
                return;
            }
        }
    }
    
    public ArrayList<OnlineCourseDTO> SearchOnline(String CourseID, String Title, String Credits, String DepartmentID, String URL) {
        ArrayList<OnlineCourseDTO> res=new ArrayList<OnlineCourseDTO>();
        boolean id=false, title=false, credits=false, depid=false, url=false;
        
        if(CourseID.equals(""))
            id=true;
        if(Title.equals(""))
            title=true;
        if(Credits.equals(""))
            credits=true;
        if(DepartmentID.equals(""))
            depid=true;
        if(URL.equals(""))
            url=true;
        
        for(OnlineCourseDTO p: listOnline){
            if(!CourseID.equals(""))
                id=(p.getCourseID()==Integer.parseInt(CourseID)) ? true : false;
            if(!Title.equals(""))
                title=(p.getTitle().contains(Title)) ? true : false;
            if(!Credits.equals(""))
                credits=(p.getCredits()==Integer.parseInt(Credits)) ? true : false;
            if(!DepartmentID.equals(""))
                depid=(p.getDepartmentID()==Integer.parseInt(DepartmentID)) ? true : false;
            if(!URL.equals(""))
                url=(p.getUrl().toString().contains(URL)) ? true : false;
            if(id && title && credits && depid && url)
                res.add(p);
        }
        return res;
    }
    
    public ArrayList<OnsiteCourseDTO> SearchOnsite(String CourseID, String Title, String Credits, String DepartmentID, String Location, String Days, String Time) {
        ArrayList<OnsiteCourseDTO> res=new ArrayList<OnsiteCourseDTO>();
        boolean id=false, title=false, credits=false, depid=false, location=false, days=false, time=false;
        
        if(CourseID.equals(""))
            id=true;
        if(Title.equals(""))
            title=true;
        if(Credits.equals(""))
            credits=true;
        if(DepartmentID.equals(""))
            depid=true;
        if(Location.equals(""))
            location=true;
        if(Days.equals(""))
            days=true;
        if(Time.equals(""))
            time=true;
        
        for(OnsiteCourseDTO p: listOnsite){
            if(!CourseID.equals(""))
                id=(p.getCourseID()==Integer.parseInt(CourseID)) ? true : false;
            if(!Title.equals(""))
                title=(p.getTitle().contains(Title)) ? true : false;
            if(!Credits.equals(""))
                credits=(p.getCredits()==Integer.parseInt(Credits)) ? true : false;
            if(!DepartmentID.equals(""))
                depid=(p.getDepartmentID()==Integer.parseInt(DepartmentID)) ? true : false;
            if(!Location.equals(""))
                location=(p.getLocation().toString().contains(Location)) ? true : false;
            if(!Days.equals(""))
                days=(p.getDays().toString().contains(Days)) ? true : false;
            if(!Time.equals(""))
                time=(p.getTime().toString().contains(Time)) ? true : false;
            if(id && title && credits && depid && location && days && time)
                res.add(p);
        }
        return res;
    }
    
    public ArrayList<OnlineCourseDTO> SearchOnlineForSelect(String input) throws Exception {
        listOnline();
        ArrayList<OnlineCourseDTO> res=new ArrayList<OnlineCourseDTO>();
        
        for(OnlineCourseDTO p: listOnline){
            if(String.valueOf(p.getCourseID()).contains(input)
                    || p.getTitle().contains(input)
                    || String.valueOf(p.getCredits()).contains(input)
                    || p.getUrl().contains(input)
                    || String.valueOf(p.getDepartmentID()).contains(input))
                res.add(p);
        }
        return res;
    }
    
    public ArrayList<OnsiteCourseDTO> SearchOnsiteForSelect(String input) throws Exception {
        listOnline();
        ArrayList<OnsiteCourseDTO> res=new ArrayList<OnsiteCourseDTO>();
        
        for(OnsiteCourseDTO p: listOnsite){
            if(String.valueOf(p.getCourseID()).contains(input)
                    || p.getTitle().contains(input)
                    || String.valueOf(p.getCredits()).contains(input)
                    || String.valueOf(p.getDepartmentID()).contains(input)
                    || p.getLocation().contains(input)
                    || p.getDays().contains(input)
                    || p.getTime().contains(input))
                res.add(p);
        }
        return res;
    }
    
    public void RemoveOnline(int id) throws Exception {
        for(OnlineCourseDTO p: listOnline) {
            if(p.getCourseID()==id) {
                listOnline.remove(p);
                CourseDAL coursedal = new CourseDAL();
                coursedal.DeleteOnline(id);
                return;
            }
        }
    }
    
    public void RemoveOnsite(int id) throws Exception {
        for(OnsiteCourseDTO p: listOnsite) {
            if(p.getCourseID()==id) {
                listOnsite.remove(p);
                CourseDAL coursedal = new CourseDAL();
                coursedal.DeleteOnsite(id);
                return;
            }
        }
    }
    
}
