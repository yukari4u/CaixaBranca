package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    // Metódo para conectar o banco de dados
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        }catch (Exception e) { }
        return conn; }
    public String nome=""; // Variável que armazena o nome retornado do banco
    public boolean result = false;
    // Método que verifica se existe um usuário com login e senha informados
    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // String que vai armazenar a consulta SQL
        Connection conn = conectarBD(); // Método de conexão
        // Consulta SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + " ' " + login + " ' ";
        sql += " and senha = " + " ' " + senha + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) { }
        // Retorna o resultado da verificação
        return result; }
}
