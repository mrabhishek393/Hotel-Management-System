import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public final class RoomMang extends javax.swing.JFrame {

    Connection con;
    Statement smt,smt1,smt2;
    ResultSet rs;
    String rtype,ac,status,query,pass;
    int rate,rno,erno,newbt,editbt,enb;
    DefaultTableModel model;
    public RoomMang(int en,String pass) {
        initComponents();
        model = (DefaultTableModel) showtbl.getModel();
        setLocationRelativeTo(null);
        unlckbtn.setVisible(false);
        srmnotxt.setEditable(false);
        updbtn.setEnabled(false); 
        gstlbl.setVisible(false);
        newlbl.setVisible(false);
        if(en==1) gstvsbl();
        enb=en;
        this.pass=pass;
        try
        {       
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            query = "SELECT * FROM ROOMDETAIL;";
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
               rno=rs.getInt("ROOMNO");
               ac=rs.getString("AC_NONAC");
               rtype=rs.getString("ROOMTYPE");
               rate=rs.getInt("RATE");
               status=rs.getString("STATUS");
              model.addRow(new Object[] {rno,ac,rtype,rate,status});
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
   newbtn.setEnabled(false);
}
   public void clear(){
     int rows=model.getRowCount();
       if (rows>0)
      {
         for (int i=0; i<rows; i++)model.removeRow(0);
      }
       srmnotxt.setText("");
         srmtptxt.setText("");
         sratetxt.setText("");
         acbtngrp.clearSelection();
         stsbtngrp.clearSelection();
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acbtngrp = new javax.swing.ButtonGroup();
        stsbtngrp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        newbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        srmnotxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        srmtptxt = new javax.swing.JTextField();
        acrbtn = new javax.swing.JRadioButton();
        nacrbtn = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sratetxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bkrbtn = new javax.swing.JRadioButton();
        vacrbtn = new javax.swing.JRadioButton();
        newlbl = new javax.swing.JLabel();
        updbtn = new javax.swing.JButton();
        srchbtn = new javax.swing.JButton();
        unlckbtn = new javax.swing.JButton();
        clsbtn = new javax.swing.JButton();
        rstbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showtbl = new javax.swing.JTable();
        gstlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ROOM MANAGMENT");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Room Management Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        newbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newbtn.setText("New");
        newbtn.setToolTipText("CLICK THIS TO ENABLE ALL TEXT FIELDS SO THAT INFORMATION FOR NEW RECORD CAN BE ENTERED");
        newbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbtnActionPerformed(evt);
            }
        });

        editbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editbtn.setText("Edit");
        editbtn.setToolTipText("SELECT A ROOM FROM TABLE AND CLICK THIS TO EDIT IN BELOW TEXT FIELDS");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Room No.");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Room Type ");

        acbtngrp.add(acrbtn);
        acrbtn.setText("AC");

        acbtngrp.add(nacrbtn);
        nacrbtn.setText("NON-AC");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("AC/NON-AC");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Room Rate");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Status");

        stsbtngrp.add(bkrbtn);
        bkrbtn.setText("Booked");

        stsbtngrp.add(vacrbtn);
        vacrbtn.setText("Vacant");

        newlbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newlbl.setForeground(new java.awt.Color(255, 0, 51));
        newlbl.setText("NEW");

        updbtn.setText("Update");
        updbtn.setToolTipText("AFTER EDITTING/NEW CLICK THIS TO UPDATE THE INFORMATION");
        updbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updbtnActionPerformed(evt);
            }
        });

        srchbtn.setText("Search");
        srchbtn.setToolTipText("ENTER INFO. IN ABOVE TEXT FIELDS AND CLICK THIS TO SEARCH AND SHOW MATCHING RECORDS");
        srchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(srmtptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(srmnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newlbl)
                                .addGap(13, 13, 13))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(acrbtn)
                        .addGap(10, 10, 10)
                        .addComponent(nacrbtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sratetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(srchbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bkrbtn)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vacrbtn)
                            .addComponent(updbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(srmnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srmtptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(acrbtn)
                    .addComponent(nacrbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sratetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(bkrbtn)
                    .addComponent(vacrbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srchbtn)
                    .addComponent(updbtn))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        unlckbtn.setText("Unlock All Options");
        unlckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlckbtnActionPerformed(evt);
            }
        });

        clsbtn.setText("Close");
        clsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clsbtnActionPerformed(evt);
            }
        });

        rstbtn.setText("Reset");
        rstbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rstbtnActionPerformed(evt);
            }
        });

        showtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ROOMNO", "AC/NON-AC", "ROOMTYPE", "RATE", "STATUS"
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unlckbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rstbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rstbtn)
                            .addComponent(clsbtn))
                        .addGap(14, 14, 14)
                        .addComponent(unlckbtn)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gstlbl)
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(215, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gstlbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clsbtnActionPerformed
     NavigationFrame nf=new NavigationFrame(enb,pass);
     nf.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_clsbtnActionPerformed

    private void unlckbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlckbtnActionPerformed
        String mpass=JOptionPane.showInputDialog(this,"Enter Master Password");
        if(mpass==null) mpass="";
        if(mpass.equals("1234"))
        {
            editbtn.setEnabled(true);
            newbtn.setEnabled(true);
            unlckbtn.setVisible(false);
        }
        else if(mpass.equals("")) ;
        else JOptionPane.showMessageDialog(this,"Incorrect Master Password");
    }//GEN-LAST:event_unlckbtnActionPerformed

    private void rstbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rstbtnActionPerformed
        newlbl.setVisible(false);
        srmnotxt.setEditable(false);
        updbtn.setEnabled(false); 
        srchbtn.setEnabled(true);
        bkrbtn.setEnabled(true);
        vacrbtn.setEnabled(true);
        clear();
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
    }//GEN-LAST:event_rstbtnActionPerformed

    private void updbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updbtnActionPerformed

        String rmtp,nac="",query1,query2,query3;
        int rmno,rrate,cnt=1;
        rmtp=srmtptxt.getText();
        
        if(acrbtn.isSelected()) nac="AC";
        else if(nacrbtn.isSelected()) nac="NON-AC";
        else JOptionPane.showMessageDialog(null,"AC/NON-AC not selected!!!");
           
        rrate=Integer.parseInt(sratetxt.getText());
      
        if(editbt==1)
        {
              rmno=Integer.parseInt(srmnotxt.getText());
            newlbl.setVisible(false);
            query1="UPDATE ROOMDETAIL SET ROOMNO=" + rmno + ", AC_NONAC='" + nac + "', ROOMTYPE='" + rmtp + "', RATE="+ rrate + " WHERE ROOMNO=" + rmno + ";";
            try
            {
                int cnfrm=JOptionPane.showConfirmDialog(this,"Are you sure you want update this information?","Confirm?",JOptionPane.YES_NO_OPTION);
                if(cnfrm==JOptionPane.YES_OPTION)
                {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
                    smt1=con.createStatement();
                    int c=smt1.executeUpdate(query1);
                    if(c>0) JOptionPane.showMessageDialog(this,"Updation Successful!!");
                    query = "SELECT * FROM ROOMDETAIL;";
                    smt=con.createStatement();
                    rs=smt.executeQuery(query);
                    srchbtn.setEnabled(true);
                    bkrbtn.setEnabled(true);
                    vacrbtn.setEnabled(true);
                    srmnotxt.setEditable(false);
                    updbtn.setEnabled(false); 
                    clear();
                    displayRecord();
                }
                else srchbtn.setEnabled(false);
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this,e);
            }

        }
        else if(newbt==1)
        {
                 
                if(nac.equals("")) JOptionPane.showMessageDialog(null,"AC/NON-AC not Selected");
                
                int cnfrm=JOptionPane.showConfirmDialog(this,"Are you sure you want insert this as new record?","Confirm?",JOptionPane.YES_NO_OPTION);
                if(cnfrm==JOptionPane.YES_OPTION)
                {
              
                    try
                    {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
                        query3="SELECT MAX(ROOMNO) FROM ROOMDETAIL";
                        smt2=con.createStatement();
                        ResultSet r=smt2.executeQuery(query3);
                        r.next(); 
                        rmno=r.getInt(1)+1;
                        query1="INSERT INTO ROOMDETAIL VALUES(" + rmno + ",'" + nac + "','" + rmtp + "'," + rrate + ",'" + "VACANT" +  "');";
                        smt1=con.createStatement();
                        int c=smt1.executeUpdate(query1);
                        if(c>0) JOptionPane.showMessageDialog(this,"Updation Successful!!");
                        query = "SELECT * FROM ROOMDETAIL;";
                        smt=con.createStatement();
                        rs=smt.executeQuery(query);
                        srchbtn.setEnabled(true);
                        updbtn.setEnabled(false);
                        bkrbtn.setEnabled(true);
                        vacrbtn.setEnabled(true);
                        clear();
                        displayRecord();
                    }
                    catch(SQLException e){
                        JOptionPane.showMessageDialog(this,e);
                    }
                   newlbl.setVisible(false);
                }
                else srchbtn.setEnabled(false);
              
            
            
        }
    }//GEN-LAST:event_updbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        newlbl.setVisible(false);
        srmnotxt.setEditable(true);
        updbtn.setEnabled(true); 
        int row  =showtbl.getSelectedRow();
        if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
        else
        {
           newbt=0;
           editbt=1;
           bkrbtn.setEnabled(false);
           vacrbtn.setEnabled(false);
           srchbtn.setEnabled(false);
           erno= Integer.parseInt(model.getValueAt(row,0).toString()); 
           srmnotxt.setText(""+ erno);
           srmnotxt.setEditable(false);
           srmtptxt.setText(model.getValueAt(row,2).toString());
           sratetxt.setText(model.getValueAt(row,3).toString());
           String nac = model.getValueAt(row,1).toString(), sts = model.getValueAt(row,4).toString();
           
           if(nac.equals("AC")) acrbtn.setSelected(true);
           else if(nac.equals("NON-AC")) nacrbtn.setSelected(true);
           
           if(sts.equals("VACANT")) vacrbtn.setSelected(true);
           else if(sts.equals("BOOKED")) bkrbtn.setSelected(true);
         }
    }//GEN-LAST:event_editbtnActionPerformed

    private void newbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbtnActionPerformed
        clear();
        srmnotxt.setEditable(false);
        updbtn.setEnabled(true);          
        newlbl.setVisible(true);
        srchbtn.setEnabled(false);
        bkrbtn.setEnabled(false);
        vacrbtn.setEnabled(false);
        editbt=0;
        newbt=1;
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
    }//GEN-LAST:event_newbtnActionPerformed

    private void srchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchbtnActionPerformed
        newlbl.setVisible(false);
        bkrbtn.setEnabled(true);
        vacrbtn.setEnabled(true);
        int rows=model.getRowCount();
        if (rows>0)  {for (int i=0; i<rows; i++)model.removeRow(0);}
        String rmno,rmrt,rmtp,nac="",sts="",query1;
        rmno=srmnotxt.getText();
        rmtp=srmtptxt.getText();
        rmrt=sratetxt.getText();
        query1="SELECT * FROM ROOMDETAIL WHERE ROOMNO LIKE '%" + rmno + "%' AND ROOMTYPE LIKE '%" + rmtp + "%' AND RATE LIKE '%" + rmrt + "%'";

        if(acrbtn.isSelected()) nac=" AND AC_NONAC='AC'";
        else if(nacrbtn.isSelected()) nac=" AND AC_NONAC='NON-AC'";

        if(bkrbtn.isSelected()) sts=" AND STATUS='BOOKED'";
        else if(vacrbtn.isSelected()) sts=" AND STATUS='VACANT'";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            Statement  stmt=con.createStatement();
            query1=query1 + nac + sts + ";";
            rs=stmt.executeQuery(query1);
            displayRecord();
            if ( showtbl.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null,"No Matching Records found!!!!");
                smt=con.createStatement();
                rs=smt.executeQuery(query);
                displayRecord();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_srchbtnActionPerformed

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup acbtngrp;
    private javax.swing.JRadioButton acrbtn;
    private javax.swing.JRadioButton bkrbtn;
    private javax.swing.JButton clsbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton nacrbtn;
    private javax.swing.JButton newbtn;
    private javax.swing.JLabel newlbl;
    private javax.swing.JButton rstbtn;
    private javax.swing.JTable showtbl;
    private javax.swing.JTextField sratetxt;
    private javax.swing.JButton srchbtn;
    private javax.swing.JTextField srmnotxt;
    private javax.swing.JTextField srmtptxt;
    private javax.swing.ButtonGroup stsbtngrp;
    private javax.swing.JButton unlckbtn;
    private javax.swing.JButton updbtn;
    private javax.swing.JRadioButton vacrbtn;
    // End of variables declaration//GEN-END:variables
}
