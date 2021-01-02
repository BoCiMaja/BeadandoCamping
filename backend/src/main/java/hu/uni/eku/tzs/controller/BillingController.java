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
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bill")
@RequiredArgsConstructor
@Api(tags = "Bill")
@Slf4j
public class BillingController {
    private final BillingService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    BillRecordRequestDto request
    ){
        log.info("Recording of Bill ({},{},{},{},{},{},{})", request.getBillId(), request.getArrive(), request.getLeave(),
                request.getFirstName(), request.getSurName(), request.getNumberOfDays(), request.getTotalAmount());
        try {
            service.record(new Bill(
                    request.getBillId(),
                    request.getArrive(),
                    request.getLeave(),
                    request.getFirstName(),
                    request.getSurName(),
                    request.getNumberOfDays(),
                    request.getTotalAmount()));
        } catch (BillAlreadyExistsException e) {
            log.info("Bill ({},{},{},{},{},{},{}) is already exists! Message: {}", request.getBillId(), request.getArrive(), request.getLeave(),
                    request.getFirstName(), request.getSurName(), request.getNumberOfDays(), request.getTotalAmount(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Query Bill")
    public Collection<BillDto> query() {
        return service.readAll().stream().map(model ->
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

    @DeleteMapping(value = {"/{billId}"})
    @ApiOperation(value = "Delete a Guest")
    public void delete(@PathVariable Integer billId) {
        try {
            service.delete(billId);
        } catch (BillNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
