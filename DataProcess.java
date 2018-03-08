package version9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.cs3.prolog.connector.process.PrologProcessException;

public class DataProcess {
	private MainGui mGui;
	Map<String,String> Teacher2Num;
	Map<String,String> Num2Course;	
	Map<String,String> Num2Teacher;
	Map<Integer,List<String>> TeacherTime; 
	String[][] time_arr;
	Prolog PL; 
	BuildModule BM;
	
	DataProcess(MainGui mGui){
		this.mGui = mGui;
		inti();
	}
	
	void inti(){
		Num2Course = new HashMap<String, String>();
		Teacher2Num = new HashMap<String,String>();
		Num2Teacher = new HashMap<String,String>();
		TeacherTime = new HashMap<Integer,List<String>>();
		
		TeacherTime.put(12, new ArrayList<>(Arrays.asList("5")));
		TeacherTime.put(13, new ArrayList<>(Arrays.asList("4")));
		TeacherTime.put(14, new ArrayList<>(Arrays.asList("2")));
		TeacherTime.put(15, new ArrayList<>(Arrays.asList("6")));
		TeacherTime.put(16, new ArrayList<>(Arrays.asList("8")));
		TeacherTime.put(17, new ArrayList<>(Arrays.asList("2","4","8")));
		TeacherTime.put(18, new ArrayList<>(Arrays.asList("2","4","8")));
		TeacherTime.put(19, new ArrayList<>(Arrays.asList("4","8")));
		TeacherTime.put(20, new ArrayList<>(Arrays.asList("4","8")));
		TeacherTime.put(21, new ArrayList<>(Arrays.asList("4","8")));
		
		Num2Teacher.put("1","鄭伯壎");
		Num2Teacher.put("2","林哲正");
		Num2Teacher.put("3","孫培真");
		Num2Teacher.put("4","楊中皇");
		Num2Teacher.put("5","葉道明");
		Num2Teacher.put("6","李文廷");
		Num2Teacher.put("7","何淑君");
		Num2Teacher.put("8","余遠澤");
		Num2Teacher.put("9","郭家旭");
		Num2Teacher.put("10","陳立偉");
		Num2Teacher.put("11","張瑞觀");
		Num2Teacher.put("12","黃碧玉");
		Num2Teacher.put("13","林振欽");
		Num2Teacher.put("14","藍恩明");
		Num2Teacher.put("15","李文環");
		Num2Teacher.put("16","黃志呈/王蘭華");
		Num2Teacher.put("17","待聘(體育)");
		Num2Teacher.put("18","待聘(體育)");
		Num2Teacher.put("19","待聘(通識)");
		Num2Teacher.put("20","待聘(通識)");
		Num2Teacher.put("21","待聘(通識)");
		Num2Teacher.put("22","");
		Num2Teacher.put("23","");
		Num2Teacher.put("24","");
		Num2Teacher.put("25","");
		Num2Teacher.put("26","");
		Num2Teacher.put("27","");
		Num2Teacher.put("28","");
		Num2Teacher.put("29","");
		
		Teacher2Num.put("鄭伯壎","1");					
		Teacher2Num.put("林哲正","2");
		Teacher2Num.put("孫培真","3");
		Teacher2Num.put("楊中皇","4");
		Teacher2Num.put("葉道明","5");
		Teacher2Num.put("李文廷","6");
		Teacher2Num.put("何淑君","7");
		Teacher2Num.put("余遠澤","8");
		Teacher2Num.put("郭家旭","9");
		Teacher2Num.put("陳立偉","10");
		Teacher2Num.put("張瑞觀","11");
		Teacher2Num.put("黃碧玉","12");
		Teacher2Num.put("林振欽","13");
		Teacher2Num.put("藍恩明","14");
		Teacher2Num.put("李文環","15");
		Teacher2Num.put("黃志呈/王蘭華","16");
		
	}

	Map<String, Object> schedual(){
		Map<String, Object> result = PL.timeTable(this,mGui);
		return result;
	}
	
