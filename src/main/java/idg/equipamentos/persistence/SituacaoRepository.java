package idg.equipamentos.persistence;

import idg.equipamentos.entity.SituacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SituacaoRepository extends JpaRepository<SituacaoEntity, UUID> {
}
