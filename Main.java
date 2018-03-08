package version9;

import java.io.IOException;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MainGui mGui=new MainGui();//建立gui(CalculatorGui)物件
		mGui.setSize(542, 421); //設定大小
		mGui.setVisible(true); //讓視窗顯示
		mGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //關閉視窗即結束城市
		mGui.setTitle("AI course scheduling"); //設定視窗名
	}
}

//各年級課程數不可超過八個
//週五之課程不可輸入
