package idg.equipamentos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table (name = "frequencia_calibracao_equipamento")
@Data
public class FrequenciaCalibracaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column (name = "frequencia_calibracao_equipamento_id")
    private UUID id;

    private String frequenciaCalibracao;
    private LocalDateTime dataCadastro;





}
