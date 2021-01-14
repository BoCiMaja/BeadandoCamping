package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
@Service
public class BillingDaoImpl implements BillingDao {
    private final BillingRepository repository;

    @Override
    public void create(Bill bill) {
        repository.save(BillingEntityModelConverter.model2entity(bill));
    }

    @Override
    public Collection<Bill> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> BillingEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer billId, Bill updated) {
        hu.uni.eku.tzs.dao.entity.Bill temp = repository.findByBillId(billId);
        temp.setBillId(updated.getBillId());
        temp.setArrive(updated.getArrive());
        temp.setLeave(updated.getLeave());
        temp.setFirstName(updated.getFirstName());
        temp.setSurName(updated.getSurName());
        temp.setNumberOfDays(updated.getNumberOfDays());
        temp.setTotalAmount(updated.getTotalAmount());
        repository.save(temp);
    }

    @Override
    public void delete(Integer billId) {
        hu.uni.eku.tzs.dao.entity.Bill temp = repository.findByBillId(billId);
        if(temp != null)
            repository.delete(temp);
    }

    private static class BillingEntityModelConverter{

        private static Bill entity2model(hu.uni.eku.tzs.dao.entity.Bill entity){
            return new Bill(
                    entity.getBillId(),
                    entity.getArrive(),
                    entity.getLeave(),
                    entity.getFirstName(),
                    entity.getSurName(),
                    entity.getNumberOfDays(),
                    entity.getTotalAmount()

            );
        }

        private static hu.uni.eku.tzs.dao.entity.Bill model2entity(Bill model){
            return hu.uni.eku.tzs.dao.entity.Bill.builder()
                    .billId(model.getBillId())
                    .arrive(model.getArrive())
                    .leave(model.getLeave())
                    .firstName(model.getFirstName())
                    .surName(model.getSurName())
                    .numberOfDays(model.getNumberOfDays())
                    .totalAmount(model.getTotalAmount())
                    .build();
        }

    }
}