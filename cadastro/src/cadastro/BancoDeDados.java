package cadastro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/cadastro?useSSL=false";
		String usuario = "root";
		String senha = "Aluno123";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		} 
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	
	}
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void listarContatos() {
		try {
			String query = "SELECT * FROM contato ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID: "+ this.resultset.getString("id") +"- NOME: "+ this.resultset.getString("nome") + "- TELEFONE: "+ this.resultset.getString("telefone") );
			}
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
	}
	public void inserirContato(String nome, String telefone) {
		try {
			String query = "INSERT INTO contato(nome,telefone) values ('"+nome+"','"+telefone+"');";
			//System.out.println(query);
			this.statement.executeUpdate(query);
			System.out.println("Contato inserido!");
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public void editarContato(String id, String nome, String telefone) {
		try {
			String query = "UPDATE contato SET nome = '"+nome+"', telefone = '"+telefone+"' where id = "+id+";";
			this.statement.executeUpdate(query);
			System.out.println("Contato editado!");
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public void deletarContato(String id) {
		try {
			String query = "DELETE FROM contato where id = "+id+";";
			this.statement.executeUpdate(query);
			System.out.println("Contato deletado!");
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public void desconectar() {
		try {
			this.connection.close();
			System.out.println("Programa encerrado!");
		}catch(Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}
	
}
