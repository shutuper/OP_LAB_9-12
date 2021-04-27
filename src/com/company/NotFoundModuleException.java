package com.company;

public class NotFoundModuleException extends Exception{
	
	/**
	 * During serialization, the Java runtime generates a version number for the class so that it can deserialize it later.
	 *  In Java, this version number is known as SerialVersionUID.
	 *  If, during deserialization, the SerialVersionUID does not match, the process will terminate with 
	 *  an InvalidClassException on the "main" thread java.io.InvalidClassException, and print the class name 
	 *  and the corresponding SerialVersionUID. A quick fix to fix this problem is to copy the SerialVersionUID 
	 *  and define it as a private static final long in your class.
	 */
	
	private static final long serialVersionUID = 2L;
	
	NotFoundModuleException(){}
	
	@Override
	public String toString() {
		String msg = "NotFoundModuleException: "+" there is no module with the specified function";
		return msg;
	}
	
	@Override
	public String getMessage() {
		String msg = "InvalidLevelException: "+" there is no module with the specified function\n";
		StackTraceElement[] ste = this.getStackTrace();
		for(StackTraceElement i: ste) msg+= i.toString()+"\n";
		return msg.strip();
	}

}


