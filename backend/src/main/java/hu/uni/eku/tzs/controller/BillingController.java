package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.BillDto;
import hu.uni.eku.tzs.controller.dto.BillRecordRequestDto;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.BillingService;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
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
@RequestMapping(value = "/Bill")
@RequiredArgsConstructor
@Api(tags = "Bills")
@Slf4j
public class BillingController {
    private final BillingService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    BillRecordRequestDto request
    ){
        try {
            service.record(new Bill(request.getArrive(),
                    request.getLeave(),
                    request.getFirstName(),
                    request.getSurName(),
                    request.getNumberOfDays(),
                    request.getTotalAmount()));
        } catch (BillAlreadyExistsException e) {
            log.info("Bill is already exists! Message: {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Query Billing Information")
    public Collection<BillDto> query()

    {
        return service.readAll().stream().map(model ->
                BillDto.builder()
                        .arrive(model.getArrive())
                        .leave(model.getLeave())
                        .firstName(model.getFirstName())
                        .surName(model.getSurName())
                        .numberOfDays(model.getNumberOfDays())
                        .totalAmount(model.getTotalAmount())
                        .build()
        ).collect(Collectors.toList());
    }
}
