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
public class DAL {
    public static MyConnectUnit getDAL(){
        return new MyConnectUnit("localhost", "root", "", "quanlykhoahoc?useUnicode=yes&characterEncoding=UTF8");
    }
}
