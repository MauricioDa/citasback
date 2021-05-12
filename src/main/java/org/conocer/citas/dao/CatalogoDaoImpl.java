package org.conocer.citas.dao;

import org.conocer.citas.model.Catalogo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogoDaoImpl extends JdbcDaoSupport implements CatalogosDao {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    @Override
    public List<Catalogo> getCat(String table, String columna) {
        String sql = "SELECT * FROM " + table;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Catalogo> result = new ArrayList<Catalogo>();
        for(Map<String, Object> row:rows){
            Catalogo ho = new Catalogo();
            ho.setId((int)row.get("id"));
            ho.setDescripcion((String)row.get(columna));
            result.add(ho);
        }

        return result;
    }

    @Override
    public List<Catalogo> getHrs(Date fecha) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("la fecha si existe es :" + fecha);
        Date date2 = sumarDiasAFecha(fecha,1);
        String date = formatter.format(date2);
        System.out.println("la con formato mas un día es: " + date);
        String sql = "select h.id, h.horarios from k_citas c " +
                "right join c_horarios h on c.id_hora = h.id and c.fecha = ? " +
                "where c.id_hora is null and h.status=1";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[]{date});
        List<Catalogo> result = new ArrayList<Catalogo>();
        for(Map<String, Object> row:rows){
            Catalogo ho = new Catalogo();
            ho.setId((int)row.get("id"));
            ho.setDescripcion((String)row.get("horarios"));
            result.add(ho);
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
