package wordHandle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dictionary.Dictionary;
import wordHandle.WordReader;
import wordHandle.TextSplit;
import wordHandle.SymptomHandle;
public class Mytest1 {
 
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String result="慢性阻塞性肺疾病：";
		String symptoms="";
		String filePath="C:\\Users\\Administrator\\Desktop\\慢阻肺临床表现.docx";
		String text=new WordReader().getText(filePath);
		//System.out.println(text);
		String [] str=new TextSplit().getString(text);
		File file = new File("C:\\Users\\Administrator\\Workspaces\\MyEclipse Professional 2014\\books2structure\\symptom_dictionary.txt");//症候字典文件
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String symptomDic = null;
			while((symptomDic = br.readLine())!=null){//使用readLine方法，一次读一行
				symptoms=symptoms+symptomDic;
			}
			br.close();;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("常见症状："+symptoms);
		//获取getSymptom(text,symptoms);
		new SymptomHandle().getSymptom(str, symptoms);
		

		
		//打印结果到result.txt中
		/*String resultFilePath = "C:\\Users\\Administrator\\Desktop\\result.txt";
		new Mytest1().WriteStringToTxt(resultFilePath,str);
		for(int i=0;i<str.length;i++){
			
		}*/
	}
	 public void WriteStringToTxt(String filePath,String[] strs) {
	        try {
	        	FileWriter fw = new FileWriter(filePath);
	            for(int i=0;i<strs.length;i++){
	            	fw.write(strs[i]+"\r\n"); 
	            }
	            fw.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("ds");
	        }
	    }

}
