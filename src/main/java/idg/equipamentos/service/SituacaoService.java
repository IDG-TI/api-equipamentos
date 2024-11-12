package idg.equipamentos.service;

import idg.equipamentos.dto.SituacaoDTO;
import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.exception.BusinessException;
import idg.equipamentos.persistence.SituacaoRepository;
import idg.equipamentos.persistence.TipoEquipamentoRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SituacaoService {
    private final SituacaoRepository situacaoRepository;

    public SituacaoService(SituacaoRepository situacaoRepository) {
        this.situacaoRepository = situacaoRepository;
    }

    public List<SituacaoDTO> buscarSituacao(){
        return situacaoRepository.findAll().stream().map(SituacaoDTO::entityToDTO).toList();
    }

    public SituacaoDTO addSituacao(SituacaoDTO situacaoDTO){
        validateCriar(situacaoDTO);
        LocalDateTime dataAtual = LocalDateTime.now();
        situacaoDTO.setDataCadastro(dataAtual);
        return SituacaoDTO.entityToDTO(situacaoRepository.save(SituacaoDTO.dtoToEntity(situacaoDTO)));
    }

    public SituacaoDTO atualizarSituacao(UUID uuid, SituacaoDTO situacaoDTO) {
        validateEditar(situacaoDTO);
        situacaoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Situação de Equipamento não encontrado!"));
        situacaoDTO.setId(uuid);
        return SituacaoDTO.entityToDTO(situacaoRepository.save(SituacaoDTO.dtoToEntity(situacaoDTO)));
    }

    public void excluirSituacao(UUID uuid){
        situacaoRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Situação de Equipamento não encontrado!"));
        situacaoRepository.deleteById(uuid);
    }


    private void validateCriar(SituacaoDTO situacaoDTO) {
        if (situacaoDTO.getNome() == null || situacaoDTO.getNome().isBlank()) {
            throw new BusinessException("Digite um nome, por favor!");
        }

        if(situacaoRepository.existsByNome(situacaoDTO.getNome())){
            throw new BusinessException("Nome já existente!");
        }
    }

    private void validateEditar(SituacaoDTO situacaoDTO) {
        if (situacaoDTO.getNome() == null || situacaoDTO.getNome().isBlank()) {
            throw new BusinessException("Digite um nome, por favor!");
        }

    }
}
