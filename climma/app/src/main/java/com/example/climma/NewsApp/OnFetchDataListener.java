package com.example.climma.NewsApp;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void onfetchData(List<NewsItems> list, String message);
    void onError(String Message);

}
