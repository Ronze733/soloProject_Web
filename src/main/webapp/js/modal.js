/**
 * 
 */

$(document).ready(function() {
  $("#myModal").draggable(); // 모달을 드래그 가능하도록 설정

  $("#openModalBtn").click(function() {
    $("#myModal").css("display", "block");
    $("#modalOverlay").css("display", "block");
  });

  $(".close, #modalOverlay").click(function() {
    $("#myModal").css("display", "none");
    $("#modalOverlay").css("display", "none");
  });
});