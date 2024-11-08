package idg.equipamentos.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table (name = "tipo_equipamento")
public class TipoEquipamentoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "tipo_equipamento_id")
    private UUID id;
    private String sigla;
    private String nome;
    private LocalDateTime dataCadastro;

}
