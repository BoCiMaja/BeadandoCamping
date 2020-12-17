package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.CellaDto;
import hu.uni.eku.tzs.controller.dto.CellaRecordRequestDto;
import hu.uni.eku.tzs.model.Cella;
import hu.uni.eku.tzs.service.CellaService;
import hu.uni.eku.tzs.service.exceptions.CellaAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.CellaNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cella")
@RequiredArgsConstructor
@Api(tags = "Cella")
@Slf4j

public class CellaController {
    private final CellaService service;

    @GetMapping(value = {"/"},produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Keresd meg a cellat")
    public Collection<CellaDto>fetchAll(){
        return  service.fetchAll().stream().map(cella -> CellaDto.builder()
                .cellaId(cella.getCellaId())
                .allapot(cella.isAllapot())
                .build()
        ).collect(Collectors.toList());
    }
    @PostMapping(value = {"/create"})
    @ApiOperation(value = "cella létrehozása")
    public void create(@RequestBody CellaRecordRequestDto request){
        try {
            service.create(new Cella(request.getCellaId(),request.isAllapot()));
        }catch (CellaAlreadyExistsException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
    @PutMapping(value = {"/{CellaId}"})
    @ApiOperation(value = "Cella frissítése")
    public  void update(@PathVariable UUID CellaId, @RequestBody CellaRecordRequestDto request )
    {
        try {
            service.update(CellaId, new Cella(request.getCellaId(),request.isAllapot()));
        }catch (CellaNotFoundException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
    @DeleteMapping(value = {"/{CellaId}"})
    @ApiOperation(value = "Cella törlése")
    public void delete(@PathVariable UUID CellaId)
    {
        try {
            service.delete(CellaId);
        }catch (CellaNotFoundException e){
            throw  new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

}
/*
@RestController
@RequestMapping(value = "/cella")

@Api(tags = "Cella")
@Slf4j
public class CellaController
{
    private final CellaService service;

    public CellaController(CellaService service) {
        this.service = service;
    }

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    CellaRecordRequestDto request
    ){
        log.info("Recording of Cella ({},{},{},{},{},{},{},{})",
                request.getCellaId(), request.getAllapot() ? "Foglalt" : "Szabad",
                request.getErkezes(), request.getErkezes(), request.getVezeteknev(), request.getKeresztnev(),
                request.getAram(), request.getTipus());
        try {
            service.record(new Cella(request.getCellaId(), request.getAllapot(),
                    request.getErkezes(), request.getErkezes(), request.getVezeteknev(), request.getKeresztnev(),
                    request.getAram(), request.getTipus()));
        } catch (CellaAlreadyExistsException e) {
            log.info("Cella ({},{},{},{},{},{},{},{}) is already exists! Message: {}",
                    request.getCellaId(), request.getAllapot() ? "Foglalt" : "Szabad", request.getErkezes(),
                    request.getErkezes(), request.getVezeteknev(), request.getKeresztnev(),
                    request.getAram(), request.getTipus(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Cella")
    public Collection<CellaDto> query(){
        return service.readAll().stream().map(model ->
                CellaDto.builder()
                        .cella_id(model.getCellaId())
                        .allapot(model.getAllapot())
                        .erkezes(model.getErkezes())
                        .tavozas(model.getTavozas())
                        .vezeteknev(model.getVezeteknev())
                        .keresztnev(model.getKeresztnev())
                        .aram(model.getAram())
                        .tipus(model.getTipus())
                        .build()
        ).collect(Collectors.toList());
    }

}
*/