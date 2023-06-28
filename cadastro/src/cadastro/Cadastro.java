package cadastro;


public class Cadastro {

	public static void main(String[] args) {
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			bancoDeDados.listarContatos();
			//bancoDeDados.inserirContato("Fulano","12987654321");
			//bancoDeDados.editarContato("1", "Pablo", "85997037781");
			//bancoDeDados.deletarContato("2");
			bancoDeDados.desconectar();
		}
		else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}

	}

}
