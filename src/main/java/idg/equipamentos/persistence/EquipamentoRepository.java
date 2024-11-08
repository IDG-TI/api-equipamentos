package idg.equipamentos.persistence;

import idg.equipamentos.entity.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, UUID> {

}

