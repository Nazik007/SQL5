import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabasePopulateService {
    private static PreparedStatement insertStWorker;
    private static PreparedStatement insertStClient;
    private static PreparedStatement insertStProject;
    private static PreparedStatement insertStProjectWorker;

    public static boolean createWorker(String name, LocalDate birthday, Level level, int salary) {
        try {
            insertStWorker.setString(1, name);
            insertStWorker.setString(2, birthday.toString());
            insertStWorker.setString(3, level.name());
            insertStWorker.setInt(4, salary);
            return insertStWorker.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createClient(String name) {
        try {
            insertStClient.setString(1, name);
            return insertStClient.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createProject(int client_id, LocalDate start_date, LocalDate finish_date) {
        try {
            insertStProject.setInt(1, client_id);
            insertStProject.setString(2, start_date.toString());
            insertStProject.setString(3, finish_date.toString());
            return insertStProject.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createProjectWorker(int project_id, int worker_id) {
        try {
            insertStProjectWorker.setInt(1, project_id);
            insertStProjectWorker.setInt(2, worker_id);

            return insertStProjectWorker.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException, SQLException {
        String sqlWorker = "INSERT INTO worker (name, birthday, level, salary) VALUES(?, ?, ?, ?)";
        String sqlClient = "INSERT INTO client (name) VALUES(?)";
        String sqlProject = "INSERT INTO project (client_id, start_date, finish_date) VALUES(?, ?, ?)";
        String sqlProjectWorker = "INSERT INTO project_worker (project_id, worker_id) VALUES(?, ?)";

        Database database = Database.getInstance();

        Connection connection = database.getConnection();
        insertStWorker = connection.prepareStatement(sqlWorker);
        insertStClient = connection.prepareStatement(sqlClient);
        insertStProject = connection.prepareStatement(sqlProject);
        insertStProjectWorker = connection.prepareStatement(sqlProjectWorker);
        createWorker("Ivan", LocalDate.parse("1970-03-04"), Level.Senior, 8000);
        createWorker("Ben", LocalDate.parse("1920-04-10"), Level.Senior, 8000);
        createWorker("Stiven", LocalDate.parse("2001-06-08"), Level.Middle, 4000);
        createWorker("Ken", LocalDate.parse("1973-01-18"), Level.Middle, 5000);
        createWorker("Anna", LocalDate.parse("1996-10-28"), Level.Middle, 4500);
        createWorker("Rina", LocalDate.parse("2001-05-03"), Level.Junior, 880);
        createWorker("Vlad", LocalDate.parse("1975-05-16"), Level.Junior, 950);
        createWorker("Tom", LocalDate.parse("1995-08-02"), Level.Junior, 459);
        createWorker("Taras", LocalDate.parse("2001-08-06"), Level.Junior, 850);
        createWorker("Shon", LocalDate.parse("2001-03-04"), Level.Junior, 800);

        createClient("Oleg");
        createClient("Masha");
        createClient("Zarina");
        createClient("Jonson");
        createClient("Harry");
        createClient("Germiona");

        createProject(6, LocalDate.parse("2019-06-06"), LocalDate.parse("2020-04-08"));
        createProject(4, LocalDate.parse("2020-09-21"), LocalDate.parse("2021-01-04"));
        createProject(4, LocalDate.parse("2022-08-16"), LocalDate.parse("2022-12-11"));
        createProject(3, LocalDate.parse("2021-07-14"), LocalDate.parse("2022-02-02"));
        createProject(5, LocalDate.parse("2020-02-01"), LocalDate.parse("2020-03-02"));
        createProject(2, LocalDate.parse("2022-10-05"), LocalDate.parse("2022-12-16"));
        createProject(1, LocalDate.parse("2002-02-07"), LocalDate.parse("2019-01-16"));
        createProject(5, LocalDate.parse("2018-04-24"), LocalDate.parse("2019-08-04"));
        createProject(2, LocalDate.parse("2022-04-08"), LocalDate.parse("2022-07-09"));
        createProject(6, LocalDate.parse("2020-03-18"), LocalDate.parse("2020-08-18"));
        createProject(3, LocalDate.parse("2022-05-17"), LocalDate.parse("2022-06-18"));

        createProjectWorker(1, 1);
        createProjectWorker(1, 3);
        createProjectWorker(1, 6);
        createProjectWorker(1, 7);
        createProjectWorker(2, 2);
        createProjectWorker(2, 4);
        createProjectWorker(2, 8);
        createProjectWorker(2, 10);
        createProjectWorker(3, 1);
        createProjectWorker(3, 5);
        createProjectWorker(3, 11);
        createProjectWorker(4, 2);
        createProjectWorker(4, 3);
        createProjectWorker(4, 6);
        createProjectWorker(5, 10);
        createProjectWorker(5, 11);
        createProjectWorker(6, 2);
        createProjectWorker(7, 3);
        createProjectWorker(7, 4);
        createProjectWorker(7, 5);
        createProjectWorker(7, 6);
        createProjectWorker(7, 7);
        createProjectWorker(8, 4);
        createProjectWorker(8, 7);
        createProjectWorker(8, 8);
        createProjectWorker(9, 4);
        createProjectWorker(9, 5);
        createProjectWorker(10, 2);
        createProjectWorker(10, 7);
        createProjectWorker(10, 8);

    }
}
