package com.company;

import java.util.ArrayList;
import java.util.List;

public class Module {
	
	private String name;
	private List<Function> functional;
	
	public Module(String name, List<Function> functional) {
		super();
		this.name = name;
		this.functional = functional;
	}

	/**
	 * Constructor for creating simple modules. Set empty function list.
	 * @param name is the module name to set.
	 * 
	 */
	
	public Module(String name) {
		super();
		this.name = name;
		this.functional = new ArrayList<>();
	}

	/**
	 * @return the module name.
	 */
	
	public  String getName() {
		return name;
	}
	
	/**
	 * @param name the module name to set.
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param func the functional to set.
	 */
	
	public void setFunctional(List<Function> func) {
		this.functional = func;
	}
	
	/**
	 * @return functional of module.
	 */
	
	public List<Function> getFunctional() {
		return functional;
	}
	
	/**
	 * add function to list.
	 * @param func added to the list of module functions.
	 */
	
	public void addFunction(Function func) {
		functional.add(func);
	}
	
	/**
	 * add list functions to list.
	 * @param func added to the list of module functions.
	 */
	
	public void addAllFunctions(List<Function> func) {
		functional.addAll(func);
	}
	
	/**
	 * remove function from list.
	 * @param func remove to the list of module functions.
	 */
	
	public void removeFunction(Function func) {
		functional.remove(func);
	}
	
	/**
	 * remove function from list by index.
	 * @param i is index for remove function from the list of module functions.
	 */
	
	public void removeFunction(int i) {
		functional.remove(i);
	}
    
	/**
	 * Creation of basic modules for using standard methods.
	 * @return three modules: SIM, GPS, microUSB.
	 */
	
	public static List<Module> defaultModules() {
		List <Module> modules = new ArrayList<>();
		
		List <Function> functionsSIM = new ArrayList<>();
		functionsSIM.add(new Function("phone call"));
		functionsSIM.add(new Function("sending messages"));
		functionsSIM.add(new Function("internet access"));
		
		Module sim = new Module("SIM",functionsSIM);
		modules.add(sim);
		
		List <Function> functionsGPS = new ArrayList<>();
		functionsGPS.add(new Function("location tracking"));
		functionsGPS.add(new Function("time measurement"));
		functionsGPS.add(new Function("distance measurement"));
		
		Module gps = new Module("GPS",functionsGPS);
		modules.add(gps);
		
		List <Function> functionsMicroUSB = new ArrayList<>();
		functionsMicroUSB.add(new Function("wired charging"));
		functionsMicroUSB.add(new Function("wired connection to devices"));
		
		Module microUSB = new Module("micro USB",functionsMicroUSB);
		modules.add(microUSB);
		
		return modules;
	}
	
	/**
	 * Compares two modules by name and list of functions.
	 */
	
	 @Override 
	    public boolean equals(Object mod) {
	    	return (mod instanceof Module) &&
	    		   this.name.equals(((Function) mod).getName()) &&
	    		   this.getFunctional().equals((((Module) mod).getFunctional()));
	    }
	    
	    @Override 
	    public String toString() {
	    	String funcs = "";
	    	for(Function f: functional) {
	    		funcs+= f.toString()+" ";
	    	}
	    	funcs = funcs.trim().replaceAll(" ", ", ");
	    	return name + " : "+funcs;
	    }

}
