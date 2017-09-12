package wordHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplit {
	public String[] getString(String text){
		String regEx="[，；。？！：【】,;?.!．:：]";  
        Pattern p =Pattern.compile(regEx);  
        Matcher m = p.matcher(text);   
        String[] substrs = p.split(text);
        List<String> tmp=new ArrayList<String>();
        for(String str:substrs){
        	if(str!=null&&str.length()>2){
        		tmp.add(str);
        	}
        }
        substrs=tmp.toArray(new String[0]);
		//String[] res=null;
		//res = text.split("、|，|。|；|？|！|,|\\.|;|\\?|!|]|：|:");
		return substrs;
	}
}
