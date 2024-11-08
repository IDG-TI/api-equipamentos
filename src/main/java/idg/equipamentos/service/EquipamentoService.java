package idg.equipamentos.service;

import idg.equipamentos.dto.EquipamentoDTO;

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

}
