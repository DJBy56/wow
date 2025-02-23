/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin_panel;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Admin_panel1 extends javax.swing.JFrame {

    ResultSet rs;
    Connection con;
    PreparedStatement ps;
    
    String url = "jdbc:mysql://localhost:3306/Personal_Information?";
    String username = "root";
    String password = "";
   
    private void checkEmployeeId(){
          String emplId = txtEmployee_Id.getText();
          String EmpIdEducational = txtEmpIdEducational.getText();
          String emplyId = txtEmpIdEmployment.getText();
            
        try{
        String url = "jdbc:mysql://localhost:3306/Personal_Information?";
        String user = "root";
        String password = "";
        con = DriverManager.getConnection(url, user, password);
            
            String queryPersonal = "SELECT * FROM personal_information WHERE employee_Id = ?";
            ps = con.prepareStatement(queryPersonal);
            ps.setString(1, emplId);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                txtfirstName.setText(rs.getString("firstName"));
                txtmiddleName.setText(rs.getString("middleName"));
                txtlastName.setText(rs.getString("lastName"));
                txtemail.setText(rs.getString("email"));
                 java.sql.Date birthdate = rs.getDate("birthdate");
                   if (birthdate != null) {
                    jdcbirthdate.setDate(birthdate); 
               }
                txtage.setText(String.valueOf(rs.getInt("age"))); 
              String gender = rs.getString("Sex");  // Fetch column "Sex" from database
                 if (gender != null) {  // Check if the value is not null
                  if (gender.equalsIgnoreCase("Male")) {
                  rbtnmale.setSelected(true);
             } else {
                  rbtnfemale.setSelected(true);
           }
             }

                cbnationality.setSelectedItem(rs.getString("Nationality"));
                txtaddress.setText(rs.getString("address"));
                txtcontactNo.setText(rs.getString("ContactNo"));
                
                btnprocess.setText("Update");
                
            }
            else
            {
                erase();
            }
            
            
              String queryEducational = "SELECT * FROM educational_background WHERE employeeId = ?";
            
            ps = con.prepareStatement(queryEducational);
            ps.setString(1, EmpIdEducational);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                //Bachelor
                txtBachelorTitle.setText(rs.getString("bachelor_title"));
                txtBachelorMajor.setText(rs.getString("bachelor_major"));
                txtBachelorMinor.setText(rs.getString("bachelor_minor"));
                txtBachelorSpecialization.setText(rs.getString("bachelor_specialization"));
                txtBachelorInstitution.setText(rs.getString("bachelor_institution"));
                java.sql.Date jdcbachelor = rs.getDate("bachelor_graduation_date");
                txtBachelorGpa.setText(rs.getString("bachelor_gpa"));
                
                //Masteral
                txtMasteralTitle2.setText(rs.getString("masteral_title"));
                txtMasteralMajor1.setText(rs.getString("masteral_major"));
                txtMasteralMinor1.setText(rs.getString("masteral_minor"));
                txtMasteralSpecialization1.setText(rs.getString("masteral_specialization"));
                txtMasteralInstitution1.setText(rs.getString("masteral_institution"));
                java.sql.Date jdcmasteral = rs.getDate("masteral_graduation_date");
                txtMasteralGpa.setText(rs.getString("masteral_gpa"));
                
                //Doctorate
                txtDoctorateTitle1.setText(rs.getString("doctorate_title"));
                txtDoctorateMajor.setText(rs.getString("doctorate_major"));
                txtDoctorateMinor.setText(rs.getString("doctorate_minor"));
                txtDoctorateSpecialization.setText(rs.getString("doctorate_specialization"));
                txtDoctorateInstitution.setText(rs.getString("doctorate_institution"));
                java.sql.Date jdcdoctorate = rs.getDate("doctorate_graduation_date");
                txtDoctorateGpa2.setText(rs.getString("doctorate_gpa"));
                
                
                btnProcessEducational.setText("Update");
                
            }
             else
            {
                erase();
            }
                 //Employment History
            String queryEmployment = "SELECT * FROM employment_history WHERE employeeId = ?";
            
            ps = con.prepareStatement(queryEmployment);
            ps.setString(1, emplId);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                txtJobPosition.setText(rs.getString("job_position"));
                String departmentFromDB = rs.getString("department");
                cmbDepartment.setSelectedItem(departmentFromDB);
                txtSchool.setText(rs.getString("school"));
                jdcyoe.setDate(rs.getDate("years_of_employment"));
                txtSubjectsTaught.setText(rs.getString("subjects_taught"));
                txtGradeLevelsTaught.setText(rs.getString("grade_levels_taught"));
                txtProfessionalOrganization.setText(rs.getString("professional_organization"));
                txtAchievements.setText(rs.getString("achievements"));
                txtNcLevel.setText(rs.getString("nc_level"));
                jdcdop.setDate(rs.getDate("date_of_appointment"));
                txtProvitionary.setText(rs.getString("provitionary"));
                if (rs.next()) {
    String retrievedStatus = rs.getString("status");

    if ("Retired".equals(retrievedStatus)) {
        rbtnRetired.setSelected(true);
    } else if ("Resigned".equals(retrievedStatus)) {
        rbtnResign.setSelected(true);
    }
}
               
                
                
                btnProcessEmployment.setText("Update");
            }
             else
            {
                erase();
            }
            
     }catch(SQLException ex)
        {
            Logger.getLogger(Admin_panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void erase()
    {
        btnprocess.setText("Add");
        txtfirstName.setText(null);
        txtmiddleName.setText(null);
        txtlastName.setText(null);
        txtemail.setText(null);
        jdcbirthdate.setDate(null); 
        txtage.setText(null);
        sexGroup.clearSelection();
        txtaddress.setText(null);
        txtcontactNo.setText(null);
        
        //Edutional Background
        btnProcessEducational.setText("Add");
        txtBachelorTitle.setText(null);
        txtBachelorMajor.setText(null);
        txtBachelorMinor.setText(null);
        txtBachelorSpecialization.setText(null);
        txtBachelorInstitution.setText(null);
        jdcbachelor.setDate(null); 
        txtBachelorGpa.setText(null);


            //Masteral
        txtMasteralTitle2.setText(null);
        txtMasteralMajor1.setText(null);
        txtMasteralMinor1.setText(null);
        txtMasteralSpecialization1.setText(null);
        txtMasteralInstitution1.setText(null);
        jdcmasteral.setDate(null); 
        txtMasteralGpa.setText(null);
            
            //Doctorate
        txtDoctorateTitle1.setText(null);
        txtDoctorateMajor.setText(null);
        txtDoctorateMinor.setText(null);
        txtDoctorateSpecialization.setText(null);
        txtDoctorateInstitution.setText(null);
        jdcdoctorate.setDate(null); 
        txtDoctorateGpa2.setText(null);
        
        txtJobPosition.setText(null);
        txtSchool.setText(null);
        
        
        txtGradeLevelsTaught.setText(null);
        txtProfessionalOrganization.setText(null);
        txtAchievements.setText(null);
        txtNcLevel.setText(null);
        txtProvitionary.setText(null);
       
    }
   
    public Admin_panel1() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexGroup = new javax.swing.ButtonGroup();
        status = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmployee_Id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfirstName = new javax.swing.JTextField();
        txtmiddleName = new javax.swing.JTextField();
        txtlastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdcbirthdate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        rbtnfemale = new javax.swing.JRadioButton();
        rbtnmale = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        txtemail = new javax.swing.JTextField();
        txtcontactNo = new javax.swing.JTextField();
        btnprocess = new javax.swing.JButton();
        cbnationality = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txteducName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtDoctorateMajor = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtDoctorateMinor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtDoctorateSpecialization = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtDoctorateInstitution = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnProcessEducational = new javax.swing.JButton();
        txtBachelorTitle = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtBachelorMajor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtBachelorMinor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtBachelorSpecialization = new javax.swing.JTextField();
        txtBachelorInstitution = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtEmpIdEducational = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtDoctorateGpa2 = new javax.swing.JTextField();
        txtBachelorGpa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDoctorateTitle1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtMasteralTitle2 = new javax.swing.JTextField();
        txtMasteralMajor1 = new javax.swing.JTextField();
        txtMasteralMinor1 = new javax.swing.JTextField();
        txtMasteralSpecialization1 = new javax.swing.JTextField();
        txtMasteralInstitution1 = new javax.swing.JTextField();
        txtMasteralGpa = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jdcmasteral = new com.toedter.calendar.JDateChooser();
        jdcdoctorate = new com.toedter.calendar.JDateChooser();
        jdcbachelor = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        txtEmpIdEmployment = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtSchool = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtSubjectsTaught = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtProvitionary = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtNcLevel = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtAchievements = new javax.swing.JTextField();
        txtProfessionalOrganization = new javax.swing.JTextField();
        txtGradeLevelsTaught = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        btnProcessEmployment = new javax.swing.JButton();
        txtJobPosition = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jdcdop = new com.toedter.calendar.JDateChooser();
        jdcyoe = new com.toedter.calendar.JDateChooser();
        rbtnResign = new javax.swing.JRadioButton();
        rbtnRetired = new javax.swing.JRadioButton();
        jLabel59 = new javax.swing.JLabel();
        cmbDepartment = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("TeaMS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(434, 434, 434))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, -1));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Employee Id");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 12, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("First Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 63, -1, -1));

        txtEmployee_Id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmployee_IdKeyReleased(evt);
            }
        });
        jPanel2.add(txtEmployee_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 35, 162, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Last Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Middle Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 116, -1, -1));
        jPanel2.add(txtfirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 89, 162, -1));
        jPanel2.add(txtmiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 142, 162, -1));
        jPanel2.add(txtlastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 196, 162, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Birthdate");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 224, -1, -1));

        jdcbirthdate.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(jdcbirthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 250, 162, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Sex");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        sexGroup.add(rbtnfemale);
        rbtnfemale.setText("Female");
        jPanel2.add(rbtnfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 36, -1, -1));

        sexGroup.add(rbtnmale);
        rbtnmale.setText("Male");
        jPanel2.add(rbtnmale, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 36, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Age");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 278, -1, -1));
        jPanel2.add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 304, 162, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 63, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Contact No.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 116, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nationality");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Address");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 224, -1, -1));

        txtaddress.setColumns(5);
        txtaddress.setLineWrap(true);
        txtaddress.setRows(4);
        txtaddress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtaddress);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 160, 80));
        jPanel2.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 89, 162, -1));
        jPanel2.add(txtcontactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 142, 162, -1));

        btnprocess.setText("Add");
        btnprocess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocessActionPerformed(evt);
            }
        });
        jPanel2.add(btnprocess, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, 20));

        cbnationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "American", "British", "Canadian", "Chinese", "Filipino\"", "French", "German", "Indian ", "Indonesian", "Italian", "Japanese", "Korean", "Mexican", "Russian", "Spanish ", "Thai", "Vietnamese ", "Australian\",", "Brazilian", "Egyptian", "Turkish", "South African", " Other" }));
        jPanel2.add(cbnationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 196, 162, -1));

        jTabbedPane1.addTab("Personal Information", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Doctorate");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));
        jPanel3.add(txteducName, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 140, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel23.setText("Major");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));
        jPanel3.add(txtDoctorateMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 140, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel24.setText("Minor");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));
        jPanel3.add(txtDoctorateMinor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 140, -1));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel25.setText("Specialization");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));
        jPanel3.add(txtDoctorateSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 140, -1));

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel30.setText("Institution Name");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 100, -1));
        jPanel3.add(txtDoctorateInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 140, -1));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel35.setText("Graduation Date");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 120, 20));

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel38.setText("GPA");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, -1, -1));

        btnProcessEducational.setText("Add");
        btnProcessEducational.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessEducationalActionPerformed(evt);
            }
        });
        jPanel3.add(btnProcessEducational, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        txtBachelorTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBachelorTitleActionPerformed(evt);
            }
        });
        jPanel3.add(txtBachelorTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setText("Major");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));
        jPanel3.add(txtBachelorMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 140, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setText("Minor");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        txtBachelorMinor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBachelorMinorActionPerformed(evt);
            }
        });
        jPanel3.add(txtBachelorMinor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 140, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setText("Specialization");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, -1));
        jPanel3.add(txtBachelorSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, -1));
        jPanel3.add(txtBachelorInstitution, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 140, -1));

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel32.setText("Institution Name");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel33.setText("Graduation Date");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 100, -1));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel37.setText("GPA");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, -1));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel39.setText("Degree Title");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setText("Bachelor");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        txtEmpIdEducational.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIdEducationalActionPerformed(evt);
            }
        });
        txtEmpIdEducational.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpIdEducationalKeyReleased(evt);
            }
        });
        jPanel3.add(txtEmpIdEducational, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setText("Employee id:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 20));

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel41.setText("Degree Title");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));
        jPanel3.add(txtDoctorateGpa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 140, 20));
        jPanel3.add(txtBachelorGpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 140, 20));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setText("Name:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, 20));
        jPanel3.add(txtDoctorateTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 140, -1));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel42.setText("Degree Title");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel43.setText("Major");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel44.setText("Minor");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel45.setText("Specialization");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel46.setText("Institution Name");
        jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 100, -1));

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel47.setText("Graduation Date");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 120, 20));

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel48.setText("GPA");
        jPanel3.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, -1, -1));
        jPanel3.add(txtMasteralTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 140, -1));
        jPanel3.add(txtMasteralMajor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 140, -1));
        jPanel3.add(txtMasteralMinor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 140, -1));
        jPanel3.add(txtMasteralSpecialization1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 140, -1));
        jPanel3.add(txtMasteralInstitution1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 140, -1));
        jPanel3.add(txtMasteralGpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 140, 20));

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel49.setText("Masteral");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));
        jPanel3.add(jdcmasteral, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 140, -1));
        jPanel3.add(jdcdoctorate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 140, -1));
        jPanel3.add(jdcbachelor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 140, -1));

        jTabbedPane1.addTab("Educational Background", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel50.setText("Date of Appointment");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 120, -1));

        txtEmpIdEmployment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIdEmploymentActionPerformed(evt);
            }
        });
        txtEmpIdEmployment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpIdEmploymentKeyReleased(evt);
            }
        });
        jPanel4.add(txtEmpIdEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 200, 33));

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel51.setText("Provitionary");
        jPanel4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 70, -1));

        txtSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSchoolActionPerformed(evt);
            }
        });
        jPanel4.add(txtSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 190, 33));

        jLabel52.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel52.setText("Status");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 80, -1));

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel53.setText("School/Institution");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 110, -1));
        jPanel4.add(txtSubjectsTaught, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 190, 33));

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel54.setText("Year of Employment");
        jPanel4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 130, -1));

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel55.setText("Subject Taught");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 130, -1));
        jPanel4.add(txtProvitionary, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 200, 33));

        jLabel56.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel56.setText("Achievements");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 90, -1));

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel57.setText("Employee Id");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 90, -1));
        jPanel4.add(txtNcLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 200, 33));

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel58.setText("NC Level");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 413, 0, -1));

        txtAchievements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAchievementsActionPerformed(evt);
            }
        });
        jPanel4.add(txtAchievements, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 200, 33));
        jPanel4.add(txtProfessionalOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 200, 33));
        jPanel4.add(txtGradeLevelsTaught, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 200, 30));

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel61.setText("Profesional Oranization");
        jPanel4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 140, -1));

        btnProcessEmployment.setText("Add");
        btnProcessEmployment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessEmploymentActionPerformed(evt);
            }
        });
        jPanel4.add(btnProcessEmployment, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 80, -1));

        txtJobPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobPositionActionPerformed(evt);
            }
        });
        jPanel4.add(txtJobPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, 33));

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel62.setText("Grade Levels Taught");
        jPanel4.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 140, 20));

        jLabel63.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel63.setText("NC Level");
        jPanel4.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));
        jPanel4.add(jdcdop, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 190, -1));
        jPanel4.add(jdcyoe, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 190, -1));

        status.add(rbtnResign);
        rbtnResign.setText("Resign");
        rbtnResign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnResignActionPerformed(evt);
            }
        });
        jPanel4.add(rbtnResign, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        status.add(rbtnRetired);
        rbtnRetired.setText("Retired");
        jPanel4.add(rbtnRetired, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel59.setText("Job Position");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 80, -1));

        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ICT", "STEAM", "HE", "GAS", "ABM" }));
        jPanel4.add(cmbDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 190, -1));

        jLabel60.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel60.setText("Department");
        jPanel4.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 80, -1));

        jTabbedPane1.addTab("Employment History", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 970, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprocessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocessActionPerformed
        // TODO add your handling code here:
        
        String emplId = txtEmployee_Id.getText();
        String fN = txtfirstName.getText();
        String mN = txtmiddleName.getText();
        String lN = txtlastName.getText();
      

         
        String sex = "";
        if (rbtnmale.isSelected()) {
          sex = "Male";
           } else if (rbtnfemale.isSelected()) {
          sex = "Female";
           }
        String email = txtemail.getText();
       String contactNO = txtcontactNo.getText();
        String nationality = cbnationality.getSelectedItem().toString();

        String address = txtaddress.getText();
        String sql;
                
        if (emplId.isEmpty() || fN.isEmpty() || lN.isEmpty() || email.isEmpty() || contactNO.isEmpty() || nationality.isEmpty() || address.isEmpty()) {
         JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }
         
        if (!fN.matches("[a-zA-Z]+") || !mN.matches("[a-zA-Z]*") || !lN.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Name fields must contain only letters!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int age;
        try {
            age = Integer.parseInt(txtage.getText().trim());
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Age must be a positive number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid age! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
         if (!contactNO.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Contact number must contain only digits!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     
        java.util.Date selectedDate = jdcbirthdate.getDate();
        if (selectedDate == null) {
        JOptionPane.showMessageDialog(null, "Please select a birthdate!", "Error", JOptionPane.ERROR_MESSAGE);
       return; // Stop execution if no date is selected
    }


          java.sql.Date sqlBirthdate = new java.sql.Date(selectedDate.getTime());

       
        if (sex.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a gender!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
          try {
            con = DriverManager.getConnection(url, username, password);
            ps = con.prepareStatement("select * from Personal_Information");
            rs=ps.executeQuery();
         
            btnprocess.getText().equals("Add");
            
            sql = "insert into Personal_Information(Employee_Id, firstName, middleName, lastName, Birthdate, Age, Sex, Email, ContactNo, Nationality, Address) values (?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, emplId);
            ps.setString(2, fN);
            ps.setString(3, mN);
            ps.setString(4, lN);
            ps.setDate(5, sqlBirthdate);
            ps.setInt(6, age);
            ps.setString(7, sex);
            ps.setString(8, email);
            ps.setString(9, contactNO);
            ps.setString(10, nationality);
            ps.setString(11, address);
            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Successfully added to records!!");
            
         if(btnprocess.getText().equals("Update"))
         {
         
    
    
    sql = "UPDATE Personal_Information SET firstName=?, middleName=?, lastName=?, Birthdate=?, Age=?, Sex=?, Email=?, ContactNo=?, Nationality=?, Address=? WHERE Employee_Id=?";

    ps = con.prepareStatement(sql);
    ps.setString(1, fN);
    ps.setString(2, mN);
    ps.setString(3, lN);
    ps.setDate(4, sqlBirthdate);
    ps.setInt(5, age);
    ps.setString(6, sex);
    ps.setString(7, email);
    ps.setString(8, contactNO);
    ps.setString(9, nationality);
    ps.setString(10, address);
    ps.setString(11, emplId); 

    ps.executeUpdate();
    erase();
                  JOptionPane.showMessageDialog(this, "Succefully Updated!!");

         }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_btnprocessActionPerformed

    private void txtEmployee_IdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmployee_IdKeyReleased
       checkEmployeeId();
    }//GEN-LAST:event_txtEmployee_IdKeyReleased

    private void txtEmpIdEducationalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpIdEducationalKeyReleased
        // TODO add your handling code here:
        checkEmployeeId();
    }//GEN-LAST:event_txtEmpIdEducationalKeyReleased

    private void txtEmpIdEducationalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIdEducationalActionPerformed
        // TODO add your handling code here:
        checkEmployeeId();
    }//GEN-LAST:event_txtEmpIdEducationalActionPerformed

    private void txtBachelorMinorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBachelorMinorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBachelorMinorActionPerformed

    private void txtBachelorTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBachelorTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBachelorTitleActionPerformed

    private void btnProcessEducationalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessEducationalActionPerformed
        // TODO add your handling code here:
        try {

            String empId = txtEmpIdEducational.getText();

             //Bachelor
            String bachelorTitle = txtBachelorTitle.getText();
            String bachelorMajor = txtBachelorMajor.getText();
            String bachelorMinor = txtBachelorMinor.getText();
             String bachelorSpecialization = txtBachelorSpecialization.getText();
            String bachelorInstitution = txtBachelorInstitution.getText();
             java.util.Date selectedDate1 = jdcbachelor.getDate();
             
             if (selectedDate1 == null) {
                 JOptionPane.showMessageDialog(null, "Please select a Bachelor graduation date!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop execution if no date is selected
                }
          java.sql.Date sqlBirthdate1 = new java.sql.Date(selectedDate1.getTime());
            String bachelorGpa = txtBachelorGpa.getText();
            
         
              
         if (bachelorTitle.isEmpty() || bachelorInstitution.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "A Bachelor's Degree is required for teaching!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
                  try {
              double gpa = Double.parseDouble(txtBachelorGpa.getText());
        if (gpa < 0 || gpa > 4.0) {
             JOptionPane.showMessageDialog(this, "Bachelor's GPA must be between 0.0 and 4.0!", "Error", JOptionPane.WARNING_MESSAGE);
             return;
             }
             } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "Invalid Bachelor's GPA format!", "Error", JOptionPane.ERROR_MESSAGE);
             return;
                      }
                  
                  
              
            
            
            //Masteral
            String masteralTitle = txteducName.getText();
            String masteralMajor = txtDoctorateMajor.getText();
            String masteralMinor = txtDoctorateMinor.getText();
            String masteralSpecialization = txtDoctorateSpecialization.getText();
            String masteralInstitution = txtDoctorateInstitution.getText();
            java.util.Date selectedDatemasteral1 = jdcmasteral.getDate();
            java.sql.Date selectedDatemasteral = null; // Default to NULL
        if (selectedDatemasteral1 != null) {
                selectedDatemasteral = new java.sql.Date(selectedDatemasteral1.getTime());
}
        
            String masteralGpa = txtMasteralGpa.getText();

            //Doctorate
            String doctorateTitle = txtDoctorateTitle1.getText();
            String doctorateMajor = txtDoctorateMajor.getText();
            String doctorateMinor = txtDoctorateMinor.getText();
            String doctorateSpecialization = txtDoctorateSpecialization.getText();
            String doctorateInstitution = txtDoctorateInstitution.getText();
            java.util.Date sqlBirthdatedoc = jdcmasteral.getDate();
            java.sql.Date sqlBirthdate3 = null; // Default to NULL

    if (sqlBirthdate3 != null) {
           sqlBirthdate3 = new java.sql.Date(selectedDatemasteral1.getTime());
}

            String doctorateGpa = txtDoctorateGpa2.getText();
            
            
            if (empId.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Employee ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            String sql;
            String url = "jdbc:mysql://localhost:3306/Personal_Information?";
            String user = "root";
            String password = "";
            con=DriverManager.getConnection(url, user, password);

            if(btnProcessEducational.getText().equals("Add"))
            {
                sql = "INSERT INTO educational_background(employeeID, bachelor_title, bachelor_major, bachelor_minor, bachelor_specialization, bachelor_institution, bachelor_graduation_date, bachelor_gpa, masteral_title, masteral_major, masteral_minor, masteral_specialization, masteral_institution, masteral_graduation_date, masteral_gpa, doctorate_title, doctorate_major, doctorate_minor, doctorate_specialization, doctorate_institution, doctorate_graduation_date, doctorate_gpa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                ps = con.prepareStatement(sql);

                //Bachelor
                ps.setString(1, empId);
                ps.setString(2, bachelorTitle);
                ps.setString(3, bachelorMajor);
                ps.setString(4, bachelorMinor);
                ps.setString(5, bachelorSpecialization);
                ps.setString(6, bachelorInstitution);
                ps.setDate(7, sqlBirthdate1);
                ps.setString(8, bachelorGpa);

                //Masteral
                ps.setString(9, masteralTitle);
                ps.setString(10, masteralMajor);
                ps.setString(11, masteralMinor);
                ps.setString(12, masteralSpecialization);
                ps.setString(13, masteralInstitution);
                ps.setDate(14, selectedDatemasteral);
                ps.setString(15, masteralGpa);

                //Doctorate
                ps.setString(16, doctorateTitle);
                ps.setString(17, doctorateMajor);
                ps.setString(18, doctorateMinor);
                ps.setString(19, doctorateSpecialization);
                ps.setString(20, doctorateInstitution);
                ps.setDate(21, sqlBirthdate3);
                ps.setString(22, doctorateGpa);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Successfully added to records!!");

            }
            else
            {
                sql = "UPDATE educational_background SET bachelor_title = ?, bachelor_major = ?, bachelor_minor = ?, bachelor_specialization = ?, bachelor_institution = ?, bachelor_graduation_date = ?, bachelor_gpa = ?, masteral_title = ?, masteral_major = ?, masteral_minor = ?, masteral_specialization = ?, masteral_institution = ?, masteral_graduation_date = ?, masteral_gpa = ?, doctorate_title = ?, doctorate_major = ?, doctorate_minor = ?, doctorate_specialization = ?, doctorate_institution = ?, doctorate_graduation_date = ?, doctorate_gpa = ?  WHERE employeeID = ?";

                ps = con.prepareStatement(sql);

                //Bachelor
                ps.setString(1, bachelorTitle);
                ps.setString(2, bachelorMajor);
                ps.setString(3, bachelorMinor);
                ps.setString(4, bachelorSpecialization);
                ps.setString(5, bachelorInstitution);
                ps.setDate(6, sqlBirthdate1);
                ps.setString(7, bachelorGpa);

                //Masteral
                ps.setString(8, masteralTitle);
                ps.setString(9, masteralMajor);
                ps.setString(10, masteralMinor);
                ps.setString(11, masteralSpecialization);
                ps.setString(12, masteralInstitution);
                ps.setDate(13, selectedDatemasteral);
                ps.setString(14, masteralGpa);

                //Doctorate
                ps.setString(15, doctorateTitle);
                ps.setString(16, doctorateMajor);
                ps.setString(17, doctorateMinor);
                ps.setString(18, doctorateSpecialization);
                ps.setString(19, doctorateInstitution);
                ps.setDate(20, sqlBirthdate3);
                ps.setString(21, doctorateGpa);
                ps.setString(22, empId);

                ps.executeUpdate();

                erase();

                JOptionPane.showMessageDialog(this, "Record updated!!");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProcessEducationalActionPerformed

    private void txtEmpIdEmploymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIdEmploymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIdEmploymentActionPerformed

    private void txtEmpIdEmploymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpIdEmploymentKeyReleased
        // TODO add your handling code here:
        checkEmployeeId();
    }//GEN-LAST:event_txtEmpIdEmploymentKeyReleased

    private void txtSchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSchoolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSchoolActionPerformed

    private void txtAchievementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAchievementsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAchievementsActionPerformed

    private void btnProcessEmploymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessEmploymentActionPerformed
        // TODO add your handling code here:
        try
        {
            String empId = txtEmpIdEmployment.getText();

            

            String jobPosition = txtJobPosition.getText();
            String school = txtSchool.getText();
            java.util.Date employment = jdcyoe.getDate();
java.sql.Date employment1 = null; // Default to NULL

if (employment1 != null) {
    employment1= new java.sql.Date(employment.getTime());
}



            String subjectTaught = txtSubjectsTaught.getText();
            String gradeLevelsTaught = txtGradeLevelsTaught.getText();
            String professionalOrganization = txtProfessionalOrganization.getText();
            String achievements = txtAchievements.getText();
            java.util.Date appointed = jdcdop.getDate();
            java.sql.Date appointed1 = new java.sql.Date(appointed.getTime());
            String ncLevel = txtNcLevel.getText();
            String provitionary = txtProvitionary.getText();
            String selectedDepartment = cmbDepartment.getSelectedItem().toString();
            String status = "";

        if (rbtnRetired.isSelected()) {
            status = "Retired";
}   else if (rbtnResign.isSelected()) {
            status = "Resigned";
}

           
            java.sql.Date employment2 = new java.sql.Date(employment.getTime());
            
            String sql;
            String url = "jdbc:mysql://localhost:3306/Personal_Information?";
            String user = "root";
            String password = "";
            con=DriverManager.getConnection(url, user, password);
            if(btnProcessEmployment.getText().equals("Add"))
            {
                sql = "INSERT INTO employment_history(employeeID,department, job_position, school, years_of_employment, subjects_taught, grade_levels_taught, professional_organization, achievements, nc_level, date_of_appointment, provitionary, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                ps = con.prepareStatement(sql);
                ps.setString(1, empId);
                ps.setString(2, jobPosition);
                ps.setString(3, selectedDepartment);
                ps.setString(4, school);
                ps.setDate(5, employment2);
                ps.setString(6, subjectTaught);
                ps.setString(7, gradeLevelsTaught);
                ps.setString(8, professionalOrganization);
                ps.setString(9, achievements);
                ps.setString(10, ncLevel);
                ps.setDate(11, appointed1);
                ps.setString(12, provitionary);
                ps.setString(13, status);
               

                
                ps.executeUpdate();
               

                JOptionPane.showMessageDialog(this, "Successfully added to records!!");

            }
            else
            {
                sql = "UPDATE employment_history SET job_position = ?, department=?, school = ?, years_of_employment = ?, subjects_taught = ?, grade_levels_taught = ?, professional_organization = ?, achievments = ?, nc_level = ?, date_of_appointment = ?, provitionary = ?, status = ? WHERE employeeID = ?";

                ps = con.prepareStatement(sql);

                ps.setString(1, jobPosition);
                ps.setString(2, selectedDepartment);
                ps.setString(3, school);
                ps.setDate(4, employment2);
                ps.setString(5, subjectTaught);
                ps.setString(6, gradeLevelsTaught);
                ps.setString(7, professionalOrganization);
                ps.setString(8, achievements);
                ps.setString(9, ncLevel);
                ps.setDate(10, appointed1);
                ps.setString(11, provitionary);
                ps.setString(12, status);                
                ps.setString(13, empId);

                
                ps.executeUpdate();
               

                erase();

                JOptionPane.showMessageDialog(this, "Record updated!!");
            }
            

        }
        catch(SQLException ex)
        {
            Logger.getLogger(Admin_panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProcessEmploymentActionPerformed

    private void txtJobPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobPositionActionPerformed

    private void rbtnResignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnResignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnResignActionPerformed

  


    
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Admin_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_panel1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessEducational;
    private javax.swing.JButton btnProcessEmployment;
    private javax.swing.JButton btnprocess;
    private javax.swing.JComboBox<String> cbnationality;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcbachelor;
    private com.toedter.calendar.JDateChooser jdcbirthdate;
    private com.toedter.calendar.JDateChooser jdcdoctorate;
    private com.toedter.calendar.JDateChooser jdcdop;
    private com.toedter.calendar.JDateChooser jdcmasteral;
    private com.toedter.calendar.JDateChooser jdcyoe;
    private javax.swing.JRadioButton rbtnResign;
    private javax.swing.JRadioButton rbtnRetired;
    private javax.swing.JRadioButton rbtnfemale;
    private javax.swing.JRadioButton rbtnmale;
    private javax.swing.ButtonGroup sexGroup;
    private javax.swing.ButtonGroup status;
    private javax.swing.JTextField txtAchievements;
    private javax.swing.JTextField txtBachelorGpa;
    private javax.swing.JTextField txtBachelorInstitution;
    private javax.swing.JTextField txtBachelorMajor;
    private javax.swing.JTextField txtBachelorMinor;
    private javax.swing.JTextField txtBachelorSpecialization;
    private javax.swing.JTextField txtBachelorTitle;
    private javax.swing.JTextField txtDoctorateGpa2;
    private javax.swing.JTextField txtDoctorateInstitution;
    private javax.swing.JTextField txtDoctorateMajor;
    private javax.swing.JTextField txtDoctorateMinor;
    private javax.swing.JTextField txtDoctorateSpecialization;
    private javax.swing.JTextField txtDoctorateTitle1;
    private javax.swing.JTextField txtEmpIdEducational;
    private javax.swing.JTextField txtEmpIdEmployment;
    private javax.swing.JTextField txtEmployee_Id;
    private javax.swing.JTextField txtGradeLevelsTaught;
    private javax.swing.JTextField txtJobPosition;
    private javax.swing.JTextField txtMasteralGpa;
    private javax.swing.JTextField txtMasteralInstitution1;
    private javax.swing.JTextField txtMasteralMajor1;
    private javax.swing.JTextField txtMasteralMinor1;
    private javax.swing.JTextField txtMasteralSpecialization1;
    private javax.swing.JTextField txtMasteralTitle2;
    private javax.swing.JTextField txtNcLevel;
    private javax.swing.JTextField txtProfessionalOrganization;
    private javax.swing.JTextField txtProvitionary;
    private javax.swing.JTextField txtSchool;
    private javax.swing.JTextField txtSubjectsTaught;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcontactNo;
    private javax.swing.JTextField txteducName;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirstName;
    private javax.swing.JTextField txtlastName;
    private javax.swing.JTextField txtmiddleName;
    // End of variables declaration//GEN-END:variables
}
