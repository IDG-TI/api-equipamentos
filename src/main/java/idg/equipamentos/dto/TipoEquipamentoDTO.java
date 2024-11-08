package idg.equipamentos.dto;

import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TipoEquipamentoDTO {
    private UUID id;

    private String sigla;

    private String nome;

    private LocalDateTime dataCadastro;


    public static TipoEquipamentoDTO entityToDTO(TipoEquipamentoEntity entity){
        //essa função vai transformar uma entidade num DTO
        //o dto vai receber os valores da entity
        TipoEquipamentoDTO tipoEquipamentodto = new TipoEquipamentoDTO();
        tipoEquipamentodto.setId(entity.getId());
        tipoEquipamentodto.setNome(entity.getNome());
        tipoEquipamentodto.setSigla(entity.getSigla());
        tipoEquipamentodto.setDataCadastro(entity.getDataCadastro());
        return tipoEquipamentodto;
    }
    public static TipoEquipamentoEntity dtoToEntity(TipoEquipamentoDTO dto){
        TipoEquipamentoEntity tipoEquipamentoEntity = new TipoEquipamentoEntity();
        tipoEquipamentoEntity.setId(dto.getId());
        tipoEquipamentoEntity.setNome(dto.getNome());
        tipoEquipamentoEntity.setSigla(dto.getSigla());
        tipoEquipamentoEntity.setDataCadastro(dto.getDataCadastro());
        return tipoEquipamentoEntity;
    }
}
