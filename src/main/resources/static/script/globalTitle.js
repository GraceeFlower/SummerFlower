const header = document.getElementsByTagName("header")[0];

if (thisURL.match(/.+movieDetails.html/)) {
  loadDetailData();
}

let topSearchInput = document.getElementsByClassName("top-search-input")[0];
function searchOperate() {
  let searchContent = topSearchInput.value;
  let searchMovieId = isABitContain(searchContent);
  if (-1 === searchMovieId) {
    window.location.href = `./movieNotFound.html?searchContent=${searchContent}`;
  } else {
    movieDetailPageId = searchMovieId;
    window.location.href = `./movieDetails.html?id=${movieDetailPageId}`;
  }
}

let recommendSearchArray = [];
const searchSuggest = document.getElementsByClassName("search-suggest")[0];
const searchSuggestList = document.getElementsByClassName("search-suggest-list")[0];

topSearchInput.addEventListener("input", function (event) {
  let searchContent = event.target.value;
  recommendSearchArray = loadSuggestionMovie(searchContent);
  setSuggestMoviePullDown();
});

function isABitContain(searchContent) {
  let containThisMovieArray = [];
  if (searchContent) {
    data.forEach(item => {
      if (item.title.includes(searchContent)) {
        containThisMovieArray.push(item.id);
      }
    });
  }
  return containThisMovieArray;
}

function setSuggestMoviePullDown() {
  searchSuggest.style.height = "auto";
  searchSuggestList.innerHTML = "";
  addSuggestMovieItem();
  if (recommendSearchArray.length > 5) {
    searchSuggest.style.height = "400px";
    searchSuggest.style.overflow = "auto";
  } else {
    searchSuggest.style.height = "auto";
  }
}

function addSuggestMovieItem() {
  searchSuggestList.innerHTML = recommendSearchArray.reduce((pre, cur) => {
    let suggestMovieData = data.filter(item => (cur === item.id))[0];
    return pre += `
    <li class="suggest-item" id='${suggestMovieData.id}'>
      <img class="suggest-item-img" src='${suggestMovieData.images}' alt='${suggestMovieData.title}'/>
      <span class="suggest-item-name">${suggestMovieData.title}</span>
      <span class="suggest-item-rating">${standardAverage(suggestMovieData.rating)}</span>
    </li>`
  }, '');
}

searchSuggest.addEventListener("click", function (event) {
  let target = event.target;
  if ("suggest-item" === target.className) {
    window.location.href = `./movieDetails.html?id=${target.id}`;
  } else {
    window.location.href = `./movieDetails.html?id=${target.parentNode.id}`;
  }
});

function judgeAverage(rating) {
  return rating.toString().length === 1 ? `${rating}.0` : rating;
}