import React from 'react'
import { BrowserRouter, Routes, Route , Link} from "react-router-dom";
import '../App.css';
import '../components/CarDetailsSection';
import '../components/Footer'

//import './LogoBrandsImg';
function CarSection() {




    const handleButtonClick2 = () => {
        const element = document.getElementById('111');
        element.scrollIntoView({ behavior: 'smooth' });
      };
  return (


    
  <section>
   <div id='bottom' className='bottom' style={{ width: '60px', height: '60px' }}></div>

    <div  className='heading'>

        <span>Nasza Oferta</span>
    
    </div>
    <div className="cars-container container">
        <Link to="/1" className="box">
          <img className="Logo-container" src="./LogoBrandsImg/AudiLogo1.png" alt="Logo Audi" />
          <h2>AUDI</h2>
        </Link>

        <Link to="/1" className="box" onClick={handleButtonClick2}>
          <img className="Logo-container" src="./LogoBrandsImg/bmwLogo3.png" alt="BMW Logo" />
          <h2>BMW</h2>
        </Link>

        <Link to="/1" className="box">
          <img className="Logo-container" src="./LogoBrandsImg/HondaLogo.jpg" alt="Lexus Logo" />
          <h2>Honda</h2>
        </Link>
      </div>
    <div className='cars-container container'>

        <div className='box' onClick={()=>console.log('Tesla')}>
        <img  className='Logo-container' src='./LogoBrandsImg/TeslaLogo.png' alt='Logo Tesli'/>
        <h2>Tesla</h2>
        </div>
        <div className='box' onClick={()=>console.log('Toyota')}>
        <img className='Logo-container' src='./LogoBrandsImg/ToyotaLogo2.png' alt='Logo Honda'/>
        <h2>Toyota</h2>
        </div>

        <div className='box' onClick={()=>console.log('volvo')}>
            <img className='Logo-container' src='./LogoBrandsImg/VolvoLogo1.png' alt='VolvoLogo' />
            <h2>Volvo</h2>
        </div>
        </div>
        
  </section>

  )
}

export default CarSection;