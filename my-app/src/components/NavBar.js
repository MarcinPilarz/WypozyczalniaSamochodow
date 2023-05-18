import React, { useEffect, useState } from 'react';
import '../App.css';
import Home from './Home';



import BMWSection from './BMWSection';

function NavBar() {
  const [showPassword, setShowPassword] = useState(false);

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

  const [popupLogin, setPopLogin] = useState(false);

  const handleLoginClick = () => {
    setPopLogin(!popupLogin);
  };

  const closePopUpLogin = () => {
    setPopLogin(false);
  };
  const [popupRegister, setPopRegister] = useState(false);

  const handleRegisterClick = () => {
    setPopRegister(!popupRegister);
  };

  const closePopUpRegister = () => {
    setPopRegister(false);
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
            <button className="btn-login" href="#Logowanie" onClick={handleLoginClick}>
              Logowanie
            </button>
            <button className="btn-login" href="#Rejestracja" onClick={handleRegisterClick}>
              Rejestracja
            </button>
          </div>
        </div>
{/* Logowanie */}
        <section className="car-details" id="car-details">
          <div>
            {popupLogin ? (
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
                    <button className="popup-inputs-button">Zaloguj</button>
                  </div>
                </div>
              </div>
            ) : (
              ''
            )}
          </div>
        </section>
        {/* Logowanie end */}
        {/* Rejestracja */}
        <section className="car-details" id="car-details">
          <div>
            {popupRegister ? (
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
                    <div className="popup-login-show-password">
                     
                    </div>
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
            ) : (
              ''
            )}
          </div>
        </section>
        {/* Rejestracja end */}
      </header>
    </>
  );

}

export default NavBar;