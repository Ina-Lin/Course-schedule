package version9;

import java.io.FileWriter;
import java.io.IOException;

public class BuildModule {
	FileWriter fw;
	
	BuildModule() throws IOException{
		fw = new FileWriter("/Users/apple/Documents/workspace/Prolog/src/timetable.pl");
		fw.write(":-use_module(library(clpfd),except([sum/3])).\n:-dynamic(class/3).\n:-dynamic(period/2).\n\n");
		
		fw.write("period(12,5).\nperiod(13,4).\nperiod(14,2).\nperiod(15,6).\nperiod(16,8).\n"
				+ "period(17,2).\nperiod(17,4).\nperiod(17,8).\nperiod(18,2).\nperiod(18,4).\nperiod(18,8).\n"
				+ "period(19,4).\nperiod(19,8).\nperiod(20,4).\nperiod(20,8).\nperiod(21,4).\nperiod(21,8).\n\n");
				
		fw.write("period(22,1).\nperiod(22,2).\nperiod(22,3).\nperiod(22,4).\nperiod(22,5).\nperiod(22,6).\nperiod(22,7).\nperiod(22,8).\n"
				+ "period(23,1).\nperiod(23,2).\nperiod(23,3).\nperiod(23,4).\nperiod(23,5).\nperiod(23,6).\nperiod(23,7).\nperiod(23,8).\n"
				+ "period(24,1).\nperiod(24,2).\nperiod(24,3).\nperiod(24,4).\nperiod(24,5).\nperiod(24,6).\nperiod(24,7).\nperiod(24,8).\n"
				+ "period(25,1).\nperiod(25,2).\nperiod(25,3).\nperiod(25,4).\nperiod(25,5).\nperiod(25,6).\nperiod(25,7).\nperiod(25,8).\n"
				+ "period(26,1).\nperiod(26,2).\nperiod(26,3).\nperiod(26,4).\nperiod(26,5).\nperiod(26,6).\nperiod(26,7).\nperiod(26,8).\n"
				+ "period(27,1).\nperiod(27,2).\nperiod(27,3).\nperiod(27,4).\nperiod(27,5).\nperiod(27,6).\nperiod(27,7).\nperiod(27,8).\n"
				+ "period(28,1).\nperiod(28,2).\nperiod(28,3).\nperiod(28,4).\nperiod(28,5).\nperiod(28,6).\nperiod(28,7).\nperiod(28,8).\n"
				+ "period(29,1).\nperiod(29,2).\nperiod(29,3).\nperiod(29,4).\nperiod(29,5).\nperiod(29,6).\nperiod(29,7).\nperiod(29,8).\n\n");
		
		fw.write("isTeacher([],[]).\n");
		fw.write("isTeacher([Head|Tail],[H|T]):-\nnth1(1,Head,X),\nnth1(2,Head,Y),\nperiod(X,H),\nclass(X,Y,_),\nisTeacher(Tail,T).\n\n");
		fw.write("timeTable(Grade):-\n"
				+ "Grade = [[S110,S111],[S120,S121],[S130,S131],[S140,S141],[S150,S151],[S160,S161],[S170,S171],[S180,S181],\n"
				+ "[S210,S211],[S220,S221],[S230,S231],[S240,S241],[S250,S251],[S260,S261],[S270,S271],[S280,S281],\n"
				+ "[S310,S311],[S320,S321],[S330,S331],[S340,S341],[S350,S351],[S360,S361],[S370,S371],[S380,S381],\n"
				+ "[S410,S411],[S420,S421],[S430,S431],[S440,S441],[S450,S451],[S460,S461],[S470,S471],[S480,S481],\n"
				+ "[S510,S511],[S520,S521],[S530,S531],[S540,S541],[S550,S551],[S560,S561],[S570,S571],[S580,S581],\n"
				+ "[S610,S611],[S620,S621],[S630,S631],[S640,S641],[S650,S651],[S660,S661],[S670,S671],[S680,S681],\n"
				+ "[S710,S711],[S720,S721],[S730,S731],[S740,S741],[S750,S751],[S760,S761],[S770,S771],[S780,S781],\n"
				+ "[S810,S811],[S820,S821],[S830,S831],[S840,S841],[S850,S851],[S860,S861],[S870,S871],[S880,S881]],\n\n"
				+ "Grade1 = [[S150,S151],[S160,S161],[S130,S131],[S140,S141],[S120,S121],[S110,S111],[S170,S171],[S180,S181]],\n"
				+ "Grade2 = [[S250,S251],[S260,S261],[S230,S231],[S240,S241],[S220,S221],[S210,S211],[S270,S271],[S280,S281]],\n"
				+ "Grade3 = [[S350,S351],[S360,S361],[S330,S331],[S340,S341],[S320,S321],[S310,S311],[S370,S371],[S380,S381]],\n"
				+ "Grade4 = [[S450,S451],[S460,S461],[S430,S431],[S440,S441],[S420,S421],[S410,S411],[S470,S471],[S480,S481]],\n"
				+ "Grade5 = [[S550,S551],[S560,S561],[S530,S531],[S540,S541],[S520,S521],[S510,S511],[S570,S571],[S580,S581]],\n"
				+ "Grade6 = [[S650,S651],[S660,S661],[S630,S631],[S640,S641],[S620,S621],[S610,S611],[S670,S671],[S680,S681]],\n"
				+ "Grade7 = [[S750,S751],[S760,S761],[S730,S731],[S740,S741],[S720,S721],[S710,S711],[S770,S771],[S780,S781]],\n"
				+ "Grade8 = [[S850,S851],[S860,S861],[S830,S831],[S840,S841],[S820,S821],[S810,S811],[S870,S871],[S880,S881]],\n\n"
				+ "Course1 = [S111,S121,S131,S141,S151,S161,S171,S181],\n"
				+ "Course2 = [S211,S221,S231,S241,S251,S261,S271,S281],\n"
				+ "Course3 = [S311,S321,S331,S341,S351,S361,S371,S381],\n"
				+ "Course4 = [S411,S421,S431,S441,S451,S461,S471,S481],\n"
				+ "Course5 = [S511,S521,S531,S541,S551,S561,S571,S581],\n"
				+ "Course6 = [S611,S621,S631,S641,S651,S661,S671,S681],\n"
				+ "Course7 = [S711,S721,S731,S741,S751,S761,S771,S781],\n"
				+ "Course8 = [S811,S821,S831,S841,S851,S861,S871,S881],\n\n"
				+ "Period1 = [S110,S210,S310,S410,S510,S610,S710,S810],\n"
				+ "Period2 = [S120,S220,S320,S420,S520,S620,S720,S820],\n"
				+ "Period3 = [S130,S230,S330,S430,S530,S630,S730,S830],\n"
				+ "Period4 = [S140,S240,S340,S440,S540,S640,S740,S840],\n"
				+ "Period5 = [S150,S250,S350,S450,S550,S650,S750,S850],\n"
				+ "Period6 = [S160,S260,S360,S460,S560,S660,S760,S860],\n"
				+ "Period7 = [S170,S270,S370,S470,S570,S670,S770,S870],\n"
				+ "Period8 = [S180,S280,S380,S480,S580,S680,S780,S880],\n\n"
				+ "TimePriority = [5,6,3,4,2,1,7,8],\n\n"
				+ "\nCourse1 ins 101..108,\nall_different(Course1),\n"
				+ "Course2 ins 201..208,\nall_different(Course2),\n"
				+ "Course3 ins 301..308,\nall_different(Course3),\n"
				+ "Course4 ins 401..408,\nall_different(Course4),\n"
				+ "Course5 ins 501..508,\nall_different(Course5),\n"
				+ "Course6 ins 601..608,\nall_different(Course6),\n"
				+ "Course7 ins 701..708,\nall_different(Course7),\n"
				+ "Course8 ins 801..808,\nall_different(Course8),\n");
	}	
	void build(double[][] arr) throws IOException{ 
		for(int i=0;i<arr.length;i++){
			fw.write("isTeacher(Grade"+(int)arr[i][3]+",TimePriority),\n"
					+ "all_different(Period8),\n"
					+ "all_different(Period7),\n"
					+ "all_different(Period6),\n"
					+ "all_different(Period5),\n"
					+ "all_different(Period4),\n"
					+ "all_different(Period3),\n"
					+ "all_different(Period2),\n"
					+ "all_different(Period1),\n\n");
		}
		fw.write("!.\n");
		fw.close();
	}
}
