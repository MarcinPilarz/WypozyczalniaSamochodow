
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect } from 'react';

function VolvoSection() {


  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
    return(
      <>
      <NavBar/>
     
        <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>Volvo</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3> Model 3</h3>
            <img src="img/model3trans2-removebg-preview.png" alt="" />
            <span>399 PLN</span>
            <a href="#" id='111' className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3>Model S</h3>
            <img src="img/teslastrans-removebg-preview.png" alt="" />
            <span>499 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3> Model X</h3>
            <img src="img/xtrans.png" alt="" />
            <span>399 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
        </div>
      </section>
      <Footer/>
      </>
    )
}

export default VolvoSection