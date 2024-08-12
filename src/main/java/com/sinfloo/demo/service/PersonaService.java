package com.sinfloo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.demo.interfaceServices.IPersonaService;
import com.sinfloo.demo.modelo.Persona;
import com.sinfloo.demo.interfaces.IPersona;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersona data;
    
    @Override
    public List<Persona> listar() {
        // Devuelve una lista de todas las personas almacenadas en la base de datos
        return (List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        // Devuelve la persona con el ID especificado, si existe
        return data.findById(id);
    }

    @Override
    public int save(Persona p) {
        // Guarda la persona en la base de datos y retorna 1 si la operación fue exitosa
        Persona savedPersona = data.save(p);
        return savedPersona != null ? 1 : 0;
    }

    @Override
    public void delete(int id) {
        // Elimina la persona con el ID especificado
        data.deleteById(id);
    }

    @Override
    public void delete() {
        // Este método no está definido en la interfaz y no tiene implementación aquí
        throw new UnsupportedOperationException("Este método no está implementado.");
    }
}
