package be.tbs.compilers.parser.nodes;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.utility.Pair;

/**
 * ParameterList Representation
 * @author Gino
 */
public class ParameterList extends ASTNode {
	
	private List<Parameter> fParameters = new ArrayList<Parameter>();

	public ParameterList(ASTNode parent, AST tree) {
		super(parent, tree, smallcParser.PARAMETER_LIST);
		
		for (int i = 0; i < tree.getChildCount(); i++) {
			Log.info("New parameter in function signature.");
			try {
				fParameters.add(new Parameter(this, tree.getChild(i)));
			} catch (SymbolError e) {
				tree.addError(e);
			}
		}
	}
	
	public void addSymbols() {
	    for (Parameter para : fParameters) {
            para.addSymbol();
        }
	}

	Vector<Pair> getParameters() {
		Vector<Pair> params = new Vector<Pair>();
		for (int i = 0; i < fParameters.size(); i++) {
			Parameter param = fParameters.get(i);
			Pair p = new Pair(param.getInfo().getY(), param.getSize());
			params.add(p);
		}
		return params;
	}
	
	@Override
	public void generateCode(OutputStream o) {}

}
