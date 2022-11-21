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
import DAL.DepartmentDAL;
import DTO.DepartmentDTO;
import java.util.ArrayList;

public class DepartmentBLL {
    private ArrayList<DepartmentDTO> list;
    
    public DepartmentBLL(){

    }    
    
    public ArrayList<DepartmentDTO> getList(){
        return list;
    }
    
    public void list() throws Exception {
        DepartmentDAL depdal=new DepartmentDAL();
        list=new ArrayList<DepartmentDTO>();
        list=depdal.list();   
    }
    
    public ArrayList<DepartmentDTO> Search(String input) {
        ArrayList<DepartmentDTO> res=new ArrayList<DepartmentDTO>();
        
        for(DepartmentDTO p: list){
            if(String.valueOf(p.getDepartmentID()).contains(input)
                    || p.getName().contains(input)
                    || String.valueOf(p.getBudget()).contains(input)
                    || p.getStartDate().contains(input)
                    || String.valueOf(p.getAdministrator()).contains(input))
                res.add(p);
        }
        return res;
    }
   
}
