package com.miguel.jeronimo.CondominioFala.Repositories;

import com.miguel.jeronimo.CondominioFala.Entities.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepositry extends JpaRepository<Condominio, Long> {
}
