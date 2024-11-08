package idg.equipamentos.dto;

import idg.equipamentos.entity.SituacaoEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class SituacaoDTO {
    private UUID id;

    private String nome;

    // isso add tbm
    private LocalDate dataCadastro;

    public static SituacaoDTO entitytoDTO(SituacaoEntity entity){
        SituacaoDTO situacaoDTO = new SituacaoDTO();
        situacaoDTO.setId(entity.getId());
        situacaoDTO.setNome(entity.getNome());
        situacaoDTO.setDataCadastro(entity.getDataCadastro());
        return situacaoDTO;
    }
    public static SituacaoEntity dtoToEntity(SituacaoDTO dto){
        SituacaoEntity situacaoEntity = new SituacaoEntity();
        situacaoEntity.setId(dto.getId());
        situacaoEntity.setNome(dto.getNome());
        situacaoEntity.setDataCadastro(dto.getDataCadastro());
        return situacaoEntity;
    }
}
