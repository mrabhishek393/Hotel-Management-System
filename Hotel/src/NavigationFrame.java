
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class NavigationFrame extends javax.swing.JFrame {
    /**
     * Creates new form NavigationFrame
     * @param enb
     */
    Connection con;
    Statement stmt , stmt1,stmt2,stmt3,stmt4,stmt5,stmt6,stmt7,smt,nsmt;
    ResultSet rs,rs1,rs2,nrs;
    String query, query1,query2,query3,query4,query5,query6,query7,queryy,nquery;
    int enb;
    String pass;
    public NavigationFrame(int en,String pass) {    
        initComponents();
        setLocationRelativeTo(null);
        gstlbl.setVisible(false);
        infoimg.setVisible(false);
        if(en==1) 
        {
            gstlbl.setVisible(true);
            infoimg.setVisible(true);
        }
        enb=en;
        String bkid,rmno,name,d1,d2,day,bill;
        int count;
        this.pass=pass;
       // JOptionPane.showMessageDialog(this, pass);
        try
        {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",this.pass);
             
             smt  = con.createStatement();
             nsmt  = con.createStatement();
             stmt  = con.createStatement();
             stmt1= con.createStatement();
             stmt2= con.createStatement();
             stmt3= con.createStatement();
             stmt4= con.createStatement();
             stmt5= con.createStatement();
             stmt6= con.createStatement();
             stmt7= con.createStatement();
             
             query = "SELECT * FROM BOOKING A, CUSTDETAIL B WHERE A.BOOK_ID = B.BOOK_ID AND CURDATE() >= CHECK_OUT;";     
             rs=stmt.executeQuery(query);
             while(rs.next())
             {
                 bkid= rs.getString("BOOK_ID");
                 rmno= rs.getString("ROOM_NO");
                 name = rs.getString("NAME");
                 d1=rs.getString("CHECK_IN");
                 d2=rs.getString("CHECK_OUT");
                 day=rs.getString("NO_OF_DAYS");
                 bill=rs.getString("TOTALBILL");
                 
                 nquery="SELECT COUNT(*) CNT FROM CHECK_OUT WHERE BOOKID = " + bkid;
                 nrs = nsmt.executeQuery(nquery);
                 nrs.next();
                 count = nrs.getInt("CNT");
                 if( count == 0 )
                 {    
                 queryy="INSERT INTO CHECK_OUT VALUES(" + bkid + ",'" + name + "'," + rmno + ",'" + d1 + "','" + d2 + "'," + day + "," + bill + ");";
                 smt.executeUpdate(queryy);
                 }
                 else if (count == 1)
                 {
                     queryy="UPDATE CHECK_OUT SET NAME ='" + name + "', ROOMNO=" + rmno + ", CHECK_IN='" + d1 + "',CHECK_OUT='" + d2 + "',NO_OF_DAYS=" + day + ",TOTALBILL=" + bill + " WHERE BOOKID="+ bkid+";"; 
                     smt.executeUpdate(queryy);
                 }
             //    query1="UPDATE CUSTDETAIL SET BOOK_ID=0, ROOM_NO=0 WHERE BOOK_ID=" + bkid + ";" ;
             //    stmt1.executeUpdate(query1);
                 query2="DELETE FROM BOOKING WHERE BOOK_ID=" + bkid + ";" ;    
                 stmt2.executeUpdate(query2);
             }
             query5="SELECT * FROM BOOKING WHERE CURDATE() < CHECK_IN || CURDATE() >= CHECK_OUT;";
             rs2=stmt5.executeQuery(query5);
             
             while (rs2.next())
             {
                rmno= rs2.getString("ROOM_NO");
                query6="UPDATE ROOMDETAIL SET STATUS = 'VACANT'  WHERE ROOMNO=" + rmno + ";";
                stmt6.executeUpdate(query6);
             }
             
             query3="SELECT * FROM BOOKING A, CUSTDETAIL B WHERE A.BOOK_ID = B.BOOK_ID AND CURDATE() >= CHECK_IN AND CURDATE() < CHECK_OUT;";
             rs1=stmt3.executeQuery(query3);
             
             while (rs1.next())
             {
                 bkid= rs1.getString("BOOK_ID");
                 rmno= rs1.getString("ROOM_NO");
                 name = rs1.getString("NAME");
                 d1=rs1.getString("CHECK_IN");
                 d2=rs1.getString("CHECK_OUT");
                 day=rs1.getString("NO_OF_DAYS");
                 bill=rs1.getString("TOTALBILL");
                 nquery="SELECT COUNT(*) CNT FROM CHECK_OUT WHERE BOOKID = " + bkid;
                 nrs = nsmt.executeQuery(nquery);
                 nrs.next();
                 count = nrs.getInt("CNT");
                 if( count == 0 )
                 {    
                  queryy="INSERT INTO CHECK_OUT VALUES(" + bkid + ",'" + name + "'," + rmno + ",'" + d1 + "','" + d2 + "'," + day + "," + bill + ");";
                  smt.executeUpdate(queryy);
                 }
                 else if (count == 1)
                 {
                    queryy="UPDATE CHECK_OUT SET NAME ='" + name + "', ROOMNO=" + rmno + ", CHECK_IN='" + d1 + "',CHECK_OUT='" + d2 + "',NO_OF_DAYS=" + day + ",TOTALBILL=" + bill +  " WHERE BOOKID="+ bkid + ";"; 
                    smt.executeUpdate(queryy);
                 }            
                query4="UPDATE ROOMDETAIL SET STATUS = 'BOOKED'  WHERE ROOMNO=" + rmno + ";";
                stmt4.executeUpdate(query4);
              }
                   
             query7="UPDATE ROOMDETAIL SET STATUS = 'VACANT' WHERE ROOMNO NOT IN(SELECT ROOM_NO FROM BOOKING);";
             stmt7.executeUpdate(query7);
          }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rmbkngbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        cusmangbtn = new javax.swing.JButton();
        bkmangbtn = new javax.swing.JButton();
        rmmangbtn = new javax.swing.JButton();
        stfmangbtn = new javax.swing.JButton();
        choutbtn = new javax.swing.JButton();
        gstlbl = new javax.swing.JLabel();
        infoimg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EVEN Hotels");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Click on the option you want to perform..", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        rmbkngbtn.setText("Room Booking");
        rmbkngbtn.setToolTipText("New Booking");
        rmbkngbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmbkngbtnActionPerformed(evt);
            }
        });

        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        cusmangbtn.setText("Customer Management");
        cusmangbtn.setToolTipText("Information of all the customers");
        cusmangbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusmangbtnActionPerformed(evt);
            }
        });

        bkmangbtn.setText("Booking Management");
        bkmangbtn.setToolTipText("Information of currently active bookings");
        bkmangbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkmangbtnActionPerformed(evt);
            }
        });

        rmmangbtn.setText("Room Management");
        rmmangbtn.setToolTipText("Information of all the Rooms\n");
        rmmangbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmmangbtnActionPerformed(evt);
            }
        });

        stfmangbtn.setText("Staff Management");
        stfmangbtn.setToolTipText("Information of all the staff members");
        stfmangbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stfmangbtnActionPerformed(evt);
            }
        });

        choutbtn.setText("Check - Out");
        choutbtn.setToolTipText("Check-Out option for all the customers who are currently staying");
        choutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rmbkngbtn)
                    .addComponent(rmmangbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(stfmangbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bkmangbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cusmangbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bkmangbtn)
                    .addComponent(rmbkngbtn)
                    .addComponent(cusmangbtn))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rmmangbtn)
                    .addComponent(stfmangbtn)
                    .addComponent(choutbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitbtn)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");

        infoimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N
        infoimg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoimgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gstlbl)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(infoimg)
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gstlbl)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(infoimg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(542, 343));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void stfmangbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stfmangbtnActionPerformed
        if(enb == 1)
        {   
          String mpass=JOptionPane.showInputDialog(this,"Enter Master Password");
          if(mpass==null) mpass="";
          if(mpass.equals("1234"))
          {
             StaffMang sm=new StaffMang(enb,pass);
             sm.setVisible(true);
          }
          else if(mpass.equals("")) ;
          else JOptionPane.showMessageDialog(this,"Incorrect Master Password");
        }
        else 
        {
            StaffMang sm=new StaffMang(enb,pass);
             sm.setVisible(true);
        }
    }//GEN-LAST:event_stfmangbtnActionPerformed

    private void rmmangbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmmangbtnActionPerformed
        this.dispose();
        RoomMang rm=new RoomMang(enb,pass);
        rm.setVisible(true);
    }//GEN-LAST:event_rmmangbtnActionPerformed

    private void rmbkngbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmbkngbtnActionPerformed
        this.dispose();
        Availability avail=new Availability(enb,pass);
        avail.setVisible(true);
    }//GEN-LAST:event_rmbkngbtnActionPerformed

    private void cusmangbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusmangbtnActionPerformed
        this.dispose();
        CustomerMang cm=new CustomerMang(enb,pass);
        cm.setVisible(true);
    }//GEN-LAST:event_cusmangbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        this.dispose();
        Login log=new Login(pass);
        log.setVisible(true);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void bkmangbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkmangbtnActionPerformed
        this.dispose();
        BookingMang bm=new BookingMang(enb,pass);
        bm.setVisible(true);
    }//GEN-LAST:event_bkmangbtnActionPerformed

    private void infoimgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoimgMouseClicked
    JOptionPane.showMessageDialog(this,"WELCOME GUEST!!!! \n All Functions are not available to perform for Guest Entries. \n If you want to perform all the functions \n contact Administrator for MASTER PASSWORD.");
    }//GEN-LAST:event_infoimgMouseClicked

    private void choutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choutbtnActionPerformed
    this.dispose();
    CheckOut ch = new CheckOut(enb,pass);
    ch.setVisible(true);
    }//GEN-LAST:event_choutbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkmangbtn;
    private javax.swing.JButton choutbtn;
    private javax.swing.JButton cusmangbtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel infoimg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rmbkngbtn;
    private javax.swing.JButton rmmangbtn;
    private javax.swing.JButton stfmangbtn;
    // End of variables declaration//GEN-END:variables
}
