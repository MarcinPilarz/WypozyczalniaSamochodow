import React from 'react'
import '../App.css';
//import './LogoBrandsImg';
function CarSection() {
  return (
    
  
  <section>
    <div className='heading'>

        <span>Oferty</span>
        <h2>Typy samochodów</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Explicabo, quia.</p>
    
    </div>
    <div className='cars-container container'>
        <div className='box'>
        <img  className='Logo-container' src='./LogoBrandsImg/TeslaLogo.png' alt='Logo Tesli'/>
        <h2>Tesla</h2>
        </div>
        <div className='box'>
        <img className='Logo-container' src='./LogoBrandsImg/AudiLogo1.png' alt='Logo Audi'/>
        <h2>AUDI</h2>
        </div>
        <div className='box'> 
        <img className='Logo-container' src='./LogoBrandsImg/bmwLogo3.png' alt='BMW Logo'/>
        <h2>BMW</h2>
        </div>
        <div className='box'>
        <img className='Logo-container' src='./LogoBrandsImg/HondaLogo.jpg' alt='Logo Honda'/>
        <h2>Honda</h2>
        </div>
        <div className='box'>
            <img className='Logo-container' src='./LogoBrandsImg/ToyotaLogo2.png' alt='Toyota Logo' />
            <h2>Toyota</h2>
        </div>
        <div className='box'>
            <img className='Logo-container' src='./LogoBrandsImg/LexusLogo3.png' alt='Lexus Logo' />
            <h2>Lexus</h2>
        </div>
        
    </div>
  </section>

  )
}

export default CarSection