package version9;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class MainGui extends JFrame{

	DefaultTableModel model;
	DefaultTableModel model1;
	JPanel panel_3;
	JTable table;
	JTable table_1;
	JButton button;
	JButton button_1;
	JButton button_2;
	JButton button_3;
	Listener lis;
	CourseGui cGui;
	TeacherGui tGui;
	
	public MainGui() {
		cGui = new CourseGui(this);
		tGui = new TeacherGui(this); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/*
		 *frame
		 */
		setBounds(100, 100, 542, 421);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*
		 *tap pane
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(6, 6, 530, 387);
		getContentPane().add(tabbedPane);
		
		/*
		 *panel
		 */
		JPanel panel = new JPanel();
		tabbedPane.addTab("課程資訊", null, panel, null);
		panel.setLayout(null);
		
		//table
		//預設課程內容
		String[] columns = {"年級","課程名稱","授課教師","必修"};
		String[][] s = {
				{"大一","程式設計","余遠澤","是"},
				{"大一","體育","待聘（體育）","是"},
				{"大一","電子商務","何淑君","否"},
				{"大一","人機互動","葉道明","是"},
				{"大一","國文","黃碧玉","是"},
				{"大一","微積分","陳立偉","否"},
				{"大一","計網","郭家旭","是"},
				{"大一","民法服務學習","黃志呈/王蘭華","是"},
			
				{"大二","視訊串流","余遠澤","否"},
				{"大二","演算法","李文廷","是"},
				{"大二","通識","待聘（通識）","是"},
				{"大二","資料庫","葉道明","是"},
				{"大二","專案管理","何淑君","是"},
				{"大二","工程經濟","葉道明","否"},
				{"大二","體育","待聘（體育）","是"},
				{"大二","統計","陳立偉","是"},
				
				{"大三","WSSE","李文廷","否"},
				{"大三","WWWP","陳立偉","否"},
				{"大三","通識","待聘（通識）","是"},
				{"大三","軟體設計","鄭伯壎","是"},
				{"大三","無線網路","郭家旭","否"},
				{"大三","嵌入式","楊中皇","否"},
				{"大三","網路程式","林哲正","否"},
				
				{"大四","資訊倫理","張瑞觀","否"},
				{"大四","影像處理","林哲正","否"},
				{"大四","軟體工程實務","鄭伯壎","否"},
				
				{"管理一","密碼學","楊中皇","否"},
				{"管理一","資料探勘","孫培真","否"},
				{"管理一","網路行銷","張瑞觀","否"},
				{"管理一","數位鑑識","楊中皇","否"},
				{"管理一","資料分析","何淑君","否"},
				
				{"工程一","無線網路","郭家旭","否"},
				{"工程一","人工智慧","孫培真","否"},
				{"工程一","軟體流程","李文廷","否"},
				
				{"管理二","科技管理","張瑞觀","否"},
				
				{"工程二","物聯網","郭家旭","否"},
				{"工程二","軟體工程","葉道明","否"},
		};
		
		model = new DefaultTableModel(s,columns){
			private static final long serialVersionUID = 1L;
			
			//使用者不可編輯表格
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		JScrollPane	jsp = new JScrollPane(table);
		jsp.setBounds(6, 6, 497, 293);
		jsp.setViewportView(table);
		panel.add(jsp);
		
		//btn
		button = new JButton("新增");
		button.setBounds(159, 304, 85, 30);
		panel.add(button);
		
		//btn_1
		button_1 = new JButton("刪除");
		button_1.setBounds(256, 304, 85, 30);
		panel.add(button_1);

		
		
		/*
		 *panel_1
		 */
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("授課時間", null, panel_1, null);
		panel_1.setLayout(null);
		
		//table1
		String[] columns1 = {"授課教師","可","授","課","時","段","候","選","區"};
	/*	String[][] s1 = {
				{"鄭伯壎","","","","","","","",""},
				{"林哲正","","","","","","","",""},
				{"孫培真","","","","","","","",""},
				{"楊中皇","","","","","","","",""},
				{"葉道明","","","","","","","",""},
				{"李文廷","","","","","","","",""},
				{"何淑君","","","","","","","",""},
				{"余遠澤","","","","","","","",""},
				{"郭家旭","","","","","","","",""},
				{"陳立偉","","","","","","","",""},
				{"張瑞觀","","","","","","","",""}}; */
		
		String[][] s1 = {
				{"鄭伯壎","3","4","5","7","8","2","1","6"},
				{"林哲正","3","5","6","7","8","4","2","1"},
				{"孫培真","1","3","4","6","7","2","5","8"},
				{"楊中皇","3","4","6","7","8","1","2","5"},
				{"葉道明","1","3","4","5","7","8","6","2"},
				{"李文廷","2","4","5","7","8","1","3","6"},
				{"何淑君","1","2","4","6","7","5","3","8"},
				{"余遠澤","1","3","5","7","8","2","4","6"},
				{"郭家旭","1","2","4","7","8","3","5","6"},
				{"陳立偉","2","3","5","6","7","1","4","8"},
				{"張瑞觀","1","3","4","6","7","2","5","8"}};		
		model1 = new DefaultTableModel(s1,columns1){
			private static final long serialVersionUID = 1L;

			//使用者不可編輯表格
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		table_1 = new JTable(model1);
		table_1.setRowSelectionAllowed(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFillsViewportHeight(true);
		JScrollPane jsp_1 = new JScrollPane(table_1);
		jsp_1.setBounds(6, 6, 497, 293);
		jsp_1.setViewportView(table_1);
		panel_1.add(jsp_1);

		//btn2
		button_2 = new JButton("修改");
		button_2.setBounds(210, 304, 85, 30);
		panel_1.add(button_2);

		
		
		/*
		 *panel_2
		 */
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(" 課    表  ", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_6 = new JLabel("時段");
		label_6.setBounds(6, 6, 26, 42);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("一上午");
		label_7.setBounds(62, 6, 39, 42);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("一下午");
		label_8.setBounds(118, 6, 39, 42);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("二上午");
		label_9.setBounds(174, 6, 39, 42);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("二下午");
		label_10.setBounds(230, 6, 39, 42);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("三上午");
		label_11.setBounds(286, 6, 39, 42);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("三下午");
		label_12.setBounds(342, 6, 39, 42);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("四上午");
		label_13.setBounds(398, 6, 39, 42);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("四下午");
		label_14.setBounds(454, 6, 39, 42);
		panel_2.add(label_14);
		
		JLabel label = new JLabel("大一");
		label.setBounds(6, 35, 26, 42);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("大二");
		label_1.setBounds(6, 68, 26, 42);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("大三");
		label_2.setBounds(6, 101, 26, 42);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("大四");
		label_3.setBounds(6, 134, 26, 42);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("管理一");
		label_4.setBounds(6, 167, 39, 42);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("工程一");
		label_5.setBounds(6, 200, 39, 42);
		panel_2.add(label_5);
		
		JLabel label_15 = new JLabel("管理二");
		label_15.setBounds(6, 233, 39, 42);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("工程二");
		label_16.setBounds(6, 265, 39, 42);
		panel_2.add(label_16);
		
		panel_3 = new JPanel();
		panel_3.setBounds(54, 45, 448, 256);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridBagLayout());
		
		button_3 = new JButton("排課");
		button_3.setBounds(190, 306, 117, 29);
		panel_2.add(button_3);
		
		/*
		 *button add action_listener
		 */		
		lis = new Listener(this);
		button.addActionListener(lis);
		button_1.addActionListener(lis);
		button_2.addActionListener(lis);
		button_3.addActionListener(lis);
	}
}
