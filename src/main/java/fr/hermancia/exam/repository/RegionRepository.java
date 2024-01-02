package fr.hermancia.exam.repository;

import fr.hermancia.exam.entity.City;
import fr.hermancia.exam.entity.Department;
import fr.hermancia.exam.entity.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RegionRepository extends AbstractRepository<Region> {

    private static RegionRepository instance;

    public RegionRepository() {
        super("region");
    }

    public static RegionRepository getRepository() {
        if (instance == null) {
            instance = new RegionRepository();
        }
        return instance;
    }


//    protected Region findPopulationByRegion() {


//        List<Country> countries = cr.findBy(null, 5, null);
//        for (Country c : countries) {
//            Dump.dump(c);
//        }

//    }



        public int findPopulationByRegion(Region region) {
            int population = 0;

            try {

                if (connection != null) {
                    String query = "SELECT SUM(population) FROM city INNER JOIN department ON city.department_id = department.id WHERE department.region = ?";
                    PreparedStatement stmt = connection.prepareStatement(query);


                    stmt.setObject(1, region.getName()); // Assumption: 'getName()' is the method to get the region name

                    // Execute the query and retrieve the result
                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        population = resultSet.getInt(1);
                    }

                    // Close resources
                    resultSet.close();
                    stmt.close();
                }
            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }

            return population;
        }


    public Region findCitiesByRegion(){
        return null;
    }

    @Override
    protected Region update(Region object) {
        return null;
    }

    @Override
    protected Region insert(Region object) {
        return null;
    }

    @Override
    protected Region getObject(ResultSet rs) {
        Region region = new Region();
        try {
            region.setId(rs.getLong("id"));
            region.setName(rs.getString("name"));
            region.setCode(rs.getString("image"));

        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Region object : " + e.getMessage());
            region = null;
        }
        return region;
    }


}

