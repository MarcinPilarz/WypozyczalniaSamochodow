
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect } from 'react';

function BMWSection() {


  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
    return(
      <>
      <NavBar/>
     
        <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>BMW</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3> I3</h3>
            <img src="img/bmw-i3 transpppp.png" alt="" />
            <span>199 PLN</span>
            <a href="#" id='111' className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3> I8</h3>
            <img src="img/abmw trans.png" alt="" />
            <span>1099 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3> IX</h3>
            <img src="img/ix_trans-removebg-preview.png" alt="" />
            <span>549 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
        </div>
      </section>
      <Footer/>
      </>
    )
}

export default BMWSection