import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.table.DefaultTableModel;
public final class BookingMang extends javax.swing.JFrame {

    Connection con;
    Statement stmt,stmt1,stmt2;
    ResultSet rs,rs1;
    int bookid, rmno,days,ebkid,bill,sdays,sbill,enb;
    String D1,D2,query,name,pass;
    DefaultTableModel model;
    SimpleDateFormat dform1,dform2;
    public BookingMang(int en,String pass) {
        initComponents();
        setLocationRelativeTo(null); 
        unlckbtn.setVisible(false);
        gstlbl.setVisible(false);
        clrbtn.setEnabled(false);   
        updbtn.setEnabled(false);   
        if(en==1) gstvsbl();
        enb=en;
        this.pass=pass;
        model = (DefaultTableModel) showtbl.getModel();
        showtbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        showtbl.getColumnModel().getColumn(0).setPreferredWidth(55);
        showtbl.getColumnModel().getColumn(1).setPreferredWidth(70);
        showtbl.getColumnModel().getColumn(2).setPreferredWidth(61);
        showtbl.getColumnModel().getColumn(3).setPreferredWidth(80);
        showtbl.getColumnModel().getColumn(4).setPreferredWidth(80);
        showtbl.getColumnModel().getColumn(5).setPreferredWidth(55);
        showtbl.getColumnModel().getColumn(6).setPreferredWidth(58);
        dform1= new SimpleDateFormat("yyyy-MM-dd");
        dform2= new SimpleDateFormat("yyyy-MM-dd");
        
        ratelbl.setVisible(false); 
       try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",this.pass);
            stmt=con.createStatement();
            query="SELECT *  FROM BOOKING A, CUSTDETAIL B WHERE A.BOOK_ID = B.BOOK_ID ORDER BY A.BOOK_ID;";
            rs=stmt.executeQuery(query);
            displayRecord();
        }
        catch(SQLException ec)
        {
            JOptionPane.showMessageDialog(null, ec);
        }
       if(showtbl.getRowCount() == 0)
       {
           updbtn.setEnabled(false);
           editbtn.setEnabled(false);
           cnclbtn.setEnabled(false);
           srchbtn.setEnabled(false);
           rsttbtn.setEnabled(false);
           unlckbtn.setEnabled(false);
           calcbtn.setEnabled(false);
           clrbtn.setEnabled(false);
       }
    }
    
   public void displayRecord(){
       try
       {
           while(rs.next())
           {   
            bookid=rs.getInt("BOOK_ID");
            rmno=rs.getInt("ROOM_NO"); 
            D1=rs.getString("CHECK_IN");
            D2=rs.getString("CHECK_OUT");
            days=rs.getInt("NO_OF_DAYS");
            bill=rs.getInt("TOTALBILL");
            name=rs.getString("NAME");
            model.addRow(new Object[] {bookid,name,rmno,D1,D2,days,bill});
           }
       }
       catch(SQLException ec){
            JOptionPane.showMessageDialog(this, ec);
        } 
   }
   
   public void gstvsbl(){
   gstlbl.setVisible(true);
   unlckbtn.setVisible(true);
   updbtn.setEnabled(false);
   editbtn.setEnabled(false);
   cnclbtn.setEnabled(false);
   }
     public void clear(){
       int rows=model.getRowCount();
       if (rows>0)  
        {
            for (int i=0; i<rows; i++) model.removeRow(0);
       }
        sidtxt.setText("");
        snametxt.setText("");
        ardtchs.setDate(null);
        depdtchs.setDate(null);
        srmnotxt.setText("");
        sdaystxt.setText("");
        sbilltxt.setText("");
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cnclbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        clsbtn = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jLabel9 = new javax.swing.JLabel();
        sidtxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        snametxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        srmnotxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sdaystxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sbilltxt = new javax.swing.JTextField();
        ardtchs = new com.toedter.calendar.JDateChooser();
        depdtchs = new com.toedter.calendar.JDateChooser();
        calcbtn = new javax.swing.JButton();
        clrbtn = new javax.swing.JButton();
        ratelbl = new javax.swing.JLabel();
        srchbtn = new javax.swing.JButton();
        updbtn = new javax.swing.JButton();
        unlckbtn = new javax.swing.JButton();
        rsttbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showtbl = new javax.swing.JTable();
        gstlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BOOKING MANAGMENT");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Booked Room Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        cnclbtn.setText("Cancel Booking");
        cnclbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnclbtnActionPerformed(evt);
            }
        });

        editbtn.setText("Edit");
        editbtn.setToolTipText("SELECT A BOOKING FROM TABLE AND CLICK THIS TO EDIT IN BELOW TEXT FIELDS");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        clsbtn.setText("Close");
        clsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clsbtnActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(204, 204, 204));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Book ID");
        panel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, -1));
        panel1.add(sidtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 11, 52, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Customer Name");
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, -1, -1));
        panel1.add(snametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 37, 180, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Room No.");
        panel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, -1, -1));

        srmnotxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        srmnotxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                srmnotxtCaretUpdate(evt);
            }
        });
        srmnotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srmnotxtActionPerformed(evt);
            }
        });
        panel1.add(srmnotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 66, 52, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Check-In");
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Check-Out");
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, -1));
        panel1.add(sdaystxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 145, 73, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("No. of Days");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 147, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Bill Amount");
        panel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 173, -1, -1));
        panel1.add(sbilltxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 171, 94, -1));
        panel1.add(ardtchs, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 93, 154, -1));
        panel1.add(depdtchs, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 119, 154, -1));

        calcbtn.setText("Calculate");
        calcbtn.setToolTipText("Calculate no. of days and total bill according to Check-In and Check-Out date entered");
        calcbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcbtnActionPerformed(evt);
            }
        });
        panel1.add(calcbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 145, -1, -1));

        clrbtn.setText("Clear");
        clrbtn.setToolTipText("Reset no. of days,totalbil, Check-In and Check-Outl back to its original value in the database.");
        clrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrbtnActionPerformed(evt);
            }
        });
        panel1.add(clrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 174, -1, -1));

        ratelbl.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        ratelbl.setForeground(new java.awt.Color(255, 0, 51));
        panel1.add(ratelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 63, 115, 24));

        srchbtn.setText("Search");
        srchbtn.setToolTipText("ENTER INFO. ABOVE TEXT FIELDS AND CLICK THIS TO SEARCH AND SHOW MATCHING RECORDS\n");
        srchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchbtnActionPerformed(evt);
            }
        });
        panel1.add(srchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 70, -1));

        updbtn.setText("UPDATE");
        updbtn.setToolTipText("AFTER EDITTING CLICK THIS TO UPDATE THE INFORMATION");
        updbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updbtnActionPerformed(evt);
            }
        });
        panel1.add(updbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 80, -1));

        unlckbtn.setText("Unlock All Options");
        unlckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlckbtnActionPerformed(evt);
            }
        });

        rsttbtn.setText("Reset");
        rsttbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsttbtnActionPerformed(evt);
            }
        });

        showtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "CustName", "Roomno.", "CheckIn", "CheckOut", "Days", "TotalBill"
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rsttbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cnclbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(unlckbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clsbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editbtn)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnclbtn)
                            .addComponent(unlckbtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rsttbtn)
                            .addComponent(clsbtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gstlbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updbtnActionPerformed
  
        clrbtn.setEnabled(false);
        int id,rno,day;
        double nbill;
        String nname,d1,d2;  
        id=Integer.parseInt(sidtxt.getText());
        rno=Integer.parseInt(srmnotxt.getText());
        nname=snametxt.getText();
        if(ardtchs.getDate() == null || depdtchs.getDate() == null) JOptionPane.showMessageDialog(this,"Arrival or Departure Date not entered!!!");
        else 
        {
              d1=dform1.format(ardtchs.getDate());
              d2=dform2.format(depdtchs.getDate());  
              String query2,query4; 
              try 
               {
                  String query1="SELECT COUNT(*) CNT FROM BOOKING, ROOMDETAIL WHERE ROOMNO=ROOM_NO AND (( CHECK_IN >= '"+ d1 +"' AND CHECK_IN < '"+ d2 +"') || (CHECK_OUT > '"+ d1 +"' AND CHECK_OUT <= '"+ d2+"')) AND ROOMNO=" + rno + " AND BOOK_ID !="+ ebkid +" ;";
                  stmt2=con.createStatement();
                  rs1=stmt2.executeQuery(query1);
                  rs1.next();
                  int count =rs1.getInt(1);
                  Period diff=Period.between(LocalDate.parse(d1), LocalDate.parse(d2));
                  day = diff.getDays();  
                  if(day <= 0) JOptionPane.showMessageDialog(this,"Check-Out should be greater than Check-In date!!!!");    
                  else if (day>0)
                  { 
                       String T="SELECT COUNT(*) FROM ROOMDETAIL WHERE ROOMNO="+rno;
                       Statement S=con.createStatement();
                       ResultSet RT=S.executeQuery(T);
                       RT.next();
                       if(RT.getInt(1)==0) JOptionPane.showMessageDialog(this,"Error!!! Trying to book a room that doesn't exist. ");
                       else
                       {
                   if(count == 0)
                   {    
                       String temp="SELECT RATE FROM ROOMDETAIL WHERE ROOMNO="+rno;
                       Statement st=con.createStatement();
                       ResultSet rt=st.executeQuery(temp);
                       rt.next();
                    sdaystxt.setText(""+day);    
                    nbill=  rt.getInt(1)*day;
                    nbill = (nbill + nbill * 0.12);
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
                   stmt1=con.createStatement();  
                   Statement smt;      
                      int code=JOptionPane.showConfirmDialog(this,"Are you sure you want to update this information?","Confirm?",JOptionPane.YES_NO_OPTION);
                      if(code==JOptionPane.YES_OPTION)
                       {
                         query2="UPDATE BOOKING SET  ROOM_NO=" + rno + ",CHECK_IN='" + d1 + "',CHECK_OUT='"+ d2 + "',NO_OF_DAYS=" + day + ",TOTALBILL="+  nbill + " WHERE BOOK_ID=" + ebkid +";";
                         int s1=stmt1.executeUpdate(query2);
                         query4="UPDATE CUSTDETAIL SET ROOM_NO=" + rno + ", NAME='" + nname + "' WHERE BOOK_ID=" + ebkid + ";";
                         smt=con.createStatement();
                         int s2=smt.executeUpdate(query4);
                         if(s1>0 && s2>0) JOptionPane.showMessageDialog(this,"Updation Successful!!");
                         rs=stmt.executeQuery(query);
                         srchbtn.setEnabled(true);
                         ratelbl.setVisible(false);
                         sdaystxt.setEditable(true);
                         sidtxt.setEditable(true);
                         sbilltxt.setEditable(true);
                         updbtn.setEnabled(false);   
                         clear();
                         displayRecord();
                        }                   
                 }
                   else JOptionPane.showMessageDialog(null,"This Room is already booked for these dates");
                 }
                  }
               }
              catch(SQLException e){
                JOptionPane.showMessageDialog(this,e);
               }
           
        }
    }//GEN-LAST:event_updbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
   
        clrbtn.setEnabled(false);
        int row  =showtbl.getSelectedRow();  
        double rate; 
        if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
        else
        {
            updbtn.setEnabled(true);   
            srchbtn.setEnabled(false);  
            sdaystxt.setEditable(false);
            sbilltxt.setEditable(false);
            sidtxt.setEditable(false);
            D1= model.getValueAt(row,3).toString();
            D2= model.getValueAt(row,4).toString();
            ebkid= Integer.parseInt(model.getValueAt(row,0).toString());
            int rno=Integer.parseInt(model.getValueAt(row,2).toString());
            sidtxt.setText("" + ebkid);
            srmnotxt.setText("" + rno);
            ardtchs.setDate(Date.valueOf(D1));
            depdtchs.setDate(Date.valueOf(D2));
            sdays=Integer.parseInt(model.getValueAt(row,5).toString());
            sbill=Integer.parseInt(model.getValueAt(row,6).toString());
            snametxt.setText(model.getValueAt(row,1).toString());         
            sdaystxt.setText("" + sdays);
            sbilltxt.setText("" + sbill);
            ratelbl.setVisible(true);
            rate = (sbill  / ( sdays + (sdays * 0.12)));
            rate = Math.ceil(rate);
            ratelbl.setText("Rate -->" + rate);
        }
       
    }//GEN-LAST:event_editbtnActionPerformed

    private void cnclbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnclbtnActionPerformed
     updbtn.setEnabled(false);
     clrbtn.setEnabled(false);
     int bkid, rno,row;
     row  =showtbl.getSelectedRow();
     
     String queryy1,query2,query3,queryy;
     Statement st,st1,st2,st3;
     ResultSet r;
     if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
     else
     {
         bkid=Integer.parseInt(model.getValueAt(row,0).toString());
         rno=Integer.parseInt(model.getValueAt(row,2).toString());
        try 
        {
            int code=JOptionPane.showConfirmDialog(this,"Are you sure you want to cancel this booking?","Confirm?",JOptionPane.YES_NO_OPTION);
            if(code==JOptionPane.YES_OPTION)
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);    
                queryy1="SELECT COUNT(*) CNT FROM BOOKING WHERE ROOM_NO=" + rno + " GROUP BY ROOM_NO";
                st1=con.createStatement();
                r=st1.executeQuery(queryy1);
                r.next();
                int cnt=r.getInt("CNT");
                if(cnt == 1)
                {
                    query2="UPDATE ROOMDETAIL SET STATUS='VACANT' WHERE ROOMNO=" + rno + ";";
                    st2=con.createStatement();
                    st2.executeUpdate(query2);
                }
              //  query3="UPDATE CUSTDETAIL SET BOOK_ID=0, ROOM_NO=0 WHERE BOOK_ID=" + bkid +"";
                queryy="DELETE FROM BOOKING WHERE BOOK_ID=" + bkid +";";
                st=con.createStatement();
                st3=con.createStatement();
                int c1=st.executeUpdate(queryy);
              //  int c2=st3.executeUpdate(query3);
                if(c1>0) JOptionPane.showMessageDialog(this,"Updation Successful!!");
                stmt=con.createStatement();
                rs=stmt.executeQuery(query); 
                clear();
                displayRecord();
            }
        }
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex);
        }
     }
    }//GEN-LAST:event_cnclbtnActionPerformed

    private void clsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clsbtnActionPerformed
      NavigationFrame nf=new NavigationFrame(enb,pass);
      nf.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_clsbtnActionPerformed

    private void rsttbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsttbtnActionPerformed
        clear();
        updbtn.setEnabled(false);   
        sidtxt.setEditable(true);
        srchbtn.setEnabled(true);
        sdaystxt.setEditable(true);
        sbilltxt.setEditable(true);
        clrbtn.setEnabled(false);
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);    
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
            cnclbtn.setEnabled(true);
            unlckbtn.setVisible(false);
        }
        else if(mpass.equals("")) ;
        else JOptionPane.showMessageDialog(this,"Incorrect Master Password");
    }//GEN-LAST:event_unlckbtnActionPerformed

    private void calcbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcbtnActionPerformed
     
     String d1,d2,rno;
     int day,nbill;
     rno=srmnotxt.getText();
     if(ardtchs.getDate() == null || depdtchs.getDate() == null) JOptionPane.showMessageDialog(this,"Arrival or Departure Date not entered!!!");
     else
     {
         if(rno.equals("")) JOptionPane.showMessageDialog(null,"Room no. not entered");
         else
         {   
             clrbtn.setEnabled(true);
         d1=dform1.format(ardtchs.getDate());
         d2=dform2.format(depdtchs.getDate());
         Period diff=Period.between(LocalDate.parse(d1), LocalDate.parse(d2));
         day = diff.getDays();
         sdaystxt.setText(""+day);  
         try
          {
             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
             Statement smt=conn.createStatement();
             ResultSet rst=smt.executeQuery("SELECT RATE FROM ROOMDETAIL WHERE ROOMNO=" + rno);
             rst.next();
             nbill=  rst.getInt("RATE") * day;
             nbill = (int) (nbill + nbill * 0.12);
             sbilltxt.setText("" + nbill);
           }
         catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
           }
         }
     }
    }//GEN-LAST:event_calcbtnActionPerformed

    private void clrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrbtnActionPerformed

    sdaystxt.setText("" + sdays);
    sbilltxt.setText("" + sbill);
    ardtchs.setDate(Date.valueOf(D1));
    depdtchs.setDate(Date.valueOf(D2));  
    
    }//GEN-LAST:event_clrbtnActionPerformed

    private void srchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchbtnActionPerformed
      
        clrbtn.setEnabled(false);
        String sname,sid,srno,schin="",schout="",sdays,sbill;
        Statement smt;
        String query1;
        sname=snametxt.getText();
        sid = sidtxt.getText();
        srno = srmnotxt.getText();
        sdays = sdaystxt.getText();
        sbill = sbilltxt.getText();
        if( !(ardtchs.getDate() == null || depdtchs.getDate() == null))
        {
          schin=dform1.format(ardtchs.getDate());
          schout=dform2.format(depdtchs.getDate());
        }
        query1="SELECT * FROM BOOKING A, CUSTDETAIL B WHERE A.BOOK_ID = B.BOOK_ID AND NAME LIKE '%" +  sname + "%' AND A.BOOK_ID LIKE '%" + sid + "%' AND A.ROOM_NO LIKE '%"+ srno + "%' AND CHECK_IN LIKE '%"+ schin +"%' AND CHECK_OUT LIKE '%" + schout + "%' AND NO_OF_DAYS LIKE '%"+ sdays +"%' AND TOTALBILL LIKE '%"+ sbill +"%' ORDER BY A.BOOK_ID;";
        
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            smt=con.createStatement();
            rs=smt.executeQuery(query1);
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

    private void srmnotxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_srmnotxtCaretUpdate
     String rno=srmnotxt.getText().trim();
     int rlen=rno.length();
     if (srchbtn.isEnabled());
     else if (!(srchbtn.isEnabled()))
     {
        if(rlen == 3)
        {  
         ratelbl.setVisible(true);
         try
         {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
            Statement s=conn.createStatement();
            ResultSet r=s.executeQuery("SELECT COUNT(*) FROM ROOMDETAIL WHERE ROOMNO="+rno);
            r.next();
            if(r.getInt(1)!=0)
            {
                 Statement smt=conn.createStatement();
                 ResultSet rst=smt.executeQuery("SELECT RATE FROM ROOMDETAIL WHERE ROOMNO=" + rno);
                 rst.next();
                 ratelbl.setText("Rate -->" +  rst.getInt("RATE") );
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Entered room doesn't exist.");
                ratelbl.setVisible(false);
            }
         }
         catch(SQLException e){
             JOptionPane.showMessageDialog(null,e);
         }
        }
        else  ratelbl.setVisible(false);
     } 
    }//GEN-LAST:event_srmnotxtCaretUpdate

    private void srmnotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srmnotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srmnotxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ardtchs;
    private javax.swing.JButton calcbtn;
    private javax.swing.JButton clrbtn;
    private javax.swing.JButton clsbtn;
    private javax.swing.JButton cnclbtn;
    private com.toedter.calendar.JDateChooser depdtchs;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private javax.swing.JLabel ratelbl;
    private javax.swing.JButton rsttbtn;
    private javax.swing.JTextField sbilltxt;
    private javax.swing.JTextField sdaystxt;
    private javax.swing.JTable showtbl;
    private javax.swing.JTextField sidtxt;
    private javax.swing.JTextField snametxt;
    private javax.swing.JButton srchbtn;
    private javax.swing.JTextField srmnotxt;
    private javax.swing.JButton unlckbtn;
    private javax.swing.JButton updbtn;
    // End of variables declaration//GEN-END:variables
}
