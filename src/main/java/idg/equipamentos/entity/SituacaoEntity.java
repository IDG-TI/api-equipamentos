package idg.equipamentos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table (name = "situacao_equipamento")
@Getter
@Setter
public class SituacaoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "situacao_equipamento_id")
    private UUID id;

    private String nome;

    // isso add tbm
    private LocalDateTime dataCadastro;


}
