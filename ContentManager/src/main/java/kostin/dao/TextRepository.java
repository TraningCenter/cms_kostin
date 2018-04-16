package kostin.dao;

import kostin.model.Text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface TextRepository extends CrudRepository<Text,Integer> {
}
