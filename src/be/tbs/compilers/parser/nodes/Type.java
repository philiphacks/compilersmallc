package be.tbs.compilers.parser.nodes;

import be.tbs.compilers.exceptions.error.SemanticError;
import be.tbs.compilers.exceptions.error.SymbolError;
import be.tbs.compilers.log.Log;
import be.tbs.compilers.parser.AST;
import be.tbs.compilers.parser.smallcParser;
import be.tbs.compilers.symboltable.Symbol;

public class Type {
    
    // All types in smallc
    public enum Types {        
        INT, CHAR, FLOAT, VOID, CONST_INT, CONST_CHAR, CONST_FLOAT;
    }
    
    private Types fType;
    private int fSize;
    
    public Type(Types t) {
        fType = t;
        fSize = 1;
    }
    
    public Type(Types t, Integer size) {
    	fType = t;
    	fSize = size;
    }
    
    // Constructs a type specifier from a node in the tree.
    public Type(AST tree) {
        boolean constType = false;
        fType = null;
        fSize = 1;
        
        for (AST child : tree.getChildren()) {
            if (child.getType() == smallcParser.CONST) {
                constType = true;
            } else if (child.getType() == smallcParser.IDENTIFIER) {
                try {
                    Symbol symbol = tree.getSymbolTable().getSymbol(child.toString());
                    fType = symbol.getType().get();
                    Log.info("Found a nested typedef type: " + child.toString() + " is a(n) " + fType);
                } catch (SymbolError e) {
                    tree.addError(e);
                }
            } else {
                // It's one of the basic types.
                switch (child.getType()) {
                case smallcParser.INT:
                    fType = Types.INT;
                    break;
                case smallcParser.CHAR:
                    fType = Types.CHAR;
                    break;
                case smallcParser.FLOAT:
                    fType = Types.FLOAT;
                    break;
                case smallcParser.VOID:
                    fType = Types.VOID;
                    break;
                default:
                    tree.addError(new SemanticError(tree.getLocation() + "Unknown type specified"));
                    break;
                }
            }
        }
        
        if (constType) {
            switch (fType) {
            case INT:
                fType = Types.CONST_INT;
                break;
            case CHAR:
                fType = Types.CONST_CHAR;
                break;
            case FLOAT:
                fType = Types.CONST_FLOAT;
                break;
            default:
                tree.addError(new SemanticError(tree.getLocation() + "Illegal type modifier"));
                break;
            }
        }
    }
    
    public Types get() {
        return fType;
    }
    
    public Integer getSize() {
    	return fSize;
    }
    
    public void setSize(int size) {
    	fSize = size;
    }
    
    public Type getBase() {
        switch (fType) {
        case CONST_INT:
            return new Type(Types.INT);
        case CONST_CHAR:
            return new Type(Types.CHAR);
        case CONST_FLOAT:
            return new Type(Types.FLOAT);
        default:
            return this;
        }
    }
    
    public boolean isConst() {
        return (fType == Types.CONST_INT || fType == Types.CONST_CHAR || fType == Types.CONST_FLOAT);
    }
    
    public static Type getResultType(Type first, Type second) {
        if (first == null || second == null)
            return null;

        if (first.equals(second)) {
            // first can be cast to second (or is equal to it)
            // we should return the biggest type
            return second;
        } else if (second.equals(first) ) {
            // second can be cast to first, and they are not equal
            return first;
        } else {
            // they cannot be cast to each other's types
            return null;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fType == null) ? 0 : fType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // Auto generated Equals method
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Type other = (Type) obj;
        if (fType == null && other.fType != null)
                return false;
        
        // Custom Equals functionality
        // Bigger types equal smaller types, but not the other way around.
        Types thisType = this.getBase().get();
        Types otherType = other.getBase().get();
        switch (thisType) {
        case VOID:
            // Void is not a member of type hierarchy
            return otherType.equals(Types.VOID);
        case CHAR:
            return !otherType.equals(Types.VOID);
        case INT:
            return otherType.equals(Types.INT) || otherType.equals(Types.FLOAT);
        case FLOAT:
            return otherType.equals(Types.FLOAT);
        default:
            return false;
        }
    }
    
    /**
     * Checks if this type can be cast to 'spec'.
     * Currently simply a more readable alias for the equals method.
     * @param spec The target type
     * @return True if this type can be cast to the target type
     */
    public boolean canCastTo(Type spec) {
        return this.equals(spec);
    }
    
    /**
     * Returns a string representation of this type, excluding any modifiers such as 'const'.
     * Use the equals method to check for types that can be cast to eachother, or use get() to compare the raw type.
     * @return A String representing the base type of this object.
     */
    public String baseString() {
        String output = null;
        switch (fType) {
        case CONST_INT:
        case INT:
            output = "int";
            break;
        case CONST_FLOAT:
        case FLOAT:
            output = "float";
            break;
        case CONST_CHAR:
        case CHAR:
            output = "char";
            break;
        default:
            output = "void";
            break;
        }
        return output;
    }
    
    public String PMachineType() {
    	switch(fType) {
    		case INT:
    		case CONST_INT:
    			return "i";
    		case FLOAT:
    		case CONST_FLOAT:
    			return "r";
    		case CHAR:
    		case CONST_CHAR:
    			return "c";
    	}
    	return null;
    }
    
    /**
     * Returns a string representation of this object's type.
     */
    public String toString() {
        String output = null;
        switch (fType) {
        case CONST_INT:
            output = "const int";
            break;
        case INT:
            output = "int";
            break;
        case CONST_FLOAT:
            output = "const float";
            break;
        case FLOAT:
            output = "float";
            break;
        case CONST_CHAR:
            output = "const char";
            break;
        case CHAR:
            output = "char";
            break;
        default:
            output = "void";
            break;
        }
        return output;
    }
    

}
