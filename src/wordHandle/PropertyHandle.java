package wordHandle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import dictionary.FilePath;
import dictionary.Dictionary;

public class PropertyHandle {
	
	public String getPropertyandOption(String text,String symptomName){
		//判断句子是否有特征名称
		String propertyName=getPropertyName(text,symptomName);
		String result=symptomName+":";
		
		//公有特征和特征选项
		HashMap<String,String> propertyMap= new Dictionary().propertyHashmap;
		Iterator it =propertyMap.keySet().iterator();  
        while(it.hasNext()) {  
            String key = (String)it.next();  
            if(text.contains(propertyMap.get(key))){
            	result=result+propertyName+key+"/";
            }  
        }
        
        //症候私有特征和特征选项
        HashMap<String,String> propertyMap1=new HashMap<String,String>();
        switch(symptomName){
        case "咳嗽":
        propertyMap1=new Dictionary().coughHashmap;
        break;
        case "喘息":
        propertyMap1=new Dictionary().gaspHashmap;
        break;
        case "咯血":
        propertyMap1=new Dictionary().hemoptysisHashmap;
        break;
        case "咳痰":
        propertyMap1=new Dictionary().phlegmHashmap;
        break;
        case "呼吸困难":
        propertyMap1=new Dictionary().dyspneaHashmap;
        break;
        case "焦虑":
        propertyMap1=new Dictionary().anxietyHashmap;
        break;
        case "气短":
        propertyMap1=new Dictionary().pantHashmap;
        break;
        case "食欲减退":
        propertyMap1=new Dictionary().anorexiaHashmap;
        break;
        case "体重减轻":
        propertyMap1=new Dictionary().lossWeightHashmap;
        break;
        case "胸闷":
        propertyMap1=new Dictionary().chestDistressHashmap;
        break;
        }
        
        it=propertyMap1.keySet().iterator();  
        while(it.hasNext()) { 
            String key = (String)it.next();
            if(text.contains(propertyMap1.get(key))){
            	result=result+propertyName+key+"/";
            }  
        }
       
	    return result;
	   // System.out.println(result);
	        
	}
	public String getPropertyName(String text,String symptomName){
		BufferedReader br;	
		String propertyName1="";
		String path=new FilePath().filePath+"property__synonym_dictionary.txt";
		try {
			br = new BufferedReader(new FileReader(path));
			String propertyDic = null;
			while((propertyDic = br.readLine())!=null){//使用readLine方法，一次读一行
				String[] propertyName=propertyDic.split("：");
				String[] properties=propertyName[1].split("，");
				for(int i=0;i<properties.length;i++){
					if(text.contains(properties[i])){
						propertyName1=propertyName[0];
					}
				}
				}
			br.close();;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyName1;
	}
	

}
