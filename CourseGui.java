package version9;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class CourseGui extends JFrame{

	JTextField textField;
	JComboBox<Object> comboBox;
	JComboBox<Object> comboBox_1;
	JCheckBox checkBox;
	JButton button;
	Listener lis;
	MainGui mGui = null;

	/**
	 * Create the application.
	 */
	public CourseGui(MainGui mGui) {
		initCsGui(mGui);
		initialize();
	}
	
	public void initCsGui(MainGui mGui){
		this.mGui = mGui;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 334, 267);
		getContentPane().setLayout(null);
		setVisible(false); //讓視窗顯示
		
		comboBox = new JComboBox<Object>();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"大一", "大二", "大三", "大四", "管理一", "工程一", "管理二", "工程二"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(141, 34, 95, 27);
		getContentPane().add(comboBox);
		
		//禮拜五課忽略 服務學習以及民主法治 視為同堂
		comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"鄭伯壎", "林哲正", "孫培真", "楊中皇", "葉道明", "李文廷", "何淑君", "余遠澤", "郭家旭", "陳立偉", "張瑞觀", "黃碧玉", "林振欽", "藍恩明", "李文環", "黃志呈/王蘭華", "待聘（通識）", "待聘（體育）"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(141, 118, 141, 27);
		getContentPane().add(comboBox_1);
		
		JLabel label_1 = new JLabel("課程名稱");
		label_1.setBounds(68, 80, 61, 16);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("授課老師");
		label_2.setBounds(68, 122, 61, 16);
		getContentPane().add(label_2);

		JLabel label = new JLabel("年級");
		label.setBounds(68, 38, 61, 16);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(141, 75, 141, 28);
		textField.setColumns(10);
		getContentPane().add(textField);
	
		button = new JButton("新增");
		button.setBounds(104, 200, 117, 29);
		getContentPane().add(button);
		
		checkBox = new JCheckBox("必修");
		checkBox.setBounds(130, 163, 66, 23);
		getContentPane().add(checkBox);
		
		lis = new Listener(mGui);
		button.addActionListener(lis);
	}
}
