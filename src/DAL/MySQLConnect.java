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

public class MySQLConnect {
    private String Host="";
    private String Username="";
    private String Password="";
    private String Database="";
    
    private Connection connect=null;
    private Statement statement=null;
    private ResultSet result=null;
    
    public MySQLConnect(String Host, String Username, String Password, String Database){
        this.Database=Database;
        this.Username=Username;
        this.Password=Password;
        this.Database=Database;
    }
    
    protected void driverTest() throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(java.lang.ClassNotFoundException e){
            throw new Exception("MySQL JDBC Driver not found!");
        }
    }
    
    protected Connection Connect() throws Exception {
        if(connect==null){
            driverTest();
            String url="jdbc:mysql://" + Host + ":3306/" + Database;
            try{
                connect=DriverManager.getConnection(url, Username, Password);
            }
            catch(java.sql.SQLException e){
                throw new Exception("Không thể kết nối đến Database Server " + url + e.getMessage());
            }
        }
        return connect;
    }
    
    public void disConnect() throws SQLException{
        if(result!=null && !result.isClosed()){
            result.close();
            result=null;
        }
        if(statement!=null && !statement.isClosed()){
            statement.close();
            statement=null;
        }
        if(connect!=null && !connect.isClosed()){
            connect.close();
            connect=null;
        }
    }
    
    protected Statement getStatement() throws Exception {
        if(statement==null ? true : statement.isClosed()){
            statement=this.Connect().createStatement();
        }
        return statement;
    }
    
    public ResultSet excuteQuery(String Query) throws Exception{
        try{
            result=getStatement().executeQuery(Query);
        }
        catch(Exception e){
            throw new Exception("Lỗi: " + e.getMessage() + " - " + Query);
        }
        return result;
    }
    
    public int executeUpdate(String Query) throws Exception {
        int res=Integer.MIN_VALUE;
        try{
            res=getStatement().executeUpdate(Query);
        }
        catch(Exception e){
            throw new Exception("Lỗi: " + e.getMessage() + " - " + Query);
        }
        finally{
            this.disConnect();
        }
        return res;
    }
    
}
