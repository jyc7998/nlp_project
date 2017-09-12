package wordHandle;
import java.util.List;

import com.hankcs.hanlp.HanLP;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List result =HanLP.segment("慢阻肺急性发作，痰量增多。");
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
	}
}
