package idg.equipamentos.dto;

import idg.equipamentos.entity.EquipamentoEntity;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EquipamentoDTO {
    private UUID id;
    private TipoEquipamentoDTO tipoEquipamento;
    private String codigo;
    private String descricao;
    private String capacidade;
    private String menorValorDivisao;
    private String toleranciaEspecificada;
    private String campoTolerancia;
    private String limiteErro;
    private LocalDate dataCompra;
    private String responsavel;
    private String secao;
    private LocalDate dataCadastro;
    private String observacao;
    private SituacaoDTO situacao;



    public static EquipamentoDTO entityToDTO(EquipamentoEntity entity){
        EquipamentoDTO equipamentoDTO = new EquipamentoDTO();
        equipamentoDTO.setId(entity.getId());
        equipamentoDTO.setTipoEquipamento(TipoEquipamentoDTO.entityToDTO(entity.getTipoEquipamento()));
        equipamentoDTO.setSituacao(SituacaoDTO.entitytoDTO(entity.getSituacao()));
        equipamentoDTO.setCodigo(entity.getCodigo());
        equipamentoDTO.setDescricao(entity.getDescricao());
        equipamentoDTO.setCapacidade(entity.getCapacidade());
        equipamentoDTO.setMenorValorDivisao(entity.getMenorValorDivisao());
        equipamentoDTO.setToleranciaEspecificada(entity.getToleranciaEspecificada());
        equipamentoDTO.setCampoTolerancia(entity.getCampoTolerancia());
        equipamentoDTO.setLimiteErro(entity.getLimiteErro());
        equipamentoDTO.setDataCompra(entity.getDataCompra());
        equipamentoDTO.setResponsavel(entity.getResponsavel());
        equipamentoDTO.setSecao(entity.getSecao());
        equipamentoDTO.setDataCadastro(entity.getDataCadastro());
        equipamentoDTO.setObservacao(entity.getObservacao());
        return equipamentoDTO;
    }

    public static EquipamentoEntity dtoToEntity(EquipamentoDTO dto){
        EquipamentoEntity equipamentoEntity= new EquipamentoEntity();
        equipamentoEntity.setId(dto.getId());
//        equipamentoEntity.setTipoEquipamento(TipoEquipamentoDTO.dtoToEntity(dto.getTipoEquipamento()));
//        equipamentoEntity.setSituacao(SituacaoDTO.dtoToEntity(dto.getSituacao()));
        equipamentoEntity.setCodigo(dto.getCodigo());
        equipamentoEntity.setDescricao(dto.getDescricao());
        equipamentoEntity.setCapacidade(dto.getCapacidade());
        equipamentoEntity.setMenorValorDivisao(dto.getMenorValorDivisao());
        equipamentoEntity.setToleranciaEspecificada(dto.getToleranciaEspecificada());
        equipamentoEntity.setCampoTolerancia(dto.getCampoTolerancia());
        equipamentoEntity.setLimiteErro(dto.getLimiteErro());
        equipamentoEntity.setDataCompra(dto.getDataCompra());
        equipamentoEntity.setResponsavel(dto.getResponsavel());
        equipamentoEntity.setSecao(dto.getSecao());
        equipamentoEntity.setDataCadastro(dto.getDataCadastro());
        equipamentoEntity.setObservacao(dto.getObservacao());
        return equipamentoEntity;
    }



}
