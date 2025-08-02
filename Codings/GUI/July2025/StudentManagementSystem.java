import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Student Management System - A comprehensive GUI application demonstrating
 * various Swing components and modern UI design patterns.
 * 
 * Features:
 * - Add/Edit/Delete students
 * - Search and filter functionality
 * - Data validation
 * - Modern UI with custom styling
 * - Table display with sorting
 * - Form validation and error handling
 */
public class StudentManagementSystem extends JFrame {
    
    // UI Components
    private JTextField txtId, txtName, txtEmail, txtPhone, txtSearch;
    private JComboBox<String> cmbCourse;
    private JSpinner spnAge;
    private JTextArea txtAddress;
    private JTable tblStudents;
    private DefaultTableModel tableModel;
    private JLabel lblStatus;
    
    // Data storage
    private ArrayList<Student> students;
    private int currentId = 1;
    
    // Colors for modern UI
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(41, 128, 185);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color ERROR_COLOR = new Color(231, 76, 60);
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    
    public StudentManagementSystem() {
        students = new ArrayList<>();
        initializeUI();
        setupEventHandlers();
        loadSampleData();
    }
    
    private void initializeUI() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
        
        // Main layout
        setLayout(new BorderLayout(10, 10));
        
        // Create panels
        JPanel headerPanel = createHeaderPanel();
        JPanel formPanel = createFormPanel();
        JPanel tablePanel = createTablePanel();
        JPanel statusPanel = createStatusPanel();
        
        // Add panels to frame
        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
        add(tablePanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        
        // Add padding
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(PRIMARY_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel subtitleLabel = new JLabel("Manage student information efficiently");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.WHITE);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);
        
        panel.add(titlePanel, BorderLayout.WEST);
        
