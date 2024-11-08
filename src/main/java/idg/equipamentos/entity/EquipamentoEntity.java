package idg.equipamentos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "equipamento")
@Data
public class EquipamentoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column (name = "equipamento_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "tipo_equipamento_id")
    private TipoEquipamentoEntity tipoEquipamento;

    private String codigo;
    //Certeza?
//    private Integer frequenciaCalibracao;
    private String descricao;
    private String capacidade;
    private String menorValorDivisao;
    private String toleranciaEspecificada;
    @ManyToOne
    @JoinColumn(name = "situaco_equipamento_id")
    private SituacaoEntity situacao;

    private String campoTolerancia;
    private String limiteErro;
    private LocalDate dataCompra;
    private String responsavel;
    private String secao;
    private LocalDate dataCadastro;
    private String observacao;


//    @JoinColumn(name = "calibracao_equipamento_id")
//    private CalibracaoEntity calibracao;


}
