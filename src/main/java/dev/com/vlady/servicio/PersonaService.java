package dev.com.vlady.servicio;

import dev.com.vlady.domain.Persona;

public interface PersonaService {
    public Iterable<Persona> listarPersonas();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);

}
