package exemplo.com.produtosapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "produto") // faz referencia ao nome da tabela SQL
public class Produto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id // diz que ID é a chave primaria

    @Column (name = "codigo") //faz referencia ao nome da coluna "codigo" na tabela SQL
    private String id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @JsonIgnore // Ignora o id no Swagger
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
