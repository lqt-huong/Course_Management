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
import java.sql.*;
import java.util.HashMap;

public class MyConnectUnit {
    
    //Biến kết nối cơ bản
    private MySQLConnect connect;

    public MyConnectUnit(String Host, String Username, String Password, String Database) {
        connect=new MySQLConnect(Host, Username, Password, Database);
    }
    
    //Hàm hỗ trợ Select CSDL
    //SELECT * FROM TableName WHERE Condition ORDER BY OrderBy;
    public ResultSet Select(String TableName, String Condition, String OrderBy) throws Exception{
        ResultSet rs=null;
        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query=new StringBuilder("SELECT * FROM " + TableName);
        //Đưa câu lệnh điều kiện vào trong câu query
        this.AddCondition(query, Condition);
        //Đưa câu lệnh Order vào câu query
        this.AddOrderBy(query, OrderBy);
        //Chèn ký tự ';' vào cuối dòng lệnh để cách các câu lệnh
        query.append(";");
        //Thực thi câu query và trả kết quả ra ngoài
        rs=this.connect.excuteQuery(query.toString());

        return rs;
    }
    
    //Hàm overload Select lược bớt OrderBy parameter
    public ResultSet Select(String TableName, String Condition) throws Exception{
        return this.Select(TableName, Condition, null);
    }
    
    //Hàm overload Select lược bớt Condition parameter
    public ResultSet Select(String TableName) throws Exception {
        return this.Select(TableName, null);
    }
    
    //Hàm thêm điều kiện vào query
    private void AddCondition(StringBuilder query, String Condition){
        //Kiểm tra nếu condition khác null
        if(Condition!=null)
            query.append(" WHERE " + Condition);
    }
    
    //Hàm thêm OrberBy vào query
    private void AddOrderBy(StringBuilder query, String OrderBy){
        //Kiểm tra OrderBy khác null
        if(OrderBy!=null)
            query.append(" ORDER BY " + OrderBy);
    }
    
    //Hàm hỗ trợ Insert xuống CSĐL
    //INSERT INTO TableName (columnName...) VALUES (column Values...); 
    public boolean Insert(String TableName, HashMap<String, Object> ColumnValues) throws Exception {
        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query=new StringBuilder("INSERT INTO " + TableName);
        //Khai báo biến StringBuilder để tạo chuỗi Column Values 
        StringBuilder valueInsert=new StringBuilder();
        
        query.append("(");
        //Duyệt và đưa thông tin tên cột và giá trị của cột vào câu query
        for(String key: ColumnValues.keySet()){
            query.append(key + ",");
            valueInsert.append("'" + ColumnValues.get(key).toString() + "' ,");
        }
        //Cắt bớt ký tự ',' cuối câu
        query=query.delete(query.length()-1, query.length());
        valueInsert=valueInsert.delete(valueInsert.length()-1, valueInsert.length());
        
        //Đưa giá trị của cột vào câu query
        query.append(") VALUES(" + valueInsert.toString()+")");
        //Chèn ký tự ';' vào cuối dòng lệnh để cách các câu
        query.append(";");
        //Thực thi câu query và trả kết quả ra ngoài
        return this.connect.executeUpdate(query.toString()) > 0;
    }
    
    //Hàm hỗ trợ Update CSDL
    //UPDATE TableName SET ColumnName = ColumnValue WHERE Condition ;
    public boolean Update(String TableName, HashMap<String, Object> ColumnValues, String Condition) throws Exception {
        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query=new StringBuilder("UPDATE " + TableName + " SET ");
        
        //Duyệt và đưa thông tin tên cột và giá trị của cột
        for(String key: ColumnValues.keySet()){
            query.append(key + " = '" + ColumnValues.get(key).toString() + "',");
        }
        //Cắt bớt ký tự ',' cuối câu
        query=query.delete(query.length()-1, query.length());
        //Đưa câu lệnh điều kiện vào trong câu query
        this.AddCondition(query, Condition);
        //Chèn ký tự ';' vào cuối cùng dòng lệnh để cách các câu lệnh
        query.append(";");
        //Thực thi câu query và trả kết quả ra ngoài
        return this.connect.executeUpdate(query.toString()) > 0;
    }
    
    //Hàm hỗ trợ DELETE trong CSDL
    //DELETE FROM TableName WHERE Condition
    public boolean Delete(String TableName, String Condition) throws Exception {
        //Khai báo biến StringBuilder để tạo chuỗi Select
        StringBuilder query=new StringBuilder("DELETE FROM " + TableName);
        //Đưa câu lệnh điều kiện vào trong câu query
        this.AddCondition(query, Condition);
        query.append(";");
        //Thực thi câu query và trả kết quả ra ngoài
        return this.connect.executeUpdate(query.toString()) > 0;
    }
 
} 

