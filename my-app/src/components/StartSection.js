import React from 'react';
import '../App.css';
import'../components/CarSection';

function StartSection() {
  const handleButtonClick = () => {
    const element = document.getElementById('bottom');
    element.scrollIntoView({ behavior: 'smooth' });
  };

  return (
    <section className="home" id="">
      <div className="home-text">
        <h1>Lorem, <span>ipsum</span> dolor.</h1>
        <p>
          Lorem ipsum dolor sit amet consectetur, <br />
          adipisicing elit. Ullam, molestias.
        </p>
        <a href="#botstom"   className="btn" onClick={handleButtonClick}>
          Sprawdź naszą ofertę
        </a>
      </div>
    </section>
  );
}

export default StartSection;
