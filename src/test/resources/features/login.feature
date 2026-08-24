# language: ru
@homework19
Функция: Авторизация на the-internet.herokuapp.com

  @login-success
  Сценарий: Успешный вход и выход
    Дано открыта главная страница the-internet.herokuapp.com
    И я перехожу по ссылке "Form Authentication"
    То заголовок страницы содержит текст "Login Page"
    И я ввожу в поле "Username" значение "tomsmith"
    И я ввожу в поле "Password" значение "SuperSecretPassword!"
    И я нажимаю кнопку "Login"
    То сообщение результата содержит текст "You logged into a secure area!"
    И на странице присутствует кнопка "Logout"
    И я нажимаю кнопку "Logout"
    То заголовок страницы содержит текст "Login Page"

  @login-invalid
  Сценарий: Вход с неверными учётными данными
    Дано открыта главная страница the-internet.herokuapp.com
    И я перехожу по ссылке "Form Authentication"
    То внизу страницы присутствует ссылка "Elemental Selenium"
    И я ввожу в поле "Username" значение "admin"
    И я ввожу в поле "Password" значение "1234"
    И я нажимаю кнопку "Login"
    То сообщение результата содержит текст "Your username is invalid!"