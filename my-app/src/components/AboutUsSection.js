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
            Lorem ipsum dolor sit<br />
            amet consectetur
          </h2>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum culpa
            voluptas sapiente ratione placeat vel minus, sed et. Nisi, in?
          </p>
          <a href="#" className="btn" onClick={()=>console.log('dsw')}>Dowiedz się więcej</a>
        </div>
      </section>
    )
}
export default AboutUsSection