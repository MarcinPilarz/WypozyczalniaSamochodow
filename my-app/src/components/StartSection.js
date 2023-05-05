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
        <h1>Zaplanuj <span>swoją</span> podróż.</h1>
        <p>
        Przyszłość już jest – wynajmij samochód elektryczny <br />
        Odkryj nowy sposób na podróżowanie
        </p>
        <a    className="btn" onClick={handleButtonClick}>
          Sprawdź naszą ofertę
        </a>
      </div>
    </section>
  );
}

export default StartSection;
