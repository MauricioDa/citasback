package org.conocer.citas.service;

import org.conocer.citas.model.Catalogo;

import java.util.Date;
import java.util.List;

public interface CatalogoService {

    List<Catalogo> getCatalogo(String table, String columna);

    List<Catalogo> getHorario(Date fecha);
}
