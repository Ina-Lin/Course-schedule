package version9;

import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import org.cs3.prolog.connector.Connector;
import org.cs3.prolog.connector.common.QueryUtils;
import org.cs3.prolog.connector.process.PrologProcess;
import org.cs3.prolog.connector.process.PrologProcessException;

public class Prolog {

	static PrologProcess process;
	
	Prolog() {
		try {
			process = Connector.newPrologProcess();
			String consultQuery = QueryUtils.bT("reconsult", "'/Users/apple/Documents/workspace/Prolog/src/timetable.pl'");
	        try {
				process.queryOnce(consultQuery);
			} catch (PrologProcessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"連結失敗");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"建立失敗");
		}
	}
	
	void addFact(String fact,String a, String b) throws PrologProcessException {
		//asserting facts : period(teacher,time)
		process.queryOnce("asserta("+fact+"("+a+","+b+"))");	 
	}

	void addFact(String fact,String a, String b, String c) throws PrologProcessException {
		//asserting facts : class(teacher,course,必修)
		process.queryOnce("assert("+fact+"("+a+","+b+","+c+"))");	 
	}

	//刪除第一個符合該條件的fact
	
	Map<String, Object> timeTable(DataProcess DP,MainGui mGui) {										
		Map<String, Object> result = null;
		int count = 1;
		try {
			String query = QueryUtils.bT("timeTable", "S");
			result = process.queryOnce(query);
			int time = 6; //老師排課志願序
			int t = 10; //老師順序
			//當以目前的老師可授課時間排課找不到符合的結果
			while((result == null)||(result.equals(null))){
				//當已經排到優先度為0之老師
				if(t==0){
					t = 10; //由優先度為10之老師開始
					time++; //並將排課志願往後
				}
				System.out.println("t＝"+t);
				System.out.println("time＝"+time);
				String teacher = DP.Teacher2Num.get(mGui.table_1.getValueAt(t, 0).toString());
				addFact("period", teacher, DP.time_arr[t][time]);
				result = process.queryOnce(query);
				t--; //老師優先度往前
				count++;
				
				System.out.println("執行次數＝"+count);
			}
			System.out.println("執行次數＝"+count);
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"失敗");
		}
		return result;
	}
}