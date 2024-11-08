package idg.equipamentos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table (name = "calibracao_equipamento")
@Getter
@Setter

public class CalibracaoEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate dataUltimaCalibracao;

    private LocalDate dataProximaCalibracao;

    private Float numero;

    //add o que ta embaixo ai pae
    private String codigoFornecedor;

    private String responsavelLaudo;
}
