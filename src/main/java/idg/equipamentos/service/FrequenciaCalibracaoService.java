package idg.equipamentos.service;

import idg.equipamentos.dto.FrequenciaCalibracaoDTO;
import idg.equipamentos.dto.SituacaoDTO;
import idg.equipamentos.exception.BusinessException;
import idg.equipamentos.persistence.FrequenciaCalibracaoRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class FrequenciaCalibracaoService {
    public final FrequenciaCalibracaoRepository frequenciaCalibracaoRepository;

    public FrequenciaCalibracaoService(FrequenciaCalibracaoRepository frequenciaCalibracaoRepository) {
        this.frequenciaCalibracaoRepository = frequenciaCalibracaoRepository;
    }

    public List<FrequenciaCalibracaoDTO> buscarFrequencia(){
        return frequenciaCalibracaoRepository.findAll().stream().map(FrequenciaCalibracaoDTO::entityToDTO).toList();
    }

    public FrequenciaCalibracaoDTO addFrequencia(FrequenciaCalibracaoDTO frequenciaCalibracaoDTO){
        validateCriar(frequenciaCalibracaoDTO);
        LocalDateTime dataAtual = LocalDateTime.now();
        frequenciaCalibracaoDTO.setDataCadastro(dataAtual);
        return FrequenciaCalibracaoDTO.entityToDTO(frequenciaCalibracaoRepository.save(FrequenciaCalibracaoDTO.dtoToEntity(frequenciaCalibracaoDTO)));
    }

    public FrequenciaCalibracaoDTO atualizarFrequencia(UUID uuid, FrequenciaCalibracaoDTO frequenciaCalibracaoDTO) {
        validateEditar(frequenciaCalibracaoDTO);
        frequenciaCalibracaoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Situação de Equipamento não encontrado!"));
        frequenciaCalibracaoDTO.setId(uuid);
        return FrequenciaCalibracaoDTO.entityToDTO(frequenciaCalibracaoRepository.save(FrequenciaCalibracaoDTO.dtoToEntity(frequenciaCalibracaoDTO)));
    }

    public void excluirFrequencia(UUID uuid){
        frequenciaCalibracaoRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Situação de Equipamento não encontrado!"));
        frequenciaCalibracaoRepository.deleteById(uuid);
    }


    private void validateCriar(FrequenciaCalibracaoDTO frequenciaCalibracaoDTO) {
        if (frequenciaCalibracaoDTO.getFrequenciaCalibracao() == null || frequenciaCalibracaoDTO.getFrequenciaCalibracao().isBlank()) {
            throw new BusinessException("Digite uma frequência, por favor!");
        }

        if(frequenciaCalibracaoRepository.existsByFrequenciaCalibracao(frequenciaCalibracaoDTO.getFrequenciaCalibracao())){
            throw new BusinessException("Frequência já existente!");
        }
    }

    private void validateEditar(FrequenciaCalibracaoDTO frequenciaCalibracaoDTO) {
        if (frequenciaCalibracaoDTO.getFrequenciaCalibracao() == null || frequenciaCalibracaoDTO.getFrequenciaCalibracao().isBlank()) {
            throw new BusinessException("Digite uma frequência, por favor!");
        }

    }


}
