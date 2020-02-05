package org.shuttle75.samples.cafe.rest;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.shuttle75.samples.cafe.dto.BillDto;
import org.shuttle75.samples.cafe.model.QBill;
import org.shuttle75.samples.cafe.repository.BillRepository;
import org.shuttle75.samples.cafe.repository.CafeTableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.shuttle75.samples.cafe.model.Bill;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@RequestMapping("/api/bills")
public class BillRestController {

    @PersistenceContext
    private EntityManager entityManager;

    private final BillRepository billRepository;
    private final CafeTableRepository cafeTableRepository;

    private ModelMapper mapper = new ModelMapper();

    public BillRestController(BillRepository billRepository, CafeTableRepository cafeTableRepository) {
        this.billRepository = billRepository;
        this.cafeTableRepository = cafeTableRepository;
    }

    @GetMapping
    public Page<Bill> getBills(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @GetMapping("/{billId}")
    public Bill getBill(@PathVariable("billId") int billId) {
        return this.billRepository.findById(billId);
    }

    @PostMapping
    @Transactional
    public Bill addBill(@RequestBody @Valid Bill bill) {
        return this.billRepository.save(bill);
    }

    @PutMapping("/{billId}")
    @Transactional
    public Bill updateBill(@PathVariable("billId")  Bill bill) {
        return this.billRepository.save(bill);
    }

    @DeleteMapping("/{billId}")
    @Transactional(propagation= Propagation.MANDATORY)
    public void deleteBill(@PathVariable("billId") Bill bill) {
        this.billRepository.delete(bill);
    }

    @GetMapping("/qdsl")
    public Page<BillDto> getBillsQueryDSL(Pageable pageable) {

//        cafeTableRepository.findAll();

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(QBill.bill.id.gt(6));

        return billRepository.findAll(builder, pageable)
            .map(bill -> mapper.map(bill, BillDto.class));
    }

    @GetMapping("/qdsl2")
    public List<BillDto> getBillsQueryDSL2() {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        cafeTableRepository.findAll();

        return queryFactory
            .select(QBill.bill)
            .from(QBill.bill)
            .where(QBill.bill.id.lt(20))
            .orderBy(QBill.bill.id.asc())
            .fetch()
            .stream()
            .map(bill -> mapper.map(bill, BillDto.class))
            .collect(Collectors.toList());
    }

    @GetMapping("/qdsl3")
    public List<BillDto> getBillsQueryDSL3() {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        return queryFactory
            .select(QBill.bill)
            .from(QBill.bill)
            .where(QBill.bill.id.lt(20))
            .orderBy(QBill.bill.id.asc())
            .fetch()
            .stream()
            .map(bill -> mapper.map(bill, BillDto.class))
            .collect(Collectors.toList());
    }
}
