package fr.hermancia.exam.repository.digimon;

import fr.hermancia.exam.entity.digimon.Digimon;
import fr.hermancia.exam.repository.AbstractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DigimonRepository extends AbstractRepository<Digimon> {
    public DigimonRepository() {
        super("digimon"
                );
    }

    @Override
    protected Digimon update(Digimon object) {
        return null;
    }

    protected Digimon insert(Digimon object) {
        try {
            String query = "INSERT INTO digimon VALUES (null, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, object.getId());
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getImg());
            stmt.setString(3, object.getLevel());

            stmt.executeUpdate();
            // getGeneratedKeys = retourne l'id du dernier objet inséré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                // on le set à notre objet de retour
                object.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong during insert of a character: " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Digimon getObject(ResultSet rs) {
        Digimon digimon = new Digimon();
        try {
            digimon.setId(rs.getLong("id"));
            digimon.setName(rs.getString("name"));
            digimon.setImg(rs.getString("img"));
            digimon.setLevel(rs.getString("level"));

        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a character object : " + e.getMessage());
            digimon = null;
        }
        return digimon;
    }
}
