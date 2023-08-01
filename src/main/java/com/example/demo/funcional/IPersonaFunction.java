package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaFunction<T, R>{
   
	//Mi T es mi retorno
	public T aplicar(R arg);
	
}
