package idg.equipamentos.controller;

import idg.equipamentos.dto.FrequenciaCalibracaoDTO;
import idg.equipamentos.dto.SituacaoDTO;
import idg.equipamentos.service.FrequenciaCalibracaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/v1/frequencia_calibracao")
public class FrequenciaCalibracaoController {
    public final FrequenciaCalibracaoService frequenciaCalibracaoService;

    public FrequenciaCalibracaoController(FrequenciaCalibracaoService frequenciaCalibracaoService) {
        this.frequenciaCalibracaoService = frequenciaCalibracaoService;
    }

    @GetMapping
    public List<FrequenciaCalibracaoDTO> mostrarFrequencia(){
        return frequenciaCalibracaoService.buscarFrequencia();
    }

    @PostMapping
    public FrequenciaCalibracaoDTO cadastrarFrequencia(@RequestBody FrequenciaCalibracaoDTO frequenciaCalibracaoDTO){
        return frequenciaCalibracaoService.addFrequencia(frequenciaCalibracaoDTO);
    }

    @PutMapping("/{uuid}")
    public FrequenciaCalibracaoDTO atualizarFrequencia(@PathVariable UUID uuid, @RequestBody FrequenciaCalibracaoDTO frequenciaCalibracaoDTO){
        return frequenciaCalibracaoService.atualizarFrequencia(uuid, frequenciaCalibracaoDTO);
    }

    @DeleteMapping ("/{uuid}")
    public void deleteFrequencia(@PathVariable UUID uuid){
        frequenciaCalibracaoService.excluirFrequencia(uuid);
    }

}
