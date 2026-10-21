package com.manuelluvuvamo.arquiteturaspring.montadora.api;

import com.manuelluvuvamo.arquiteturaspring.montadora.CarroStatus;
import com.manuelluvuvamo.arquiteturaspring.montadora.Chave;
import com.manuelluvuvamo.arquiteturaspring.montadora.HondaHRV;
import com.manuelluvuvamo.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    @Eletrico
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
