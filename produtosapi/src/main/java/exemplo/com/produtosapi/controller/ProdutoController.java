package exemplo.com.produtosapi.controller;

import exemplo.com.produtosapi.model.Produto;
import exemplo.com.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //diz para o spring que essa classe vai receber requisições REST
@RequestMapping ("produtos") //vai dizer qual é a URL base do controller nessa aplicação é "produtos"
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }//Essa classe foi injetada no método sem problema por ser uma classe gerenciada pelo Spring

    @PostMapping // salvar recuros no servidor
    public Produto salvar (@RequestBody Produto produto){
        //@RequestBody serve para pegar os dados que vêm no corpo de uma mensagem enviada para o sistema e transformar esses dados em um objeto Java
        System.out.println("Produto recebido" + produto);

        var id = UUID.randomUUID().toString();//variavel que armazena um metodo que gera um Id aleatorio automaticamente
        produto.setId(id);//define que a classe ID da classe Produto recebe o id aleatorio

        produtoRepository.save(produto);
        //salva o produto que vem la do postman, só permitido porque a classe é gerenciada pelo spring
        return produto;
    }

    @GetMapping ("/{id}")//define a Url e associa ao parametro do PathVariable que no caso é "id"
    public Produto obterPorId(@PathVariable ("id") String id){
        return produtoRepository.findById(id). orElse(null);
    }

    @DeleteMapping ("{id}") //Usado para deletar recursos existentes no servidor
    // associa o parametro do metodo com a url na anotação que é "id"
    public void deletar ( @PathVariable ("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping ("{id}")//usado para atualizar algum recurso que ja exista no servidor
    //associa a Url na anotação com o PathVariable "id"
    public void atualizar(@PathVariable ("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping //indica que o metodo vai receber requisição Get
    //quando a rota get for acessada ele vai retornar uma lista de objetos do tipo Produto utilizando o parametro "nome"
    public List<Produto> buscar(@RequestParam("nome") String nome){
       return produtoRepository.findByNome(nome);
    }
}