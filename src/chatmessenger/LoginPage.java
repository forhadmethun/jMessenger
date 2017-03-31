
package chatmessenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nusrat Jahan
 */
public class LoginPage extends javax.swing.JFrame {

    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/authentication";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    String username;
    String password;

    static ResultSet rs;

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 522));
        setPreferredSize(new java.awt.Dimension(480, 522));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(null);

        jButton2.setText("SIGN IN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(160, 210, 120, 43);

        jButton3.setText("SIGN UP");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(160, 290, 120, 49);

        jButton5.setText("CANCEL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(160, 380, 120, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatmessenger/Messege.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, -11, 490, 540);

        getContentPane().add(jPanel1, "card2");

        jPanel2.setLayout(null);

        jLabel1.setText("USER NAME :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 160, 80, 30);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(150, 160, 240, 40);

        jLabel2.setText("PASSWORD :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 254, 80, 30);
        jPanel2.add(jPasswordField2);
        jPasswordField2.setBounds(150, 250, 230, 40);

        jButton1.setText("SIGN IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(260, 373, 100, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatmessenger/Messege.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 490, 530);

        getContentPane().add(jPanel2, "card3");

        jPanel3.setLayout(null);

        jLabel5.setText("USER NAME :");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(33, 179, 76, 24);

        jLabel6.setText("EMAIL ID :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(33, 244, 76, 29);

        jLabel7.setText("PASSWORD :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(33, 343, 76, 42);
        jPanel3.add(jTextField2);
        jTextField2.setBounds(195, 167, 233, 48);
        jPanel3.add(jTextField3);
        jTextField3.setBounds(195, 244, 233, 43);
        jPanel3.add(jPasswordField1);
        jPasswordField1.setBounds(195, 348, 233, 32);

        jButton4.setText("SIGN UP");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(233, 430, 120, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatmessenger/Messege.png"))); // NOI18N
        jPanel3.add(jLabel8);
        jLabel8.setBounds(0, -6, 490, 530);

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try {
            String user_name = new String();
            user_name = jTextField1.getText().toString();

            String password = new String();
            password = jPasswordField2.getText().toString();
            Connection conn = null;
            Statement stmt = null;
            try {
                //STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT username,password FROM userinfo";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
         //Retrieve by column name

                    String first = rs.getString("username");
                    String last = rs.getString("password");

         //Display values
                    System.out.print(", username: " + first);
                    System.out.println(", password: " + last);
                    if (first.equals(user_name) && last.equals(password)) {
                        setVisible(false);
                        new messenger(user_name).setVisible(true);
                        break;
                    }

                }
        //STEP 5: Extract data from result set

      //STEP 6: Clean-up environment
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try
            //rs.close();
            // stmt.close();
            //conn.close();

        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //inside sign up button....

        String user_name = new String();
        user_name = jTextField2.getText().toString();

        String mail = new String();
        mail = jTextField3.getText().toString();

        String pass = new String();
        pass = jPasswordField1.getText().toString();
        
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO userinfo "
                    // + "VALUES ('fourth', 'fourth', 'fourth@mail.com', '1', '<empty message>')"
                    + "VALUES ('" + user_name + "','" + pass + "','" + mail + "','" + '1' +"','"+ "<empty message>" + "')" ; 
            //+ "VALUES (100, 'Zara', 'Ali', 18)";
            stmt.executeUpdate(sql);
             sql = "CREATE TABLE " + user_name + //user_name + "(VARCHAR(255) 
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   //" first VARCHAR(255), " + //
                      " message VARCHAR(255), "+ 
                   " username VARCHAR(255), " + 
                   //" age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

              stmt.executeUpdate(sql);
            
           
            System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        try {
           // String user_name = new String();
            user_name = jTextField2.getText().toString();
            setVisible(false);
            new messenger(user_name).setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        System.out.println("Goodbye!");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //     java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //   java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            // java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new LoginPage().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
