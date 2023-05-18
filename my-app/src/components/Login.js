import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect, useState } from 'react';

function BMWSection() {


   
  
  
 

return (
    <>
      <div>
            {popup ? (
              <div className="popup-container">
                <div className="popup">
                  <div className="popup-header">
                    <h3 className="popup-header-text">Panel Logowania</h3>
                    <button className="close-btn" onClick={closePopUp}>
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

         </>
  );
}

export default Login;
