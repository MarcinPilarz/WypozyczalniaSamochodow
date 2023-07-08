import React, { useEffect, useState } from 'react';
import '../App.css';
import Home from './Home';
import axios from 'axios';

import { useNavigate } from 'react-router-dom';
import BMWSection from './BMWSection';

import CarTable from './CarTable';
/**
 * Komponent NavBar - pasek nawigacyjny.
 */
function NavBar() {
  const [showPassword, setShowPassword] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [popupLogin, setPopupLogin] = useState(false);
  const [popupRegister, setPopupRegister] = useState(false);
  const [registrationData, setRegistrationData] = useState({
    username: '',
    imie: '',
    nazwisko: '',
    email: '',
    telefon: '',
    password: '',
    confirmPassword: ''
  });

  const [showRegistrationSuccess, setShowRegistrationSuccess] = useState(false);

  const [loginData, setLoginData] = useState({
    username: '',
    password: ''
  });
  const [loggedInUser, setLoggedInUser] = useState(null);
  const [userRole, setUserRole] = useState(''); // Dodany stan userRole
  const navigate = useNavigate();

  const [klientId, setKlientId] = useState(null);
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

  /**
   * Funkcja obsługująca przycisk "Zaloguj".
   */
  const handleLoginClick = () => {
    setPopupLogin(true);
  };

  const closePopupLogin = () => {
    setPopupLogin(false);
  };

  const handleRegisterClick = () => {
    setPopupRegister(true);
  };

  const closePopupRegister = () => {
    setPopupRegister(false);
  };

  
  const closePopUpRegister = () => {
    setPopupRegister(false);
  };

  const handleLogoutClick = () => {
    // Wyczyść token i role z localStorage
    localStorage.removeItem('token');
    localStorage.removeItem('userRole');
    localStorage.removeItem('idKlienta');
    // Zaktualizuj stany
    setIsLoggedIn(false);
    setUserRole('');
    setKlientId(null);
  };

  
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setRegistrationData((prevState) => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleRegistrationSuccess = () => {
    setShowRegistrationSuccess(true);
    closePopUpRegister();
  };

  const handleRegisterSubmit = async () => {
    try {
      const response = await axios.post('http://localhost:8080/klienci', registrationData);
      console.log(response.data); // Odpowiedź z serwera

      // Wyczyść pola formularza po udanym zarejestrowaniu
      setRegistrationData({
        username: '',
        imie: '',
        nazwisko: '',
        email: '',
        telefon: '',
        password: ''
      });
      handleRegistrationSuccess(true);
    } catch (error) {
      console.log(error); // Obsługa błędu
    }
  };

  const handleLoginInputChange = (event) => {
    const { name, value } = event.target;
    setLoginData((prevState) => ({
      ...prevState,
      [name]: value
    }));
  };
//debugger

const handleLoginSubmit = async (event) => {
  event.preventDefault();

  try {
    const response = await axios.post('http://localhost:8080/login', loginData);
    console.log(response.data);

    const { role, token } = response.data;
    console.log(role);
    console.log(token);

    localStorage.setItem('token', token);
    localStorage.setItem('userRole', role);
    setLoggedInUser(response.data);
    setIsLoggedIn(true);
    setLoggedInUser(response.data.username);
    setUserRole(role);

    debugger
    if (response.data.klient) {
      const idKlienta = response.data.klient.idKlienta;
      setKlientId(idKlienta);
      localStorage.setItem('idKlienta', idKlienta)
      console.log(idKlienta);
    }

    setLoginData({
      username: '',
      password: ''
    });

    closePopupLogin();
  } catch (error) {
    console.log(error);
  }
};

useEffect(() => {
  const token = localStorage.getItem('token');
  const role = localStorage.getItem('userRole');
  const idKlienta = localStorage.getItem('idKlienta'); 
  if (token && role) {
    setIsLoggedIn(true);
    setUserRole(role);
  }
  if (idKlienta) {
    setKlientId(idKlienta);
  }
}, []);



  const handleAddCarClick = () => {
    // Przekierowanie do strony "Dodaj samochód"
    navigate('/add-car');
  };

  return (
    <>
      <header>
        <div className="nav ">
          
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
                {isLoggedIn && userRole === 'ROLE_ADMIN' && (
                <button className="nav__btn" onClick={handleAddCarClick}>
                          Dodaj pojazd
                     </button>
                    )}
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
      </header>

      {/* Logowanie */}
      {popupLogin && (
        <section className="car-details" id="car-details">
          <div>
            <div className="popup-container">
              <div className="popup">
                <div className="popup-header">
                  <h3 className="popup-header-text">Zaloguj się</h3>
                  <button className="close-btn" onClick={closePopupLogin}>
                    X
                  </button>
                </div>
                <div className="popup-inputs-container">
                  <p className="popup-input-headers">Nazwa użytkownika/Adres email</p>
                  <input 
                    type="text"
                    name="username"
                    placeholder="Podaj adres email"
                    value={loginData.username}
                    onChange={handleLoginInputChange}
                  
                     />
                  <p className="popup-input-headers">Hasło</p>
                  <input
                      type={showPassword ? 'text' : 'password'}
                      placeholder="Podaj hasło"
                      name="password"
                      id="passwordInput"
                      value={loginData.password}
                      onChange={handleLoginInputChange}
                    />
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
          </div>
        </section>
      )}
      {/* Logowanie end */}

      {/* Rejestracja */}
      {popupRegister && (
        <section className="car-details" id="car-details">
          <div>
            <div className="popup-container">
              <div className="popup">
                <div className="popup-header">
                  <h3 className="popup-header-text">Zarejestruj się</h3>
                  <button className="close-btn" onClick={closePopupRegister}>
                    X
                  </button>
                </div>
                
                <div className="popup-inputs-container">
                  <p className="popup-input-headers">Nazwa użytkownika</p>
                    <input 
                    type="text" 
                    name="username"
                    placeholder="Podaj nazwe użytkownika"
                    value={registrationData.username}
                    onChange={handleInputChange}
                    />
                  <p className="popup-input-headers">Imię</p>
                  <input 
                    type="text" 
                    name="imie"
                    placeholder="Podaj Imię"
                    value={registrationData.imie}
                    onChange={handleInputChange}
                    />
                  <p className="popup-input-headers">Nazwisko</p>
                  <input 
                    type="text" 
                    name="nazwisko"
                    placeholder="Podaj Nazwisko"
                    value={registrationData.nazwisko}
                    onChange={handleInputChange}
                    />

                  <p className="popup-input-headers">Adres email</p>
                  <input 
                    type="text"
                    name="email" 
                    placeholder="Podaj adres email"
                    value={registrationData.email}
                    onChange={handleInputChange}
                    />
                  <p className="popup-input-headers">Nr. kontaktowy</p>
                  <input 
                    type="text" 
                    name="telefon"
                    placeholder="Podaj nr. kontaktowy"
                    value={registrationData.telefon}
                    onChange={handleInputChange}
                    />
                  <p className="popup-input-headers">Ustaw hasło</p>
                  <input
                      type={showPassword ? 'text' : 'password'}
                      name="password"
                      placeholder="Podaj hasło"
                      id="passwordInput"
                      value={registrationData.password}
                      onChange={handleInputChange}
                    />
                  <div className="popup-login-show-password"></div>
                  <p className="popup-input-headers">Powtórz hasło</p>
                  <input
                      type={showPassword ? 'text' : 'password'}
                      name="confirmPassword"
                      placeholder="Powtórz hasło"
                      id="passwordInput"
                      value={registrationData.confirmPassword}
                      onChange={handleInputChange}
                    ></input>
                  <div className="popup-login-show-password">
                    <input
                      type="checkbox"
                      checked={showPassword}
                      onChange={handlePasswordToggle}
                    />
                    <p>Pokaż hasło</p>
                  </div>
                  <button className="popup-inputs-button" onClick={handleRegisterSubmit}>Zarejestruj</button>
                </div>
              </div>
            </div>
          </div>
        </section>
      )}
      {/* Rejestracja end */}
    </>
  );
}

export default NavBar;