package idg.equipamentos.controller;

import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import idg.equipamentos.service.TipoEquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/v1/tipo_equipamentos")
public class TipoEquipamentoController {
    private final TipoEquipamentoService tipoEquipamentoService;

    public TipoEquipamentoController(TipoEquipamentoService tipoEquipamentoService) {
        this.tipoEquipamentoService = tipoEquipamentoService;
    }

   @GetMapping
   public List<TipoEquipamentoDTO> mostrarTipoEquipamento() {
        return tipoEquipamentoService.buscarTipos();
   }

    @PostMapping
    public TipoEquipamentoDTO addTipo(@RequestBody TipoEquipamentoDTO tipoEquipamentoDTO) {
        return tipoEquipamentoService.addTipo(tipoEquipamentoDTO);
    }
    @PutMapping ("/{uuid}")
    public TipoEquipamentoDTO atualizarItem(@PathVariable UUID uuid, @RequestBody TipoEquipamentoDTO tipoEquipamentoDto){
        return tipoEquipamentoService.atualizarTipo(uuid, tipoEquipamentoDto);
    }
    @DeleteMapping ("/{uuid}")
    public void delete(@PathVariable UUID uuid){
        tipoEquipamentoService.excluirTipo(uuid);
    }


}
