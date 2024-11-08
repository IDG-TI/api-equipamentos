package idg.equipamentos.persistence;

import idg.equipamentos.entity.CalibracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalibracaoRepository extends JpaRepository<CalibracaoEntity, UUID> {
}
