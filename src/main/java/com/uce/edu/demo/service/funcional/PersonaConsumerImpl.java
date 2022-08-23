package com.uce.edu.demo.service.funcional;

public class PersonaConsumerImpl implements IPersonaConsumer<String> {

	@Override
	public void accept(String arg1) {
		System.out.println(arg1);
	}

}
