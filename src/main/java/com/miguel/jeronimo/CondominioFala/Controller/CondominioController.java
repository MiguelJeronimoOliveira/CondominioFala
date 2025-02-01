package com.miguel.jeronimo.CondominioFala.Controller;

import com.miguel.jeronimo.CondominioFala.DTOS.CondominioRequest;
import com.miguel.jeronimo.CondominioFala.Entities.Condominio;
import com.miguel.jeronimo.CondominioFala.Services.CondominioService;
import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/condominio")
public class CondominioController {

    private final CondominioService service;

    public CondominioController(CondominioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createCondominio(@RequestBody CondominioRequest request) {
        service.createCondominio(request);
        return ResponseEntity.ok("Condominio created");
    }

    @DeleteMapping
    public ResponseEntity deleteCondominio(@PathVariable Long id) {
        Optional<Condominio> condominio = service.findById(id);

        if(condominio.isPresent()) {
            service.deleteCondominio(id);
            return ResponseEntity.ok("Condominio deleted");
        }
        return ResponseEntity.notFound().build();
    }




}
