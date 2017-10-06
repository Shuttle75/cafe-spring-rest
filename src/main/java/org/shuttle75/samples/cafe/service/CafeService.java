package org.shuttle75.samples.cafe.service;

import org.shuttle75.samples.cafe.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CafeService {

    Page<Bill> findAllBills(Pageable pageable) throws DataAccessException;
    Bill findBillById(int id) throws DataAccessException;
    void saveBill(Bill bill) throws DataAccessException;
    void deleteBill(Bill bill) throws DataAccessException;

    List<BillItem> findAllBillItems() throws DataAccessException;
    List<BillItem> findBillItemsByBillId(int billId) throws DataAccessException;
    BillItem findBillItemById(int id) throws DataAccessException;
    void saveBillItem(BillItem billItem) throws DataAccessException;
    void deleteBillItem(BillItem billItem) throws DataAccessException;

    List<CafeTable> findAllCafeTables() throws DataAccessException;
    CafeTable findCafeTableById(int id) throws DataAccessException;

    List<Waiter> findAllWaiters() throws DataAccessException;
    Waiter findWaiterById(int id) throws DataAccessException;

    List<MenuGroup> findAllMenuGroups() throws DataAccessException;
    MenuGroup findMenuGroupById(int id) throws DataAccessException;

    List<MenuItem> findAllMenuItems() throws DataAccessException;
    List<MenuItem> findMenuItemsByMenuGroup(int id) throws DataAccessException;
    MenuItem findMenuItemById(int id) throws DataAccessException;
}
