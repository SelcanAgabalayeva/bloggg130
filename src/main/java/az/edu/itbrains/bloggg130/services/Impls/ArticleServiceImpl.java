package az.edu.itbrains.bloggg130.services.Impls;

import az.edu.itbrains.bloggg130.dtos.article.*;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleCreateDto;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleDashboardDto;
import az.edu.itbrains.bloggg130.dtos.article.dashboard.ArticleUpdateDto;
import az.edu.itbrains.bloggg130.models.Article;
import az.edu.itbrains.bloggg130.models.Category;
import az.edu.itbrains.bloggg130.repositories.ArticleRepository;
import az.edu.itbrains.bloggg130.repositories.CategoryRepository;
import az.edu.itbrains.bloggg130.response.PaginationResponse;
import az.edu.itbrains.bloggg130.services.ArticleService;
import az.edu.itbrains.bloggg130.services.CategoryService;
import org.apache.coyote.Request;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {


    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<ArticleBannerDto> getBannerArticles() {
        List<Article> articleList=articleRepository.findAll().stream().limit(3).collect(Collectors.toList());
        List<ArticleBannerDto> articles=articleList.stream().map(article -> modelMapper.map(article,ArticleBannerDto.class)).collect(Collectors.toList());
        return articles;
    }

    @Override
    public PaginationResponse<ArticleFeedDto> getFeedArticles(Integer pageNumber) {
        pageNumber =pageNumber==null?1:pageNumber;
        Pageable pageable= PageRequest.of(pageNumber-1,2);
        Page<Article> articlePage=articleRepository.findAll(pageable);

        List<ArticleFeedDto> articles=articlePage.stream().map(a -> modelMapper.map(a,ArticleFeedDto.class)).collect(Collectors.toList()) ;
        PaginationResponse response=new PaginationResponse<>();
        response.setData(articles);
        response.setPageSize(articlePage.getTotalPages());

        return response;
    }

    @Override
    public ArticleDetailDto getArticleDetail(Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        ArticleDetailDto articleDetailDto=modelMapper.map(article,ArticleDetailDto.class);
        return articleDetailDto;
    }

    @Override
    public PaginationResponse<ArticleCategoryDto> getArticlesByCategoryId(Integer pageNumber,Long categoryId) {
        pageNumber =pageNumber==null?1:pageNumber;
        Pageable pageable= PageRequest.of(pageNumber-1,2);
        Page<Article> articlePage=articleRepository.findAll(pageable);
        List<Article> articleList=articleRepository.findByTitle("Spring Boot Guide");
        List<ArticleCategoryDto> articles=articleList.stream().map(a -> modelMapper.map(a,ArticleCategoryDto.class)).collect(Collectors.toList()) ;
        PaginationResponse response=new PaginationResponse<>();
        response.setData(articles);
        response.setPageSize(articlePage.getTotalPages());

        return response;

    }

    @Override
    public List<ArticleRelatedDto> getRelatedArticles(Long id, Long categoryId) {
        List<Article>articles=articleRepository.findRelatedArticle(categoryId,id);
        List<ArticleRelatedDto> articleRelatedDtoList=articles.stream().map(p ->modelMapper.map(p, ArticleRelatedDto.class)).collect(Collectors.toList());
        return articleRelatedDtoList;
    }

    @Override
    public List<ArticleDashboardDto> getDashboardArticles() {
        List<Article> articleList=articleRepository.findAll();
        List<ArticleDashboardDto> articleDashboardDtoList=articleList.stream().map(article -> modelMapper.map(article, ArticleDashboardDto.class)).collect(Collectors.toList());
        return articleDashboardDtoList;
    }

    @Override
    public ArticleUpdateDto getUpdateArticle(Long id) {
        Article article=articleRepository.findById(id).orElseThrow();
        ArticleUpdateDto articleUpdateDto=modelMapper.map(article,ArticleUpdateDto.class);
        articleUpdateDto.setCategoryId(article.getCategory().getId());
        return articleUpdateDto;
    }

    @Override
    public void updateArticle(Long id, ArticleUpdateDto articleUpdateDto) {
      try {
          Article article=articleRepository.findById(id).orElseThrow();
          Category category=categoryService.getCategoryById(articleUpdateDto.getCategoryId());
          article.setView(articleUpdateDto.getView());
          article.setUpdateDate(new Date());
          article.setDescription(articleUpdateDto.getDescription());
          article.setTitle(articleUpdateDto.getTitle());
          article.setCategory(category);
          articleRepository.save(article);
      }catch (Exception e){
          System.out.println(e.getMessage());
      }

    }

    @Override
    public void createArticle(ArticleCreateDto articleCreateDto) {
        Article article=modelMapper.map(articleCreateDto,Article.class);
        article.setView(0L);
        article.setDescription(articleCreateDto.getEditor1());
        Category category=categoryService.getCategoryById(articleCreateDto.getCategoryId());
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        Article findArticle=articleRepository.findById(id).orElseThrow();
        articleRepository.delete(findArticle);
    }
}
