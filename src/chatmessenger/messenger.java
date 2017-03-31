/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmessenger;

/**
 *
 * @author Nusrat Jahan
 */
import static chatmessenger.LoginPage.DB_URL;
import static chatmessenger.LoginPage.rs;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class messenger extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form messenger
     */
    boolean b = true;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/authentication";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    //String username;
    //String password;
    // String username;
    String SetUsername;
    //String servername="localhost";
    public DataOutputStream os = null;
    // The input stream
    public DataInputStream is;
    InputStream ips;

    //public BufferedReader inputLine = null;
    // public boolean closed;
    Thread t = null;

    //PrintWriter pw;
    //BufferedReader br;
    //JTextArea chatmsg;
    //JButton send,exit;
    //JTextField chatip;
    Socket chatusers;
    /* public messenger()
     {
     initComponents();
     }*/

    public messenger(String LoginName) throws Exception {
        super(LoginName + "'s Account");
        initComponents();
        lastMessages l = new lastMessages(LoginName);
        jTextArea1.append(l.get_m());
        jList1 = new javax.swing.JList();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(jList1);

        this.SetUsername = LoginName;

        chatusers = new Socket("127.0.0.1", 5217);

        is = new DataInputStream(chatusers.getInputStream());
        os = new DataOutputStream(chatusers.getOutputStream());

        os.writeUTF(SetUsername);

        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            try {
                String msgFromClient = new String();
                msgFromClient = is.readUTF();
                StringTokenizer st = new StringTokenizer(msgFromClient);
                String MsgType = st.nextToken();
                String send_from = st.nextToken();
                int iCount;
                if (MsgType.equals("MESS")) {
                    String msg = "";
                    while (st.hasMoreTokens()) {
                        msg = msg + st.nextToken() + " ";
                    }
                    jTextArea1.append("\n" + send_from + " : " + msg);
                } else if (MsgType.equals("LIST")) {
                    int length = Integer.parseInt(st.nextToken());

                    final String[] strings1 = new String[length];
                    //something changed here .............
                    
                    
                    iCount = 1;
                    // strings1[iCount] = "";
                    while (st.hasMoreTokens()) {
                        String user_name = st.nextToken();
                        if (user_name.equals(SetUsername) == false) {
                            strings1[iCount] = user_name;
                            iCount++;
                        }
                    }
                    jList1.setModel(new javax.swing.AbstractListModel() {
                        String[] strings = strings1;

                        public int getSize() {
                            return strings.length;
                        }

                        public Object getElementAt(int i) {
                            return strings[i];
                        }
                    });
                    jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    jScrollPane2.setViewportView(jList1);
                }
            } catch (IOException ex) {
                System.out.println("I'm fine");

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setText("                  CHAT LIST");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(0, -10, 160, 620);

        jButton2.setText("SEND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("EXIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(170, 140, 780, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(170, 190, 730, 410);

        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(770, 0, 130, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatmessenger/Messege.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(160, 0, 850, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            os.writeUTF("LOGOUT " + SetUsername);
            this.setVisible(false);
            new LoginPage().setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String user_name = new String();
        user_name = jTextField1.getText().toString();

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

            String sql = "INSERT INTO " + SetUsername + "(message)"
                    // + "VALUES ('fourth', 'fourth', 'fourth@mail.com', '1', '<empty message>')"
                    + " VALUES ('" + jTextField1.getText().toString() + "')"; //+ 1  + "','" 
            //+ "VALUES (100, 'Zara', 'Ali', 18)";
            System.out.println(user_name);
            stmt.executeUpdate(sql);
            
            stmt = conn.createStatement();
            sql = "";
            sql = "INSERT INTO " + "common" + "(username,message)"
                            //  + "VALUES ('" + user_name+ "'),"
                    + " VALUES ('"  + SetUsername + "','"+ jTextField1.getText().toString() + "')"; //+ 1  + "','" 
            //+ "VALUES (100, 'Zara', 'Ali', 18)";
            System.out.println(user_name);
            //stmt.executeUpdate(sql);
            stmt.execute(sql);
            
            

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

        
     
             
             
             
             
             
             
             
        try {
            /*
            if(b = true){
                lastMessages l = new lastMessages("c");
                jTextArea1.append(l.get_m());
                b = false;
            }
            */
            //lastMessages l = new lastMessages("c");
            //System.out.print(l.get_m());
            //System.out.println(l.get_i());
            //jTextArea1.append(l.get_m());
            os.writeUTF("DATA " + SetUsername + " " + jTextField1.getText().toString());
            jTextArea1.append("\n" + SetUsername + " : " + jTextField1.getText().toString());
            jTextField1.setText("");

        } catch (Exception ex) {
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            os.writeUTF("LOGOUT " + SetUsername);
            this.setVisible(false);
            new LoginPage().setVisible(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
