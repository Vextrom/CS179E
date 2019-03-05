package symbol;

import java.util.*;

// Class for symbols of classes
public class ClassSymbol extends Symbol {
	private ClassSymbol baseClass;				// base class, if extends some class
	private HashMap<String, VarSymbol> flds;	// List of fields
	private HashMap<String, MethodSymbol> mtds;	// List of methods
	
	// Default constructor
	public ClassSymbol(String _name) {
		super(_name);
		this.baseClass = null;
		this.flds = new HashMap<String, VarSymbol>();
		this.mtds = new HashMap<String, MethodSymbol>();
	}
	
	// Set base class of this class
	public void SetBaseClass(ClassSymbol _cSymbol) {
		this.baseClass = _cSymbol;
	}
	
	// Return the base class
	public ClassSymbol getBaseClass() {
		return this.baseClass;
	}
	
	// Add field to this class
	public boolean addField(String _fName, String _fType) {
		boolean is_added = false;
		if (!this.flds.containsKey(_fName)) {
			VarSymbol var = new VarSymbol(_fName, _fType);
			this.flds.put(_fName, var);
			is_added = true;
		}
		return is_added;
	}
	
	// Find a matching field
	public VarSymbol findField(String _name) {
		if (this.flds.containsKey(_name)) {
			return this.flds.get(_name);
		} else if (this.baseClass != null) {
			return this.baseClass.findField(_name);
		} else {
			return null;
		}
	}
	
	// Return the number of fields
	public int fieldSize() {
		return this.flds.size();
	}
	
	// Add method to this class
	public MethodSymbol addMethod(String _mName, String _mRtype) {
		MethodSymbol mtd = null;
		if (!this.mtds.containsKey(_mName)) {
			mtd = new MethodSymbol(_mName, _mRtype);
			this.mtds.put(_mName, mtd);
		}
		return mtd;
	}
	
	// Find a matching method
	public MethodSymbol findMethod(String _name) {
		if (this.mtds.containsKey(_name)) {
			return this.mtds.get(_name);
		} else if (this.baseClass != null) {
			return this.baseClass.findMethod(_name);
		} else {
			return null;
		}
	}
	
	// Return the number of methods
	public int methodSize() {
		return this.mtds.size();
	}
}
