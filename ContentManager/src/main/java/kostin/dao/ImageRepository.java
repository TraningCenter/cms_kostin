package kostin.dao;

import kostin.model.ImageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<ImageEntity,Integer> {
    List<ImageEntity> findByHash(String hash);
}
