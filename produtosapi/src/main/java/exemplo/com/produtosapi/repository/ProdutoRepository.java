package exemplo.com.produtosapi.repository;

import exemplo.com.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, String> {
    //Quando extende um JpaRepository temos que declarar uma entidade e o tipo dessa entidade

    List<Produto> findByNome(String nome);
}
