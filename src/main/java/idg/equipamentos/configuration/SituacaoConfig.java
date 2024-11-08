package idg.equipamentos.configuration;

import idg.equipamentos.persistence.SituacaoRepository;
import idg.equipamentos.service.SituacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SituacaoConfig {
    @Bean
    public SituacaoService situacaoService(SituacaoRepository situacaoRepository){
        return new SituacaoService(situacaoRepository);
    }
}
