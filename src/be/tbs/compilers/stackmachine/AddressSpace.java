package be.tbs.compilers.stackmachine;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

import be.tbs.compilers.log.Log;
import be.tbs.compilers.utility.Pair;

/**
 * Represents the Address Space
 * @author Philip De Smedt
 *
 */
public class AddressSpace {

	private Stack<Integer> fAddresses = new Stack<Integer>();
	private Stack<Vector<String>> fStack = new Stack<Vector<String>>();
	private Hashtable<String, Pair> fNames = new Hashtable<String, Pair>();
	
	public static int STACK_RESERVED_WORDS = 5;
	
	public AddressSpace() {
		fStack.push(new Vector<String>());
		fAddresses.push(0);
	}
	
	public void startNestingDepth() {
		fStack.push(new Vector<String>());
		fAddresses.push(0);
	}
	
	public void endNestingDepth() {
		if (fStack.size() > 1) {
			for (String key : fStack.peek()) {
				fNames.remove(key);
			}
			fStack.pop();
			fAddresses.pop();
		}
	}
	
	public void addName(String name) {
		fStack.peek().add(0, name);
		Pair p = new Pair(getAddress(), getNestingDepth());
		fNames.put(name, p);
	}
	
	public int getNestingDepth() {
		return fStack.size()-1;
	}
	
	public int getAddress() {
		return fAddresses.peek();
	}
	
	public void incAddress(int inc) {
		if (fAddresses.peek() + inc >= 0) {
			fAddresses.push(fAddresses.pop() + inc);
		}
	}
	
	public Pair getName(String name) {
		return fNames.get(name);
	}
	
	public void printNames() {
		Enumeration<String> myKeys = fNames.keys();
		while (myKeys.hasMoreElements()) {
			String key = myKeys.nextElement();
			Log.info("Name: " + key);
		}
	}
	
	public void addVariable(Pair p) {
		addName((String)p.getX());
		incAddress((Integer)p.getY());
	}
}
