package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.ServicoGabriel;
import br.edu.faculdadedelta.util.Conexao;

public class ServicoDAOGabriel {

	public void incluir(ServicoGabriel servico) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO servicos (desc_cliente ,desc_servico ,  valor_unitario_servico , qtde_servico , data_exec_servico ) " 
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, servico.getDescC());
		ps.setString(2, servico.getDescS());
		ps.setDouble(3, servico.getValor());
		ps.setInt(4, servico.getQtdS());
		ps.setDate(5, new java.sql.Date(servico.getDataexecS().getTime()));
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	public void alterar(ServicoGabriel servico) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE servicos SET desc_cliente = ? ,"
				+ " desc_servico = ? ,"
				+ "valor_unitario_servico = ? ,"
				+ " qtde_servico = ? ,"
				+ "data_exec_servico = ? " 
				+ "WHERE id_servico = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, servico.getDescC());
		ps.setString(2, servico.getDescS());
		ps.setDouble(3, servico.getValor());
		ps.setInt(4, servico.getQtdS());
		ps.setDate(5, new java.sql.Date(servico.getDataexecS().getTime()));
		ps.setLong(6, servico.getId());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public void excluir(ServicoGabriel servico) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "DELETE FROM servicos WHERE id_servico = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, servico.getId());
		
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public List<ServicoGabriel> listar() throws ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id_servico , desc_cliente ,desc_servico ,  valor_unitario_servico , qtde_servico , data_exec_servico  FROM servicos ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ServicoGabriel> listaRetorno = new ArrayList<ServicoGabriel>();
		
		while(rs.next()) {
			ServicoGabriel servico = new ServicoGabriel();
			servico.setId(rs.getLong("id_servico"));
			servico.setDescC(rs.getString("desc_cliente"));
			servico.setDescS(rs.getString("desc_servico"));
			servico.setValor(rs.getDouble("valor_unitario_servico"));
			servico.setQtdS(rs.getInt("qtde_servico"));
			servico.setDataexecS(rs.getDate("data_exec_servico"));
			listaRetorno.add(servico);
		}
		
			rs.close();
			ps.close();
			conn.close();
			
		return listaRetorno;
	}
	
}
