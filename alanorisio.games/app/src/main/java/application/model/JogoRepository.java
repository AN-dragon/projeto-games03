import org.springframework.data.repository.CrudRepository;

import alanorisio.games.models.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, Integer> {
    
}
