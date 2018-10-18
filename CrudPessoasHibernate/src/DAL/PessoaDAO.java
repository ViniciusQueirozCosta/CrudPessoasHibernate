
package DAL;

import Modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PessoaDAO implements intPessoaDAO
{
    public String mensagem;
    Session session = Conexao.getSessionFactory().openSession();
    
    @Override
    public void CadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        
        session.beginTransaction();
        session.save(pessoa);
        session.getTransaction().commit();
        session.close();
        
        this.mensagem = "Pessoa cadastrada com sucesso!";
    }

    @Override
    public void EditarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        
        session.beginTransaction();
        session.saveOrUpdate(pessoa);
        session.getTransaction().commit();
        session.close();
        
        this.mensagem = "Pessoa editada com sucesso!";
    }

    @Override
    public void ExcluirPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        
        session.beginTransaction();
        session.delete(pessoa);
        session.getTransaction().commit();
        session.close();
        
        this.mensagem = "Pessoa Excluida com sucesso!";
    }

    @Override
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa)
    {
        this.mensagem = "";
        
        Query query = session.createQuery("from Pessoa p where p.id = :id");
        query.setParameter("id", pessoa.getId());
        List<Pessoa> listaPessoa =  query.list();
        pessoa = listaPessoa.get(0);
        return pessoa;
    }

    @Override
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa)
    {
        this.mensagem = "";
        
        Query query = session.createQuery("from Pessoa p where p.nome like :nome");
        query.setParameter("nome", "%" + pessoa.getNome() + "%");
        return (List<Pessoa>) query.list();
    }
}
