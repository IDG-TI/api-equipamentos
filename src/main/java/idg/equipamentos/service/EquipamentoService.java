package idg.equipamentos.service;

import idg.equipamentos.dto.EquipamentoDTO;

import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.entity.EquipamentoEntity;
import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import idg.equipamentos.persistence.EquipamentoRepository;
import idg.equipamentos.persistence.SituacaoRepository;
import idg.equipamentos.persistence.TipoEquipamentoRepository;

import java.util.List;


public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<EquipamentoDTO> buscarEquipamentos() {
        return equipamentoRepository.findAll().stream().map(EquipamentoDTO::entityToDTO).toList();
    }
    public EquipamentoDTO addEquipamento(EquipamentoDTO equipamentoDTO){

        return EquipamentoDTO.entityToDTO(EquipamentoDTO.dtoToEntity(equipamentoDTO));
    }


    public String gerarNovaIdentificacao(TipoEquipamentoDTO tipoEquipamento) {
        String prefixo = tipoEquipamento.getSigla();
        List<EquipamentoEntity> equipamentos = equipamentoRepository.findLastByPrefixo(prefixo + "-%");
        int novoNumero = 1;
        if (!equipamentos.isEmpty()) {
            String ultimaIdentificacao = equipamentos.get(0).getIdentificacao();
            String numeroStr = ultimaIdentificacao.split("-")[1];
            novoNumero = Integer.parseInt(numeroStr) + 1;
        }
        // Formata a nova identificação no padrão "PREFIXO-XXX"
        return String.format("%s-%03d", prefixo, novoNumero);
    }

}
