import React from 'react'
import '../App.css';

function AboutUsSection(){
    return(
        <section className="about container" id="about">
        <div className="about-img">
          <img src="img/abmw trans.png" alt="" />
        </div>
        <div className="about-text">
          <span>O nas</span>
          <h2>
          Wypożycz auto i wybierz swój kierunek podróży!<br />
            
          </h2>
          <p>
          W naszej wypożyczalni samochodów oferujemy szeroki wybór pojazdów, elastyczne ceny oraz szybką i łatwą procedurę wynajmu.
          </p>
          <a href="#" className="btn" onClick={()=>console.log('dsw')}>Dowiedz się więcej</a>
        </div>
      </section>
    )
}
export default AboutUsSection