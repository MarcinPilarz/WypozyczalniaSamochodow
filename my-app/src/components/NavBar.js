import React, { useState } from 'react';
import '../App.css';

function NavBar() {
  const [showPassword, setShowPassword] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [popupLogin, setPopupLogin] = useState(false);
  const [popupRegister, setPopupRegister] = useState(false);

  const handlePasswordToggle = () => {
    setShowPassword(!showPassword);
  };

  const handleButtonClick = () => {
    const element = document.getElementById('bottom');
    if (element) {
      element.scrollIntoView({ behavior: 'smooth' });
    } else {
      window.location.href = '/';
    }

    const element2 = document.getElementById('bottom');
    if (element2) {
      element2.scrollIntoView({ behavior: 'smooth' });
    }
  };

  const handleLoginClick = () => {
    setPopupLogin(true);
  };

  const closePopUpLogin = () => {
    setPopupLogin(false);
  };

  const handleRegisterClick = () => {
    setPopupRegister(true);
  };

  const closePopUpRegister = () => {
    setPopupRegister(false);
  };

  const handleLoginSubmit = () => {
    setIsLoggedIn(true);
    setPopupLogin(false);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  return (
    <>
      <header>
        <div className="nav container">
          <i className="bx bx-menu" id="menu-icon"></i>
          <a href="/" className="logo">
            Car<span>Rent</span>
          </a>
          <ul className="navbar">
            <li>
              <a href="/" className="active">
                Start
              </a>
            </li>
            <li>
              <a href="#Oferta">O nas</a>
            </li>
            <li>
              <a onClick={handleButtonClick}>Oferta</a>
            </li>
            <li>
              <a href="/Contact">Kontakt</a>
            </li>
          </ul>
          <i className="bx bx-search" id="search-icon"></i>
          <div className="search-box container">
            <input type="search" placeholder="Szukaj..." />
          </div>
          <div className="btn-login-container">
            {isLoggedIn ? (
              <div className="dropdown">
                <button className="btn-login">Profil</button>
                <div className="dropdown-content">
                  <a href="/User">Wyświetl profil</a>
                  <a href="#" onClick={handleLogoutClick}>
                    Wyloguj
                  </a>
                </div>
              </div>
            ) : (
              <>
                <button className="btn-login" onClick={handleLoginClick}>
                  Logowanie
                </button>
                <button className="btn-login" onClick={handleRegisterClick}>
                  Rejestracja
                </button>
              </>
            )}
          </div>
        </div>

        {/* Logowanie */}
        {popupLogin && (
          <section className="car-details" id="car-details">
            <div className="popup-container">
              <div className="popup">
                <div className="popup-header">
                  <h3 className="popup-header-text">Zaloguj się</h3>
                  <button className="close-btn" onClick={closePopUpLogin}>
                    X
                  </button>
                </div>
                <div className="popup-inputs-container">
                  <p className="popup-input-headers">Nazwa użytkownika/Adres email</p>
                  <input type="text" placeholder="Podaj adres email"></input>
                  <p className="popup-input-headers">Hasło</p>
                  <input
                    type={showPassword ? 'text' : 'password'}
                    placeholder="Podaj hasło"
                    id="passwordInput"
                  ></input>
                  <div className="popup-login-show-password">
                    <input
                      type="checkbox"
                      checked={showPassword}
                      onChange={handlePasswordToggle}
                    />
                    <p>Pokaż hasło</p>
                  </div>
                  <button className="popup-inputs-button" onClick={handleLoginSubmit}>
                    Zaloguj
                  </button>
                </div>
              </div>
            </div>
          </section>
        )}
        {/* Logowanie end */}

        {/* Rejestracja */}
        {popupRegister && (
          <section className="car-details" id="car-details">
            <div className="popup-container">
              <div className="popup">
                <div className="popup-header">
                  <h3 className="popup-header-text">Zarejestruj się</h3>
                  <button className="close-btn" onClick={closePopUpRegister}>
                    X
                  </button>
                </div>
                <div className="popup-inputs-container">
                  <p className="popup-input-headers">Imię</p>
                  <input type="text" placeholder="Podaj Imię"></input>
                  <p className="popup-input-headers">Nazwisko</p>
                  <input type="text" placeholder="Podaj Nazwisko"></input>
                  <p className="popup-input-headers">Adres email</p>
                  <input type="text" placeholder="Podaj adres email"></input>
                  <p className="popup-input-headers">Nr. kontaktowy</p>
                  <input type="text" placeholder="Podaj nr. kontaktowy"></input>
                  <p className="popup-input-headers">Ustaw hasło</p>
                  <input
                    type={showPassword ? 'text' : 'password'}
                    placeholder="Podaj hasło"
                    id="passwordInput"
                  ></input>
                  <div className="popup-login-show-password"></div>
                  <p className="popup-input-headers">Powtórz hasło</p>
                  <input
                    type={showPassword ? 'text' : 'password'}
                    placeholder="Powtórz hasło"
                    id="passwordInput"
                  ></input>
                  <div className="popup-login-show-password">
                    <input
                      type="checkbox"
                      checked={showPassword}
                      onChange={handlePasswordToggle}
                    />
                    <p>Pokaż hasło</p>
                  </div>
                  <button className="popup-inputs-button">Zarejestruj</button>
                </div>
              </div>
            </div>
          </section>
        )}
        {/* Rejestracja end */}
      </header>
    </>
  );
}

export default NavBar;