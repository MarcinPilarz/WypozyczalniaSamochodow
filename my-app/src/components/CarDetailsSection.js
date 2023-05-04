import React from 'react'
import '../App.css';

function CarDetailsSection() {
    return(
        <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2>BMW</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3>BMW I3</h3>
            <img src="img/bmw-i3 transpppp.png" alt="" />
            <span>199.00PLN</span>
            <a href="#" id='111' className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3>BMW I8</h3>
            <img src="img/abmw trans.png" alt="" />
            <span>1099.00PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3>BMW IX</h3>
            <img src="img/ix_trans-removebg-preview.png" alt="" />
            <span>549.00PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
        </div>
      </section>
    )
}

export default CarDetailsSection