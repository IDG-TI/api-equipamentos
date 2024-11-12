package idg.equipamentos.configuration;


import idg.equipamentos.persistence.FrequenciaCalibracaoRepository;
import idg.equipamentos.persistence.SituacaoRepository;
import idg.equipamentos.service.FrequenciaCalibracaoService;
import idg.equipamentos.service.SituacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FrequenciaCalibracaoConfig {
    @Bean
    public FrequenciaCalibracaoService frequenciaCalibracaoService(FrequenciaCalibracaoRepository frequenciaCalibracao){
        return new FrequenciaCalibracaoService(frequenciaCalibracao);
    }
}
