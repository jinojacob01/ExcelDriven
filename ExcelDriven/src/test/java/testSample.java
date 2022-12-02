import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class testSample {

	public static void main(String[] args) throws IOException {
		dataDriven obj = new dataDriven();
		ArrayList ar = obj.getData1("Delete Profile");
		Iterator ait = ar.iterator();
		while (ait.hasNext()) {
			System.out.println(ait.next());
		}
//		
//		System.out.println(ar.get(0));
//		System.out.println(ar.get(1));
//		System.out.println(ar.get(2));
//		System.out.println(ar.get(3));
	}

}
