import java.util.*;
import symbol.*;

public class Test {
	public static void main(String[] args) {
		ClassSymbol c1 = new ClassSymbol("ClassA");
		c1.addField("f1","int"); c1.addField("f2","int");
		ClassSymbol c2 = new ClassSymbol("ClassB");
		c2.setBaseClass(c1);
		c2.addField("f1","boolean"); c2.addField("f3","boolean");
		for (VarSymbol v: c1.getClassRecord()) {
			System.out.println(v.getName() + " " + v.getType());
		}
	}
}
