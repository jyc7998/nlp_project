package wordHandle;
import java.util.HashMap;
import java.util.Iterator;

import dictionary.Dictionary;
import wordHandle.PropertyHandle;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="晨间干咳并阵咳 随病程发展可终身不愈";
		String symptomName="咳嗽";
		new PropertyHandle().getPropertyandOption(text, symptomName);
	}

}
