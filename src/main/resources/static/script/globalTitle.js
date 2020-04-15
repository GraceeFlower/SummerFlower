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

const searchSuggest = document.getElementsByClassName("search-suggest")[0];
const searchSuggestList = document.getElementsByClassName("search-suggest-list")[0];

topSearchInput.addEventListener("input", function (event) {
  let value = event.target.value
  if (value) {
    loadSuggestionMovie(value);
  } else {
    setSuggestMoviePullDown([]);
  }
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

function setSuggestMoviePullDown(suggestArray) {
  searchSuggest.style.height = "auto";
  searchSuggestList.innerHTML = "";
  if (suggestArray.length > 5) {
    searchSuggest.style.height = "400px";
    searchSuggest.style.overflow = "auto";
  }
}

function addSuggestMovieItem(suggestArray) {
  setSuggestMoviePullDown(suggestArray);
  searchSuggestList.innerHTML = suggestArray.reduce((pre, cur) =>
    pre += `<li class="suggest-item" id='${cur.id}'>
      <img class="suggest-item-img" src='${cur.image}' alt='${cur.title}'/>
      <span class="suggest-item-name">${cur.title}</span>
      <span class="suggest-item-rating">${standardAverage(cur.rating)}</span>
    </li>`
  , '');
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