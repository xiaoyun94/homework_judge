import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame
  extends JFrame
{
  private JTextField assignmentNameTextField;
  private JTextField nameTextField;
  private JTextField filerTextField;
  private JTextField idTextField;
  private JTable scroeTable;
  private int numberOfQuestion = 7;
  private JTextField scroeField;
  private JTree tree;
  private JLabel scroeLabel;
  private JTextArea textArea;
  private JRadioButton isTopButton;
  private JSlider slider;
  private JComboBox nameComboBox;
  private int localQuestion = 1;
  private int allReceivedNum = 0;
  private String localChosedFilePath;
  private String encodingWay;
  private JToggleButton matchedToggleButton;
  private Student localStudent;
  private int requireNumber;
  private String[] columnNames = { "#N", "Scroe" };
  private JavaMail javaMail;
  private String lastUseAddr = "";
  private JTextArea mailTextArea;
  Node[] topLayer;
  int length;
  private JTextField formatTextField;
  private JTextField commentsTextField;
  private JTable historyTable;
  private JTextField questionNumberTextField;
  private JTextField receiveAddrTextField;
  
  MainFrame(int hwname)
  {
    this.encodingWay = System.getProperty("file.encoding");
    
    setTitle(String.format("Homework judgement [%s]", new Object[] { Integer.valueOf(hwname) }));
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(3);
    
    JPanel panel = new JPanel();
    getContentPane().add(panel, "North");
    
    JLabel lblhw = new JLabel("#HW");
    panel.add(lblhw);
    
    this.assignmentNameTextField = new JTextField(String.valueOf(hwname));
    panel.add(this.assignmentNameTextField);
    this.assignmentNameTextField.setColumns(4);
    
    JLabel lblquestions = new JLabel("#QUESTIONS");
    panel.add(lblquestions);
    
    this.questionNumberTextField = new JTextField("0");
    this.questionNumberTextField.setColumns(4);
    panel.add(this.questionNumberTextField);
    
    JLabel lblId = new JLabel("ID");
    panel.add(lblId);
    
    this.idTextField = new JTextField();
    panel.add(this.idTextField);
    this.idTextField.setColumns(10);
    
    JLabel lblNewLabel_1 = new JLabel("NAME");
    panel.add(lblNewLabel_1);
    
    this.nameComboBox = new JComboBox();
    this.nameComboBox.setEditable(true);
    this.nameComboBox.setPreferredSize(new Dimension(100, 26));
    panel.add(this.nameComboBox);
    
    JSeparator separator_6 = new JSeparator();
    separator_6.setOrientation(1);
    separator_6.setPreferredSize(new Dimension(10, 30));
    panel.add(separator_6);
    
    JLabel lblNamw = new JLabel("MEACHED NAME");
    panel.add(lblNamw);
    
    this.nameTextField = new JTextField();
    panel.add(this.nameTextField);
    this.nameTextField.setColumns(10);
    
    this.matchedToggleButton = new JToggleButton("MATCHED ?");
    panel.add(this.matchedToggleButton);
    
    JTabbedPane tabbedPane = new JTabbedPane(1);
    getContentPane().add(tabbedPane, "East");
    
    JPanel panel_2 = new JPanel();
    panel_2.setPreferredSize(new Dimension(150, 400));
    tabbedPane.add(panel_2, "Seetings");
    panel_2.setLayout(new BoxLayout(panel_2, 1));
    
    JLabel lblScore = new JLabel("Score");
    lblScore.setFont(new Font("Lucida Grande", 0, 16));
    panel_2.add(lblScore);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setPreferredSize(new Dimension(150, 200));
    panel_2.add(scrollPane_2);
    
    this.scroeTable = new JTable(new DefaultTableModel(this.columnNames, 0));
    this.scroeTable.setFont(new Font("Lucida Grande", 0, 16));
    scrollPane_2.setViewportView(this.scroeTable);
    
    JLabel lblNewLabel = new JLabel("New label");
    scrollPane_2.setColumnHeaderView(lblNewLabel);
    
    JPanel panel_5 = new JPanel();
    panel_5.setPreferredSize(new Dimension(150, 500));
    panel_2.add(panel_5);
    
    this.scroeLabel = new JLabel(String.format("Scroe#%d", new Object[] { Integer.valueOf(this.localQuestion) }));
    panel_5.add(this.scroeLabel);
    
    this.scroeField = new JTextField();
    this.scroeField.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent e)
      {
        MainFrame.this.scroeField.requestFocus();
      }
    });
    this.scroeField.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent e)
      {
        if (e.getKeyChar() == '\n') {
          MainFrame.this.nextQuestion();
        }
      }
    });
    panel_5.add(this.scroeField);
    this.scroeField.setColumns(6);
    
    JButton btnNewButton = new JButton("Next");
    panel_5.add(btnNewButton);
    
    JSeparator separator_2 = new JSeparator();
    panel_5.add(separator_2);
    separator_2.setPreferredSize(new Dimension(140, 10));
    
    JLabel lblNewLabel_2 = new JLabel("Comments");
    panel_5.add(lblNewLabel_2);
    
    this.commentsTextField = new JTextField();
    panel_5.add(this.commentsTextField);
    this.commentsTextField.setColumns(10);
    
    JButton btnNewButton_1 = new JButton("Store");
    panel_5.add(btnNewButton_1);
    btnNewButton_1.setPreferredSize(new Dimension(120, 40));
    
    JButton btnNext = new JButton("Next");
    btnNext.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.localQuestion = 1;
        MainFrame.this.idTextField.setText("");
        MainFrame.this.nameComboBox.setModel(new DefaultComboBoxModel());
        MainFrame.this.matchedToggleButton.setSelected(false);
        MainFrame.this.nameTextField.setText("");
      }
    });
    btnNext.setPreferredSize(new Dimension(120, 40));
    panel_5.add(btnNext);
    
    JSeparator separator = new JSeparator();
    panel_5.add(separator);
    separator.setPreferredSize(new Dimension(140, 10));
    
    JLabel lblText = new JLabel("Text Size");
    panel_5.add(lblText);
    
    this.slider = new JSlider();
    panel_5.add(this.slider);
    this.slider.setValue(32);
    this.slider.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent e)
      {
        MainFrame.this.textArea.setFont(new Font("system", 0, (int)(MainFrame.this.slider.getValue() * 0.5D)));
      }
    });
    this.slider.setPreferredSize(new Dimension(150, 20));
    
    this.isTopButton = new JRadioButton("Top Always");
    panel_5.add(this.isTopButton);
    this.isTopButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.setAlwaysOnTop(MainFrame.this.isTopButton.isSelected());
      }
    });
    JSeparator separator_1 = new JSeparator();
    panel_5.add(separator_1);
    separator_1.setPreferredSize(new Dimension(140, 10));
    
    JLabel lblCoding = new JLabel("Language Encode");
    panel_5.add(lblCoding);
    
    JPanel panel_1 = new JPanel();
    panel_5.add(panel_1);
    
    JRadioButton gbkButton = new JRadioButton("GBK");
    JRadioButton utf8Button = new JRadioButton("UTF-8");
    
    gbkButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.changeEncoding("GBK");
      }
    });
    utf8Button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.changeEncoding("UTF-8");
      }
    });
    panel_1.add(gbkButton);
    panel_1.add(utf8Button);
    
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(utf8Button);
    buttonGroup.add(gbkButton);
    
    btnNewButton_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        try
        {
          if (!MainFrame.this.matchedToggleButton.isSelected())
          {
            int id = Integer.parseInt(MainFrame.this.idTextField.getText());
            String name = MainFrame.this.nameComboBox.getSelectedItem().toString();
            MainFrame.this.localStudent = new Student(id, name, MainFrame.this.requireNumber);
            StudentList.addStudent(MainFrame.this.localStudent);
          }
          double[] score = new double[MainFrame.this.numberOfQuestion];
          String emailtext = "";
          for (int i = 0; i < MainFrame.this.numberOfQuestion; i++)
          {
            String s = MainFrame.this.scroeTable.getValueAt(i, 1).toString();
            score[i] = Double.parseDouble(s);
            emailtext = emailtext + s + "\t";
          }
          int assignment = Integer.parseInt(MainFrame.this.assignmentNameTextField.getText());
          boolean s = MainFrame.this.localStudent.addAssignment(new Assignment(assignment, score, MainFrame.this.commentsTextField.getText()));
          if (!s) {
            JOptionPane.showMessageDialog(null, "Add assignment ERROR", "ERROR", 0);
          }
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String date = df.format(new Date());
          
          MainFrame.this.mailTextArea.setText(String.format("Dear SUSTCer(%s),\n\nThis is a feedback for your java assignment #%s. And scroes are listed in the following:\n\n%s\n\nComments:\n%s\n\nFang Ge\n%s\n----------------\nPowered by JAVA", new Object[] {
          
            MainFrame.this.idTextField.getText(), MainFrame.this.assignmentNameTextField.getText(), 
            emailtext, MainFrame.this.commentsTextField.getText(), date }));
        }
        catch (Exception exception)
        {
          exception.printStackTrace();
        }
      }
    });
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.nextQuestion();
      }
    });
    if (this.encodingWay.equals("GBK")) {
      gbkButton.setSelected(true);
    } else {
      utf8Button.setSelected(true);
    }
    JPanel panel_3 = new JPanel();
    getContentPane().add(panel_3, "South");
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(32);
    scrollPane.setPreferredSize(new Dimension(200, 600));
    
    JPanel panel2 = new JPanel();
    
    panel2.setLayout(new BoxLayout(panel2, 1));
    
    JPanel panel_4 = new JPanel();
    panel_4.setPreferredSize(new Dimension(200, 200));
    panel2.add(panel_4);
    
    JLabel lblFilter = new JLabel("Regex Filter");
    panel_4.add(lblFilter);
    
    this.filerTextField = new JTextField("[\\s\\S]+\\.java");
    panel_4.add(this.filerTextField);
    this.filerTextField.setColumns(15);
    
    JLabel lblAccessFormat = new JLabel("Access Load Format");
    panel_4.add(lblAccessFormat);
    
    this.formatTextField = new JTextField("java|inf|txt|c|m|bat");
    this.formatTextField.setColumns(15);
    panel_4.add(this.formatTextField);
    
    JSeparator separator_3 = new JSeparator();
    separator_3.setPreferredSize(new Dimension(200, 10));
    panel_4.add(separator_3);
    JButton btnNewButton_2 = new JButton("Choose a folder");
    btnNewButton_2.setPreferredSize(new Dimension(200, 30));
    panel_4.add(btnNewButton_2);
    btnNewButton_2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.getPath();
      }
    });
    panel2.add(scrollPane);
    
    getContentPane().add(panel2, "West");
    
    this.tree = new JTree(new Object[] { "Nothing." });
    this.tree.addTreeWillExpandListener(new TreeWillExpandListener()
    {
      public void treeWillCollapse(TreeExpansionEvent event) {}
      
      public void treeWillExpand(TreeExpansionEvent event) {}
    });
    this.tree.addTreeSelectionListener(new TreeSelectionListener()
    {
      public void valueChanged(TreeSelectionEvent e)
      {
        MainFrame.this.folderMatch((Node)MainFrame.this.tree.getLastSelectedPathComponent());
      }
    });
    scrollPane.setViewportView(this.tree);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    getContentPane().add(scrollPane_1, "Center");
    
    this.textArea = new JTextArea();
    this.textArea.addMouseListener(new MouseAdapter()
    {
      public void mouseEntered(MouseEvent e)
      {
        MainFrame.this.textArea.requestFocus();
      }
    });
    this.textArea.setCaretColor(Color.white);
    this.textArea.setBackground(Color.DARK_GRAY);
    this.textArea.setForeground(Color.WHITE);
    this.textArea.setFont(new Font("Lucida Grande", 0, 16));
    
    scrollPane_1.setViewportView(this.textArea);
    panel_3.setLayout(new FlowLayout(1, 5, 5));
    
    JLabel lblNewLabel_3 = new JLabel("History");
    panel_3.add(lblNewLabel_3);
    
    JScrollPane scrollPane_3 = new JScrollPane();
    scrollPane_3.setPreferredSize(new Dimension(500, 50));
    panel_3.add(scrollPane_3);
    
    JScrollPane scrollPane_4 = new JScrollPane();
    scrollPane_4.setPreferredSize(new Dimension(150, 90));
    tabbedPane.add(scrollPane_4, "Email");
    
    JPanel panel_6 = new JPanel();
    scrollPane_4.setColumnHeaderView(panel_6);
    panel_6.setLayout(new BoxLayout(panel_6, 1));
    
    JLabel lblNewLabel_4 = new JLabel("Email Addr");
    panel_6.add(lblNewLabel_4);
    
    this.receiveAddrTextField = new JTextField();
    panel_6.add(this.receiveAddrTextField);
    this.receiveAddrTextField.setColumns(10);
    
    JButton btnNewButton_3 = new JButton("Send");
    btnNewButton_3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if (MainFrame.this.javaMail == null)
        {
          JOptionPane.showMessageDialog(null, "Please set email at first.\nAfter that resend it again", "error", 0);
          MainFrame.this.setEmail();
        }
        else
        {
          boolean state = MainFrame.this.javaMail.send(MainFrame.this.receiveAddrTextField.getText(), 
            String.format("Feedback for JAVA assignment #%s", new Object[] { MainFrame.this.assignmentNameTextField.getText() }), 
            MainFrame.this.mailTextArea.getText());
          if (state)
          {
            MainFrame.this.localStudent.setEmail(MainFrame.this.receiveAddrTextField.getText());
            MainFrame.this.receiveAddrTextField.setText("");
            MainFrame.this.mailTextArea.setText("SEND SUCCESSFULLY");
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Failed send, try checking and resending.", "ERROR", 0);
          }
        }
      }
    });
    panel_6.add(btnNewButton_3);
    
    this.mailTextArea = new JTextArea();
    scrollPane_4.setViewportView(this.mailTextArea);
    
    this.historyTable = new JTable(new DefaultTableModel(new String[] { "Name", "ID", "#SUB", "HW1" }, 1));
    this.historyTable.setFont(new Font("Lucida Grande", 0, 18));
    
    scrollPane_3.setViewportView(this.historyTable);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnFile = new JMenu("File");
    menuBar.add(mnFile);
    
    JMenuItem mntmLoad = new JMenuItem("Load Stundent Information");
    mntmLoad.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFileChooser jFileChooser = new JFileChooser(MainFrame.this.lastUseAddr);
        jFileChooser.setDialogTitle("Choose a file to load");
        jFileChooser.setFileSelectionMode(0);
        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.setFileFilter(new FileNameExtensionFilter("SUSTC(*.sustc)", new String[] { "sustc" }));
        int state = jFileChooser.showOpenDialog(null);
        if (state == 0) {
          StudentList.loadFile(jFileChooser.getSelectedFile().getPath());
        }
      }
    });
    JMenuItem mntmNewFile = new JMenuItem("New File");
    mntmNewFile.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFileChooser jFileChooser = new JFileChooser(MainFrame.this.lastUseAddr);
        jFileChooser.setDialogTitle("Choose a file to save");
        jFileChooser.setSelectedFile(new File("untitled"));
        jFileChooser.setDialogTitle("Choose a file to save");
        jFileChooser.setFileSelectionMode(0);
        jFileChooser.setFileFilter(new FileNameExtensionFilter("SUSTC(*.sustc)", new String[] { "sustc" }));
        jFileChooser.setAcceptAllFileFilterUsed(false);
        int state = jFileChooser.showSaveDialog(null);
        if (state == 0)
        {
          File file = jFileChooser.getSelectedFile();
          MainFrame.this.lastUseAddr = file.getParent();
          if (!file.exists()) {
            try
            {
              file.createNewFile();
            }
            catch (IOException e1)
            {
              e1.printStackTrace();
            }
          }
        }
      }
    });
    mnFile.add(mntmNewFile);
    
    JSeparator separator_5 = new JSeparator();
    mnFile.add(separator_5);
    mnFile.add(mntmLoad);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Save Stundent Information");
    mntmNewMenuItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File(MainFrame.this.lastUseAddr));
        jFileChooser.setSelectedFile(new File("untitled"));
        jFileChooser.setDialogTitle("Choose a file to save");
        jFileChooser.setFileSelectionMode(0);
        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.setFileFilter(new FileNameExtensionFilter("SUSTC(*.sustc)", new String[] { "sustc" }));
        int state = jFileChooser.showDialog(null, "Save");
        if (state == 0) {
          StudentList.storeFile(jFileChooser.getSelectedFile().getPath() + ".sustc");
        }
      }
    });
    mnFile.add(mntmNewMenuItem);
    
    JSeparator separator_4 = new JSeparator();
    mnFile.add(separator_4);
    
    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
    mntmNewMenuItem_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        int i = JOptionPane.showConfirmDialog(null, new String[] { "Are you sure to exit?", "And has files been saved?" }, "Confirm", 0);
        if (i == 0) {
          System.exit(0);
        }
      }
    });
    mnFile.add(mntmNewMenuItem_1);
    
    JMenu mnWork = new JMenu("Work");
    menuBar.add(mnWork);
    
    JMenuItem mntmCheckNow = new JMenuItem("Set Email");
    mntmCheckNow.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MainFrame.this.setEmail();
      }
    });
    mnWork.add(mntmCheckNow);
    
    JMenu mnSearch = new JMenu("Search");
    menuBar.add(mnSearch);
    
    JMenuItem mntmInStudentId = new JMenuItem("In Student ID");
    mnSearch.add(mntmInStudentId);
  }
  
  public void getPath()
  {
    JFileChooser jFileChooser = new JFileChooser();
    setAlwaysOnTop(false);
    jFileChooser.setFileSelectionMode(1);
    int state = jFileChooser.showOpenDialog(null);
    if (state == 0)
    {
      File file = jFileChooser.getSelectedFile();
      
      FileFilter fileFilter = new FileFilter()
      {
        public boolean accept(File newfile)
        {
          String name = newfile.getName();
          Pattern pattern = Pattern.compile(MainFrame.this.filerTextField.getText());
          Matcher matcher = pattern.matcher(name);
          return (matcher.matches()) || (newfile.isDirectory());
        }
      };
      Node node = new Node(file.getName(), file.getPath());
      Node.getAllNodes(node, fileFilter);
      
      this.tree.setModel(new DefaultTreeModel(node));
    }
  }
  
  public void loadFile(File file, String encodingway)
  {
    try
    {
      FileInputStream fileReader = new FileInputStream(file);
      InputStreamReader inputStreamReader = new InputStreamReader(fileReader, encodingway);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      
      StringBuffer stringBuffer = new StringBuffer();
      String temp;
      while ((temp = bufferedReader.readLine()) != null)
      {
        stringBuffer.append(temp + "\n");
      }
      bufferedReader.close();
      fileReader.close();
      this.textArea.setText(stringBuffer.toString());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void changeEncoding(String encodingway)
  {
    try
    {
      Object[] objects = { "The file will be reopen with chosed encoding way.", 
        "And later files will keep using that." };
      
      JOptionPane.showMessageDialog(null, objects);
      Node node = (Node)this.tree.getLastSelectedPathComponent();
      loadFile(new File(node.getFilePath()), encodingway);
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }
  }
  
  public void getInformationFromNode(Node node)
  {
    String string = node.getName();
    
    Pattern pattern = Pattern.compile("\\d{8}");
    Matcher matcher = pattern.matcher(string);
    if (matcher.find())
    {
      String result = matcher.group(0);
      this.idTextField.setText(result);
      int id = Integer.parseInt(result);
      this.localStudent = StudentList.getStudent(id);
      this.matchedToggleButton.setSelected(this.localStudent != null);
      if (this.localStudent != null)
      {
        this.nameTextField.setText(this.localStudent.getName());
        
        this.historyTable.setModel(new DefaultTableModel(new String[][] { this.localStudent.getInformationArray()[1] }, 
          this.localStudent.getInformationArray()[0]));
      }
      string.replaceAll("[\\+\\-\\_\\s]\\*\\/", "");
      String[] names = string.split(result);
      this.nameComboBox.setModel(new DefaultComboBoxModel(names));
      if ((this.localStudent.getEmail() != null) && (!this.localStudent.getEmail().equals(""))) {
        this.receiveAddrTextField.setText(this.localStudent.getEmail());
      }
    }
  }
  
  public void setEmail()
  {
    JTextField user = new JTextField("fang.g@bigforce.cn");
    JTextField emailAddr = new JTextField("fang.g@bigforce.cn");
    JPasswordField password = new JPasswordField("");
    JTextField host = new JTextField("smtp.exmail.qq.com");
    
    Object[] objects = { "User", user, "Email Addr", emailAddr, "Password", password, "Host", host };
    int i = JOptionPane.showConfirmDialog(null, objects, "Settings for email", 0);
    if (i == 0) {
      this.javaMail = new JavaMail(user.getText(), new String(password.getPassword()), host.getText(), emailAddr.getText());
    }
  }
  
  public void nextQuestion()
  {
    this.numberOfQuestion = Integer.parseInt(this.questionNumberTextField.getText());
    if (this.scroeTable.getModel().getRowCount() == 0) {
      this.scroeTable.setModel(new DefaultTableModel(this.columnNames, this.numberOfQuestion));
    }
    System.out.println(this.scroeTable.getModel().getRowCount());
    if (this.localQuestion <= this.numberOfQuestion)
    {
      this.scroeTable.setValueAt(Integer.valueOf(this.localQuestion), this.localQuestion - 1, 0);
      this.scroeTable.setValueAt(this.scroeField.getText(), this.localQuestion - 1, 1);
      this.localQuestion += 1;
    }
    if (this.localQuestion > this.numberOfQuestion) {
      this.localQuestion = 1;
    }
    this.scroeLabel.setText(String.format("Scroe#%d", new Object[] { Integer.valueOf(this.localQuestion) }));
    
    this.scroeField.setText("");
  }
  
  public void reset()
  {
    this.idTextField.setText("");
    this.nameTextField.setText("");
    this.nameComboBox.setModel(new DefaultComboBoxModel());
    this.matchedToggleButton.setSelected(false);
  }
  
  public void folderMatch(Node a)
  {
    try
    {
      File file = new File(a.getFilePath());
      if (file.getName().matches(String.format("[\\s\\S]*\\.(%s)", new Object[] { this.formatTextField.getText() }))) {
        loadFile(file, this.encodingWay);
      }
      getInformationFromNode(a);
    }
    catch (Exception localException) {}
  }
}
