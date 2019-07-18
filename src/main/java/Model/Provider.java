package Model;

public interface Provider {
    String userName ="root";
    String password = "mysqltest";
    //String connectionUrl = "jdbc:mysql://127.0.0.1:3306/SmartFoto";
    String connectionUrl = "jdbc:mysql://localhost/SmartFoto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
}
