package br.com.restapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "loja")
    @JsonManagedReference
    private Set<Usuario> user_list;

    @OneToMany(mappedBy = "loja")
    @JsonManagedReference
    private Set<Funcionario> funcionarios_list;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
            name = "produtos",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "loja_id")
    )
    private Set<Produto> produtos_list;


    public Set<Usuario> getUser_list() {
        return user_list;
    }

    public void setUser_list(Set<Usuario> user_list) {
        this.user_list = user_list;
    }

    public Set<Funcionario> getFuncionarios_list() {
        return funcionarios_list;
    }

    public void setFuncionarios_list(Set<Funcionario> funcionarios_list) {
        this.funcionarios_list = funcionarios_list;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<Produto> getProdutos_list() {
        return produtos_list;
    }

    public void setProdutos_list(Set<Produto> produtos_list) {
        this.produtos_list = produtos_list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Loja{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
