import java.sql.*;

public class Test_MySQL {
    public static String server = "localhost";
    public static String port = "3306";
    public static String database = "sakila"; // Remplace par ta base (ex: esp_database)
    public static String user = "root";       // Remplace par ton utilisateur (ex: esp)
    public static String password = "MotDePasse#2026"; // Ton mot de passe
    public static String url = "jdbc:mysql://" + server + ":" + port + "/" + database;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie à la base de données !");

            String sql = "SELECT * FROM actor"; // Adapte selon une table existante chez toi
            PreparedStatement ps = connection.prepareStatement(sql);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("Liste des éléments :");
                while (rs.next()) {
                    System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
