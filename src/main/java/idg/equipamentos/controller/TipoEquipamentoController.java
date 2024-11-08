package idg.equipamentos.controller;

import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import idg.equipamentos.service.TipoEquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/tipo_equipamentos")
public class TipoEquipamentoController {
    private final TipoEquipamentoService tipoEquipamentoService;

    public TipoEquipamentoController(TipoEquipamentoService tipoEquipamentoService) {
        this.tipoEquipamentoService = tipoEquipamentoService;
    }

//   public List<TipoEquipamentoEntity> mostrarTipos(){
//        return tipoEquipamentoService.buscarTipos();
//   }
   @GetMapping ("/find")
   public List<TipoEquipamentoDTO> mostrarTipoEquipamento() {
        return tipoEquipamentoService.buscarTipos();
   }

    @PostMapping("/add")
    public TipoEquipamentoDTO addTipo(@RequestBody TipoEquipamentoDTO tipoEquipamentoDTO) {
        TipoEquipamentoDTO tipoEquipamentoSalvo = tipoEquipamentoService.addTipo(tipoEquipamentoDTO);
        return tipoEquipamentoSalvo;
    }



}
