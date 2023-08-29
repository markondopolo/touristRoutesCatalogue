package app.dao;

import app.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RouteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Route getRouteById(int id) {
        return jdbcTemplate.query("SELECT * FROM Routes WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Route.class))
                .stream().findAny().orElse(null);
    }

    public List<Route> getAllRoutes() {
        return jdbcTemplate.query("SELECT * FROM Routes", new BeanPropertyRowMapper<>(Route.class));
    }

    public void insertNewRoute(Route route) {
        jdbcTemplate.update("INSERT INTO Routes (routeDescription, price, grade) VALUES (?,?,?)", route.getRouteDescription(), route.getPrice(), route.getGrade());
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE from Routes WHERE id=?", id);
    }

    public void update(int id, Route updatedRoute) {
        jdbcTemplate.update("update Routes  SET  routeDescription=?, price=?, grade=? where  id=?",
                updatedRoute.getRouteDescription(), updatedRoute.getPrice(), updatedRoute.getGrade(), id);
    }
}
