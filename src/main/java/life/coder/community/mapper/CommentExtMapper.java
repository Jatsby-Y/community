package life.coder.community.mapper;

import life.coder.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}