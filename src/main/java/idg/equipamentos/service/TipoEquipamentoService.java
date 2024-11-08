package idg.equipamentos.service;

import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import idg.equipamentos.persistence.TipoEquipamentoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TipoEquipamentoService {

    private final TipoEquipamentoRepository tipoEquipamentoRepository;

    public TipoEquipamentoService(TipoEquipamentoRepository tipoEquipamentoRepository) {
        this.tipoEquipamentoRepository = tipoEquipamentoRepository;
    }

    public List<TipoEquipamentoDTO> buscarTipos() {
        return tipoEquipamentoRepository.findAll().stream().map(TipoEquipamentoDTO::entityToDTO).toList();
    }

    public TipoEquipamentoDTO addTipo(TipoEquipamentoDTO tipoEquipamento) {
        LocalDateTime dataAtual = LocalDateTime.now();
        tipoEquipamento.setDataCadastro(dataAtual);
        return TipoEquipamentoDTO.entityToDTO(tipoEquipamentoRepository.save(TipoEquipamentoDTO.dtoToEntity(tipoEquipamento)));
    }
}
