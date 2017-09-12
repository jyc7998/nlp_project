package wordHandle;

import java.io.*;  
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
  
public class WordReader {  
	public String getText(String filePath){
		String text=null;
		try {
  	      OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
  	      POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
  	      text = extractor.getText().trim();
  	    } catch (Exception e) {
  	      e.printStackTrace();
  	      System.out.println("WordReader出错！");
  	    }
		return text;
	}
}  

