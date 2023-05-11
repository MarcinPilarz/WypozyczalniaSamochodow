import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect } from 'react';

function CookieSection() {
  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  return (
    <>
      <NavBar/>

      <div className="car-details-heading" id="111">
        <h2 style={{ marginTop: '150px' }}>Polityka Cookie</h2>
      </div>

      <div className="car-details-heading">
        <h3 style={{ marginTop: '50px' }}>Czym są pliki cookie?</h3>
      </div>


      <div className="container2">
      <div className="column column-1"></div>
      <div className="column column-2" > <p>Pliki cookie to małe pliki tekstowe, które przechowywane są na urządzeniu użytkownika (komputerze, tablecie, smartfonie) podczas przeglądania strony internetowej. Mogą być one wykorzystywane do gromadzenia informacji o użytkowniku, takich jak preferencje i nawyki przeglądania stron.</p></div>
      <div className="column column-3"></div>
    </div>

      <Footer/>
    </>
  )
}

export default CookieSection
