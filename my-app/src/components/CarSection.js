import React from 'react'
import { BrowserRouter, Routes, Route , Link} from "react-router-dom";
import '../App.css';
import './BMWSection';
import '../components/Footer'

/**
 * Komponent CarSection - sekcja wyświetlająca wszystkie marki.
 */
function CarSection() {




   
  return (


    
  <section>
   <div id='bottom' className='bottom' style={{ width: '60px', height: '60px' }}></div>

    <div  className='heading'>

        <span>Nasza Oferta</span>
    
    </div>
    <div className="cars-container container">
        <Link to="/Audi" className="box">
          <img className="Logo-container" src="./LogoBrandsImg/AudiLogo1.png" alt="Logo Audi" />
          <h2>AUDI</h2>
        </Link>

        <Link to="/BMW" className="box" >
          <img className="Logo-container" src="./LogoBrandsImg/bmwLogo3.png" alt="BMW Logo" />
          <h2>BMW</h2>
        </Link>

        <Link to="/Honda" className="box">
          <img className="Logo-container" src="./LogoBrandsImg/HondaLogo.jpg" alt="Lexus Logo" />
          <h2>Honda</h2>
        </Link>
      </div>
    <div className='cars-container container'>

        <div className='box' >
        <Link to="/Tesla" >
        <img  className='Logo-container' src='./LogoBrandsImg/TeslaLogo.png' alt='Logo Tesli'/>
        <h2>Tesla</h2>
        </Link>
        </div>

        <div className='box' >
        <Link to="/Toyota" >
        <img className='Logo-container' src='./LogoBrandsImg/ToyotaLogo2.png' alt='Logo Honda'/>
        <h2>Toyota</h2>
        </Link>
        </div>

        <div className='box' >
           <Link to="/Volvo" >
            <img className='Logo-container' src='./LogoBrandsImg/VolvoLogo1.png' alt='VolvoLogo' />
            <h2>Volvo</h2>
            </Link>
        </div>
        </div>
        
  </section>

  )
}

export default CarSection;