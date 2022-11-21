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
import DTO.DepartmentDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class DepartmentDAL {
    private MyConnectUnit connect;
    
    public DepartmentDAL() {
        connect=DAL.getDAL();
    }
    
    public ArrayList<DepartmentDTO> list() throws Exception{
        ResultSet result=this.connect.Select("department");
        ArrayList<DepartmentDTO> list=new ArrayList<DepartmentDTO>();
        while(result.next()){
            DepartmentDTO p=new DepartmentDTO();
            p.setDepartmentID(result.getInt("DepartmentID"));
            p.setName(result.getString("Name"));
            p.setBudget(result.getInt("Budget"));
            p.setStartDate(result.getString("StartDate"));
            p.setAdministrator(result.getInt("Administrator"));
            list.add(p);
        }
        return list;
    }
  
}

