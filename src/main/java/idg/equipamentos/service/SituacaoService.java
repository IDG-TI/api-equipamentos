package idg.equipamentos.service;

import idg.equipamentos.dto.SituacaoDTO;
import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.persistence.SituacaoRepository;
import idg.equipamentos.persistence.TipoEquipamentoRepository;
import java.util.List;
public class SituacaoService {
    private final SituacaoRepository situacaoRepository;

    public SituacaoService(SituacaoRepository situacaoRepository) {
        this.situacaoRepository = situacaoRepository;
    }
    public List<SituacaoDTO> buscarSituacao(){
        return situacaoRepository.findAll().stream().map(SituacaoDTO::entitytoDTO).toList();
    }
}
