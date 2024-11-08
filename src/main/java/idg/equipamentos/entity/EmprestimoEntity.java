package idg.equipamentos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "emprestimo_equipamento")
@Getter
@Setter
public class EmprestimoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private String nomeResponsavel;

    private String secao;

    private LocalDate dataCadastro;

//    private List<EquipamentoEntity> equipamentosEmprestimo;

    private String observacao;
}
