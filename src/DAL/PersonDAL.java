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
import DTO.PersonDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class PersonDAL {
    private MyConnectUnit connect;
    
    public PersonDAL() {
        connect=DAL.getDAL();
    }
    
    public ArrayList<Integer> getAllPersonID() throws Exception{
        ResultSet result=this.connect.Select("person");
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(result.next()){
            list.add(result.getInt("PersonID"));
        }
        return list;
    }
    
    public ArrayList<PersonDTO> listStudent() throws Exception{
        ResultSet result=this.connect.Select("person", "EnrollmentDate IS NOT NULL");       //S1
        ArrayList<PersonDTO> list=new ArrayList<PersonDTO>();       //S2
        while(result.next()){       //C1
            PersonDTO p=new PersonDTO();        //S3
            p.setPersonID(result.getInt("PersonID"));       //S4
            p.setLastname(result.getString("LastName"));        //S5
            p.setFirstname(result.getString("FirstName"));      //S6
            p.setEnrollmentDate(result.getString("EnrollmentDate"));        //S7
            list.add(p);        //S8
        }
        return list;        //S9
    }
    
    public ArrayList<PersonDTO> listLecturer() throws Exception{
        ResultSet result=this.connect.Select("person", "HireDate IS NOT NULL");
        ArrayList<PersonDTO> list=new ArrayList<PersonDTO>();
        while(result.next()){
            PersonDTO p=new PersonDTO();
            p.setPersonID(result.getInt("PersonID"));
            p.setLastname(result.getString("LastName"));
            p.setFirstname(result.getString("FirstName"));
            p.setHireDate(result.getString("HireDate"));
            list.add(p);
        }
        return list;
    }
    
    public void InsertStudent(PersonDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("PersonID", p.getPersonID());
        map.put("LastName", p.getLastname());
        map.put("FirstName", p.getFirstname());
        map.put("EnrollmentDate", p.getEnrollmentDate());
 
        this.connect.Insert("person", map);
    }
    
    public void InsertLecturer(PersonDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("PersonID", p.getPersonID());
        map.put("LastName", p.getLastname());
        map.put("FirstName", p.getFirstname());
        map.put("HireDate", p.getHireDate());
 
        this.connect.Insert("person", map);
    }
    
    public void UpdateStudent(PersonDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("LastName", p.getLastname());
        map.put("FirstName", p.getFirstname());
        map.put("EnrollmentDate", p.getEnrollmentDate());
 
        this.connect.Update("person", map, "PersonID = '" + p.getPersonID() + "'");
    }
    
    public void UpdateLecturer(PersonDTO p) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("LastName", p.getLastname());
        map.put("FirstName", p.getFirstname());
        map.put("HireDate", p.getHireDate());
 
        this.connect.Update("person", map, "PersonID = '" + p.getPersonID() + "'");
    }
    
    public void Delete(int id) throws Exception{
        this.connect.Delete("person", "PersonID = '" + id + "'" );    
    }
}

