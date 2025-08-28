package com.proyecto.ProyectoFinal.Service;

import com.proyecto.ProyectoFinal.Model.Local;
import com.proyecto.ProyectoFinal.Repository.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    private final LocalRepository localRepository;

    public LocalServiceImpl(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public List<Local> listarLocales() {
        return localRepository.findAll();
    }

    @Override
    public Local guardar(Local local) {
        return localRepository.save(local);
    }
}
