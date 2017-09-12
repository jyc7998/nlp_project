package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import dictionary.FilePath;

public class Dictionary {
		//保存公有特征及其选项
		public static HashMap<String, String> propertyHashmap =new Dictionary().getPropertyHashmap("public_property_dictionary.txt");
		//保存咳嗽特征及其选项
		public static HashMap<String, String> coughHashmap =new Dictionary().getPropertyHashmap("咳嗽_dictionary.txt");
		//保存喘息特征及其选项
		public static HashMap<String, String> gaspHashmap =new Dictionary().getPropertyHashmap("喘息_dictionary.txt");
		//保存咯血特征及其选项
		public static HashMap<String, String> hemoptysisHashmap =new Dictionary().getPropertyHashmap("咯血_dictionary.txt");
		//保存咳痰特征及其选项
		public static HashMap<String, String> phlegmHashmap =new Dictionary().getPropertyHashmap("咳痰_dictionary.txt");
		//保存呼吸困难特征及其选项
		public static HashMap<String, String> dyspneaHashmap =new Dictionary().getPropertyHashmap("呼吸困难_dictionary.txt");
		//保存焦虑特征及其选项
		public static HashMap<String, String> anxietyHashmap =new Dictionary().getPropertyHashmap("焦虑_dictionary.txt");
		//保存气短特征及其选项
		public static HashMap<String, String> pantHashmap =new Dictionary().getPropertyHashmap("气短_dictionary.txt");
		//保存食欲减退特征及其选项
		public static HashMap<String, String> anorexiaHashmap =new Dictionary().getPropertyHashmap("食欲减退_dictionary.txt");
		//保存体重减轻特征及其选项
		public static HashMap<String, String> lossWeightHashmap =new Dictionary().getPropertyHashmap("体重减轻_dictionary.txt");
		//保存胸闷特征及其选项
		public static HashMap<String, String> chestDistressHashmap =new Dictionary().getPropertyHashmap("胸闷_dictionary.txt");		
		
		
		//从词典中获取相关特征选项
		public HashMap<String, String> getPropertyHashmap(String filePath){
			filePath=new FilePath().filePath+filePath;
			HashMap<String, String> hashmap=new HashMap<String, String>();
			File file = new File(filePath);
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				String propertyDic = null;
				while((propertyDic = br.readLine())!=null){//使用readLine方法，一次读一行
					String[] propertyAndOption=propertyDic.split("：");
					String[] options=propertyAndOption[1].split("，");
					for(int i=0;i<options.length;i++){
						//System.out.println(propertyAndOption[0]+options[i]);
						hashmap.put(propertyAndOption[0]+":"+options[i],options[i]);
					}
				}
				br.close();;
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//构造一个BufferedReader类来读取文件
		     catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hashmap;	
		}
		
	
}
