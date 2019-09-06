public class PrinterTest {
	public static void main(String[] args) {
		Printer p = new Printer();
		p.printStmt("Grand ZI-O");
		p.incDepth();
		p.printStmt("Build Genius");
		p.decDepth();
		p.printStmt("EX-AID Muteki Gamer");
	}
}
