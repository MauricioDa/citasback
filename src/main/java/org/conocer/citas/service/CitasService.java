package org.conocer.citas.service;

import org.conocer.citas.dto.CitasDto;
import org.conocer.citas.model.ResumenCitas;

import java.util.Date;
import java.util.List;

public interface CitasService {

    void createEvent(CitasDto request, String idMeet);

    boolean eventExists(Date fecha, String hora);

    List<ResumenCitas> getResumenCitas();
}
