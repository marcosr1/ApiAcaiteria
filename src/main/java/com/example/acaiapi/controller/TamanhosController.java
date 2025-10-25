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
import com.example.acaiapi.model.Tamanhos;
import com.example.acaiapi.repository.TamanhosRepository;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/tamanhos")
@CrossOrigin(origins = {
    "https://acaiteria-six.vercel.app",
    "http://localhost:3000"
})
public class TamanhosController {

    private final TamanhosRepository repository;

    public TamanhosController(TamanhosRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Tamanhos> listarTamanhos() {
        return repository.findAll();
    }

    @PutMapping("/{id}/ativo")
    public ResponseEntity<?> atualizarAtivo(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
            Optional<Tamanhos> ComplementoOpt = repository.findById(id);

            if (ComplementoOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            Boolean ativo = body.get("ativo");
            if (ativo == null) {
                return ResponseEntity.badRequest().body("Campo 'ativo' é obrigatório");
            }

            Tamanhos Complemento = ComplementoOpt.get();
            Complemento.setAtivo(ativo);
            repository.save(Complemento);

            return ResponseEntity.ok(Complemento);
    }
}
