import React, { useEffect, useState } from 'react';
import '../App.css';
import Home from './Home';
import axios from 'axios';
import Modal from 'react-modal';

import BMWSection from './BMWSection';
Modal.setAppElement('#root');
function NavBar() {
  //const [popupLogin, setPopupLogin] = useState(false);
  //const [popupRegister, setPopupRegister] = useState(false);
  const [showPassword, setShowPassword] = useState(false);
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

  // const handleModalClose = () => {
  //   setShowRegistrationSuccess(false);
  // };
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


  const handleLoginSubmit = async (event) => {
    event.preventDefault();
    
    try {
      // Wykonaj żądanie logowania na serwerze
      const response = await axios.post('http://localhost:8080/login', loginData);
      console.log(response.data); // Odpowiedź z serwera
  
      // Zresetuj pola formularza logowania
      setLoginData({
        username: '',
        password: ''
      });
  
      // Przetwórz odpowiedź z serwera i wykonaj odpowiednie akcje (np. przechowywanie tokena, przekierowanie użytkownika itp.)
    } catch (error) {
      console.log(error); // Obsługa błędu
    }
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
                    <button type='submit' onClick={handleLoginSubmit} className="popup-inputs-button">Zaloguj</button>
                    
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
                    <div className="popup-login-show-password">
                     
                    </div>
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
            ) : (
              ''
            )}
          </div>
        </section>
        {/* Rejestracja end */}
      </header>
        {/* Modal z wiadomością o udanej rejestracji */}
       {/* Okno z wiadomością o udanej rejestracji */}
     
    </>
  );

}

export default NavBar;