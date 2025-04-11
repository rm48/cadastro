package testes;

import java.util.List;

import cadastro.modelo.beans.Cliente;
import cadastro.modelo.dao.ClienteDAO;

public class TesteInserir {
	public static void main(String[] args) {
/*	*/
		Cliente c = new Cliente();
		c.setNome("Belo Bono");
		c.setEndereco("Rua Vinhedo, 132");
		c.setCidade("Jacarezinho");
		c.setUf("PR");
		c.setCep("84000-890");
		c.setCpf("619.041.871-79");
		c.setEmail("belobono@email.com");
		c.setSexo("M");
		c.setBairro("Galo");
		c.setFone("(43) 9 9895-0780");
		
		ClienteDAO dao = new ClienteDAO();
		
//		dao.salvar(c);
		dao.alterar(c,false);
		System.out.println("Incluído.");
	
		
/*
		Cliente c = new Cliente();
		c.setId(5);	
		
		ClienteDAO dao = new ClienteDAO();
		dao.excluir(5);	
		System.out.println("Excluído.");
*/	
/*
		Cliente c = new Cliente();
		c.setId(6);	
		c.setNome("Juma Marriá");
		c.setEndereco("Rua Paloma, 69");
		c.setCidade("Cuiabá");
		c.setUf("MT");
		c.setCep("887600");
		c.setCpf("424.033.186-45");
		c.setEmail("juma@email.com");
		c.setSexo("F");
		c.setBairro("Morrinho");
		c.setFone("(26) 9 9099-6051");
		ClienteDAO dao = new ClienteDAO();
		//dao.alterar(c);	
		dao.alterar(c,true);
		System.out.println("Alterado.");
*/	
		
/*	
		Cliente c = new Cliente();
		ClienteDAO dao2 = new ClienteDAO();
		c = dao2.PesquisarPorId(2);
		System.out.println(c.getId()+" | "+c.getNome()+ " | "+c.getCpf());
*/
	
/*		
		ClienteDAO dao2 = new ClienteDAO();
		List<Cliente> lst = dao2.pesquisarPorNome("bor");
		for(Cliente cliente : lst) {
			System.out.println(cliente.getId()+" | "+cliente.getNome()+ " | "+cliente.getCpf());
		}
*/
		
/*		*/
		ClienteDAO dao2 = new ClienteDAO();
		List<Cliente> lst = dao2.listar();
		for(Cliente cliente : lst) {
//			System.out.println(cliente.getId()+" | "+cliente.getNome()+ " | "+cliente.getCpf());
			System.out.println(cliente);
		}

	}

}
