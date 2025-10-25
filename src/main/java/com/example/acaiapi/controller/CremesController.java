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
import com.example.acaiapi.model.Cremes;
import com.example.acaiapi.repository.CremesRepository;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/cremes")
@CrossOrigin(origins = "https://acaiteria-six.vercel.app/")
public class CremesController {

    private final CremesRepository repository;

    public CremesController(CremesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Cremes> listarCremes() {
        return repository.findAll();
    }

    @PutMapping("/{id}/ativo")
    public ResponseEntity<?> atualizarAtivo(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
            Optional<Cremes> ComplementoOpt = repository.findById(id);

            if (ComplementoOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Boolean ativo = body.get("ativo");
            if (ativo == null) {
                return ResponseEntity.badRequest().body("Campo 'ativo' é obrigatório");
            }

            Cremes Complemento = ComplementoOpt.get();
            Complemento.setAtivo(ativo);
            repository.save(Complemento);

            return ResponseEntity.ok(Complemento);
    }
}
