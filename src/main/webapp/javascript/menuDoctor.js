function showText1() {
  var outputElement = document.getElementById("output1");
  outputElement.textContent = "プロフィール画面を開きます";
}

function showText2() {
  var outputElement = document.getElementById("output2");
  outputElement.textContent = "あなたがこれまでに投稿した回答が表示されます";
}

function showText3() {
  var outputElement = document.getElementById("output3");
  outputElement.textContent = "未回答の質問を閲覧できます";
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


const profileLink = document.getElementById('profile-link');
const profileButtons = document.getElementById('profile-buttons');

profileLink.addEventListener('click', function() {
  profileButtons.classList.toggle('hidden');
});