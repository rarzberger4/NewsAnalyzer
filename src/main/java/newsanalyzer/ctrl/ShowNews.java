package newsanalyzer.ctrl;

import newsapi.NewsApi;
import newsapi.NewsApiException;
import newsapi.beans.Article;
import newsapi.beans.NewsReponse;

import java.util.List;

public class ShowNews {
    NewsApi newsApi;
    private NewsReponse newsResponse;
    private List<Article> articles = null;

    public ShowNews(NewsApi newsApi) throws NewsApiException {
        this.newsApi = newsApi;
    }

    public void show() throws NewsApiException {
        newsResponse = newsApi.getNews();
        if (newsResponse != null) {
            articles = newsResponse.getArticles();
            articles.stream().forEach(article -> System.out.println("\n"
                    +"Title: "+article.getTitle()+"\n"
                    +"Author: "+article.getAuthor()+"\n"
                    +"Description: "+article.getDescription()+"\n"
                    +"Published at: "+article.getPublishedAt()+"\n"
                    +"Content: "+article.getContent()+"\n"
                    +"Publisher: "+article.getSource().getName()+"\n"
            ));
        } else {
            throw new NewsApiException("Error in Controller");
        }
    }


}
