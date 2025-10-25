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
import com.example.acaiapi.model.Cobertura;
import com.example.acaiapi.repository.CoberturaRepository;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/coberturas")
@CrossOrigin(origins = {
    "https://acaiteria-six.vercel.app",
    "http://localhost:3000"
})
public class CoberturaController {

    private final CoberturaRepository repository;

    public CoberturaController(CoberturaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Cobertura> listarCoberturas() {
        return repository.findAll();
    }

    @PutMapping("/{id}/ativo")
    public ResponseEntity<?> atualizarAtivo(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
            Optional<Cobertura> coberturaOpt = repository.findById(id);

            if (coberturaOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Boolean ativo = body.get("ativo");
            if (ativo == null) {
                return ResponseEntity.badRequest().body("Campo 'ativo' é obrigatório");
            }

            Cobertura cobertura = coberturaOpt.get();
            cobertura.setAtivo(ativo);
            repository.save(cobertura);

            return ResponseEntity.ok(cobertura);
    }
}
