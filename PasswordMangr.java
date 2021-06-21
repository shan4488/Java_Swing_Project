import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;


public class PasswordMangr{

    JFrame mainFrame;                           //Declare everything here
    JMenuBar mbar;
    JMenu mFile, mEdit, mHelp, mRate;
    JMenuItem mfNewWindow, mfSave, mfExit, meCut, meCopy, mePaste, meRemove;
    JMenuItem mhAboutUs, mhDocs, mhViewLicence, mhSendFeed, mrRateOurApp, mrComplaint; 
    JPanel AddInfoPanel, tablePanel;  
    JTextField txtfAppName, txtfUserName, txtfPassword;
    JTextArea txtaNote;
    JLabel lblAppName, lblUserName, lblPassword, lblNote, lblTablehead, lblAddInfohead;
    JButton btnAdd,btnClear;

    JTable table;                                           //shreyas content
    JScrollPane scrollPaneTable;

    public void SignUp()
    {
        //Sign up code comes here
    }

    public void SignIn()
    {
        //Sign in code comes here
    }

    public void Menu()
    {
        mbar = new JMenuBar();

        mFile = new JMenu("File");
        mEdit = new JMenu("Edit");
        mHelp = new JMenu("Help");
        mRate = new JMenu("Rate");

        mfNewWindow = new JMenuItem("New Window");
        mfSave = new JMenuItem("Save");
        mfExit = new JMenuItem("Exit");

        meCut = new JMenuItem("Cut");
        meCopy = new JMenuItem("Copy");
        mePaste = new JMenuItem("Paste");
        meRemove = new JMenuItem("Remove");

        mhAboutUs = new JMenuItem("About Us");
        mhDocs = new JMenuItem("Docs");
        mhViewLicence = new JMenuItem("View Licence");
        mhSendFeed = new JMenuItem("Send Feedback");

        mrRateOurApp = new JMenuItem("Rate Our App");
        mrComplaint = new JMenuItem("Complaint");

        mbar.add(mFile);
        mbar.add(mEdit);
        mbar.add(mHelp);
        mbar.add(mRate);

        mFile.add(mfNewWindow);
        mFile.add(mfSave);
        mFile.add(mfExit);

        mEdit.add(meCut);
        mEdit.add(meCopy);
        mEdit.add(mePaste);
        mEdit.add(meRemove);

        mHelp.add(mhAboutUs);
        mHelp.add(mhDocs);
        mHelp.add(mhViewLicence);
        mHelp.add(mhSendFeed);

        mRate.add(mrRateOurApp);
        mRate.add(mrComplaint);

        mainFrame.setJMenuBar(mbar);
  

    }

