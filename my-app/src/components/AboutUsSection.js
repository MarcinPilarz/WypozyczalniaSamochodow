import React from 'react'
import '../App.css';

function AboutUsSection(){
    return(
        <section class="about container" id="about">
        <div class="about-img">
          <img src="img/abmw trans.png" alt="" />
        </div>
        <div class="about-text">
          <span>O nas</span>
          <h2>
            Lorem ipsum dolor sit<br />
            amet consectetur
          </h2>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum culpa
            voluptas sapiente ratione placeat vel minus, sed et. Nisi, in?
          </p>
          <a href="#" class="btn">Dowiedz się więcej</a>
        </div>
      </section>
    )
}
export default AboutUsSection