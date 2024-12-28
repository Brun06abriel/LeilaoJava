/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn = new conectaDAO().connectDB();;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
          int status;
        try {
            prep = conn.prepareStatement("INSERT INTO produtos(nome ,valor,status) VALUES(?,?,?)");
            prep.setString(1,produto.getNome());
            prep.setInt(2,produto.getValor());
            prep.setString(3,produto.getStatus());
            
            status = prep.executeUpdate();
           // return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar livro: " + ex.getMessage());
           // return ex.getErrorCode();
        }
// TESTE de Versão
        
        
        
        
        
        
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){               
    String sql = "SELECT * FROM produtos" ;
          try {

    /* Executando o comando select */
     PreparedStatement stmt = this.conn.prepareStatement(sql);
                   resultset = stmt.executeQuery();            
                    
    java.util.List<ProdutosDTO> listaGeralProdutos = new ArrayList<>();
    /* Exibindo os resultados */
    while (resultset.next()) {
        ProdutosDTO produto = new ProdutosDTO();
        int id = resultset.getInt("id");
        String nome = resultset.getString("nome");
        int valor = resultset.getInt("valor");
        String status = resultset.getString("status");
       
        /*                        
        System.out.println("dados da tabela autor do banco de dados");
        System.out.println("--------------------------");
        System.out.println(email + " - " + nome + " - "+ telefone); */
        
        produto.setId(id);
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setStatus(status);
        
        listaGeralProdutos.add(produto);
    }
     return (ArrayList<ProdutosDTO>) listaGeralProdutos;
} catch (SQLException sqle) {
    System.out.println( "Erro efetuando consulta : " + sqle.getMessage() );
    return null;
}
        
        
    }
    
    public void venderProduto(Integer id){
        
        
          int status;
           try{ 
         /* Executando o comando update */
         
         
           prep = conn.prepareStatement("UPDATE produtos SET status = 'Vendido'  where id = ?");
            prep.setInt(1, id);
    // PreparedStatement stmt = this.conn.prepareStatement(sql);
                   status = prep.executeUpdate();   
             
           // prep.executeUpdate();       
                   
                   
  
        
    } catch (SQLException sqle) {
    System.out.println( "Erro efetuando consulta : " + sqle.getMessage() );
    } 
    
    }   
    
     public ArrayList<ProdutosDTO> listarProdutosVendidos(){               
    String sql = "SELECT * FROM produtos where status = 'Vendido'" ;
          try {

    /* Executando o comando select */
     PreparedStatement stmt = this.conn.prepareStatement(sql);
                   resultset = stmt.executeQuery();            
                    
    java.util.List<ProdutosDTO> listaGeralProdutos = new ArrayList<>();
    /* Exibindo os resultados */
    while (resultset.next()) {
        ProdutosDTO produto = new ProdutosDTO();
        int id = resultset.getInt("id");
        String nome = resultset.getString("nome");
        int valor = resultset.getInt("valor");
        String status = resultset.getString("status");
       
        produto.setId(id);
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setStatus(status);
        
        listaGeralProdutos.add(produto);
    }
     return (ArrayList<ProdutosDTO>) listaGeralProdutos;
} catch (SQLException sqle) {
    System.out.println( "Erro efetuando consulta : " + sqle.getMessage() );
    return null;
}
        
        
    }
    
}

