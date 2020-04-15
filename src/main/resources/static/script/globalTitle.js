const keyword = decodeURI(thisURL.match(/(?<=keyword=).*/));

if (thisURL.match(/.+movieDetails.html/)) {
  loadDetailData();
}

let topSearchInput = document.getElementsByClassName("top-search-input")[0];
const searchSuggest = document.getElementsByClassName("search-suggest")[0];
const searchSuggestList = document.getElementsByClassName("search-suggest-list")[0];

function searchOperate() {
  if (topSearchInput.value) {
    window.location.href = `./searchResult.html?keyword=${topSearchInput.value}`;
  }
}

topSearchInput.addEventListener("input", function (event) {
  let value = event.target.value;
  if (value) {
    loadSuggestionMovie(value);
  } else {
    setSuggestMoviePullDown([]);
  }
});

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

function standardAverage(average) {
  return average.toString().length === 1 ? `${average}.0` : average;
}