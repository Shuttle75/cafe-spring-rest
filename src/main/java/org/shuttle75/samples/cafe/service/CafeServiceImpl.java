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
import org.shuttle75.samples.cafe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 * @author Vitaliy Fedoriv
 */
@Service

public class CafeServiceImpl implements CafeService {

    private BillRepository billRepository;
    private BillItemRepository billItemRepository;
    private CafeTableRepository cafeTableRepository;
    private WaiterRepository waiterRepository;
    private MenuGroupRepository menuGroupRepository;
    private MenuItemRepository menuItemRepository;

    @Autowired
     public CafeServiceImpl(
            BillRepository billRepository,
            BillItemRepository billItemRepository,
            CafeTableRepository cafeTableRepository,
            WaiterRepository waiterRepository,
            MenuGroupRepository menuGroupRepository,
            MenuItemRepository menuItemRepository) {
        this.billRepository = billRepository;
        this.billItemRepository = billItemRepository;
        this.cafeTableRepository = cafeTableRepository;
        this.waiterRepository = waiterRepository;
        this.menuGroupRepository = menuGroupRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
	@Transactional(readOnly = true)
	public Page<Bill> findAllBills(Pageable pageable) throws DataAccessException {
		return billRepository.findAll(pageable);
	}

    @Override
    @Transactional(readOnly = true)
    public Bill findBillById(int id) throws DataAccessException {
        Bill bill = null;
        try {
            bill = billRepository.findById(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return bill;
    }

    @Override
    @Transactional
    public void saveBill(Bill bill) throws DataAccessException {
        billRepository.save(bill);
    }

    @Override
	@Transactional
	public void deleteBill(Bill bill) throws DataAccessException {
        billRepository.delete(bill);
	}



    @Override
    @Transactional(readOnly = true)
    public List<BillItem> findAllBillItems() throws DataAccessException {
        return billItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BillItem> findBillItemsByBillId(int billId) throws DataAccessException {
        List<BillItem> itemCollection = null;
        try {
            itemCollection = billItemRepository.findByBillId(billId);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return itemCollection;
    }

    @Override
    @Transactional(readOnly = true)
    public BillItem findBillItemById(int id) throws DataAccessException {
        BillItem billItem = null;
        try {
            billItem = billItemRepository.findById(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return billItem;
    }

    @Override
    @Transactional
    public void saveBillItem(BillItem billItem) throws DataAccessException {
        billItemRepository.save(billItem);
    }

    @Override
    @Transactional
    public void deleteBillItem(BillItem billItem) throws DataAccessException {
        billItemRepository.delete(billItem);
    }


    @Override
    @Transactional(readOnly = true)
    public List<CafeTable> findAllCafeTables() throws DataAccessException {
        return cafeTableRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CafeTable findCafeTableById(int id) throws DataAccessException {
        CafeTable cafeTable = null;
        try {
            cafeTable = cafeTableRepository.findById(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return cafeTable;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Waiter> findAllWaiters() throws DataAccessException {
        return waiterRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Waiter findWaiterById(int id) throws DataAccessException {
        Waiter waiter = null;
        try {
            waiter = waiterRepository.findById(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return waiter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuGroup> findAllMenuGroups() throws DataAccessException {
        return menuGroupRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MenuGroup findMenuGroupById(int id) throws DataAccessException {
        MenuGroup menuGroup = null;
        try {
            menuGroup = menuGroupRepository.findById(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return menuGroup;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItem> findAllMenuItems() throws DataAccessException {
        return menuItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItem> findMenuItemsByMenuGroup(int id) throws DataAccessException {
        List<MenuItem> menuItemList = null;
        try {
            menuItemList = menuItemRepository.findByMenuGroupId(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return menuItemList;
    }

    @Override
    @Transactional(readOnly = true)
    public MenuItem findMenuItemById(int id) throws DataAccessException {
        MenuItem menuItem = null;
        try {
            menuItem = menuItemRepository.findById(id);
        } catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return menuItem;
    }

}
