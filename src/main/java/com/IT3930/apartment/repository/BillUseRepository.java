package com.IT3930.apartment.repository;

import com.IT3930.apartment.model.bill.Bill;
import com.IT3930.apartment.model.bill.BillUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillUseRepository extends JpaRepository<BillUse, Long> {
    List<BillUse> findByBill(Bill bill);
}
