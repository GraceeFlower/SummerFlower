const detailPage = document.getElementsByClassName('detail-page-content')[0];

function renderMovieDetail(movie) {
  detailPage.innerHTML = `
    <h1 class="movie-title-and-date">${movie.title}-${movie.originTitle}(${movie.year})</h1>
    <div class="movie-poster-and-detail">
      <div class="movie-poster"><img src="${movie.smallImage}" alt="${movie.title}"/></div>
      <div class="movie-detail">
        <div><span class="detail-name">导演：</span><span class="detail-text">${movie.directorList}</div>
        <div><span class="detail-name">主演：</span><span class="detail-text">${movie.castList}</div>
        <div><span class="detail-name">类型：</span><span class="detail-text">${movie.genres}</div>
        <div><span class="detail-name">制作国家/地区：</span><span class="detail-text">${movie.countryList}</div>
        <div><span class="detail-name">语言：</span><span class="detail-text">${movie.languageList}</div>
        <div><span class="detail-name">片长：</span><span class="detail-text">${movie.duration}</div>
        <div><span class="detail-name">上映时间：</span><span class="detail-text">${movie.publicDateList}</div>
        <div><span class="detail-name">豆瓣评分：</span><span class="detail-text">${standardAverage(movie.average)}</div>
      </div>
      <div class="movie-video"><h5>电影路径</h5><ul></ul></div>
    </div>
    <div class="movie-story-intro">
      <div class="item-title">剧情介绍</div>
      <p>${movie.summary}</p>
    </div>
    <div class="movie-reviews">
      <div class="item-title">豆瓣热评Top5</div>
      <div class="comment-list"></div>
    </div>
  `
}

function renderMovieVideo(video) {
  const videoInner = document.getElementsByClassName("movie-video")[0].getElementsByTagName("ul")[0];
  if (!video.length) {
    return videoInner.innerHTML = 'Sorry，暂时没有观影路径哦~';
  }
  return videoInner.innerHTML = video.reduce((whole, item) => whole +=
    `<li>
      <a href="${item.link}">${item.platform}</a>
      <span class="${item.free ? 'free-movie' : 'paying-movie'}">${item.free ?  '免费' : '¥付费'}</span>
    </li>`
    , '');
}

function renderComment(comment) {
  document.getElementsByClassName("comment-list")[0].innerHTML =
      comment.reduce((whole, item) => whole += `
  <div class="commenter-info">
    <img src="${item.userAvatar}" alt="${item.userName}" />
    <span class="commenter-name">${item.userName}</span>
    <span class="comment-title">#${item.commentTitle}#</span>
    <div class="comment-text">${item.commentContent}</div>
  </div>`, '');
}

const similarMovie = document.getElementsByClassName('similar-movie-recommend')[0];

function renderSimilarMovie(similar) {
  similarMovie.innerHTML = `<div class="item-title">相似电影</div><ul class="similar-movie-list"></ul>`;
  const similarList = document.getElementsByClassName('similar-movie-list')[0];
  let randomSimilarIndex = similar.length > 12 ? Math.floor(Math.random() * (similar.length - 12)) : 0;
  if (0 === similar.length) {
    similarList.innerHTML = "暂时没有哦～";
  } else {
    similarList.innerHTML = similar.slice(randomSimilarIndex, randomSimilarIndex + 12).reduce((pre, cur) => pre +=
      `<li id='${cur.id}'>
        <div class="similar-movie-cover"><img src='${cur.image}' alt='${cur.title}'/></div>
        <div class="similar-movie-name">${cur.title}</div>
        <div class="similar-movie-average">${standardAverage(cur.rating)}</div>
      </li>`
      , '');
  }
  adjustFootBar();
  similarList.addEventListener("click", function (event) {
    let target = event.target;
    if ('similar-movie-list' !== target.className) {
      if ("similar-movie-cover" === target.parentNode.className) {
        window.location.href = `./movieDetails.html?id=${target.parentNode.parentNode.id}`;
      } else if ("similar-movie-list" === target.parentNode.parentNode.className) {
        window.location.href = `./movieDetails.html?id=${target.parentNode.id}`;
      }
    }
  })
}
