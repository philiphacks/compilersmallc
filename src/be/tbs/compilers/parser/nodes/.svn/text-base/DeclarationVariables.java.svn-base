package be.tbs.compilers.parser.nodes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.utility.Pair;

/**
 * DeclarationVariables Representation
 * @author Gino
 */
public class DeclarationVariables extends ASTNode {
	
	private List<VariableInit> fVarInits = new ArrayList<VariableInit>();
	
	public DeclarationVariables(ASTNode parent, AST tree, Type fType) {
		super(parent, tree, smallcParser.DECLARATION_VARIABLES);
		
		for (AST child : tree.getChildren()) {
			try {
				fVarInits.add(new VariableInit(this, child, fType));
			} catch (SemanticError e) {
				tree.addError(e);
			}
		}
	}

	public Vector<Pair> getNames() {
		Vector<Pair> names = new Vector<Pair>();
		for (VariableInit v : fVarInits) {
			int size = 1;
			if (v.isArray()) {
				size = Integer.valueOf(v.getArrayLength());
			} 
			Pair p = new Pair(v.getName(), size);
			names.add(p);
		}
		return names;
	}
	
	@Override
	public void generateCode(OutputStream o) throws IOException {
		for (VariableInit varInit : fVarInits) {
			varInit.generateCode(o);
		}
		o.flush();
	}

}
