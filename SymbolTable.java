package symbol;

import java.util.*;

// Class for final symbol table
public class SymbolTable {
	private HashMap<String, ClassSymbol> cls;	// List of classes
	private ArrayList<ClassSymbol> dclSequence;
	
	// Default constructor
	public SymbolTable() {
		this.cls = new HashMap<String, ClassSymbol>();
		this.dclSequence = new ArrayList<ClassSymbol>();
	}
	
	// Add class to the list
	public ClassSymbol addClass(String _cName) {
		ClassSymbol _class = null;
		if (!this.cls.containsKey(_cName)) {
			_class = new ClassSymbol(_cName);
			this.cls.put(_cName, _class);
			this.dclSequence.add(_class);
		}
		return _class;
	}
	
	// Find class from the list
	public ClassSymbol findClass(String _name) {
		return this.cls.get(_name);
	}
	
	// Return the number of classes
	public int classSize() {
		return this.cls.size();
	}
}
