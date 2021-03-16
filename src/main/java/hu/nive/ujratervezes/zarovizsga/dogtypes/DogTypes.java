package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DogTypes {

    private MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT name FROM dog_types WHERE country=? ORDER BY name;")) {
            stmt.setString(1, country.toUpperCase());
            return getDogsByCountry(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }

    private List<String> getDogsByCountry(PreparedStatement stmt) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String dogName = rs.getString(1);
                result.add(dogName.toLowerCase());
            }
        }
        return result;

    }
}

