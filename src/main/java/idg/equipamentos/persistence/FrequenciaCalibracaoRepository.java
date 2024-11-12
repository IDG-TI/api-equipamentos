package idg.equipamentos.persistence;

import idg.equipamentos.entity.FrequenciaCalibracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FrequenciaCalibracaoRepository extends JpaRepository<FrequenciaCalibracaoEntity, UUID> {
    Boolean existsByFrequenciaCalibracao(String frequenciaCalibracao);
}
