package idg.equipamentos.service;

import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.exception.BusinessException;
import idg.equipamentos.persistence.TipoEquipamentoRepository;
import jakarta.persistence.EntityNotFoundException;

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
        validateCriar(tipoEquipamento);
        LocalDateTime dataAtual = LocalDateTime.now();
        tipoEquipamento.setDataCadastro(dataAtual);
        return TipoEquipamentoDTO.entityToDTO(tipoEquipamentoRepository.save(TipoEquipamentoDTO.dtoToEntity(tipoEquipamento)));
    }

    public TipoEquipamentoDTO atualizarTipo(UUID uuid, TipoEquipamentoDTO tipoEquipamentoDTO) {
        validateEditar(tipoEquipamentoDTO);
        tipoEquipamentoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de Equipamento não encontrado!"));
        tipoEquipamentoDTO.setId(uuid);
        return TipoEquipamentoDTO.entityToDTO(tipoEquipamentoRepository.save(TipoEquipamentoDTO.dtoToEntity(tipoEquipamentoDTO)));
    }

    public void excluirTipo(UUID uuid){
        tipoEquipamentoRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado"));
        tipoEquipamentoRepository.deleteById(uuid);
    }

    private void validateCriar(TipoEquipamentoDTO tipoEquipamentoDTO) {
        if (tipoEquipamentoDTO.getNome() == null || tipoEquipamentoDTO.getNome().isBlank()) {
            throw new BusinessException("Digite um nome, por favor!");
        }
        if (tipoEquipamentoDTO.getSigla() == null || tipoEquipamentoDTO.getSigla().isBlank()) {
            throw new BusinessException("Digite uma sigla, por favor");
        }
        if(tipoEquipamentoRepository.existsByNome(tipoEquipamentoDTO.getNome())){
            throw new BusinessException("Nome já existente!");
        }
        if(tipoEquipamentoRepository.existsBySigla(tipoEquipamentoDTO.getSigla())){
            throw new BusinessException("Sigla já existente!");
        }
    }

    private void validateEditar(TipoEquipamentoDTO tipoEquipamentoDTO) {
        if (tipoEquipamentoDTO.getNome() == null || tipoEquipamentoDTO.getNome().isBlank()) {
            throw new BusinessException("Digite um nome, por favor!");
        }
        if (tipoEquipamentoDTO.getSigla() == null || tipoEquipamentoDTO.getSigla().isBlank()) {
            throw new BusinessException("Digite uma sigla, por favor");
        }
    }
}
