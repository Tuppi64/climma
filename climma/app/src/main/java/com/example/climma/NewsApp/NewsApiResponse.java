package NewsApp;

import java.util.List;

public class NewsApiResponse {
    String status;
    int totalResults;
    List<NewsItems> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsItems> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsItems> articles) {
        this.articles = articles;
    }
}
