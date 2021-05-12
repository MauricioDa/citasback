package org.conocer.citas.dao;

import org.conocer.citas.dto.CitasDto;
import org.conocer.citas.model.Catalogo;
import org.conocer.citas.model.ResumenCitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class CitasDaoImpl extends JdbcDaoSupport implements CitasDao {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public void createCita(CitasDto request, String idMeet) {

        String sql = "insert into k_citas (nombre, empresa, id_estado, id_ocupacion, id_medio, descripcion_solicitud,email, fecha, id_hora, id_meet, fecha_registro) " +
                "values (?,?,?,?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
                request.getNombre(), request.getEmpresa(), request.getEntidad(), request.getOcupacion(), request.getMedio(), request.getDescripcion(), request.getEmail(),
                sumarDiasAFecha(request.getFecha(),1), request.getHorario(), idMeet, new Date()});


    }

    @Override
    public boolean eventExist(Date fecha, String hora) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("la fecha si existe es :" + fecha);
        Date date2 = sumarDiasAFecha(fecha,1);
        String date = formatter.format(date2);
        System.out.println("la con formato mas un día es: " + date);
        String sql = "select count(h.id) from k_citas c " +
                "right join c_horarios h on c.id_hora = h.id and c.fecha = ?" +
                "where c.id_hora = ? ";
        Integer existe = getJdbcTemplate().queryForObject(sql, new Object[]{date, hora}, Integer.class);

        return existe == 1 ? false : true;
    }

    @Override
    public List<ResumenCitas> resumenCitas() {
        String sql = " select c.nombre as nombre, c.empresa as empresa, e.entidades as entidaes, " +
                " o.ocupacion as ocupacion, m.medio as medio, c.descripcion_solicitud as descripcion, " +
                " c.email as email, c.fecha as fecha, h.horarios as horario, c.id_meet  as meet " +
                "from k_citas c " +
                "inner join c_horarios h on h.id = c.id_hora " +
                "inner join c_medios_conocer m on m.id = c.id_medio " +
                "inner join c_ocupacion_actual o on o.id = c.id_ocupacion " +
                "inner join c_entidades e on e.id = c.id_estado order by c.fecha asc";
        List<Map<String, Object>> rows =  getJdbcTemplate().queryForList(sql, new Object[]{});
        List<ResumenCitas> result = new ArrayList<ResumenCitas>();
        for(Map<String, Object> row:rows){
            ResumenCitas citas = new ResumenCitas();
            citas.setNombre((String)row.get("nombre"));
            citas.setEmpresa((String)row.get("empresa"));
            citas.setEstado((String)row.get("entidaes"));
            citas.setOcupacion((String)row.get("ocupacion"));
            citas.setMedio((String)row.get("medio"));
            citas.setDescripcion((String)row.get("descripcion"));
            citas.setEmail((String)row.get("email"));
            citas.setFecha((Date)row.get("fecha"));
            citas.setHora((String)row.get("horario"));
            citas.setMeet((String)row.get("meet"));

            result.add(citas);
        }

        return result;
    }


    public static Date sumarDiasAFecha(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

}
