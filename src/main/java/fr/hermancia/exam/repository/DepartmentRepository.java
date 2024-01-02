package fr.hermancia.exam.repository;

import fr.hermancia.exam.entity.Department;
import fr.hermancia.exam.entity.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository extends AbstractRepository<Department> {

    private static DepartmentRepository instance;
    public DepartmentRepository() {
        super("department");
    }

    public static DepartmentRepository getRepository() {
        if (instance == null) {
            instance = new DepartmentRepository();
        }
        return instance;
    }
    @Override
    protected Department update(Department object) {
        return null;
    }



        public List<Department> findDepartmentsByRegion(Region region) {
            List<Department> departments = new ArrayList<>();

            try {

                if (connection != null) {
                    String query = "SELECT * FROM department WHERE region = ?";
                    PreparedStatement stmt = connection.prepareStatement(query);


                    stmt.setObject(1, region.getName()); //

                    // Execute the query and retrieve the results
                    ResultSet resultSet = stmt.executeQuery();

                    while (resultSet.next()) {
                        Department department = new Department();
                        department.setId((long) resultSet.getLong("id"));
                        department.setName(resultSet.getString("name"));
                        department.setCode(resultSet.getString("code"));

                        // Add the department to the list
                        departments.add(department);
                    }

                    // Close resources
                    resultSet.close();
                    stmt.close();
                }
            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }

            return departments;
        }



    @Override
    protected Department insert(Department object) {
        return null;
    }



        public int findPopulationByDepartment(Department department) {
            int population = 0;

            try {

                if (connection != null) {
                    String query = "SELECT SUM(population) FROM city WHERE department_id = ?";
                    PreparedStatement stmt = connection.prepareStatement(query);


                    stmt.setObject(1, department.getId()); // Assumption: 'getId()' is the method to get the department ID


                    ResultSet resultSet = stmt.executeQuery();

                    if (resultSet.next()) {
                        population = resultSet.getInt(1);
                    }


                    resultSet.close();
                    stmt.close();
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }

            return population;
        }







    public  Department findPopulationByDepartment(){
        return null;
    }
    @Override
    protected Department getObject(ResultSet rs) {
        Department department = new Department();
        try {
            department.setId(rs.getLong("id"));
            department.setName(rs.getString("name"));
            department.setCode(rs.getString("code"));

        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Department object : " + e.getMessage());
            department = null;
        }
        return department;
    }
}
