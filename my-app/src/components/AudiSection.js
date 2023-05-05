
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect } from 'react';

function AudiSection() {


  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
    return(
      <>
      <NavBar/>
     
        <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>AUDI</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3> e-tron</h3>
            <img src="img/etrontrans2.png" alt="" />
            <span>399 PLN</span>
            <a href="#" id='111' className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3>Q8 e-tron</h3>
            <img src="img/q8etrontrans.png" alt="" />
            <span>1099 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3> RS e-tron GT</h3>
            <img src="img/rsetrontrans.png" alt="" />
            <span>1049 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
        </div>
      </section>
      <Footer/>
      </>
    )
}

export default AudiSection