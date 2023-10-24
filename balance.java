package bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class balance extends javax.swing.JInternalFrame {
    public balance() {
        initComponents();
    }
Connection con1;
  PreparedStatement insert;
  PreparedStatement insert2;
  ResultSet rs1;
    @SuppressWarnings("unchecked")
     private void initComponents() {
        jLabel4 = new javax.swing.JLabel();
        lbal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtaccno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel4.setText("Balance");
        lbal.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        lbal.setForeground(new java.awt.Color(0, 51, 204));
        lbal.setText("Balance");
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account No"));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setText("Enter the Acccount No");
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtaccno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtaccno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel7.setText("Customer ID");
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLabel9.setText("Customer ID");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel5.setText("Firstname");
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setText("Lastname");
        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String accno = txtaccno.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/customer","root","");
            insert = con1.prepareStatement("select c.cust_id,c.firstname,c.lastname,a.balance from customer c,account a where c.cust_id = a.cust_id and a.acc_id = ?");
            insert.setString(1, accno);
            rs1 = insert.executeQuery();
            if(rs1.next() == false)
            {
                JOptionPane.showMessageDialog(null,"Account No no found");
                jLabel5.setText("");
                jLabel6.setText("");
                lbal.setText("");
            }
            else
            {
                String id = rs1.getString(1);
                String firstname = rs1.getString(2);
                String laststname = rs1.getString(3);
                String balance = rs1.getString(4);
                jLabel7.setText(id.trim());
                jLabel5.setText(firstname.trim());
                jLabel6.setText(laststname.trim());
                lbal.setText(balance.trim());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(balance.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (SQLException ex) {
            Logger.getLogger(balance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
