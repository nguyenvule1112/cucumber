Feature: Login to admin
  Scenario: Should show error message for wrong password
    Given The login page is show
    When The user attempt to login with the username "khanhtx@live.com" and wrong password "abc123456"
    Then The popup with message "Tên đăng nhập hoặc Mật khẩu không đúng." will be show
