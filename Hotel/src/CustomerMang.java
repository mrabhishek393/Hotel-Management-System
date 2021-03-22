
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public final class CustomerMang extends javax.swing.JFrame {

    Connection con;
    Statement smt,smt1,smt2;
    ResultSet rs;
    String name,add,phno,query,pass;
    int rmno, bookid,ebkid,enb;
    DefaultTableModel model;
   
    public CustomerMang(int en, String pass) {
        initComponents();
        setLocationRelativeTo(null);
        gstlbl.setVisible(false);
        unlckbtn.setVisible(false);
        updbtn.setEnabled(false);  
        if(en==1) gstvsbl();
        enb=en;
        this.pass=pass;
        showtbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        showtbl.getColumnModel().getColumn(0).setPreferredWidth(70);
        showtbl.getColumnModel().getColumn(1).setPreferredWidth(217);
        showtbl.getColumnModel().getColumn(2).setPreferredWidth(90);
        showtbl.getColumnModel().getColumn(3).setPreferredWidth(62);
        showtbl.getColumnModel().getColumn(4).setPreferredWidth(55);
        model = (DefaultTableModel) showtbl.getModel();    
        try
        {       
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            query = "SELECT * FROM CUSTDETAIL;";
            smt=con.createStatement();
            rs=smt.executeQuery(query);    
            displayRecord();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
public final void displayRecord(){
         try
        {
            while(rs.next())
             {
              name=rs.getString("NAME");
              add=rs.getString("ADDRESS");
              phno=rs.getString("PHONE_NO");
              bookid=rs.getInt("BOOK_ID");
              rmno=rs.getInt("ROOM_NO");     
              model.addRow(new Object[] {name,add,phno,rmno,bookid});
             } 
        }
        catch(SQLException ec)
        {
            JOptionPane.showMessageDialog(this,ec);
        }  
    }
public void gstvsbl(){
   gstlbl.setVisible(true);
   unlckbtn.setVisible(true);
   updbtn.setEnabled(false);
   editbtn.setEnabled(false);
}
  public void clear(){
       int rows=model.getRowCount();
       if (rows>0)  
        {
            for (int i=0; i<rows; i++) model.removeRow(0);
       }
       sidtxt.setText("");
        snametxt.setText("");
        saddrstxt.setText("");
        sphnotxt.setText("");
        srmnotxt.setText("");
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cusbtngrp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        editbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        snametxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        saddrstxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        sidtxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        srmnotxt = new javax.swing.JTextField();
        sphnotxt = new javax.swing.JTextField();
        srchbtn = new javax.swing.JButton();
        updbtn = new javax.swing.JButton();
        unlckbtn = new javax.swing.JButton();
        clsbtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showtbl = new javax.swing.JTable();
        rsttbtn = new javax.swing.JButton();
        gstlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CUSTOMER MANAGMENT");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "CUSTOMER INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editbtn.setText("Edit");
        editbtn.setToolTipText("SELECT A CUSTOMER FROM TABLE AND CLICK THIS TO EDIT IN BELOW TEXT FIELDS");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        jPanel1.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 91, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, -1, -1));
        jPanel2.add(snametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 37, 215, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Address");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel2.add(saddrstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 280, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Phone no.");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Book ID");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 62, 14));
        jPanel2.add(sidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 57, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Room no.");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        jPanel2.add(srmnotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 57, -1));
        jPanel2.add(sphnotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 175, -1));

        srchbtn.setText("Search");
        srchbtn.setToolTipText("ENTER INFO. IN ABOVE TEXT FIELDS AND CLICK THIS TO SEARCH AND SHOW MATCHING RECORDS\n");
        srchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchbtnActionPerformed(evt);
            }
        });
        jPanel2.add(srchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 92, 30));

        updbtn.setText("Update");
        updbtn.setToolTipText("AFTER EDITTING CLICK THIS TO UPDATE THE INFORMATION");
        updbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updbtnActionPerformed(evt);
            }
        });
        jPanel2.add(updbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 370, 220));

        unlckbtn.setText("Unlock All Options");
        unlckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlckbtnActionPerformed(evt);
            }
        });
        jPanel1.add(unlckbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 140, -1));

        clsbtn.setText("Close");
        clsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clsbtnActionPerformed(evt);
            }
        });
        jPanel1.add(clsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 93, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("<html><body><B><U>Note</U></B>: - <br> Book ID and Room No. of Old Customers will be shown 0.</body</html>");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        showtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Phoneno.", "Roomno.", "BookID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(showtbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 500, 270));

        rsttbtn.setText("Reset");
        rsttbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsttbtnActionPerformed(evt);
            }
        });
        jPanel1.add(rsttbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 140, -1));

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gstlbl)
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gstlbl)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 918, 576);
    }// </editor-fold>//GEN-END:initComponents

    private void updbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updbtnActionPerformed
        String cname,cadd,cphno;
        cname=snametxt.getText();
        cadd=saddrstxt.getText();
        cphno=sphnotxt.getText();      
        try
        {
            int cnfrm=JOptionPane.showConfirmDialog(this, "Are you sure you want to update this information?","Confirm?",JOptionPane.YES_NO_OPTION);
            if(cnfrm==JOptionPane.YES_OPTION)
            {    
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            String query1="UPDATE CUSTDETAIL SET NAME='" + cname + "', ADDRESS='" + cadd + "', PHONE_NO='" + cphno + "' WHERE BOOK_ID=" + ebkid + ";";
            smt1=con.createStatement(); 
            int s1=smt1.executeUpdate(query1);
            if(s1> 0 ) JOptionPane.showMessageDialog(this,"UPDATION SUCCESSFUL!!");
            smt=con.createStatement();
            rs=smt.executeQuery(query); 
            clear();
            displayRecord();
            updbtn.setEnabled(false); 
            sidtxt.setEditable(true);
            srmnotxt.setEditable(true);
            srchbtn.setEnabled(true);
            }
            else srchbtn.setEnabled(false);
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_updbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
       int row  =showtbl.getSelectedRow();
        if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
        else
        {
            updbtn.setEnabled(true);  
            srchbtn.setEnabled(false);
            sidtxt.setEditable(false);
            srmnotxt.setEditable(false);
            ebkid= Integer.parseInt(model.getValueAt(row,4).toString());
            int rno=Integer.parseInt(model.getValueAt(row,3).toString());
            sidtxt.setText("" + ebkid);
            srmnotxt.setText("" + rno);
            snametxt.setText("" + model.getValueAt(row,0).toString());
            saddrstxt.setText("" + model.getValueAt(row,1).toString());
            sphnotxt.setText("" + model.getValueAt(row,2).toString());
        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void srchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchbtnActionPerformed
        String sname,sphno,sadd,sbid,srno;
       
        sname=snametxt.getText();
        sphno=sphnotxt.getText();
        sadd=saddrstxt.getText();
        sbid=sidtxt.getText();
        srno=srmnotxt.getText();  
        Statement stmt;
        String query1;   
                
        query1= "SELECT * FROM CUSTDETAIL WHERE BOOK_ID LIKE '%"+ sbid +"%' AND NAME LIKE '%" + sname + "%' AND ADDRESS LIKE '%" + sadd + "%' AND PHONE_NO LIKE '%" + sphno + "%' AND ROOM_NO LIKE '%" + srno + "%';";
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query1);
            clear();
            displayRecord();      
            if ( showtbl.getRowCount() == 0) 
             {
               JOptionPane.showMessageDialog(null,"No Matching Records found!!!!");
                smt=con.createStatement();
                rs=smt.executeQuery(query);
                displayRecord();
             }   
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_srchbtnActionPerformed

    private void rsttbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsttbtnActionPerformed
        clear();
        updbtn.setEnabled(false); 
        sidtxt.setEditable(true);
        srmnotxt.setEditable(true);
        srchbtn.setEnabled(true);
        cusbtngrp.clearSelection(); 
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            smt=con.createStatement();
            rs=smt.executeQuery(query);
            displayRecord();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_rsttbtnActionPerformed

    private void unlckbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlckbtnActionPerformed
        String mpass=JOptionPane.showInputDialog(this,"Enter Master Password");
        if(mpass==null) mpass="";
        
        if(mpass.equals("1234"))
        {  
            editbtn.setEnabled(true);     
            unlckbtn.setVisible(false);
        }
        else if(mpass.equals("")) ;
        else JOptionPane.showMessageDialog(this,"Incorrect Master Password");
    }//GEN-LAST:event_unlckbtnActionPerformed

    private void clsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clsbtnActionPerformed
    NavigationFrame nf=new NavigationFrame(enb,pass);
    nf.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_clsbtnActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clsbtn;
    private javax.swing.ButtonGroup cusbtngrp;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rsttbtn;
    private javax.swing.JTextField saddrstxt;
    private javax.swing.JTable showtbl;
    private javax.swing.JTextField sidtxt;
    private javax.swing.JTextField snametxt;
    private javax.swing.JTextField sphnotxt;
    private javax.swing.JButton srchbtn;
    private javax.swing.JTextField srmnotxt;
    private javax.swing.JButton unlckbtn;
    private javax.swing.JButton updbtn;
    // End of variables declaration//GEN-END:variables
}
