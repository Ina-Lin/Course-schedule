package version9;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.cs3.prolog.connector.process.PrologProcessException;

public class Listener implements ActionListener{

	MainGui mGui = null;
	TableProcess  TP = null;
	DataProcess DP = null;
		
	public Listener(MainGui mGui){
		this.mGui = mGui;
		TP = new TableProcess(mGui);
		DP = new DataProcess(mGui);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//點選新增按鈕開啟設定視窗
		if(e.getSource() == mGui.button){
			mGui.cGui.setVisible(true);
		}
		
		//點選刪除按鈕
		if(e.getSource() == mGui.button_1){
			int row = mGui.table.getSelectedRow();
			if(row >= 0){
				TP.delectData(row);	
			}
		}
		
		//點選修改按鈕，並將選取之授課教室顯示於table
		if(e.getSource() == mGui.button_2){
			int Row = mGui.table_1.getSelectedRow(); //取得選取列
			if(Row >= 0){
				mGui.tGui.textField.setText(mGui.table_1.getValueAt(Row,0).toString());
				mGui.tGui.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "請選擇修改選項");
			}
		}
		
		//點選courseGui-新增按鈕，將新增之課程資料顯示於table，且reset表單
		if(e.getSource() == mGui.cGui.button){
			String year = mGui.cGui.comboBox.getSelectedItem().toString();
			String course = mGui.cGui.textField.getText();
			String teacher = mGui.cGui.comboBox_1.getSelectedItem().toString();
			String obligatory = "";
			if(mGui.cGui.checkBox.isSelected()){
				obligatory = "是";
			}
			else{
				obligatory = "否";
			}
			if(course.replaceAll(" ", "").equals("")){
				JOptionPane.showMessageDialog(null, "請輸入課程名稱");
			}
			else{
				TP.addData(year, course, teacher,obligatory);
				JOptionPane.showMessageDialog(null, "新增成功");
			}
			mGui.cGui.textField.setText("");
			mGui.cGui.checkBox.setSelected(false);
		}
		
		//點選teacherGui-確定按鈕，修改GUI內容，清空表單並關閉
		if(e.getSource() == mGui.tGui.button){
				if(checkTime(5,mGui.tGui.objectList)){
				int[] arr = timeSet(mGui.tGui.objectList);
				if(arr != null){
					int Row = mGui.table_1.getSelectedRow();
					TP.modifyData(Row,arr);
					JOptionPane.showMessageDialog(null, "修改成功");
					mGui.tGui.setVisible(false);
					teacherGuiReset(mGui.tGui.objectList);
				}
				else{
					JOptionPane.showMessageDialog(null, "時段重複");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "請選擇五個可授課時段");
			}	
		}
		
		if(e.getSource() == mGui.button_3){
			long start = System.currentTimeMillis();
			try {
				boolean pass = teacherTimeIsFull();
				if(pass){
					mGui.panel_3.removeAll();
					mGui.panel_3.validate();
					DP.buildPL();
					DP.courseEncode();
					DP.teacherTime();
					DP.addTime();
					show(DP.schedual());
					long end = System.currentTimeMillis();;
					System.out.println(end-start);
				}
				else{
					JOptionPane.showMessageDialog(null, "老師授課時段不可為空");
				}
			} catch (PrologProcessException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	//將修改授課時間之介面恢復預設											
	void teacherGuiReset(ArrayList<Object> arr){
		for(int i = 0;i < arr.size();i++){	//size=11
			if(arr.get(i) instanceof JCheckBox){
				((JCheckBox) arr.get(i)).setSelected(false);
			}
			else{
				((JComboBox<Object>) arr.get(i)).setSelectedIndex(0);
			}
		}
	}
	
	//檢查老師選擇授課時間是否足夠
	boolean checkTime(int time,ArrayList<Object> arr){
		int t = 0; //時段選擇之數量
		for(int i = 0;i < 8;i++){
			if(((JCheckBox)arr.get(i)).isSelected()){
				t++;
			}
		}
		if( t == time){
			return true;
		}
		return false;
	}
	
	//判斷選擇授課時段是否有重複														
	int[] timeSet(ArrayList<Object> arr){
		Set<Integer> period = new HashSet<Integer>();
		int[] time = new int [8]; //存放排課時間
		int t = 0; //計算第t個時段
		for(int i = 0;i < arr.size();i++){	//size=11
			if(arr.get(i) instanceof JCheckBox){
				if(((JCheckBox) arr.get(i)).isSelected()){
					time[t] = i+1;
					period.add(i);
					t++;
				}
			}
			else{
				@SuppressWarnings("unchecked")
				int d = ((JComboBox<Object>) arr.get(i)).getSelectedIndex();
				time[t] = d+1;
				period.add(d);
				t++;
			}
		}
		//（利用Set不重複之特色）若時段有重複，兩者大小不同
		if(period.size() == time.length){
			return time;
		}
		return null;
	}

	//判斷授課時間有無缺少
	boolean teacherTimeIsFull(){
		for(int i = 0;i<mGui.model1.getRowCount();i++){
			for(int j = 0;j<mGui.model1.getColumnCount();j++){
				if(mGui.model1.getValueAt(i, j).equals("")){
					return false;
				}
			}
		}
		return true;
	}
	
	//將老師授課時間從prolog fact中移除						
	

	@SuppressWarnings("rawtypes")
	void show(Map<String, Object> map){													
		if((!map.equals(null))|(map != null)){
			Vector vec = (Vector) map.get("S");
			int index = 0;
			for(int i = 0;i<16;i+=2){
				for(int j =0;j<8;j++){
					if(index<vec.size()){
						Vector v = (Vector) vec.get(index);
						GridBagConstraints c = new GridBagConstraints();
						c.gridy = i;
						c.gridx = j;
						c.gridwidth = 1;
						c.gridheight = 1;
						c.weightx = 39;
						c.weighty = 28;
						c.fill = GridBagConstraints.BOTH;
						String course = DP.Num2Course.get(v.get(1).toString());
					//	System.out.println("course : "+j+" "+course);
						mGui.panel_3.add(new JLabel(course,SwingConstants.CENTER),c);
						mGui.panel_3.validate();//動態新增元件直接顯示
						
						GridBagConstraints c1 = new GridBagConstraints();
						c1.gridy = i+1;
						c1.gridx = j;
						c1.gridwidth = 1;
						c1.gridheight = 1;
		        		c.weightx = 39;
		        		c.weighty = 28;
						c1.fill = GridBagConstraints.BOTH;
						String teacher = DP.Num2Teacher.get(v.get(0).toString());
						mGui.panel_3.add(new JLabel(teacher,SwingConstants.CENTER),c1);
						mGui.panel_3.validate(); //動態新增元件直接顯示
						index++;
					}
				}
			}	
		}
	}
}




/*
 * 得到选中的行
 * 
 * 得到table中有几列
 * int cell = table.getModel().getColumnCount();
 * 根据你想要的行和列去取值。方法如下：
 * 获取自己想要的列,这里我默认写0列注意填写的值不能大于cell
 * int column = 0;
 * Object selectedValue = table.getModel().getValueAt(row,column);
 * selectedValue就是你想要的值
 */









