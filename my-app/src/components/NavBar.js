import React from 'react'
import '../App.css';

function NavBar() {
    return (

        <header>
        <div class="nav container">
          <i class="bx bx-menu" id="menu-icon"></i>
          <a href="#" class="logo">Car<span>Rent</span></a>
          <ul class="navbar">
            <li><a href="#Start" class="active">Start</a></li>
            <li><a href="#Oferta">O nas</a></li>
            <li><a href="#Wynajem">Oferta</a></li>
            <li><a href="#Kontakt">Kontakt</a></li>
          </ul>
          <i class="bx bx-search" id="search-icon"></i>
          <div class="search-box container">
            <input type="search" placeholder="Szukaj..." />
          </div>
          <div class="btn-login-container">
            <button class="btn-login" href="#Logowanie">Logowanie</button>
            <button class="btn-login" href="#Rejestracja">Rejestracja</button>
          </div>
        </div>
      </header>
    )
}
export default NavBar