package idg.equipamentos.persistence;

import idg.equipamentos.entity.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, UUID> {
    @Query("SELECT e FROM EquipamentoEntity e WHERE e.identificacao LIKE :prefixo ORDER BY e.identificacao DESC")
    List<EquipamentoEntity> findLastByPrefixo(@Param("prefixo") String prefixo);
}

