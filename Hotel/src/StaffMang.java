import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class StaffMang extends javax.swing.JFrame {

    Connection con;
    Statement smt,smt1;
    ResultSet rs;
    String pass,name,query,passw;
    int uid,eid,enb;
    int newbt=0,editbt=0;
    DefaultTableModel model;
    public StaffMang(int en,String passw) {  
        initComponents();
        setLocationRelativeTo(null);
        hidenew();      
        updbtn.setEnabled(false); 
        gstlbl.setVisible(false);
        model = (DefaultTableModel) showtbl.getModel();
         enb=en;
        this.passw=passw;
        try
        {      
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",this.passw);
            query = "SELECT * FROM LOGIN;";
            smt=con.createStatement();
            rs=smt.executeQuery(query);
            displayRecord();
             }
        catch(SQLException e)
        {  
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        re = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        passtxt = new javax.swing.JTextField();
        rpasstxt = new javax.swing.JTextField();
        clsbtn = new javax.swing.JButton();
        uidtxt = new javax.swing.JTextField();
        e1 = new javax.swing.JLabel();
        e2 = new javax.swing.JLabel();
        e3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sidtxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        snametxt = new javax.swing.JTextField();
        srchbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        showtbl = new javax.swing.JTable();
        rsttbtn = new javax.swing.JButton();
        updbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gstlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("STAFF MANAGMENT");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Staff Management Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

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
        editbtn.setToolTipText("SELECT A STAFF MEMBER FROM TABLE AND CLICK THIS TO EDIT IN BELOW TEXT FIELDS");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        delbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        delbtn.setText("Delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Password");

        re.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        re.setText("Re Enter Password");

        nametxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        passtxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        rpasstxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        clsbtn.setText("Close");
        clsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clsbtnActionPerformed(evt);
            }
        });

        e1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        e1.setText("Enter");

        e2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        e2.setText("Enter");

        e3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        e3.setText("Enter");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText(" User ID");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Search for Specific Staff member\\s");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("User Id");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Username");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabel4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(srchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(42, 42, 42)
                                .addComponent(sidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addComponent(snametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(sidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(snametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(srchbtn)
                .addGap(326, 326, 326))
        );

        showtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showtbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(showtbl);

        rsttbtn.setText("Reset");
        rsttbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsttbtnActionPerformed(evt);
            }
        });

        updbtn.setText("Update");
        updbtn.setToolTipText("AFTER EDITTING/NEW CLICK THIS TO UPDATE THE INFORMATION");
        updbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(delbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(newbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rsttbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(clsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(170, 170, 170))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(e2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(e1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(e3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(re))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nametxt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(passtxt)
                    .addComponent(rpasstxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(editbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rsttbtn)
                            .addComponent(newbtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clsbtn)
                            .addComponent(delbtn))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(e1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updbtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gstlbl)
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gstlbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        setSize(new java.awt.Dimension(685, 526));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //FETCH THE VALUES FROM DATABASE TO TEXT FIELDS AND TEXT AREA
    public final void displayRecord(){
        try
        {
            while(rs.next())
             {
              uid=rs.getInt("USERID");
              pass=rs.getString("PASSWORD");
              name=rs.getString("USERNAME");
              model.addRow(new Object[] {uid,name,pass});
             }
        }
        catch(SQLException ec)
        {
            JOptionPane.showMessageDialog(this,ec);
        }
    } 
    public void hidenew(){
    e1.setVisible(false);
    e2.setVisible(false);
    e3.setVisible(false);
    re.setVisible(false);
    rpasstxt.setVisible(false);
    }
     public void gstvsbl(){
   gstlbl.setVisible(true); 
   updbtn.setEnabled(false);
   editbtn.setEnabled(false);
   delbtn.setEnabled(false);
   newbtn.setEnabled(false);
  }
     public void cleartbl(){
     int rows=model.getRowCount();
if (rows>0)
 {
   for (int i=0; i<rows; i++)
    model.removeRow(0); 
  }
   uidtxt.setText("");
   nametxt.setText("");
   passtxt.setText("");
   rpasstxt.setText("");
      }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened

//GEN-FIRST:event_jButton7ActionPerformed
 
//GEN-LAST:event_jButton7ActionPerformed

//GEN-FIRST:event_jButton5ActionPerformed
 
//GEN-LAST:event_jButton5ActionPerformed

//GEN-FIRST:event_jButton3ActionPerformed

//GEN-LAST:event_jButton3ActionPerformed

//GEN-FIRST:event_jButton2ActionPerformed
 
//GEN-LAST:event_jButton2ActionPerformed

//GEN-FIRST:event_jButton1ActionPerformed
 
//GEN-LAST:event_jButton1ActionPerformed

    private void clsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clsbtnActionPerformed
    NavigationFrame nf=new NavigationFrame(enb,passw);
    nf.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_clsbtnActionPerformed

    private void newbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbtnActionPerformed
       editbt=0;
       updbtn.setEnabled(true); 
       newbt=1;
       e1.setVisible(true);
       e2.setVisible(true);
       e3.setVisible(true);
       re.setVisible(true);
       rpasstxt.setVisible(true);
       uidtxt.setText("");
       nametxt.setText("");
       passtxt.setText("");
       rpasstxt.setText("");
    }//GEN-LAST:event_newbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
         
         String query1;
         int row  =showtbl.getSelectedRow();
         
         if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
         else
         {
             int id=Integer.parseInt(model.getValueAt(row,0).toString()); 
          try
          {
             int cnfrm=JOptionPane.showConfirmDialog(this,"Are you sure you want delete this record?","Confirm?",JOptionPane.YES_NO_OPTION);
             if(cnfrm==JOptionPane.YES_OPTION) 
             {
                 query1="DELETE FROM LOGIN WHERE USERID=" + id + ";";
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",passw);
                 Statement stmt=con.createStatement();
                 int c=stmt.executeUpdate(query1);
                 if(c>0) JOptionPane.showMessageDialog(this,"Successfully Deleted");     
                 query1 = "SELECT * FROM LOGIN;";
                 smt=con.createStatement();
                 rs=smt.executeQuery(query1);
                 cleartbl();
                 displayRecord();
             }
          }
          catch(SQLException ex){
          JOptionPane.showMessageDialog(this,ex);
          }
         }
    }//GEN-LAST:event_delbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed

    int row  =showtbl.getSelectedRow();
    if(row == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
    else
    {
       updbtn.setEnabled(true); 
       newbt=0;
       editbt=1;
       eid= Integer.parseInt(model.getValueAt(row,0).toString()); 
       uidtxt.setText(""+ eid);
       nametxt.setText(model.getValueAt(row,1).toString());
       passtxt.setText(model.getValueAt(row,2).toString());
    }
    }//GEN-LAST:event_editbtnActionPerformed

    private void updbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updbtnActionPerformed

         String uname,upass,query1,query2;
         int id,cnt=1;
         id=Integer.parseInt(uidtxt.getText());
         uname=nametxt.getText();
         upass=passtxt.getText();
         try
         {
           query2="SELECT COUNT(*) CNT FROM LOGIN WHERE USERID=" +id + ";";  
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",passw);
           Statement stmt=con.createStatement();
           ResultSet res=stmt.executeQuery(query2);
           res.next();
           cnt=res.getInt("CNT");
         }
         catch(SQLException r){
         JOptionPane.showMessageDialog(this,r);
         }
         if(editbt==1)
         {
             query1="UPDATE LOGIN SET USERID=" +id + ", USERNAME='" + uname + "', PASSWORD='" + upass + "' WHERE USERID=" + eid + ";";
             try
             {
                int cnfrm=JOptionPane.showConfirmDialog(this,"Are you sure you want update this information?","Confirm?",JOptionPane.YES_NO_OPTION);
                if(cnfrm==JOptionPane.YES_OPTION)
                {
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",passw);
                  smt1=con.createStatement();
                  int c=smt1.executeUpdate(query1);
                  if(c>0) JOptionPane.showMessageDialog(this,"Updation Successful!!");
                  cleartbl();
                  query = "SELECT * FROM LOGIN;";
                  smt=con.createStatement();
                  rs=smt.executeQuery(query);
                  displayRecord();
                  updbtn.setEnabled(false); 
                 }
              }
             catch(SQLException e){
                 JOptionPane.showMessageDialog(this,e);
             }     
         }
         else if(newbt==1)
         {
            if(cnt==0)
            {   
            String urpass=rpasstxt.getText();
            if(upass.equals(urpass))
            {    
               int cnfrm=JOptionPane.showConfirmDialog(this,"Are you sure you want insert this as new record?","Confirm?",JOptionPane.YES_NO_OPTION);
               if(cnfrm==JOptionPane.YES_OPTION)
               {
               query1="INSERT INTO LOGIN VALUES(" + id + ",'" + uname + "','" + upass + "');";
               try
                 {
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",passw);
                   smt1=con.createStatement();
                   int c=smt1.executeUpdate(query1);
                   if(c>0) JOptionPane.showMessageDialog(this,"Updation Successful!!"); 
                   updbtn.setEnabled(false);
                   query = "SELECT * FROM LOGIN;";
                   smt=con.createStatement();
                   rs=smt.executeQuery(query);
                   cleartbl();
                   hidenew();
                   displayRecord();
                 }
               catch(SQLException e){
                 JOptionPane.showMessageDialog(this,e);
                 }     
               }           
             }
            else JOptionPane.showMessageDialog(this,"Oops!!!Passwords doesn't match.");                
           }
            else JOptionPane.showMessageDialog(this,"Oops!!! User Id already exists.");   
            
         }
    }//GEN-LAST:event_updbtnActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void srchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchbtnActionPerformed
       cleartbl();
       String sname,sid;
       sname=snametxt.getText();
       sid=sidtxt.getText();
       Statement stmt;
       String query1;
       query1="SELECT * FROM LOGIN WHERE USERID LIKE '%" + sid + "%' AND USERNAME LIKE '%" + sname + "%';"; 
       try
       {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",passw);
           stmt=con.createStatement();
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
       catch(SQLException ex){
       JOptionPane.showMessageDialog(this,ex);
       }
    }//GEN-LAST:event_srchbtnActionPerformed

    private void rsttbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsttbtnActionPerformed
        hidenew();
        updbtn.setEnabled(false); 
        cleartbl();
                try
                 {
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",passw);
                   smt=con.createStatement();
                   rs=smt.executeQuery(query);     
                  displayRecord();
                 }
               catch(SQLException e){
                 JOptionPane.showMessageDialog(this,e);
                 }     
    }//GEN-LAST:event_rsttbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clsbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel e1;
    private javax.swing.JLabel e2;
    private javax.swing.JLabel e3;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nametxt;
    private javax.swing.JButton newbtn;
    private javax.swing.JTextField passtxt;
    private javax.swing.JLabel re;
    private javax.swing.JTextField rpasstxt;
    private javax.swing.JButton rsttbtn;
    private javax.swing.JTable showtbl;
    private javax.swing.JTextField sidtxt;
    private javax.swing.JTextField snametxt;
    private javax.swing.JButton srchbtn;
    private javax.swing.JTextField uidtxt;
    private javax.swing.JButton updbtn;
    // End of variables declaration//GEN-END:variables
}
