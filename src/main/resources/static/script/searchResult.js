const movieList = document.getElementsByClassName('movie-list')[0];
const pageInfo = document.getElementsByClassName('current-page')[0];
const searchResultInfo = document.getElementsByClassName("search-result")[0];
let [wholePage, currentPage] = [1, 1];
let currentMovie;

window.onload = function () {
    renderSuggestionMovie(keyword);
};

function renderMovies(movie) {
    movie.forEach((element) => movieList.innerHTML += `
    <li id='${element.id}'>
      <div class="movie-cover">
        <img src='${element.image}' alt='${element.title}'/>
      </div>
      <span class="movie-name">${element.title}</span>
      <span class="movie-average">${standardAverage(element.rating)}</span>
    </li>`);
}

movieList.addEventListener("click", function (event) {
    let target = event.target;
    if ('movie-list' !== target.className) {
        if ("movie-cover" === target.parentNode.className) {
            window.location.href = `./movieDetails.html?id=${target.parentNode.parentNode.id}`;
        } else if ("movie-list" === target.parentNode.className) {
            window.location.href = `./movieDetails.html?id=${target.id}`;
        } else {
            window.location.href = `./movieDetails.html?id=${target.parentNode.id}`;
        }
    }
});

function separatePage() {
    if (currentMovie.length > 10) {
        movieList.innerHTML = '';
        wholePage = Math.ceil(currentMovie.length / 10);
        let pageList = currentMovie.slice((currentPage - 1) * 10, currentPage * 10);
        renderMovies(pageList);
    } else if (!currentMovie.length) {
        window.location.href = `./movieNotFound.html?keyword=${keyword}`;
    } else {
        renderMovies(currentMovie);
    }
    reloadPageBar();
}

const formerBtn = document.getElementById('former-page');
const latterBtn = document.getElementById('latter-page');

function changePage(isFormer) {
    if (wholePage > 1) {
        if (isFormer && currentPage > 1) {
            currentPage--;
            separatePage(currentMovie);
        } else if (!isFormer && currentPage < wholePage) {
            currentPage++;
            separatePage(currentMovie);
        }
    }
    reloadPageBar();
}

const viewMore = document.getElementsByClassName('view-more')[0];

function reloadPageBar() {
    viewMore.style.display = 'flex';
    pageInfo.innerHTML = `${currentPage}/${wholePage}`;
    formerBtn.innerHTML = 1 === currentPage ? '没有上一页了' : '上一页';
    latterBtn.innerHTML = wholePage === currentPage ? '没有下一页了' : '下一页';
}

