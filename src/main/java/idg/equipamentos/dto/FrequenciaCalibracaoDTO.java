package idg.equipamentos.dto;

import idg.equipamentos.entity.FrequenciaCalibracaoEntity;
import idg.equipamentos.entity.SituacaoEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FrequenciaCalibracaoDTO {
    private UUID id;
    private String frequenciaCalibracao;
    private LocalDateTime dataCadastro;
    public static FrequenciaCalibracaoDTO entityToDTO(FrequenciaCalibracaoEntity entity){
        FrequenciaCalibracaoDTO frequenciaCalibracaoDTO = new FrequenciaCalibracaoDTO();
        frequenciaCalibracaoDTO.setId(entity.getId());
        frequenciaCalibracaoDTO.setFrequenciaCalibracao(entity.getFrequenciaCalibracao());
        frequenciaCalibracaoDTO.setDataCadastro(entity.getDataCadastro());
        return frequenciaCalibracaoDTO;
    }
    public static FrequenciaCalibracaoEntity dtoToEntity(FrequenciaCalibracaoDTO dto){
        FrequenciaCalibracaoEntity frequenciaCalibracaoEntity = new FrequenciaCalibracaoEntity();
        frequenciaCalibracaoEntity.setId(dto.getId());
        frequenciaCalibracaoEntity.setFrequenciaCalibracao(dto.getFrequenciaCalibracao());
        frequenciaCalibracaoEntity.setDataCadastro(dto.getDataCadastro());
        return frequenciaCalibracaoEntity;
    }
}
