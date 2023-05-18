import React from 'react'
import '../App.css';
import Home from './Home';
import BMWSection from './BMWSection';
function NavBar() {


  const handleButtonClick = () => {
    const element = document.getElementById('bottom');
    if (element) {
      element.scrollIntoView({ behavior: 'smooth' });
    } else {
      window.location.href = "/";
    }
    
    const element2 = document.getElementById('bottom');
    if (element2) {
      element2.scrollIntoView({ behavior: 'smooth' });
    }
  };
    return (

        <header>
        <div className="nav container">
          <i className="bx bx-menu" id="menu-icon"></i>
          <a href="/" className="logo">Car<span>Rent</span></a>
          <ul className="navbar">
            <li><a href="/" className="active">Start</a></li>
            <li><a href="#Oferta">O nas</a></li>
            <li><a onClick={handleButtonClick}>Oferta</a></li>
            <li><a href="/Contact">Kontakt</a></li>
          </ul>
          <i className="bx bx-search" id="search-icon"></i>
          <div className="search-box container">
            <input type="search" placeholder="Szukaj..." />
          </div>
          <div className="btn-login-container">
            <button className="btn-login" href="#Logowanie">Logowanie</button>
            <button className="btn-login" href="#Rejestracja">Rejestracja</button>
          </div>
        </div>
      </header>
     
    )
}
export default NavBar