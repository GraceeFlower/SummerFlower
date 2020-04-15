let BASIC_URL = 'http://localhost:8080';
let thisURL = document.URL;
let getIdFromURL = thisURL.split("?")[1];
let movieDetailPageId = getIdFromURL ? getIdFromURL.split("=")[1] : "";

function loadDisplayItems() {
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
    }
  });
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
    url: `./movies/keyword?keyword=${keyword}`,
    method: 'GET',
    success: function (responseText) {
      addSuggestMovieItem(responseText);
    }
  });
}

function renderSuggestionMovie(keyword) {
  ajax({
    url: `./movies/keyword?keyword=${keyword}`,
    method: 'GET',
    success: function (responseText) {
      currentMovie = responseText;
      searchResultInfo.innerHTML = `已为您查询到${currentMovie.length}部与"${keyword}"相关的电影:`;
      separatePage();
    }
  });
}