import javax.persistance.Entity;
import javax.persistance.Table;
import javax.persistance.Id;
import javax.persistance.GeneratedValue;
import javax.persistance.GenerationType;

import javax.persistance.ManyToMany;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="plataformas")
public class Plataforma {
    @id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String nome;

    @ManyToMany(mappedBy = "plataformas")
    private Set<Jogo> jogos = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
}