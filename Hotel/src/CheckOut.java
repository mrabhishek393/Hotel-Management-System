import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public final class CheckOut extends javax.swing.JFrame {

  Connection con;
  Statement stmt,stmt1;
  ResultSet rs;
  String query,query1,bkid,rno,d1,d2,day,tbill,cname,pass;
  int enb;
  DefaultTableModel model;
    public CheckOut(int en,String pass) {
        initComponents();
        setLocationRelativeTo(null);
        unlckbtn.setVisible(false);
        gstlbl.setVisible(false);
        ex1lbl.setVisible(false);
        ex2lbl.setVisible(false);
         if(en==1) 
         {
             unlckbtn.setVisible(true);
             paybtn.setEnabled(false);
             gstlbl.setVisible(true);
         }
         enb=en;
         this.pass=pass;
        showtbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        showtbl.getColumnModel().getColumn(0).setPreferredWidth(55);
        showtbl.getColumnModel().getColumn(1).setPreferredWidth(70);
        showtbl.getColumnModel().getColumn(2).setPreferredWidth(61);
        showtbl.getColumnModel().getColumn(3).setPreferredWidth(80);
        showtbl.getColumnModel().getColumn(4).setPreferredWidth(80);
        showtbl.getColumnModel().getColumn(5).setPreferredWidth(55);
        showtbl.getColumnModel().getColumn(6).setPreferredWidth(58);
        model = (DefaultTableModel) showtbl.getModel();
        try
        {
            query = "SELECT * FROM CHECK_OUT;";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            query1="DELETE FROM CHECK_OUT WHERE CURDATE() >= (CHECK_OUT + INTERVAL 1 DAY);";
            stmt1=con.createStatement();
            stmt1.executeUpdate(query1);
            stmt  = con.createStatement();
            rs=stmt.executeQuery(query);
            displayRecord();
            if (showtbl.getRowCount() == 0 )
            {
                JOptionPane.showMessageDialog(null,"No Booking is available for Check_Out");
                prerbtn.setEnabled(false);
                exrbtn.setEnabled(false);
                paybtn.setEnabled(false);
                rstbtn.setEnabled(false);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void displayRecord(){
       try
       {
           while(rs.next())
           {   
             bkid=rs.getString("BOOKID");
             rno=rs.getString("ROOMNO"); 
             d1=rs.getString("CHECK_IN");
             d2=rs.getString("CHECK_OUT");
             day=rs.getString("NO_OF_DAYS");
             tbill=rs.getString("TOTALBILL");
             cname=rs.getString("NAME");
             model.addRow(new Object[] {bkid,cname,rno,d1,d2,day,tbill});
           }
       }
       catch(SQLException ec){
            JOptionPane.showMessageDialog(this, ec);
        } 
   }
    public void clear(){
    int row = showtbl.getRowCount();
     if (row>0)  
        {
            for (int i=0; i<row; i++) model.removeRow(0);
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choutrbtngrp = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        showtbl = new javax.swing.JTable();
        ex1lbl = new javax.swing.JLabel();
        ex2lbl = new javax.swing.JLabel();
        paybtn = new javax.swing.JButton();
        prerbtn = new javax.swing.JRadioButton();
        exrbtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rstbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        gstlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        unlckbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHECK-OUT MANAGMENT");

        showtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Name", "Roomno.", "CheckIn", "CheckOut", "Days", "TotalBill"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(showtbl);

        ex1lbl.setText("Expected");

        ex2lbl.setText("Expected");

        paybtn.setBackground(new java.awt.Color(51, 255, 51));
        paybtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        paybtn.setText("<html><body>Check-Out<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;and<br>&nbsp;&nbsp;Pay Bill </body></html>");
        paybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybtnActionPerformed(evt);
            }
        });

        choutrbtngrp.add(prerbtn);
        prerbtn.setText("Pre Check-Out");
        prerbtn.setToolTipText("Shows info. of customers where check-out id greater than current date");
        prerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prerbtnActionPerformed(evt);
            }
        });

        choutrbtngrp.add(exrbtn);
        exrbtn.setText("Expected Check-Out");
        exrbtn.setToolTipText("Sows info. of customers where check-out date is equal to current date");
        exrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exrbtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Select the type of Check-Out");

        rstbtn.setText("RESET");
        rstbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rstbtnActionPerformed(evt);
            }
        });

        exitbtn.setText("EXIT");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("CHECK OUT");

        unlckbtn.setText("UNLOCK CHECK-OUT BUTTON");
        unlckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlckbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(ex1lbl)
                        .addGap(18, 18, 18)
                        .addComponent(ex2lbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gstlbl)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paybtn)
                    .addComponent(rstbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prerbtn)
                            .addComponent(exrbtn)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(unlckbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gstlbl)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prerbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exrbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(paybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(unlckbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rstbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ex2lbl)
                            .addComponent(ex1lbl))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prerbtnActionPerformed
     ex1lbl.setVisible(true);
     ex2lbl.setVisible(true);
     String queryy="SELECT * FROM CHECK_OUT WHERE CURDATE() >= CHECK_IN AND CURDATE() < CHECK_OUT;";
     Statement smt;
    try
     {    
       smt=con.createStatement();
       rs=smt.executeQuery(queryy);
       clear();
       displayRecord();
     }
      catch(SQLException ec){
            JOptionPane.showMessageDialog(this, ec);
        } 
    }//GEN-LAST:event_prerbtnActionPerformed

    private void exrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exrbtnActionPerformed
     ex1lbl.setVisible(false);
     ex2lbl.setVisible(false);
     String queryy="SELECT * FROM CHECK_OUT WHERE CURDATE() >= CHECK_OUT;";
     Statement smt;
     try
     {    
       smt=con.createStatement();
       rs=smt.executeQuery(queryy);
       clear();
       displayRecord();
     }
      catch(SQLException ec){
            JOptionPane.showMessageDialog(this, ec);
        } 
    }//GEN-LAST:event_exrbtnActionPerformed

    private void paybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybtnActionPerformed
      String name,D1,id,bill,rmno,queryy,queryy1,queryy2,nquery;
      int row  =showtbl.getSelectedRow(),days;
      
      LocalDate curdate = LocalDate.now();
      Statement smt,smt1,smt2,nsmt;
      ResultSet rst;
      
      if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
      else
      {
          id = model.getValueAt(row,0).toString();
          name= model.getValueAt(row,1).toString();
          D1= model.getValueAt(row,4).toString();
          bill=model.getValueAt(row,6).toString();
          rmno = model.getValueAt(row,2).toString();
          Period diff=Period.between(curdate, LocalDate.parse(D1));
          days = diff.getDays();
          if( days > 0 )
          {
              int cnfrm = JOptionPane.showConfirmDialog(null,"Are you sure you want to Check-Out","Confirm?",JOptionPane.YES_NO_OPTION);
              if(cnfrm == JOptionPane.YES_OPTION)
              {
                  nquery= "DELETE FROM CHECK_OUT WHERE BOOKID=" + id + ";";
                  queryy="DELETE FROM BOOKING WHERE BOOK_ID=" + id + ";";
                  queryy2="UPDATE ROOMDETAIL SET STATUS = 'VACANT' WHERE ROOMNO=" + rmno + ";";
                  try
                  {
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
                  nsmt=con.createStatement();
                  smt=con.createStatement();
                  smt1=con.createStatement();
                  smt2=con.createStatement();
                  smt.executeUpdate(queryy);
                  smt2.executeUpdate(queryy2);
                  nsmt.executeUpdate(nquery);
                  JOptionPane.showMessageDialog(null,"Thank You " + name + " for staying in our hotel.\nBill =Rs-" + bill + "\nSEE YOU SOON!!!!!");
                  stmt  = con.createStatement();
                  rs=stmt.executeQuery(query);
                  clear();
                  displayRecord();
                  choutrbtngrp.clearSelection();
                  }
                  catch(SQLException ec){
                      JOptionPane.showMessageDialog(this, ec);
                  } 
              }
          }
          if (days == 0)
          {
              int cnfrm = JOptionPane.showConfirmDialog(null,"Are you sure you want to Check-Out");
              if(cnfrm == JOptionPane.YES_OPTION)
              {
                  try
                  {    
                   nquery= "DELETE FROM CHECK_OUT WHERE BOOKID=" + id + ";";
                   nsmt=con.createStatement();
                   nsmt.executeUpdate(nquery);
                   JOptionPane.showMessageDialog(null,"Thank You " + name + " for staying in our hotel.\nBill =Rs-" + bill + "\nSEE YOU SOON!!!!!");
                   stmt  = con.createStatement();
                   rs=stmt.executeQuery(query);
                   clear();
                   displayRecord();
                   choutrbtngrp.clearSelection();
                  }
                   catch(SQLException ec){
                      JOptionPane.showMessageDialog(this, ec);
                  } 
              }
          }
       }
    
    }//GEN-LAST:event_paybtnActionPerformed

    private void rstbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rstbtnActionPerformed
    clear();
    choutrbtngrp.clearSelection();
    try
    {
    stmt  = con.createStatement();
    rs=stmt.executeQuery(query);
    displayRecord();
    }
     catch(SQLException ec){
                      JOptionPane.showMessageDialog(this, ec);
                  } 
    }//GEN-LAST:event_rstbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
    NavigationFrame nf=new NavigationFrame(enb,pass);
    nf.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_exitbtnActionPerformed

    private void unlckbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlckbtnActionPerformed
   String mpass=JOptionPane.showInputDialog(this,"Enter Master Password");
     if(mpass==null) mpass="";
     
     if(mpass.equals("1234")) 
     {
         paybtn.setEnabled(true);
         unlckbtn.setVisible(false);
     }
     else if(mpass.equals("")) ;
     else JOptionPane.showMessageDialog(this,"Incorrect Master Password");
    }//GEN-LAST:event_unlckbtnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup choutrbtngrp;
    private javax.swing.JLabel ex1lbl;
    private javax.swing.JLabel ex2lbl;
    private javax.swing.JButton exitbtn;
    private javax.swing.JRadioButton exrbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton paybtn;
    private javax.swing.JRadioButton prerbtn;
    private javax.swing.JButton rstbtn;
    private javax.swing.JTable showtbl;
    private javax.swing.JButton unlckbtn;
    // End of variables declaration//GEN-END:variables
}
