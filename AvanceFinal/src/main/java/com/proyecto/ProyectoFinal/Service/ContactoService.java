package com.proyecto.ProyectoFinal.Service;

import com.proyecto.ProyectoFinal.Model.Contacto;
import com.proyecto.ProyectoFinal.Repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    @Autowired
    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public Contacto guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public List<Contacto> listarContactos() {
        return contactoRepository.findAll();
    }

    public void eliminarContacto(Long id) {
        contactoRepository.deleteById(id);
    }

    public Contacto obtenerPorId(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }
}
