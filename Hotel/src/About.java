/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucky
 * 
 */

public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     * 
     */
    public About() {
        initComponents();
         setLocationRelativeTo(null);
        DisplayArea.setEditable(false);
        DisplayArea.setText("");
        DisplayArea.append("Tired of having your wellness routine disrupted when you’re traveling? \nWhether you join us for a short stopover or a long stay, EVEN Hotels are\nhere to make sure you keep active, rest easy, eat well and accomplish\nmore every day even when you’re away from home.\n\n");
        DisplayArea.append("ABOUT DEVELOPERS: -\n\n");
        DisplayArea.append("1) Abhishek Singh (191CS103)\n2) Aaidan Ram Meghwal\n\nInstitute- NITK, Surathkal \nSection- S1\nTopic- HOTEL MANAGEMENT SYSTEM\n\n");
        //DisplayArea.append("\t\t\t\t           Submitted to:-\n\t\t\t\t           IP Teacher");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayArea = new javax.swing.JTextArea();
        bckbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setText("About Us");

        DisplayArea.setColumns(20);
        DisplayArea.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DisplayArea.setForeground(new java.awt.Color(102, 102, 0));
        DisplayArea.setRows(5);
        jScrollPane1.setViewportView(DisplayArea);

        bckbtn.setText("Back");
        bckbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(bckbtn)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(bckbtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 703, 507);
    }// </editor-fold>//GEN-END:initComponents

    private void bckbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckbtnActionPerformed
       this.dispose();
    }//GEN-LAST:event_bckbtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DisplayArea;
    private javax.swing.JButton bckbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}