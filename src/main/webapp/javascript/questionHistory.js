function extractRows() {
  // 開始日と終了日の入力値を取得
  var startDate = new Date(document.getElementById("startDateInput").value);
  var endDate = new Date(document.getElementById("endDateInput").value);

  // テーブルの全ての行を取得
  var table = document.querySelector(".table_layout");
  var rows = table.getElementsByTagName("tr");

  // 抽出された行を格納するための配列
  var extractedRows = [];

  // 行を順番にチェックして、日付が範囲内の行を抽出
  for (var i = 1; i < rows.length; i++) {
    var dateCell = rows[i].querySelector(".th0");

    // 行の日付を取得
    var rowDate = new Date(dateCell.innerText.trim());

    // 日付が範囲内にある場合、行を抽出
    if (rowDate >= startDate && rowDate <= endDate) {
      extractedRows.push(rows[i]);
    }
  }

  // テーブルの全ての行を非表示にする
  for (var i = 0; i < rows.length; i++) {
    rows[i].style.display = "none";
  }

  // 抽出された行のみ表示する
  for (var i = 0; i < extractedRows.length; i++) {
    extractedRows[i].style.display = "";
  }
}
