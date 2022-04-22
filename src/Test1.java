import java.util.ArrayList;
import java.util.List;

public class Test1 {
	 public static void main(String[] args) {
	        List<String> data = new ArrayList<>();
	        data.add("1");
	        data.add("2");
	        updateData(data);
	        data.add("5");
	        System.out.print(data);
	   }
	   
	   private static void updateData(List<String> data) {
	       data.add("3");
	       data = new ArrayList<>();
	       data.add("4");
	   }
}
