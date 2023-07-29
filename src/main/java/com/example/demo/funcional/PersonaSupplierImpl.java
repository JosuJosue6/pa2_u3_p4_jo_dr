package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "1720525516";
		cedula = cedula +"zzzz";
		return cedula;
	}

}
