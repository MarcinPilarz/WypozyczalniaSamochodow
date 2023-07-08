
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect } from 'react';

/**
 * Komponent NontactSection - sekcja wyświetlająca możliwość kontaktowania się z wypożyczalnią.
 */
function ContactSection() {


  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
    return(
      <>
      <NavBar/>
     
        <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>Kontakt</h2>
          <p></p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3 style={{ marginBottom: '20px' }}> Telefonicznie</h3>
            <img src="img/phonetrans2-removebg-preview.png" alt="" style={{ marginBottom: '20px' }} />
            <span> +48 676 687 972</span>
            
          </div>
          <div className="box">
            <h3 style={{ marginBottom: '20px' }}> Mailowo</h3>
            <img src="img/mailtrans.png" alt="" style={{ marginBottom: '20px' }} />
            <span style={{ marginLeft: '20px' }}>
            <a href="mailto:carrent@example.com">carrent@example.com</a>
            </span>

            
          </div>
          
        </div>
      </section>
      <Footer/>
      </>
    )
}

export default ContactSection