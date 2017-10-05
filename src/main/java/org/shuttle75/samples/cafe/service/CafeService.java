/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.shuttle75.samples.cafe.service;

import org.shuttle75.samples.cafe.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Michael Isvy
 * @author Vitaliy Fedoriv
 */
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
