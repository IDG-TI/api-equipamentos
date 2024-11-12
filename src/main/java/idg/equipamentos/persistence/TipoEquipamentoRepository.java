package idg.equipamentos.persistence;

import idg.equipamentos.entity.SituacaoEntity;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TipoEquipamentoRepository extends JpaRepository<TipoEquipamentoEntity, UUID> {

    Boolean existsByDataCadastro(LocalDateTime data);
    Boolean existsByNome(String nome);
    Boolean existsBySigla(String sigla);
}