        // Add current date
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        JLabel dateLabel = new JLabel(sdf.format(new Date()));
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        dateLabel.setForeground(Color.WHITE);
        panel.add(dateLabel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                "Student Information",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                PRIMARY_COLOR
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panel.setPreferredSize(new Dimension(350, 0));
        
        // Student ID
        JPanel idPanel = createFormField("Student ID:", txtId = new JTextField(10));
        txtId.setEditable(false);
        txtId.setText(String.valueOf(currentId));
        
        // Name
        JPanel namePanel = createFormField("Full Name:", txtName = new JTextField(20));
        
        // Email
        JPanel emailPanel = createFormField("Email:", txtEmail = new JTextField(20));
        
        // Phone
        JPanel phonePanel = createFormField("Phone:", txtPhone = new JTextField(15));
        
        // Age
        SpinnerNumberModel ageModel = new SpinnerNumberModel(18, 16, 100, 1);
        spnAge = new JSpinner(ageModel);
        JPanel agePanel = createFormField("Age:", spnAge);
        
        // Course
        String[] courses = {"Computer Science", "Engineering", "Business", "Arts", "Medicine", "Law"};
        cmbCourse = new JComboBox<>(courses);
        JPanel coursePanel = createFormField("Course:", cmbCourse);
        
        // Address
        txtAddress = new JTextArea(3, 20);
        txtAddress.setLineWrap(true);
        txtAddress.setWrapStyleWord(true);
        JScrollPane addressScroll = new JScrollPane(txtAddress);
        JPanel addressPanel = createFormField("Address:", addressScroll);
        
        // Buttons
        JPanel buttonPanel = createButtonPanel();
        
        // Add all panels
        panel.add(idPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(phonePanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(agePanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(coursePanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(addressPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());
        
        return panel;
    }
    
    private JPanel createFormField(String label, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.setOpaque(false);
        
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(new Color(52, 73, 94));
        
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setOpaque(false);
        
        JButton btnAdd = createStyledButton("Add Student", SUCCESS_COLOR);
        JButton btnUpdate = createStyledButton("Update", PRIMARY_COLOR);
        JButton btnDelete = createStyledButton("Delete", ERROR_COLOR);
        JButton btnClear = createStyledButton("Clear", WARNING_COLOR);
        
        btnAdd.setActionCommand("ADD");
        btnUpdate.setActionCommand("UPDATE");
        btnDelete.setActionCommand("DELETE");
        btnClear.setActionCommand("CLEAR");
        
        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnClear);
        
        return panel;
    }
    
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
        
        return button;
    }
    
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                "Student Records",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                PRIMARY_COLOR
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        // Search panel
        JPanel searchPanel = new JPanel(new BorderLayout(5, 0));
        searchPanel.setOpaque(false);
        
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtSearch = new JTextField(20);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        searchPanel.add(searchLabel, BorderLayout.WEST);
        searchPanel.add(txtSearch, BorderLayout.CENTER);
        
        // Table
        String[] columns = {"ID", "Name", "Email", "Phone", "Age", "Course", "Address"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        
        tblStudents = new JTable(tableModel);
        tblStudents.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tblStudents.setRowHeight(25);
        tblStudents.setSelectionBackground(PRIMARY_COLOR);
        tblStudents.setSelectionForeground(Color.WHITE);
        tblStudents.setGridColor(new Color(189, 195, 199));
        
        // Enable sorting
        tblStudents.setAutoCreateRowSorter(true);
        
        JScrollPane scrollPane = new JScrollPane(tblStudents);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(52, 73, 94));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        lblStatus = new JLabel("Ready");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblStatus.setForeground(Color.WHITE);
        
        JLabel recordCount = new JLabel("Total Records: 0");
        recordCount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        recordCount.setForeground(Color.WHITE);
        
        panel.add(lblStatus, BorderLayout.WEST);
        panel.add(recordCount, BorderLayout.EAST);
        
        return panel;
    }
    
    private void setupEventHandlers() {
        // Button actions
        addActionListener("ADD", e -> addStudent());
        addActionListener("UPDATE", e -> updateStudent());
        addActionListener("DELETE", e -> deleteStudent());
        addActionListener("CLEAR", e -> clearForm());
        
        // Table selection
        tblStudents.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedStudent();
            }
        });
        
        // Search functionality
        txtSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { searchStudents(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { searchStudents(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { searchStudents(); }
        });
        
        // Form validation
        txtName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validateName();
            }
        });
        
        txtEmail.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validateEmail();
            }
        });
    }
    
    private void addActionListener(String command, ActionListener listener) {
        for (Component comp : getComponents()) {
            if (comp instanceof JPanel) {
                addActionListenerToPanel((JPanel) comp, command, listener);
            }
        }
    }
    
    private void addActionListenerToPanel(JPanel panel, String command, ActionListener listener) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (command.equals(button.getActionCommand())) {
                    button.addActionListener(listener);
                }
            } else if (comp instanceof JPanel) {
                addActionListenerToPanel((JPanel) comp, command, listener);
            }
        }
    }
    
    private void addStudent() {
        if (!validateForm()) {
            return;
        }
        
        Student student = new Student(
            currentId++,
            txtName.getText().trim(),
            txtEmail.getText().trim(),
            txtPhone.getText().trim(),
            (Integer) spnAge.getValue(),
            (String) cmbCourse.getSelectedItem(),
            txtAddress.getText().trim()
        );
        
        students.add(student);
        updateTable();
        clearForm();
        updateStatus("Student added successfully!", SUCCESS_COLOR);
        updateRecordCount();
    }
    
    private void updateStudent() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow == -1) {
            showError("Please select a student to update.");
            return;
        }
        
        if (!validateForm()) {
            return;
        }
        
        int modelRow = tblStudents.convertRowIndexToModel(selectedRow);
        int studentId = Integer.parseInt(tableModel.getValueAt(modelRow, 0).toString());
        
        Student student = findStudentById(studentId);
        if (student != null) {
            student.setName(txtName.getText().trim());
            student.setEmail(txtEmail.getText().trim());
            student.setPhone(txtPhone.getText().trim());
            student.setAge((Integer) spnAge.getValue());
            student.setCourse((String) cmbCourse.getSelectedItem());
            student.setAddress(txtAddress.getText().trim());
            
            updateTable();
            clearForm();
            updateStatus("Student updated successfully!", SUCCESS_COLOR);
        }
    }
    
    private void deleteStudent() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow == -1) {
            showError("Please select a student to delete.");
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this student?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            int modelRow = tblStudents.convertRowIndexToModel(selectedRow);
            int studentId = Integer.parseInt(tableModel.getValueAt(modelRow, 0).toString());
            
            students.removeIf(s -> s.getId() == studentId);
            updateTable();
            clearForm();
            updateStatus("Student deleted successfully!", SUCCESS_COLOR);
            updateRecordCount();
        }
    }
    
    private void clearForm() {
        txtId.setText(String.valueOf(currentId));
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        spnAge.setValue(18);
        cmbCourse.setSelectedIndex(0);
        txtAddress.setText("");
        tblStudents.clearSelection();
        
        // Reset validation styling
        txtName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        updateStatus("Form cleared", Color.BLACK);
    }
    
    private void loadSelectedStudent() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow == -1) return;
        
        int modelRow = tblStudents.convertRowIndexToModel(selectedRow);
        int studentId = Integer.parseInt(tableModel.getValueAt(modelRow, 0).toString());
        
        Student student = findStudentById(studentId);
        if (student != null) {
            txtId.setText(String.valueOf(student.getId()));
            txtName.setText(student.getName());
            txtEmail.setText(student.getEmail());
            txtPhone.setText(student.getPhone());
            spnAge.setValue(student.getAge());
            cmbCourse.setSelectedItem(student.getCourse());
            txtAddress.setText(student.getAddress());
        }
    }
    
    private void searchStudents() {
        String searchTerm = txtSearch.getText().toLowerCase();
        updateTable(searchTerm);
    }
    
    private boolean validateForm() {
        boolean isValid = true;
        
        // Validate name
        if (txtName.getText().trim().isEmpty()) {
            showFieldError(txtName, "Name is required");
            isValid = false;
        } else if (txtName.getText().trim().length() < 2) {
            showFieldError(txtName, "Name must be at least 2 characters");
            isValid = false;
        }
        
        // Validate email
        if (txtEmail.getText().trim().isEmpty()) {
            showFieldError(txtEmail, "Email is required");
            isValid = false;
        } else if (!isValidEmail(txtEmail.getText().trim())) {
            showFieldError(txtEmail, "Invalid email format");
            isValid = false;
        }
        
        // Validate phone
        if (txtPhone.getText().trim().isEmpty()) {
            showFieldError(txtPhone, "Phone is required");
            isValid = false;
        }
        
        return isValid;
    }
    
    private void validateName() {
        if (txtName.getText().trim().isEmpty()) {
            showFieldError(txtName, "Name is required");
        } else if (txtName.getText().trim().length() < 2) {
            showFieldError(txtName, "Name must be at least 2 characters");
        } else {
            txtName.setBorder(BorderFactory.createLineBorder(SUCCESS_COLOR, 2));
        }
    }
    
    private void validateEmail() {
        if (txtEmail.getText().trim().isEmpty()) {
            showFieldError(txtEmail, "Email is required");
        } else if (!isValidEmail(txtEmail.getText().trim())) {
            showFieldError(txtEmail, "Invalid email format");
        } else {
            txtEmail.setBorder(BorderFactory.createLineBorder(SUCCESS_COLOR, 2));
        }
    }
    
    private void showFieldError(JTextField field, String message) {
        field.setBorder(BorderFactory.createLineBorder(ERROR_COLOR, 2));
        updateStatus(message, ERROR_COLOR);
    }
    
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(
            this,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    private void updateTable() {
        updateTable("");
    }
    
    private void updateTable(String searchTerm) {
        tableModel.setRowCount(0);
        
        for (Student student : students) {
            if (searchTerm.isEmpty() || 
                student.getName().toLowerCase().contains(searchTerm) ||
                student.getEmail().toLowerCase().contains(searchTerm) ||
                student.getCourse().toLowerCase().contains(searchTerm)) {
                
                tableModel.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getPhone(),
                    student.getAge(),
                    student.getCourse(),
                    student.getAddress()
                });
            }
        }
    }
    
    private Student findStudentById(int id) {
        return students.stream()
                      .filter(s -> s.getId() == id)
                      .findFirst()
                      .orElse(null);
    }
    
    private void updateStatus(String message, Color color) {
        lblStatus.setText(message);
        lblStatus.setForeground(color);
    }
    
    private void updateRecordCount() {
        Component[] components = getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                Component[] subComponents = ((JPanel) comp).getComponents();
                for (Component subComp : subComponents) {
                    if (subComp instanceof JLabel && subComp.getName() == null) {
                        JLabel label = (JLabel) subComp;
                        if (label.getText().startsWith("Total Records:")) {
                            label.setText("Total Records: " + students.size());
                            return;
                        }
                    }
                }
            }
        }
    }
    
    private void loadSampleData() {
        students.add(new Student(1, "John Doe", "john.doe@email.com", "555-0101", 20, "Computer Science", "123 Main St, City"));
        students.add(new Student(2, "Jane Smith", "jane.smith@email.com", "555-0102", 22, "Engineering", "456 Oak Ave, Town"));
        students.add(new Student(3, "Mike Johnson", "mike.johnson@email.com", "555-0103", 19, "Business", "789 Pine Rd, Village"));
        students.add(new Student(4, "Sarah Wilson", "sarah.wilson@email.com", "555-0104", 21, "Arts", "321 Elm St, Borough"));
        students.add(new Student(5, "David Brown", "david.brown@email.com", "555-0105", 23, "Medicine", "654 Maple Dr, County"));
        
        currentId = 6;
        updateTable();
        updateRecordCount();
        updateStatus("Sample data loaded", Color.BLACK);
    }
    
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run the application
        SwingUtilities.invokeLater(() -> {
            new StudentManagementSystem().setVisible(true);
        });
    }
}

/**
 * Student class to represent student data
 */
class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String course;
    private String address;
    
    public Student(int id, String name, String email, String phone, int age, String course, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.course = course;
        this.address = address;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
} 