	//將老師可授課時間存於陣列中
	void teacherTime() throws PrologProcessException{										
		time_arr = new String[mGui.model1.getRowCount()][mGui.model1.getColumnCount()];
		for(int i = 0;i<time_arr.length;i++){
			for(int j = 1; j<time_arr[i].length;j++){
				time_arr[i][j] = mGui.table_1.getValueAt(i, j).toString();
			}
		}
	}
	
	void buildPL() throws IOException{
		BM = new BuildModule();
		double[][] arr = new double[8][4];
		ArrayList<HashSet<String>> Set = new ArrayList<HashSet<String>>();
		int Y1 = 0,Y2 = 0,Y3 = 0,Y4 = 0,Y5 = 0,Y6 = 0,Y7 = 0,Y8 = 0;
		for(int i=0;i<8;i++){
			Set.add(new HashSet<String>());
		}
		//計算可排課時間
		for(int i = 0;i<mGui.model.getRowCount();i++){	
			String year = mGui.table.getValueAt(i, 0).toString(); //取得年級
			int teacher = getTeacher(i); //取得老師編號
			switch(year){
			case "大一":
				Y1++;
				if(teacher >= 12){
			//		System.out.println(TeacherTime.get(teacher).size());
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(0).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(0).add(mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "大二":
				Y2++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(1).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(1).add( mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "大三":
				Y3++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(2).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(2).add( mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "大四":
				Y4++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(3).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(3).add( mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "管理一":
				Y5++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(4).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(4).add(mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "工程一":
				Y6++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(5).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(5).add(mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "管理二":
				Y7++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(teacher)){
						Set.get(6).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(6).add(mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			case "工程二":
				Y8++;
				if(teacher > 11){
					for (String  Num : TeacherTime.get(i)){
						Set.get(7).add(Num);
					}
				}
				else{
					for(int j=1;j<=5;j++){
						Set.get(7).add(mGui.table_1.getValueAt(teacher-1, j).toString());
					}
				}
				break;
			}
		}
		int[] t = {Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8};
		for(int i=0;i<8;i++){
			arr[i][0] = Set.get(i).size(); //有幾個可授課時段
			arr[i][1] = t[i]; //各年級有幾門課
			arr[i][2] = (double)arr[i][0]/(double)arr[i][1];
			arr[i][3] = i+1;
		}
		Sort(arr);
		BM.build(arr);
		PL = new Prolog();
	}
	
	//先加入前五志願 若衝堂 從最後一名老師開始添加候選時段
	void addTime() throws PrologProcessException{
		for(int i = (time_arr.length-1);i>=0;i--){
			//取得老師編碼
			String teacher = Teacher2Num.get(mGui.table_1.getValueAt(i, 0).toString());
			for(int j = 1; j<(time_arr[i].length)-3;j++){
				PL.addFact("period", teacher, time_arr[i][j]);
				//將老師前五志願時間加入prolog fact
			}
		}
	}
	
	
	//取得老師編碼
	int getTeacher(int i){													
		String teacher = mGui.table.getValueAt(i, 2).toString();
		String year = mGui.table.getValueAt(i,0).toString();
		int t;
		if(teacher.equals("待聘（體育）")){
			if(year.equals("大一")){
				t = 17;
			}
			else{
				t = 18;
			}
		}
		else if(teacher.equals("待聘（通識）")){
			if(year.equals("大一")){
				t = 19;
			}
			else if(year.equals("大二")){
				t = 20;
			}
			else{
				t = 21;
			}
		}
		else{
			t = Integer.parseInt(Teacher2Num.get(teacher));
		}
		return t;
	}
	
	
	void courseEncode() throws PrologProcessException{							
		int X = 0,Y = 0;
		int Y1 = -1,Y2 = -1,Y3 = -1,Y4 = -1,Y5 = -1,Y6 = -1,Y7 = -1,Y8 = -1;
		//Y1~Y8：計算各年級課程數
		int[][][] arr = new int[8][8][3];
		
		for(int i = 0;i<mGui.model.getRowCount();i++){	
			String year = mGui.table.getValueAt(i, 0).toString();
			String course = mGui.table.getValueAt(i, 1).toString();
			String obligatory = mGui.table.getValueAt(i, 3).toString();
			int teacher = getTeacher(i);
			int code = 0;

			switch(year){
			case "大一":
				X = 0;
				Y1++;
				Y = Y1;
				break;
			case "大二":
				X = 1;
				Y2++;
				Y = Y2;
				break;
			case "大三":
				X = 2;
				Y3++;
				Y = Y3;
				break;
			case "大四":
				X = 3;
				Y4++;
				Y = Y4;
				break;
			case "管理一":
				X = 4;
				Y5++;
				Y = Y5;
				break;
			case "工程一":
				X = 5;
				Y6++;
				Y = Y6;
				break;
			case "管理二":
				X = 6;
				Y7++;
				Y = Y7;
				break;
			case "工程二":
				X = 7;
				Y8++;
				Y = Y8;
				break;
			}
			
			//完成課程編碼並放入map
			code = (X+1)*100+Y+1;
			String courseCode = String.valueOf(code);
			Num2Course.put(courseCode, course);
			
			//判斷是否為必修課
			if(obligatory.equals("是")){
				obligatory = "1";
			}
			else{
				obligatory = "0";
			}
			
			arr[X][Y][0] = teacher;
			arr[X][Y][1] = code;
			arr[X][Y][2] = Integer.parseInt(obligatory);
		}
		
		int[] t = {Y1,Y2,Y3,Y4,Y5,Y6,Y7,Y8};
		list(t,arr);
		Sort(arr);
		sort(arr);
		
		//將課程資訊加入prolog fact
		for(int i = 0; i <arr.length; i++){
			for(int j = 0;j<arr[i].length;j++){
				PL.addFact("class", String.valueOf(arr[i][j][0]), String.valueOf(arr[i][j][1]),String.valueOf(arr[i][j][2]));
			}
		}	
	}
	
	//處理課程未滿堂
	private void list(int[] t,int[][][] arr){								
		for(int i = 0;i<t.length;i++){
			//如果課堂未滿（堂數少於8)
			if(t[i] < 7){
				//將缺少之課堂數編碼map
				for(int j = t[i]+1;j<8;j++){
					arr[i][j][0] = i + 22;
					arr[i][j][1] = ((i+1)*100) + j+1;
					arr[i][j][2] = 0;
					Num2Course.put(String.valueOf(arr[i][j][1]), "");
				}
			}
		}
	}
	
	//按照排課成功比排序
	private void Sort(double[][] array){
		for (int i = array.length - 1; i > 0; --i){
			boolean swapped = false;
			for (int j = 0; j < i; ++j)
				if (array[j][2] > array[j + 1][2])
				{
					Swap(array, j, j + 1);
					swapped = true;
				}
			if(!swapped)
				break;
		}
	}
	
	//1.先將課程依照授課老師排序																				
	private void Sort(int[][][] array){
		for(int k = 0;k < array.length;k++){
			for (int i = array[k].length - 1; i > 0; --i){
				for (int j = 0; j < i; ++j){
					if (array[k][j][0] > array[k][j + 1][0]){
						Swap(array,k, j ,1);
					}
				}
            }
        }
    }
 
	//2.當老師相同時，將必修課列為優先
	private void sort(int[][][] array){
		for(int k = 0; k < array.length;k++){
			for (int i = 0; i < array[k].length - 1; i++){ 
				if ((array[k][i][0] == array[k][i + 1][0])&&(array[k][i][2] < array[k][i + 1][2])){
					Swap(array,k, i ,1);
				}
			}
        }
	}
	
	
	//交換順序-排課成功比(建立PL)
	private void Swap(double[][] array, int indexA, int indexB){
		double[] tmp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = tmp;
	}
	
	//交換順序-
    private void Swap(int[][][] array,int k, int i, int index){
        int[] tmp = array[k][i];
        array[k][i] = array[k][i+1];
        array[k][i+1] = tmp;
    }
}
