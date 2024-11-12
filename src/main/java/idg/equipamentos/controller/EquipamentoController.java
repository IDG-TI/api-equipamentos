package idg.equipamentos.controller;

import idg.equipamentos.dto.EquipamentoDTO;
import idg.equipamentos.dto.TipoEquipamentoDTO;
import idg.equipamentos.entity.TipoEquipamentoEntity;
import idg.equipamentos.service.EquipamentoService;
import idg.equipamentos.service.TipoEquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/equipamentos")
public class EquipamentoController {
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    //   public List<TipoEquipamentoEntity> mostrarTipos(){
//        return tipoEquipamentoService.buscarTipos();
//   }
    @GetMapping
    public List<EquipamentoDTO> mostrarTipoEquipamento() {
        return equipamentoService.buscarEquipamentos();
    }






}
