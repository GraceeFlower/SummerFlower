let BASIC_URL = 'http://localhost:8080';
const top250 = 'top250';

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


function loadSearchData() {
  ajax({
    url: BASIC_URL + '/v2/movie/' + top250,
    method: 'GET',
    success: function (responseText) {
      data = responseText.subjects;
    }
  });
}

function loadDetailSearchData() {
  ajax({
    url: BASIC_URL + '/v2/movie/' + top250,
    method: 'GET',
    success: function (responseText) {
      data = responseText.subjects;
      findSimilarArray();
    }
  });
}

function loadDetailData() {
  ajax({
    url: BASIC_URL + '/movie' + movieDetailPageId,
    method: 'GET',
    success: function (responseText) {
      movieDetailData = responseText;
      renderMovieDetail(responseText);
    }
  });
}