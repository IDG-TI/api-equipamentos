package idg.equipamentos.configuration;

import idg.equipamentos.persistence.TipoEquipamentoRepository;
import idg.equipamentos.service.SituacaoService;
import idg.equipamentos.service.TipoEquipamentoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoEquipamentoConfig {
    @Bean
    public TipoEquipamentoService tipoEquipamentoService(TipoEquipamentoRepository tipoEquipamentoRepository){
        return new TipoEquipamentoService(tipoEquipamentoRepository);
    }

}