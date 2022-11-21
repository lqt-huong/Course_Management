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
import DAL.PersonDAL;
import DTO.PersonDTO;
import java.util.ArrayList;

public class PersonBLL {
    private ArrayList<PersonDTO> list;
    
    public PersonBLL(){

    }    
    
    public ArrayList<Integer> getAllPersonID() throws Exception{
        ArrayList<Integer> listAll=new ArrayList<Integer>();
        PersonDAL persondal=new PersonDAL();
        listAll=persondal.getAllPersonID();  
        return listAll;
    }
    
    public ArrayList<PersonDTO> getList(){
        return list;
    }
    
    public void listStudent() throws Exception {
        PersonDAL persondal=new PersonDAL();
        list=new ArrayList<PersonDTO>();
        list=persondal.listStudent();   
    }
    
    public void listLecturer() throws Exception {
        PersonDAL persondal=new PersonDAL();
        list=new ArrayList<PersonDTO>();
        list=persondal.listLecturer();   
    }
    
    public void AddStudent(PersonDTO p) throws Exception {
        list.add(p);
        PersonDAL persondal=new PersonDAL();
        persondal.InsertStudent(p);
    }
    
    public void AddLecturer(PersonDTO p) throws Exception {
        list.add(p);
        PersonDAL persondal=new PersonDAL();
        persondal.InsertLecturer(p);
    }
    
    public void EditStudent(PersonDTO p) throws Exception {
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getPersonID()==p.getPersonID()) {
                list.set(i, p);
                PersonDAL persondal = new PersonDAL();
                persondal.UpdateStudent(p);
                return;
            }
        }
    }
    
    public void EditLecturer(PersonDTO p) throws Exception {
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getPersonID()==p.getPersonID()) {
                list.set(i, p);
                PersonDAL persondal = new PersonDAL();
                persondal.UpdateLecturer(p);
                return;
            }
        }
    }
    
    public ArrayList<PersonDTO> Search(String PersonID, String LastName, String FirstName, String HireDate, String EnrollmentDate) {
        ArrayList<PersonDTO> res=new ArrayList<PersonDTO>();
        boolean id=false, lastname=false, firstname=false, hiredate=false, endate=false;
        
        if(PersonID.equals(""))
            id=true;
        if(LastName.equals(""))
            lastname=true;
        if(FirstName.equals(""))
            firstname=true;
        if(HireDate.equals(""))
            hiredate=true;
        if(EnrollmentDate.equals(""))
            endate=true;
        
        for(PersonDTO p: list){
            if(!PersonID.equals(""))
                id=(p.getPersonID()==Integer.parseInt(PersonID)) ? true : false;
            if(!LastName.equals(""))
                lastname=(p.getLastname().contains(LastName)) ? true : false;
            if(!FirstName.equals(""))
                firstname=(p.getFirstname().contains(FirstName)) ? true : false;
            if(!HireDate.equals(""))
                hiredate=(p.getHireDate().toString().contains(HireDate)) ? true : false;
            if(!EnrollmentDate.equals(""))
                endate=(p.getEnrollmentDate().toString().contains(EnrollmentDate)) ? true : false;
            if(id && lastname && firstname && hiredate && endate)
                res.add(p);
        }
        return res;
    }
    
    public ArrayList<PersonDTO> SearchStudent(String input) throws Exception {
        listStudent();
        ArrayList<PersonDTO> res=new ArrayList<PersonDTO>();
        
        for(PersonDTO p: list){
            if(String.valueOf(p.getPersonID()).contains(input)
                    || p.getLastname().contains(input)
                    || p.getFirstname().contains(input)
                    || p.getEnrollmentDate().contains(input))
                res.add(p);
        }
        return res;
    }
    
    public ArrayList<PersonDTO> SearchLecturer(String input) throws Exception {
        listLecturer();
        ArrayList<PersonDTO> res=new ArrayList<PersonDTO>();
        
        for(PersonDTO p: list){
            if(String.valueOf(p.getPersonID()).contains(input)
                    || p.getLastname().contains(input)
                    || p.getFirstname().contains(input)
                    || p.getHireDate().contains(input))
                res.add(p);
        }
        return res;
    }
    
    public void Remove(int id) throws Exception {
        for(PersonDTO p: list) {
            if(p.getPersonID()==id) {
                list.remove(p);
                PersonDAL persondal = new PersonDAL();
                persondal.Delete(id);
                return;
            }
        }
    }
    
}
