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
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomtable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        probtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        daystxt = new javax.swing.JTextField();
        closebtn = new javax.swing.JButton();
        checkbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        delrbtn = new javax.swing.JRadioButton();
        suprbtn = new javax.swing.JRadioButton();
        execrbtn = new javax.swing.JRadioButton();
        presrbtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        acrbtn = new javax.swing.JRadioButton();
        nacrbtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        gstlbl = new javax.swing.JLabel();
        ardtchs = new com.toedter.calendar.JDateChooser();
        depdtchs = new com.toedter.calendar.JDateChooser();
        rstbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rmdtbtn = new javax.swing.JButton();

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Departure Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 27, -1, 20));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 110));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("List of Availabale Room/s");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Arrival Date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 27, -1, -1));

        probtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        probtn.setText("Proceed");
        probtn.setToolTipText("Select from the list and click Proceed");
        probtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probtnActionPerformed(evt);
            }
        });
        jPanel1.add(probtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 177, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Booking for");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 30, -1, -1));

        daystxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(daystxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 27, 75, -1));

        closebtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        jPanel1.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 177, -1));

        checkbtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkbtn.setText("Check Available Rooms");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtnActionPerformed(evt);
            }
        });
        jPanel1.add(checkbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Room Type");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        roomrbtngrp.add(delrbtn);
        delrbtn.setText("Deluxe");
        delrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delrbtnActionPerformed(evt);
            }
        });
        jPanel1.add(delrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        roomrbtngrp.add(suprbtn);
        suprbtn.setText("Superior");
        jPanel1.add(suprbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 20));

        roomrbtngrp.add(execrbtn);
        execrbtn.setText("Executive");
        jPanel1.add(execrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        roomrbtngrp.add(presrbtn);
        presrbtn.setText("Presidential Suite");
        jPanel1.add(presrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("AC/NON-AC");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        acrbtngrp.add(acrbtn);
        acrbtn.setText("AC");
        jPanel1.add(acrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        acrbtngrp.add(nacrbtn);
        nacrbtn.setText("Non-AC");
        jPanel1.add(nacrbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Even_Hotels_logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 250, 120));

        gstlbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gstlbl.setForeground(new java.awt.Color(204, 0, 51));
        gstlbl.setText("Guest Mode");
        jPanel1.add(gstlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(ardtchs, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 27, 186, -1));
        jPanel1.add(depdtchs, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 27, 161, -1));

        rstbtn.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rstbtn.setText("Reset");
        rstbtn.setToolTipText("All Fields will be resetted for new entries.");
        rstbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rstbtnActionPerformed(evt);
            }
        });
        jPanel1.add(rstbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 177, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("<html><body><B><U>Note: -</U></B> <br> Each Room contains 1 DoubleBed.</body</html>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        rmdtbtn.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        rmdtbtn.setText("Check Room Details");
        rmdtbtn.setToolTipText("Shows information and design about the room");
        rmdtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmdtbtnActionPerformed(evt);
            }
        });
        jPanel1.add(rmdtbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 290, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jPanel1.setOpaque(true);
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
    private javax.swing.JPanel jPanel1;
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
