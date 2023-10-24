import javax.persistance.Entity;
import javax.persistance.Table;
import javax.persistance.Id;
import javax.persistance.GeneratedValue;
import javax.persistance.GenerationType;

import javax.persistance.ManyToOne;
import javax.persistance.JoinColumn;
import javax.persistance.JoinTable;
import javax.persistance.ManyToMany;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name="id_genero")
    private Genero genero;

    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_plataformas",
        joinColumns = @JoinColumn(name = "jogos_id"),
        inverseJoinColumns = @JoinColumn(name = "plataformas_id"))
    private Set<Plataforma> plataformas = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return this.titulo;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Genero getGenero() {
        return this.genero;
    }

    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
    public Set<Plataforma> getPlataformas() {
        return this.plataformas;
    }
}