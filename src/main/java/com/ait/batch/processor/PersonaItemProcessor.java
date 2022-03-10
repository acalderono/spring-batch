package com.ait.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.ait.batch.model.Persona;

public class PersonaItemProcessor implements ItemProcessor<Persona, Persona> {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(PersonaItemProcessor.class);
	
	@Override
	public Persona process(Persona item) throws Exception {
		String nombre = item.getNombre().toUpperCase();
		String apellido = item.getApellido().toUpperCase();
		String telefono = item.getTelefono();
		
		Persona persona = new Persona(nombre, apellido, telefono);
		
		LOG.info("Convirtiendo ({}) a ({})", item, persona);
		
		return persona;
		
	}
	
}

