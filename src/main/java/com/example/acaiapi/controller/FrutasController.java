package com.example.acaiapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.acaiapi.model.Frutas;
import com.example.acaiapi.repository.FrutasRepository;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/frutas")
@CrossOrigin(origins = {
    "https://acaiteria-six.vercel.app",
    "http://localhost:3000"
})
public class FrutasController {

    private final FrutasRepository repository;

    public FrutasController(FrutasRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Frutas> listarFrutas() {
        return repository.findAll();
    }

    @PutMapping("/{id}/ativo")
    public ResponseEntity<?> atualizarAtivo(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
            Optional<Frutas> ComplementoOpt = repository.findById(id);

            if (ComplementoOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Boolean ativo = body.get("ativo");
            if (ativo == null) {
                return ResponseEntity.badRequest().body("Campo 'ativo' é obrigatório");
            }

            Frutas Complemento = ComplementoOpt.get();
            Complemento.setAtivo(ativo);
            repository.save(Complemento);

            return ResponseEntity.ok(Complemento);
    }
}