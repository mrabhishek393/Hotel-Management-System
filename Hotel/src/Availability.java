import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Availability extends javax.swing.JFrame {

    Connection con;
    Statement stmt1,stmt2,stmt3,stmt4;
    ResultSet rs2,rs3,rs4;
    int enb,days;
    String D1,D2,pass;
    public Availability(int en,String pass) {
        initComponents();
        setLocationRelativeTo(null);
        daystxt.setEditable(false);
        gstlbl.setVisible(false);
        if(en==1) gstlbl.setVisible(true);
        enb=en;  
        this.pass=pass;
    }
public Object GetData(JTable jTable1, int row_index, int col_index){
		return jTable1.getModel().getValueAt(row_index, col_index);
	}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomrbtngrp = new javax.swing.ButtonGroup();
        acrbtngrp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        closebtn = new javax.swing.JButton();
        probtn = new javax.swing.JButton();
        checkbtn = new javax.swing.JButton();
        rstbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomtable = new javax.swing.JTable();
        gstlbl = new javax.swing.JLabel();
        ardtchs = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        depdtchs = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        rmdtbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        daystxt = new javax.swing.JTextField();
        delrbtn = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        suprbtn = new javax.swing.JRadioButton();
        execrbtn = new javax.swing.JRadioButton();
        presrbtn = new javax.swing.JRadioButton();
        nacrbtn = new javax.swing.JRadioButton();
        acrbtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Availibilty Checking Form");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N

        closebtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        probtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        probtn.setText("Proceed");
        probtn.setToolTipText("Select from the list and click Proceed");
        probtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probtnActionPerformed(evt);
            }
        });

        checkbtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkbtn.setText("Check Available Rooms");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtnActionPerformed(evt);
            }
        });

        rstbtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rstbtn.setText("Reset");
        rstbtn.setToolTipText("All Fields will be resetted for new entries.");
        rstbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rstbtnActionPerformed(evt);
            }
        });

        roomtable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No.", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomtable.getTableHeader().setReorderingAllowed(false);
        roomtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomtable);
        if (roomtable.getColumnModel().getColumnCount() > 0) {
            roomtable.getColumnModel().getColumn(0).setResizable(false);
            roomtable.getColumnModel().getColumn(0).setPreferredWidth(60);
            roomtable.getColumnModel().getColumn(1).setResizable(false);
            roomtable.getColumnModel().getColumn(1).setPreferredWidth(70);
        }

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Arrival Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Departure Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("List of Availabale Room/s");

        rmdtbtn.setFont(new java.awt.Font("Monotype Corsiva", 0, 12)); // NOI18N
        rmdtbtn.setText("Check Room Details");
        rmdtbtn.setToolTipText("Shows information and design about the room");
        rmdtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmdtbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("<html><body><B><U>Note: -</U></B> <br> Each Room contains 1 DoubleBed.</body</html>");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Booking for");

        daystxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        roomrbtngrp.add(delrbtn);
        delrbtn.setText("Deluxe");
        delrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delrbtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Room Type");

        roomrbtngrp.add(suprbtn);
        suprbtn.setText("Superior");

        roomrbtngrp.add(execrbtn);
        execrbtn.setText("Executive");

        roomrbtngrp.add(presrbtn);
        presrbtn.setText("Presidential Suite");

        acrbtngrp.add(nacrbtn);
        nacrbtn.setText("Non-AC");

        acrbtngrp.add(acrbtn);
        acrbtn.setText("AC");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("AC/NON-AC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ardtchs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(depdtchs, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(execrbtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(delrbtn)
                            .addComponent(suprbtn))
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nacrbtn)
                            .addComponent(acrbtn)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(presrbtn)
                            .addGap(18, 18, 18)
                            .addComponent(checkbtn))
                        .addComponent(rstbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(daystxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(probtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rmdtbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(gstlbl)
                .addGap(228, 228, 228)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gstlbl))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(daystxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(probtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(ardtchs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(depdtchs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(delrbtn)
                                .addComponent(acrbtn))
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(suprbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nacrbtn))
                            .addGap(9, 9, 9)
                            .addComponent(execrbtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(checkbtn)
                                .addComponent(presrbtn)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmdtbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rstbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closebtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
    NavigationFrame nf=new NavigationFrame(enb,pass);
    nf.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_closebtnActionPerformed

    private void checkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbtnActionPerformed

DefaultTableModel model=(DefaultTableModel) roomtable.getModel();
int rows=model.getRowCount();
if (rows>0)
{
for (int i=0; i<rows; i++)
model.removeRow(0); 
}
String room="",ac="";
SimpleDateFormat dform1= new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat dform2= new SimpleDateFormat("yyyy-MM-dd");
LocalDate localDate = LocalDate.now();

if(ardtchs.getDate() == null || depdtchs.getDate() == null) JOptionPane.showMessageDialog(this,"Arrival or Departure Date not entered!!!");
else
{
    D1=dform1.format(ardtchs.getDate());
    D2=dform2.format(depdtchs.getDate());
    Period diff=Period.between(LocalDate.parse(D1), LocalDate.parse(D2));
    days = diff.getDays();
      try 
      {
        if(days < 0) JOptionPane.showMessageDialog(this,"Check-Out should be greater than Check-In date!!!!");
        else if (days>0)
        {
            Period differ=Period.between(localDate, LocalDate.parse(D1));
            int dd=differ.getDays();
            if (dd < 0) JOptionPane.showMessageDialog(this,"Check-In date should be greater than Current Date!!!!");
            else
            {    
            daystxt.setText(""+days + " day/s");
            if(!(delrbtn.isSelected() || execrbtn.isSelected() || presrbtn.isSelected() || suprbtn.isSelected())) JOptionPane.showMessageDialog(this,"Room Type not Selected!");
            else if(!(acrbtn.isSelected() || nacrbtn.isSelected())) JOptionPane.showMessageDialog(this," AC | NON-AC NOT SELECTED ");
            else 
              {
                 if(rows == -1) JOptionPane.showMessageDialog(null,"No Record Selected!!");
                 else
                 {  
                 if(delrbtn.isSelected()) room="DELUXE";
                 else if (suprbtn.isSelected()) room="SUPERIOR"; 
                 else if (execrbtn.isSelected()) room="EXECUTIVE";
                 else if (presrbtn.isSelected()) room="PRESIDENTIAL SUITE"; 
             
                 if(acrbtn.isSelected()) ac="AC";
                 else if(nacrbtn.isSelected()) ac="NON-AC";
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root",pass);
                 stmt4=con.createStatement();
                 String query4="SELECT COUNT(*) CNT FROM BOOKING, ROOMDETAIL WHERE ROOMNO=ROOM_NO AND (( CHECK_IN >= '"+ D1 +"' AND CHECK_IN < '"+ D2 +"') || (CHECK_OUT > '"+ D1 +"' AND CHECK_OUT <= '"+ D2+"')) AND ROOMTYPE='" + room + "' AND AC_NONAC ='" + ac + "' ;";
                 rs4=stmt4.executeQuery(query4);
                 rs4.next();
                 int count =rs4.getInt("CNT");
                 try
                  {
                    stmt2 = (Statement) con.createStatement();
                    stmt3 = (Statement) con.createStatement();
                    String query2="SELECT ROOMNO, RATE FROM ROOMDETAIL WHERE ROOMTYPE='" + room + "' AND STATUS="+ " 'VACANT' AND AC_NONAC='" + ac + "' AND ROOMNO NOT IN(SELECT DISTINCT(ROOM_NO) FROM BOOKING);";  
                    rs2=stmt2.executeQuery(query2);
                    while(rs2.next())
                     {
                       int roomno = rs2.getInt("ROOMNO");
                       int rate = rs2.getInt("RATE");
                       model.addRow (new Object[] {roomno,rate});
                       
                     }
                    if(count==0) 
                    {
                      String query3="SELECT ROOMNO, RATE FROM ROOMDETAIL, BOOKING WHERE ROOMNO=ROOM_NO AND ROOMTYPE='" + room + "' AND AC_NONAC='" +ac + "';"; 
                      rs3=stmt3.executeQuery(query3);
                       while(rs3.next())
                     {
                       int roomno = rs3.getInt("ROOMNO");
                       int rate = rs3.getInt("RATE");
                       model.addRow (new Object[] {roomno,rate});
                     }
                    }
                   }
                  catch (SQLException err) {
                 JOptionPane.showMessageDialog(this,err.getMessage());
                   }
               }
                 int rowcnt=model.getRowCount();
                 if (rowcnt==0) JOptionPane.showMessageDialog(this,"No Rooms Available");
              }
            }
         } 
       }
      catch (SQLException err) {
           JOptionPane.showMessageDialog(this, err.getMessage());
                  }
     }
    }//GEN-LAST:event_checkbtnActionPerformed

    
    private void probtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probtnActionPerformed
       String room="",ac="";
        int rno=roomtable.getSelectedRow();
        Object obj1,obj2;
        obj1 = GetData(roomtable, rno, 0);
        obj2 = GetData(roomtable, rno, 1);
        DefaultTableModel model=(DefaultTableModel) roomtable.getModel();
        if(delrbtn.isSelected()) room="DELUXE";
        else if (suprbtn.isSelected()) room="SUPERIOR"; 
        else if (execrbtn.isSelected()) room="EXECUTIVE";
        else if (presrbtn.isSelected()) room="PRESIDENTIAL SUITE"; 
             
         if(acrbtn.isSelected()) ac="AC";
         else if(nacrbtn.isSelected()) ac="NON-AC";
        BookRoom br=new BookRoom(D1,D2,days,room,ac,obj1,obj2,enb,pass);
        br.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_probtnActionPerformed

    private void roomtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomtableMouseClicked
       
    }//GEN-LAST:event_roomtableMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //jPanel1.setOpaque(true);
        jLabel9.setOpaque(true);
        roomtable.setToolTipText("Select the Room want to reserve");
        probtn.setToolTipText("Select the Room from the list and click this button for Room Booking");
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    private void rstbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rstbtnActionPerformed
DefaultTableModel model=(DefaultTableModel) roomtable.getModel();
int rows=model.getRowCount();
if (rows>0)
{
for (int i=0; i<rows; i++)
model.removeRow(0); 
}
roomrbtngrp.clearSelection();
acrbtngrp.clearSelection();
daystxt.setText("");
ardtchs.setDate(null);
depdtchs.setDate(null);
    }//GEN-LAST:event_rstbtnActionPerformed

    private void delrbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delrbtnActionPerformed
       
    }//GEN-LAST:event_delrbtnActionPerformed

    private void rmdtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmdtbtnActionPerformed
    if(delrbtn.isSelected())
    {
        Deluxe dl=new Deluxe();
        dl.setVisible(true);
    }
    else if(suprbtn.isSelected())
    {
        Superior sp=new Superior();
        sp.setVisible(true);
    }
    else if(execrbtn.isSelected())
    {
        Executive ex=new Executive();
        ex.setVisible(true);
    }
    else if(presrbtn.isSelected())
    {
        Presidential_suite ps=new  Presidential_suite();
        ps.setVisible(true);
    }
    else JOptionPane.showMessageDialog(this,"No Room Selected");
    }//GEN-LAST:event_rmdtbtnActionPerformed

    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Availability().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton acrbtn;
    private javax.swing.ButtonGroup acrbtngrp;
    private com.toedter.calendar.JDateChooser ardtchs;
    private javax.swing.JButton checkbtn;
    private javax.swing.JButton closebtn;
    private javax.swing.JTextField daystxt;
    private javax.swing.JRadioButton delrbtn;
    private com.toedter.calendar.JDateChooser depdtchs;
    private javax.swing.JRadioButton execrbtn;
    private javax.swing.JLabel gstlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton nacrbtn;
    private javax.swing.JRadioButton presrbtn;
    private javax.swing.JButton probtn;
    private javax.swing.JButton rmdtbtn;
    private javax.swing.ButtonGroup roomrbtngrp;
    public javax.swing.JTable roomtable;
    private javax.swing.JButton rstbtn;
    private javax.swing.JRadioButton suprbtn;
    // End of variables declaration//GEN-END:variables
}
