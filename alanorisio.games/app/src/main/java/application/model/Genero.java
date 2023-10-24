import javax.persistance.Entity;
import javax.persistance.Table;
import javax.persistance.Id;
import javax.persistance.GeneratedValue;
import javax.persistance.GenerationType;

import javax.persistance.OneToMany;

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

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void SetJogos(Set<Jogo> jogos) {
        this.jogos = jogos;
    }
    public Set<Jogo> getJogos() {
        return this.jogos;
    }
    
}
