package idg.equipamentos.persistence;

import idg.equipamentos.entity.EmprestimoEntity;
import idg.equipamentos.entity.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, UUID> {

}
