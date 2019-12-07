$(document).ready(function () {

  $("#registrationForm").hide();

  $("a.login").click(function () {
    $("#loginForm").show();
    $("#registrationForm").hide();
  });

  $("a.registration").click(function () {
    $("#loginForm").hide();
    $("#registrationForm").show();
  });


});

