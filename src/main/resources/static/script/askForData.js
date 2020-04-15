let BASIC_URL = 'http://localhost:8080';
let thisURL = document.URL;
let getIdFromURL = thisURL.split("?")[1];
let movieDetailPageId;

function findMovieId() {
  if (getIdFromURL) {
    movieDetailPageId = getIdFromURL.split("=")[1];
  }
}
findMovieId();

function loadItems() {
  ajax({
    url: BASIC_URL + '/movies?num=10',
    method: 'GET',
    success: function (responseText) {
      loadMovieList(responseText);
    }
  });
}

function loadMenu() {
  ajax({
    url: BASIC_URL + '/movies/menu',
    method: 'GET',
    success: function (responseText) {
      loadMovieMenu(responseText);
    }
  });
}

function getPointedTypeMenu(type) {
  ajax({
    url: BASIC_URL + '/movies/type?type=' + type,
    method: 'GET',
    success: function (responseText) {
      currentMovie = responseText;
      separatePage(responseText);
    }});
}

function loadDetailData() {
  ajax({
    url: BASIC_URL + '/movies/detail?id=' + movieDetailPageId,
    method: 'GET',
    success: function (responseText) {
      loadDetailComment();
      loadDetailVideo();
      loadDetailSimilar(responseText.genres);
      renderMovieDetail(responseText);
    }
  });
}

function loadDetailVideo() {
  ajax({
    url: BASIC_URL + '/movies/video?id=' + movieDetailPageId,
    method: 'GET',
    success: function (responseText) {
      renderMovieVideo(responseText);
    }
  });
}

function loadDetailComment() {
  ajax({
    url: BASIC_URL + '/movies/comment?id=' + movieDetailPageId,
    method: 'GET',
    success: function (responseText) {
      renderComment(responseText);
    }
  });
}

function loadDetailSimilar(genres) {
  ajax({
    url: BASIC_URL + '/movies/similarType?type=' + genres + "&id=" + movieDetailPageId,
    method: 'GET',
    success: function (responseText) {
      renderSimilarMovie(responseText);
    }
  });
}

function loadSuggestionMovie(keyword) {
  ajax({
    url: BASIC_URL + '/movies/keyword?keyword=' + keyword,
    method: 'GET',
    success: function (responseText) {
      addSuggestMovieItem(responseText);
    }
  });
}