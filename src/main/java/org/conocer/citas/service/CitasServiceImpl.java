package org.conocer.citas.service;

import org.conocer.citas.dao.CitasDao;
import org.conocer.citas.dto.CitasDto;
import org.conocer.citas.model.ResumenCitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    CitasDao citasDao;

    @Override
    public void createEvent(CitasDto request, String idMeet) {
        citasDao.createCita(request, idMeet);
    }

    @Override
    public boolean eventExists(Date fecha, String hora) {
        return citasDao.eventExist(fecha, hora);
    }

    @Override
    public List<ResumenCitas> getResumenCitas() {
        return citasDao.resumenCitas();
    }
}
