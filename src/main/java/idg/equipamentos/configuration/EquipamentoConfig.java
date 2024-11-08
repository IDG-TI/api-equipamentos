package idg.equipamentos.configuration;

import idg.equipamentos.persistence.EquipamentoRepository;

import idg.equipamentos.service.EquipamentoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipamentoConfig {
    @Bean
    public EquipamentoService equipamentoService(EquipamentoRepository equipamentoRepository){
        return new EquipamentoService(equipamentoRepository);
    }

}
