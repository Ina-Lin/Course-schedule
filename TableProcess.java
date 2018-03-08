package version9;

public class TableProcess {
	
	MainGui gui;
	
	public TableProcess(MainGui gui){
		this.gui = gui;
	}
	
	void addData(String year,String course,String teacher, String obligatory){
		gui.model.addRow(new Object[]{year,course,teacher,obligatory});
	}
	//新增課程資訊（年級、課程名稱、授課教師、是否為必修）於表格中
	
	void delectData(int row){
		gui.model.removeRow(row);
	}
	//刪除表格中某筆資料（課程資訊）
	
	void modifyData(int row,int[] arr){
		for(int i = 0;i<arr.length;i++){
			gui.table_1.setValueAt(""+arr[i], row, i+1);
		}
	}
	//修改授課時間
	//arr為存放可授課時間之陣列
}
