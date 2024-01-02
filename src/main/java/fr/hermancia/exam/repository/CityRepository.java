package fr.hermancia.exam.repository;

import fr.hermancia.exam.entity.City;
import fr.hermancia.exam.entity.Region;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepository extends AbstractRepository<City> {

    private static CityRepository instance;

    public CityRepository() {
        super("city");
    }

    public static CityRepository getRepository() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    @Override
    protected City update(City object) {
        return null;
    }

    @Override
    protected City insert(City object) {
        return null;
    }

    @Override
    protected City getObject(ResultSet rs) {
        City city = new City();
        try {
            city.setId(rs.getLong("id"));
            city.setName(rs.getString("name"));
            city.setSiren(rs.getString("siren"));
            city.setCode(rs.getString("code"));
            city.setPopulation(rs.getInt("population"));


        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a city object : " + e.getMessage());
            city = null;
        }
        return city;
    }

    public  City findCitiesByDepartment(){
        return null;
    }
}
