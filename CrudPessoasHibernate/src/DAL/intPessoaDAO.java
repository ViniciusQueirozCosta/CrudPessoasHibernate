
package DAL;

import Modelo.Pessoa;
import java.util.List;

public interface intPessoaDAO
{
    public void CadastrarPessoa(Pessoa pessoa);
    public void EditarPessoa(Pessoa pessoa);
    public void ExcluirPessoa(Pessoa pessoa);
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa);
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa);
}
