function showText1() {
  var outputElement = document.getElementById("output1");
  outputElement.textContent = "質問フォームの入力画面に移動します";
}

function showText2() {
  var outputElement = document.getElementById("output2");
  outputElement.textContent = "あなたがこれまでに投稿した質問が表示されます";
}

function showText3() {
  var outputElement = document.getElementById("output3");
  outputElement.textContent = "このアプリケーションに参加している医師一覧を見る事ができます";
}

function showText4() {
  var outputElement = document.getElementById("output4");
  outputElement.textContent = "あなたの健康情報や個人情報の登録ができます";
}

function hideText1() {
  var outputElement = document.getElementById("output1");
  outputElement.textContent = "";
}

function hideText2() {
  var outputElement = document.getElementById("output2");
  outputElement.textContent = "";
}

function hideText3() {
  var outputElement = document.getElementById("output3");
  outputElement.textContent = "";
}

function hideText4() {
  var outputElement = document.getElementById("output4");
  outputElement.textContent = "";
}



const profileLink = document.getElementById('profile-link');
const profileButtons = document.getElementById('profile-buttons');

profileLink.addEventListener('click', function() {
  profileButtons.classList.toggle('hidden');
});