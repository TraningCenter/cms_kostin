package kostin.mappers;

import kostin.model.Post;

public interface PostMapper {

    Post getPostById(Integer id);

    Integer createPost(Post post);

    void updatePost(Post post);

    void deletePostById (Integer id);
}
