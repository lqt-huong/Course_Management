/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.PersonBLL;
import DTO.PersonDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ManageLecturer extends javax.swing.JFrame {
    private DefaultTableModel modelLecturer = new DefaultTableModel();
    private DefaultTableModel resOfSearch;
    private ArrayList<PersonDTO> listSearch=new ArrayList<PersonDTO>();
    private PersonBLL personbll=new PersonBLL();
    private boolean isEditing = false;
    private int selectedRow=-1;
    
    /**
     * Creates new form QuanLyHocVien
     */
    public ManageLecturer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txHireDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLecturer = new javax.swing.JTable();
        btClose = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        btAll = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txPersonID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QU???N L?? GI???NG VI??N");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("H???");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("T??n");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ng??y thu??");

        tbLecturer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbLecturer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "M?? gi???ng vi??n", "H???", "T??n", "Ng??y thu??"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbLecturer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLecturerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLecturer);

        btClose.setText("????NG");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        btAdd.setText("TH??M");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btEdit.setText("S???A");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("XO??");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btSearch.setText("T??M");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        btAll.setText("T???T C???");
        btAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllActionPerformed(evt);
            }
        });

        btNew.setText("T???O M???I");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btSave.setText("L??U");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setText("HU???");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("M?? gi???ng vi??n");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(270, 270, 270))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btSave)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btCancel)
                                            .addGap(8, 8, 8))
                                        .addComponent(txHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btClose)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAdd)
                                    .addComponent(btSearch)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txFirstName)
                                .addComponent(btEdit)
                                .addComponent(btAll))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txHireDate)
                                .addComponent(btDelete)
                                .addComponent(btNew))
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSave)
                            .addComponent(btCancel))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btClose))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btSave.setVisible(false);
        btCancel.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void List() throws Exception{
        if(personbll.getList()==null)
            personbll.listLecturer();
        ArrayList<PersonDTO> list = personbll.getList();
        Vector header=new Vector();
        header.add("M?? gi???ng vi??n");
        header.add("H???");
        header.add("T??n");
        header.add("Ng??y thu??");
        if (modelLecturer.getRowCount() == 0) 
                modelLecturer = new DefaultTableModel(header, 0);
        for(PersonDTO p: list) {
            Vector row=new Vector();
            row.add(p.getPersonID());
            row.add(p.getLastname());
            row.add(p.getFirstname());
            row.add(p.getHireDate());
            modelLecturer.addRow(row);
        }
        tbLecturer.setModel(modelLecturer);
    }
    
    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btCloseActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        if(!isEditing)
            txPersonID.setText("");
        txLastName.setText("");
        txFirstName.setText("");
        txHireDate.setText("");
    }//GEN-LAST:event_btNewActionPerformed

    private void tbLecturerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLecturerMouseClicked
        selectedRow = tbLecturer.getSelectedRow();
        if (personbll.getList().size() > 0) {
            PersonDTO p = new PersonDTO(); 
            if(listSearch.size()>0)
                p = listSearch.get(selectedRow);
            else
                p = personbll.getList().get(selectedRow);
            
            txPersonID.setText(String.valueOf(p.getPersonID()));
            txLastName.setText(p.getLastname());
            txFirstName.setText(p.getFirstname());
            txHireDate.setText(p.getHireDate().toString());
        }
    }//GEN-LAST:event_tbLecturerMouseClicked
    
    private boolean isLeapYear(int year){
        if(((year%4==0)&&(year%100!=0))||(year%400==0))
            return true;
        return false;
    }
    
    private int ValidateDate(String dateInput){
        if(!dateInput.matches("^\\d{4}-\\d{2}-\\d{2}$"))
            return 1;
        
        String[] date;
        date=dateInput.split("-");
        int day, month, year;
        year=Integer.parseInt(date[0]);
        month=Integer.parseInt(date[1]);
        day=Integer.parseInt(date[2]);
        
        if(month<1 || month>12)
            return 2;
        
        if(month==2){
            if(isLeapYear(year)){
                if(day<1||day>29)
                    return 2;
            }
            else{
                if(day<1||day>28)
                    return 2;     
            }
        }
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            if(day<1||day>31){
                return 2;
            }
        }
        if(month==4||month==6||month==9||month==11){
            if(day<1||day>30)
                return 2;
        }
        return 0;
    }
    
    private boolean Validate() throws Exception{
        String id, lastname, firstname, endate;
        id=txPersonID.getText();
        lastname=txLastName.getText();
        firstname=txFirstName.getText();
        endate=txHireDate.getText();
        if(id.equals("") || lastname.equals("") || firstname.equals("") || endate.equals("")){
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ????? th??ng tin", "Ch?? ??!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        if(!id.matches("^\\d+")){
            JOptionPane.showMessageDialog(null, "M?? gi???ng vi??n ph???i ??? ?????nh d???ng s???", "Ch?? ??!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        if(!isEditing)
            for(Integer p: personbll.getAllPersonID()){
                if(id.equals(String.valueOf(p))){
                    JOptionPane.showMessageDialog(null, "M?? ???? t???n t???i", "Ch?? ??!", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
        }
        
        if(ValidateDate(endate)==1){
            JOptionPane.showMessageDialog(null, "Ng??y thu?? ph???i ??? ?????nh d???ng s??? yyyy-mm-dd", "Ch?? ??!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else if(ValidateDate(endate)==2) {
            JOptionPane.showMessageDialog(null, "Ng??y thu?? kh??ng h???p l???");
            return false;
        }
        return true;
    }
    
    
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        try {
            if(!Validate())
                return;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        PersonDTO p=new PersonDTO();
        p.setPersonID(Integer.parseInt(txPersonID.getText()));
        p.setLastname(txLastName.getText());
        p.setFirstname(txFirstName.getText());
        p.setHireDate(txHireDate.getText());

        try {
            personbll.AddLecturer(p);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        Vector row=new Vector();
        row.add(p.getPersonID());
        row.add(p.getLastname());
        row.add(p.getFirstname());
        row.add(p.getHireDate());
        
        modelLecturer.addRow(row);

        tbLecturer.setModel(modelLecturer);
    }//GEN-LAST:event_btAddActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        selectedRow=tbLecturer.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Ch???n gi???ng vi??n c???n ch???nh s???a", "Ch?? ??!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        isEditing = true;
        txPersonID.setEditable(false);
        tbLecturer.setEnabled(false);
        btAdd.setEnabled(false);
        btDelete.setEnabled(false);
        btSearch.setEnabled(false);
        btAll.setEnabled(false);
        btSave.setVisible(true);
        btCancel.setVisible(true);
    }//GEN-LAST:event_btEditActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        isEditing = false;
        txPersonID.setEditable(true);
        tbLecturer.setEnabled(true);
        btAdd.setEnabled(true);
        btDelete.setEnabled(true);
        btSearch.setEnabled(true);
        btAll.setEnabled(true);
        btSave.setVisible(false);
        btCancel.setVisible(false);
    }//GEN-LAST:event_btCancelActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int selectedRow = tbLecturer.getSelectedRow();
        if(personbll.getList().size()>0){
            try {
                personbll.Remove(personbll.getList().get(selectedRow).getPersonID());
            } catch (Exception ex) {
                System.out.println(ex);
            }
            modelLecturer.removeRow(selectedRow);
            tbLecturer.setModel(modelLecturer);
            this.btNewActionPerformed(evt);
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            if(!Validate())
                return;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        if(personbll.getList().size()>0){
            PersonDTO p=new PersonDTO();

            p.setPersonID(Integer.parseInt(txPersonID.getText()));
            p.setLastname(txLastName.getText());
            p.setFirstname(txFirstName.getText());
            p.setHireDate(txHireDate.getText());

            try {
                personbll.EditLecturer(p);
            } catch (Exception ex) {
                System.out.println(ex);
            }

            modelLecturer.setValueAt(p.getPersonID(), selectedRow, 0);
            modelLecturer.setValueAt(p.getLastname(), selectedRow, 1);
            modelLecturer.setValueAt(p.getFirstname(), selectedRow, 2);
            modelLecturer.setValueAt(p.getHireDate(), selectedRow, 3);

            tbLecturer.setModel(modelLecturer);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        if(personbll.getList().isEmpty()){
            return;
        }
        String id, lastname, firstname, hiredate;
        id=txPersonID.getText();
        lastname=txLastName.getText();
        firstname=txFirstName.getText();
        hiredate=txHireDate.getText();
        
        try {
            listSearch=personbll.Search(id, lastname, firstname, hiredate, "");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        if (listSearch.size()==0){
            JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y k???t qu??? n??o!", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
            tbLecturer.setModel(modelLecturer);
        }
        else{
            Vector header = new Vector();
            header.add("M?? gi???ng vi??n");
            header.add("H???");
            header.add("T??n");
            header.add("Ng??y thu??");
            resOfSearch = new DefaultTableModel(header, 0);
            for(PersonDTO p: listSearch){
                Vector row=new Vector();
                row.add(p.getPersonID());
                row.add(p.getLastname());
                row.add(p.getFirstname());
                row.add(p.getHireDate());
                resOfSearch.addRow(row);
            }
            tbLecturer.setModel(resOfSearch);
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllActionPerformed
        if (personbll.getList().size()>0)
            tbLecturer.setModel(modelLecturer);
        listSearch.clear();
    }//GEN-LAST:event_btAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageLecturer QLHV=new ManageLecturer();
                try {
                    QLHV.List();          
                } catch (Exception ex) { 
                    System.out.println(ex);
                }
                QLHV.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAll;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLecturer;
    private javax.swing.JTextField txFirstName;
    private javax.swing.JTextField txHireDate;
    private javax.swing.JTextField txLastName;
    private javax.swing.JTextField txPersonID;
    // End of variables declaration//GEN-END:variables
}
