package idg.equipamentos.controller;


import idg.equipamentos.dto.SituacaoDTO;
import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.service.SituacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping ("/v1/situacao_equipamentos")

public class SituacaoController {
    private final SituacaoService situacaoService;

    public SituacaoController(SituacaoService situacaoService) {
        this.situacaoService = situacaoService;
    }

    @GetMapping
    public List<SituacaoDTO> mostrarSituacao(){
        return situacaoService.buscarSituacao();
    }

    @PostMapping
    public SituacaoDTO cadastrarSituacao(@RequestBody SituacaoDTO situacaoDTO){
        return situacaoService.addSituacao(situacaoDTO);
    }

    @PutMapping("/{uuid}")
    public SituacaoDTO atualizarSituacao(@PathVariable UUID uuid, @RequestBody SituacaoDTO situacaoDTO){
        return situacaoService.atualizarSituacao(uuid, situacaoDTO);
    }

    @DeleteMapping ("/{uuid}")
    public void deleteSituacao(@PathVariable UUID uuid){
        situacaoService.excluirSituacao(uuid);
    }
}
