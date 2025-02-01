package com.miguel.jeronimo.CondominioFala.Services;

import com.miguel.jeronimo.CondominioFala.DTOS.CondominioRequest;
import com.miguel.jeronimo.CondominioFala.Entities.Condominio;
import com.miguel.jeronimo.CondominioFala.Repositories.CondominioRepositry;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CondominioService {

    private final CondominioRepositry repositry;

    public CondominioService(CondominioRepositry repositry) {
        this.repositry = repositry;
    }

    public void createCondominio(CondominioRequest request) {
        Condominio condominio = new Condominio();
        condominio = condominio.condominioDTO(request);
        repositry.save(condominio);
    }

    public Optional<Condominio> findById(Long id) {
       return repositry.findById(id);
    }

    public void deleteCondominio(Long id) {repositry.deleteById(id);}

}
