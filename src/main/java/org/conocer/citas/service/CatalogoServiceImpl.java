package org.conocer.citas.service;

import org.conocer.citas.dao.CatalogosDao;
import org.conocer.citas.model.Catalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    CatalogosDao catalogosDao;

    @Override
    public List<Catalogo> getCatalogo(String table, String columna) {
        return catalogosDao.getCat(table, columna);
    }

    @Override
    public List<Catalogo> getHorario(Date fecha) {
        return catalogosDao.getHrs(fecha);
    }
}
