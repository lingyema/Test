package lingye.service;

import lingye.mapper.ArticleMapper;
import lingye.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> queryByUserId(Integer userId) {
        return articleMapper.queryByUserId(userId);
    }
}
