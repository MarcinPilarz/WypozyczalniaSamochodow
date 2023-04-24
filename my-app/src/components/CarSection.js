import React from 'react'
import '../App.css';

//import './LogoBrandsImg';
function CarSection() {
  return (
  <section>
    <div className='heading'>

        <span>Nasza Oferta</span>
    
    </div>
    <div className='cars-container container'>
        <div className='box'>
        <img className='Logo-container' src='./LogoBrandsImg/AudiLogo1.png' alt='Logo Audi'/>
        <h2>AUDI</h2>
        </div>
        <div className='box'> 
        <img className='Logo-container' src='./LogoBrandsImg/bmwLogo3.png' alt='BMW Logo'/>
        <h2>BMW</h2>
        </div>
        <div className='box'>
            <img className='Logo-container' src='./LogoBrandsImg/HondaLogo.jpg' alt='Lexus Logo' />
            <h2>Honda</h2>
        </div>
    </div>
    <div className='cars-container container'>

        <div className='box'>
        <img  className='Logo-container' src='./LogoBrandsImg/TeslaLogo.png' alt='Logo Tesli'/>
        <h2>Tesla</h2>
        </div>
        <div className='box'>
        <img className='Logo-container' src='./LogoBrandsImg/ToyotaLogo2.png' alt='Logo Honda'/>
        <h2>Toyota</h2>
        </div>
        <div className='box'>
            <img className='Logo-container' src='./LogoBrandsImg/VolvoLogo1.png' alt='VolvoLogo' />
            <h2>Volvo</h2>
        </div>
        </div>
        
  </section>

  )
}

export default CarSection