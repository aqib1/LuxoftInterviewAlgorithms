import com.utils.BT.io.BT;
import com.utils.BT.io.BTTraversal;

public class MainClass {

	public static void main(String[] args) {
		BT<String> bt = new BT<>();
		bt.add(8, "Aqib");
		bt.add(5, "ali");
		bt.add(6, "test");
		bt.add(10, "Nudrat");
		bt.add(11, "shj");
		bt.add(9, "jhwl");
		bt.traverseBT(BTTraversal.LEVEL_ORDER);
	}

}
