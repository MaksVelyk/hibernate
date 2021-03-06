package com.cookwarestore.service.impl;

import com.cookwarestore.database.ICookwareDAOI;
import com.cookwarestore.model.Cookware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cookwarestore.service.ICookwareServI;

import java.util.List;
import java.util.Optional;

@Service
public class CookwareServ implements ICookwareServI {

    @Autowired
    ICookwareDAOI cookwareDAO;

    public List<Cookware> getAllCookwares() {
        return this.cookwareDAO.getCookwares();
    }

    @Override
    public Cookware getCookwareById(int cookwareId) {
        Optional<Cookware> cookwareOptional = cookwareDAO.getCookwareById(cookwareId);

        if (cookwareOptional.isEmpty()) {
            return null;
        }

        return cookwareOptional.get();
    }

    public void updateCookware(Cookware cookware) {
        this.cookwareDAO.updateCookware(cookware);

    }
}
