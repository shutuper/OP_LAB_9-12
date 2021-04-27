package com.company;

import java.util.List;

public class SmartPhone extends Phone{
	
	/**
	 * Constructor for creating a smartphone with two parameters.
	 * @param model is name of phone.
	 * @param modules is a set of modules that is added to the base list (SIM, GPS, micro USB).
	 */
	
	public SmartPhone(String model, List<Module> modules){
		super();
		this.model = model;
		this.modules = Module.defaultModules();
		this.modules.addAll(modules);
	}


	/**
	 * Constructor for creating a smartphone with two parameters.
	 *  The list of modules will be standard (SIM, GPS, micro USB).
	 * @param model is name of phone.
	 */
	
	public SmartPhone(String model){
		super();
		this.model = model;
		this.modules = Module.defaultModules();
	}
	
	/**
	 * A method that makes a call to given number.
	 * @param number is the number to be called.
	 * @throws NotFoundModuleException if there are no phone call or internet access functions.
	 * @throws IllegalArgumentException if not a number is entered. (Correct number - "+380-50-617-0543")
	 */
	
	@Override
	public void call(String number) throws NotFoundModuleException {
		if(!this.checkNumber(number)) throw new IllegalArgumentException("Invalid number: "+ number);
		if(this.phoneNumber.equals(number)) throw new IllegalArgumentException("Can't type yourself");
		if((this.isBuiltInFunction("phone call") || this.isBuiltInFunction("internet access"))) {
			System.out.println("Call by number "+number +" successfully completed!");
		}
		else {
			throw new NotFoundModuleException();
		}
		
	}
	
	/**
	 * A method charges the phone.
	 * @throws NotFoundModuleException if there are no wired charging or wireless charging functions.
	 */
    
	@Override
	public void charging() throws NotFoundModuleException {
		if(this.isBuiltInFunction("wired charging") || this.isBuiltInFunction("wireless charging")) {
			System.out.println("Charging successfully completed!");
		}
		else throw new NotFoundModuleException();
	}

}
