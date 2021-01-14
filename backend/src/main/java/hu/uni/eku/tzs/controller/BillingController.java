package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.BillDto;
import hu.uni.eku.tzs.controller.dto.BillRecordRequestDto;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.BillingService;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.BillNotFoundException;
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
@RequestMapping(value = "/bill")
@RequiredArgsConstructor
@Api(tags = "Bill")
@Slf4j

public class BillingController {
    private final BillingService service;

    @GetMapping(value = {"/"},produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Query Bill")
    public Collection<BillDto> query(){
        return  service.readAll().stream().map(model ->
                BillDto.builder()
                        .billId(model.getBillId())
                        .arrive(model.getArrive())
                        .leave(model.getLeave())
                        .firstName(model.getFirstName())
                        .surName(model.getSurName())
                        .numberOfDays(model.getNumberOfDays())
                        .totalAmount(model.getTotalAmount())
                        .build()
        ).collect(Collectors.toList());
    }
    @PostMapping(value = {"/record"})
    @ApiOperation(value = "Record")
    public  void record(
            @RequestBody
                    BillRecordRequestDto request
    ){
        try {
            service.record(new Bill(request.getBillId(),request.getArrive(),request.getLeave(),
                    request.getFirstName(),request.getSurName(),request.getNumberOfDays(), request.getTotalAmount()));
        }catch (BillAlreadyExistsException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    /*@PutMapping(value = {"/{Foglalas_Id}"})
    @ApiOperation(value = "Foglalás frissítése")
    public  void update(@PathVariable UUID Foglalas_Id,@RequestBody FoglalasRecordRequestDto request )
    {
        try {
            service.update(Foglalas_Id, new Foglalas(request.getFoglalas_Id(),request.getCellaSzam(),
                    request.getErkezes(),request.getTavozas(),request.getVezeteknev(),request.getKeresztnev(),
                    request.getTelefonszam(), request.getTipus(), request.isAram()));
        }catch (FoglalasNotFoundException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }*/

    @DeleteMapping(value = {"/{billId}"})
    @ApiOperation(value = "Delete a Bill")
    public void delete(@PathVariable Integer billId)
    {
        try {
            service.delete(billId);
        }catch (BillNotFoundException e){
            throw  new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

}
