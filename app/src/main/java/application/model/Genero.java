package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.OneToMany;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="generos")
public class Genero {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToMany(mappedBy = "genero")
    private Set<Jogo> jogos = new HashSet<>();

    //get e set ID
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    //get e set Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //get e set setjogos
    public void SetJogos(Set<Jogo> jogos) {
        this.jogos = jogos;
    }
    public Set<Jogo> getJogos() {
        return this.jogos;
    }
    
}