    public void actionListnrMenu()
    {
        mfNewWindow.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                PasswordMangr frameObj2 = new PasswordMangr();
                frameObj2.MainFrameDisplay();
            }
        });

        mfSave.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(mainFrame, "Dont worry! We autosave as you add");
            }
        });

        mfExit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
                //System.exit(0);  //This also can be used
            }

        });

        meCut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtfAppName.cut();
                txtfPassword.cut();
                txtfUserName.cut();
                txtaNote.cut();
            }
        });

        meCopy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtfAppName.copy();
                txtfPassword.copy();
                txtfUserName.copy();
                txtaNote.copy();
            }
        });

        mePaste.addActionListener(new ActionListener()  //HAS A PROBLEM, RECTIFICATION NEEDED
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(mainFrame, txtfAppName.getCaret());
                txtfAppName.paste();
                txtfPassword.paste();
                txtfUserName.paste();
                txtaNote.paste();
            }
        });

       
    }


    public void CTable()
    {

        table = new JTable();
        
        Object[] columns = { "App Name", "User Name", "Password", "Note" };    // create a table model and set a Column Identifiers to this model
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        table.setModel(model);                                                  // set the model to the table

        table.setBackground(Color.CYAN.brighter());
        table.setForeground(Color.black);
        Font font = new Font("", 1, 16);
        table.setFont(font);
        table.setRowHeight(20);

        scrollPaneTable = new JScrollPane(table);                               //ScrollPane
        scrollPaneTable.setBounds(10, 30, 760, 210);

        Object[] row = new Object[4];
        
        btnAdd.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        
        row[0] = txtfAppName.getText();
        row[1] = txtfUserName.getText();
        row[2] = txtfPassword.getText();
        row[3] = txtaNote.getText();
        
        // add row to the model
        model.addRow(row);
        }
        });

        btnClear.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
                txtfAppName.setText("");
                txtfUserName.setText("");
                txtfPassword.setText("");
                txtaNote.setText("");
           }
        });

        mainFrame.add(scrollPaneTable);
    }


    public void Header()
    {
        lblTablehead = new JLabel("Your Password List ");
        lblTablehead.setBounds(10,5,200,20);
        lblTablehead.setFont(new Font("Serif",Font.BOLD, 16));
        mainFrame.add(lblTablehead);

        lblAddInfohead = new JLabel("Add New Password Details ");
        lblAddInfohead.setBounds(10,255,200,20);
        lblAddInfohead.setFont(new Font("Serif",Font.BOLD, 16));
        lblTablehead.setBackground(Color.BLUE);
        mainFrame.add(lblAddInfohead);

    }


    public void Addinfo()
    {
        AddInfoPanel = new JPanel();           //Panel containing textfields, labels, and buttons of AddInfo
        AddInfoPanel.setBounds(10,280,765,300);
        AddInfoPanel.setBackground(Color.YELLOW);
        AddInfoPanel.setLayout(null);

        lblAppName = new JLabel("App Name");                    //Addinfo label start
        lblAppName.setBounds(45,20,80,20);
        lblAppName.setFont(new Font("Serif",Font.BOLD, 16));
        AddInfoPanel.add(lblAppName);

        lblUserName = new JLabel("User Name");
        lblUserName.setBounds(45,70,80,20);
        lblUserName.setFont(new Font("Serif",Font.BOLD, 16));
        AddInfoPanel.add(lblUserName);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(45,120,80,20);
        lblPassword.setFont(new Font("Serif",Font.BOLD, 16));
        AddInfoPanel.add(lblPassword);

        lblNote = new JLabel("Note");
        lblNote.setBounds(45,170,80,20);
        lblNote.setFont(new Font("Serif",Font.BOLD, 16));
        AddInfoPanel.add(lblNote);

        txtfAppName = new JTextField();                 //Addinfo textfields start
        txtfAppName.setBounds(160,20,450,30);
        AddInfoPanel.add(txtfAppName);
        

        txtfUserName = new JTextField();
        txtfUserName.setBounds(160,70,450,30);
        AddInfoPanel.add(txtfUserName);

        txtfPassword = new JTextField();
        txtfPassword.setBounds(160,120,450,30);
        AddInfoPanel.add(txtfPassword);

        txtaNote = new JTextArea();
        txtaNote.setBounds(160,170,450,80);
        txtaNote.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        txtaNote.setWrapStyleWord(true);
        txtaNote.setLineWrap(true);
        AddInfoPanel.add(txtaNote);

        btnAdd = new JButton("ADD");
        btnAdd.setBounds(500,260,100,30);
        btnAdd.setBackground(Color.GREEN);
        AddInfoPanel.add(btnAdd);

        btnClear = new JButton("CLEAR");
        btnClear.setBounds(380,260,100,30);
        btnClear.setBackground(Color.RED);
        AddInfoPanel.add(btnClear);


        mainFrame.add(AddInfoPanel);

    }


    public void MainFrameDisplay()
    {
        mainFrame = new JFrame("SecurePass");           // You are free to change 
        mainFrame.setSize(800,650);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);

        //All the functions Comes here

        Menu();
        Header();
        Addinfo();
        CTable();
        actionListnrMenu();

        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public static void main(String args[])
    {
        PasswordMangr frameObj = new PasswordMangr();
        frameObj.MainFrameDisplay();
    }
    
}

