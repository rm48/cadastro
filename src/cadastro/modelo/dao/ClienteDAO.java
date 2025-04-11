package cadastro.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import cadastro.modelo.beans.Cliente;
import cadastro.util.Conexao;

public class ClienteDAO {
	private Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public ClienteDAO() {
		this.con = Conexao.getConexao();
	}

	public boolean alterar(Cliente cliente, boolean comandoSql) {
		String sql0 = "INSERT INTO cliente (nome,endereco,cidade,uf,cep,cpf,email,sexo,bairro,fone) value(?,?,?,?,?,?,?,?,?,?)";
		String sql1 = "UPDATE cliente SET nome=?,endereco=?,cidade=?,uf=?,cep=?,cpf=?,email=?, sexo=?, bairro=?, fone=? where id_cliente=? ";
		try {
			int i = 0;	
			stmt = con.prepareStatement(comandoSql ? sql1 : sql0);
			stmt.setString(++i, cliente.getNome());
			stmt.setString(++i, cliente.getEndereco());
			stmt.setString(++i, cliente.getCidade());
			stmt.setString(++i, cliente.getUf());
			stmt.setString(++i, cliente.getCep());
			stmt.setString(++i, cliente.getCpf());
			stmt.setString(++i, cliente.getEmail());
			stmt.setString(++i, cliente.getSexo());
			stmt.setString(++i, cliente.getBairro());
			stmt.setString(++i, cliente.getFone());
			if (comandoSql)
				stmt.setInt(++i, cliente.getId());
			stmt.execute();
			stmt.close();
			con.close();			
			return true;
		} catch (SQLException e) {
//			throw new RuntimeException(e);
			return false;
		}
	}

	public void excluir(int id) {
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente=?");
			stmt.setInt(1, id);
			;
			stmt.execute();

			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> listar() {
		List<Cliente> lst = new ArrayList<Cliente>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cliente");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setEndereco(rs.getString(3));
				cliente.setCidade(rs.getString(4));
				cliente.setUf(rs.getString(5));
				cliente.setCep(rs.getString(6));
				cliente.setCpf(rs.getString(7));
				cliente.setEmail(rs.getString(8));
				cliente.setSexo(rs.getString(9));
				cliente.setBairro(rs.getString(10));
				cliente.setFone(rs.getString(11));

				lst.add(cliente);
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public Cliente PesquisarPorId(int id) {
		Cliente cliente = new Cliente();

		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?",
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.first();

			cliente.setId(rs.getInt(1));
			cliente.setNome(rs.getString(2));
			cliente.setEndereco(rs.getString(3));
			cliente.setCidade(rs.getString(4));
			cliente.setUf(rs.getString(5));
			cliente.setCep(rs.getString(6));
			cliente.setCpf(rs.getString(7));
			cliente.setEmail(rs.getString(8));
			cliente.setSexo(rs.getString(9));
			cliente.setBairro(rs.getString(10));
			cliente.setFone(rs.getString(11));

			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		return cliente;
	}
	
	public List<Cliente> pesquisarPorNome(String valor) {
		List<Cliente> lst = new ArrayList<Cliente>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
			stmt.setString(1, '%' + valor + '%');
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setEndereco(rs.getString(3));
				cliente.setCidade(rs.getString(4));
				cliente.setUf(rs.getString(5));
				cliente.setCep(rs.getString(6));
				cliente.setCpf(rs.getString(7));
				cliente.setEmail(rs.getString(8));
				cliente.setSexo(rs.getString(9));
				cliente.setBairro(rs.getString(10));
				cliente.setFone(rs.getString(11));

				lst.add(cliente);
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public ResultSet carregarGrade() {
		try {
			stmt = con.prepareStatement("SELECT id_cliente, nome FROM cliente");
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return rs;
	}
	public List<String> nomeCampos(){
		List<String> campos = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente LIMIT 1");
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1; i<=rsmd.getColumnCount(); i++)
				campos.add(rsmd.getColumnName(i));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return campos;
		
	}
	
	public ResultSet pesquisa(String campo, String valor) {
		String sql = "SELECT id_cliente, nome FROM cliente WHERE " + campo + " like '%" + valor + "%' ";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return rs;
	}
}

