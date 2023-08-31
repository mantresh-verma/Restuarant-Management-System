import java.sql.*;
//import java.util.Calendar;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

/**
 *
 * @author Mantresh Verma
 */
public class LogMenu extends javax.swing.JFrame {

    
    /**
     * Creates new form FoodMenu
     */
    public LogMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomePanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LogBtn = new javax.swing.JButton();
        ReturnBtn = new javax.swing.JButton();
        BackgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurant Management System - Log Menu");
        setMinimumSize(new java.awt.Dimension(1210, 681));
        setPreferredSize(new java.awt.Dimension(1210, 681));
        getContentPane().setLayout(null);

        HomePanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "See All Customer Log Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        HomePanel4.setMinimumSize(new java.awt.Dimension(1150, 480));
        HomePanel4.setOpaque(false);
        HomePanel4.setPreferredSize(new java.awt.Dimension(1150, 480));

        jScrollPane4.setMaximumSize(new java.awt.Dimension(3000, 500));
        jScrollPane4.setMinimumSize(new java.awt.Dimension(3000, 500));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(3000, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Code", "DATE", "TIME", "NAME", "GENDER", "Email ID", "Contact No", "SPECIAL CUST", "Home Delivery", "ADDRESS", "Rice", "Quantity", "Biryani", "Quantity", "Veg Appetizer", "Quantity", "Non-Veg Appetizer", "Quantity", "Roti", "Quantity", "Dessert", "Quantity", "Drinks", "Quantity", "Street Food", "Quantity", "TOTAL BILL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(10000, 600));
        jTable1.setMinimumSize(new java.awt.Dimension(10000, 600));
        jTable1.setPreferredSize(new java.awt.Dimension(10000, 600));
        jTable1.setRowHeight(20);
        jScrollPane4.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane4);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout HomePanel4Layout = new javax.swing.GroupLayout(HomePanel4);
        HomePanel4.setLayout(HomePanel4Layout);
        HomePanel4Layout.setHorizontalGroup(
            HomePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
                .addContainerGap())
        );
        HomePanel4Layout.setVerticalGroup(
            HomePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(HomePanel4);
        HomePanel4.setBounds(20, 30, 1150, 480);

        LogBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LogBtn.setText("Show All Customer Logs");
        LogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogBtnActionPerformed(evt);
            }
        });
        getContentPane().add(LogBtn);
        LogBtn.setBounds(610, 530, 190, 23);

        ReturnBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ReturnBtn.setText("Return To Home");
        ReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ReturnBtn);
        ReturnBtn.setBounds(400, 530, 190, 23);

        BackgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r7.jpg"))); // NOI18N
        getContentPane().add(BackgroundLabel);
        BackgroundLabel.setBounds(0, 0, 1210, 681);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","root");
            Statement stmt = con.createStatement();
            String LOG = "select * from food_order;";
            ResultSet rs = stmt.executeQuery(LOG);
        
            while (rs.next())
            {
                String A = rs.getString("Customer_Code");
                String B = rs.getString("Date");
                String C = rs.getString("Time");
                String D = rs.getString("Name");
                String E = rs.getString("Gender");
                String F = rs.getString("EmailId");
                String G = rs.getString("Contact_No");
                String H = rs.getString("Special_Customer");
                String I = rs.getString("Home_Delivery");
                String J = rs.getString("Address");
                String K = rs.getString("Rice_Type");
                String L = rs.getString("q1");
                String M = rs.getString("Biryani_Type");
                String N = rs.getString("q2");
                String O = rs.getString("Veg_Appetizer_Type");
                String P = rs.getString("q3");
                String Q = rs.getString("Non_Veg_Appetizer_Type");
                String R = rs.getString("q4");
                String S = rs.getString("Chapati_Type");
                String T = rs.getString("q5");
                String U = rs.getString("Desserts_Type");
                String V = rs.getString("q6");
                String W = rs.getString("Drinks_Type");
                String X = rs.getString("q7");
                String Y = rs.getString("Street_Food_Type");
                String Z = rs.getString("q8");
                String AA = rs.getString("Total_Bill");

                Object [] data = { A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,AA } ;
                dtm.addRow(data);
            }

                JOptionPane.showMessageDialog(null,"Customer Log Successfully Searched","Information",1);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e,"Error",0);
        }
    }//GEN-LAST:event_LogBtnActionPerformed

    private void ReturnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBtnActionPerformed
        // TODO add your handling code here:
        MainMenu MM =  new MainMenu();
        MM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnBtnActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLabel;
    private javax.swing.JPanel HomePanel4;
    private javax.swing.JButton LogBtn;
    private javax.swing.JButton ReturnBtn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
