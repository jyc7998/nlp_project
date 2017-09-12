package wordHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import wordHandle.PropertyHandle;

public class SymptomHandle {
	public void getSymptom(String[] str,String symptoms){
		String result="";
		String[] symptom=symptoms.split("，");
		for(int i=0;i<str.length;i++){
			String tmp="";
			for(int j=0;j<symptom.length;j++){
				if(str[i].contains(symptom[j])){
					String tmp1=symptom[j];
					//症候近义词处理
					File file = new File("C:\\Users\\Administrator\\Workspaces\\MyEclipse Professional 2014\\books2structure\\symptom_synonym_dictionary.txt");
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file));
						String symptomDic = null;
						while((symptomDic = br.readLine())!=null){//使用readLine方法，一次读一行
							if(symptomDic.contains(symptom[j])){
								String[] symptomName=symptomDic.split("：");
								tmp1=symptomName[0];
								break;//跳出while循环
							}
						}
						br.close();;
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//构造一个BufferedReader类来读取文件
			         catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//获取getProperty(text,tmp1)	
					tmp1=new PropertyHandle().getPropertyandOption(str[i], tmp1);
					tmp=tmp+tmp1+",";				
				}
			}
			if(tmp!=""){
				result=result+tmp+";";
			}	
		}
		System.out.println("结果："+result);
		
	}

}
