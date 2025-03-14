//jquery
$(document).ready(function () {
  $("#btn-login").click(function () {
    var email = $("#login-email").val();

    var password = $("#login-password").val();
    console.log(email);

    $.ajax({
      method: "POST",
      url: "http://localhost:8080/auth/sign-in",
      data: { email: email, password: password },
    }).done(function (result) {
      console.log(result.data);
      if (result.data) {
        alert(" đăng nhập thành công ");
      } else {
        alert(" đăng nhập thất bại ");
      }
    });
  });

  $("#btn-signup").click(function () {
    //console.log("click sign up");
    var signupEmail = $("#signup-email").val();
    var signupFullname = $("#signup-fullname").val();
    var signupPassword1 = $("#signup-password1").val();
    var signupPassword2 = $("#signup-password2").val();

    if (signupPassword1 !== signupPassword2) {
      alert("Mật khẩu không trùng khớp!");
      return; 
    }

    $.ajax({
      method: "POST",
      url: "http://localhost:8080/user/sign-up",
      data: JSON.stringify({
        email: signupEmail,
        password: signupPassword1,
        fullname: signupFullname,
      }),
      contentType: "application/json", 
    })
      .done(function (result) {
        console.log(result.data);
        if (result.data) {
          alert(" đăng ký thành công ");
        } else {
          alert(" đăng ký thất bại ");
        }
      })
      .fail(function (xhr) {
        if (xhr.status === 400) {
          var response = JSON.parse(xhr.responseText);
          alert(response.message); 
        } else {
          alert("Có lỗi xảy ra, vui lòng thử lại!");
        }
      });
  });
});
