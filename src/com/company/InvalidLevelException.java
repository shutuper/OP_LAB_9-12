package com.company;

public class InvalidLevelException extends Exception{
	
	/**
	 * During serialization, the Java runtime generates a version number for the class so that it can deserialize it later.
	 *  In Java, this version number is known as SerialVersionUID.
	 *  If, during deserialization, the SerialVersionUID does not match, the process will terminate with 
	 *  an InvalidClassException on the "main" thread java.io.InvalidClassException, and print the class name 
	 *  and the corresponding SerialVersionUID. A quick fix to fix this problem is to copy the SerialVersionUID 
	 *  and define it as a private static final long in your class.
	 */
	
	private static final long serialVersionUID = 1L;
	int level;
	
	InvalidLevelException(int level){
		this.level = level;
	}
	
	@Override
	public String toString() {
		String msg = "InvalidLevelException: "+level+" should be from 1 to 5\n";
		return msg;
	}
	
	@Override
	public String getMessage() {
		String msg = "InvalidLevelException: "+level+" should be from 1 to 5\n";
		StackTraceElement[] ste = this.getStackTrace();
		for(StackTraceElement i: ste) msg+= i.toString()+"\n";
		return msg.strip();
	}

}
