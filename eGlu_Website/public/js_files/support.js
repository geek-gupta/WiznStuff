// This JS file is for Support page.


$(document).ready(function() {
  $("#videoBtn").click(function() {
    changeActiveClass(this, 0);

  });
  $("#manualBtn").click(function() {
    changeActiveClass(this, 1);
  });
  $("#otherBtn").click(function() {
    changeActiveClass(this, 2);
  });
})

function changeActiveClass() {
  var current = document.getElementsByClassName("active");
  var currentChild = $(".content-section").children();
  $(".content-section").children().css("display", "none");
  current[0].className = current[0].className.replace("active", "");
  $(arguments[0]).addClass("active");
  $(currentChild[arguments[1]]).css("display", "grid");

}
