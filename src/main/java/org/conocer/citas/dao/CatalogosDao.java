package org.conocer.citas.dao;

import org.conocer.citas.model.Catalogo;

import java.util.Date;
import java.util.List;

public interface CatalogosDao {

    List<Catalogo> getCat(String table, String columna);

    List<Catalogo> getHrs(Date fecha);

}
