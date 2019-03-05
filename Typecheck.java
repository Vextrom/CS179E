import syntaxtree.*;

public class Typecheck {
	public static void main(String[] args) {
		try {
			Goal goal = new MiniJavaParser(System.in).Goal();
			BuildSTVisitor bvisitor = new BuildSTVisitor();
			goal.accept(bvisitor);
			TypeCheckVisitor tcvisitor = new TypeCheckVisitor(bvisitor.getSymbolTable());
			goal.accept(tcvisitor);
			if (tcvisitor.isAnyError()) {
				System.out.println("Type error");
				System.exit(1);
			} else {
				System.out.println("Program type checked successfully");
				System.exit(0);
			}
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
}
