package idg.equipamentos.controller;


import idg.equipamentos.dto.SituacaoDTO;
import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.service.SituacaoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/v1/situacao_equipamentos")

public class SituacaoController {
    private final SituacaoService situacaoService;

    public SituacaoController(SituacaoService situacaoService) {
        this.situacaoService = situacaoService;
    }

    @GetMapping("/find")
    public List<SituacaoDTO> mostrarSituacao(){
        return situacaoService.buscarSituacao();

    }
}
