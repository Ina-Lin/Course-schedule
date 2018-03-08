package version9;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TeacherGui extends JFrame{

	JTextField textField;
	JComboBox<Object> comboBox;
	JComboBox<Object> comboBox_1;
	JComboBox<Object> comboBox_2;
	JButton button;
	JCheckBox checkBox;
	JCheckBox checkBox_1;
	JCheckBox checkBox_2;
	JCheckBox checkBox_3;
	JCheckBox checkBox_4;
	JCheckBox checkBox_5;
	JCheckBox checkBox_6;
	JCheckBox checkBox_7;
	Listener lis;
	MainGui mGui = null;
	ArrayList<Object> objectList = new ArrayList<Object>();
	
	public TeacherGui(MainGui mGui) {
		initTcGui(mGui);
		initialize();
	}

	public void initTcGui(MainGui mGui){
		this.mGui = mGui;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 326, 314);
		getContentPane().setLayout(null);
		setVisible(false); //讓視窗顯示
		
		JLabel label = new JLabel("授課老師");
		label.setBounds(58, 27, 61, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("排課時間");
		label_1.setBounds(58, 62, 61, 16);
		getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(131, 62, 146, 84);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("下");
		label_3.setBounds(16, 58, 13, 16);
		panel.add(label_3);
		
		JLabel label_2 = new JLabel("一   二   三   四");
		label_2.setBounds(38, 6, 95, 16);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("上");
		label_4.setBounds(16, 30, 13, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("候補時間1");
		label_5.setBounds(58, 157, 61, 16);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("候補時間2");
		label_6.setBounds(58, 185, 61, 16);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("候補時間3");
		label_7.setBounds(58, 213, 61, 16);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("(勾選五個時段)");
		label_8.setBounds(40, 80, 86, 16);
		getContentPane().add(label_8);
		
		checkBox = new JCheckBox("");
		checkBox.setBounds(31, 26, 28, 23);
		panel.add(checkBox);
		
		checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(31, 54, 28, 23);
		panel.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(56, 26, 28, 23);
		panel.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(56, 54, 28, 23);
		panel.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(81, 26, 28, 23);
		panel.add(checkBox_4);
		
		checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(81, 54, 28, 23);
		panel.add(checkBox_5);
		
		checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(105, 26, 28, 23);
		panel.add(checkBox_6);
		
		checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(105, 54, 28, 23);
		panel.add(checkBox_7);
		
		textField = new JTextField("");
		textField.setEditable(false);
		textField.setBounds(129, 21, 134, 28);
		textField.setColumns(10);
		getContentPane().add(textField);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"一上午", "一下午", "二上午", "二下午", "三上午", "三下午", "四上午", "四下午"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(131, 153, 95, 27);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"一上午", "一下午", "二上午", "二下午", "三上午", "三下午", "四上午", "四下午"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(131, 181, 95, 27);
		getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox<Object>();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"一上午", "一下午", "二上午", "二下午", "三上午", "三下午", "四上午", "四下午"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(131, 209, 95, 27);
		getContentPane().add(comboBox_2);
		
		button = new JButton("確定");
		button.setBounds(109, 246, 117, 29);
		getContentPane().add(button);
		
		objectList.add(checkBox);
		objectList.add(checkBox_1);
		objectList.add(checkBox_2);
		objectList.add(checkBox_3);
		objectList.add(checkBox_4);
		objectList.add(checkBox_5);
		objectList.add(checkBox_6);
		objectList.add(checkBox_7);
		
		objectList.add(comboBox);
		objectList.add(comboBox_1);
		objectList.add(comboBox_2);
		
		lis = new Listener(mGui);
		button.addActionListener(lis);
	}
}
