import React from 'react'
import CarSection from './CarSection'

function Footer() {
    // let header=document.querySelector('header');
    // window.addEventListener('scroll', () =>{
    //     header.classList.toogle('shadow', window.scrollY>0)
    // }) 

    //Odkomentowac jak pojawi sie header
  return (
    <>
    <section className= 'footer' >
        <div className= 'footer-container container'>
            <div className='footer-box'>
                <a href='#'   className='logo'>Car<span>Rent</span></a>
                <div className='social'>
                <a href='#'><i className='bx bxl-facebook'></i></a>
                <a href='#'><i className='bx bxl-twitter'></i></a>
                <a href='#'><i className='bx bxl-instagram'></i></a>
                <a href='#'><i className='bx bxl-youtube'></i></a>

                </div>
            </div>  
              <div className='footer-box'>
                <h3>Strona</h3>
                <a href='#'>Start</a>
                <a href='#'>Oferta</a>
                <a href='#'>Kontakt</a>
              </div>
              <div className='footer-box'>
                <h3>Legal</h3>
                <a href='#'>Prywatność</a>
                <a href='#'>Polityka Zwrotów</a>
                <a href='#'>Polityka Cookie</a>
                
              </div>

              <div className='footer-box'>
                <h3 >Kontakt</h3>
                <p className="bx bx-phone"> +48 676 687 972 </p>
                <p className="bx bx-envelope"> carrent@example.com</p>
                
              </div>
        </div>
    </section>
    <div className='copyright'>
        <p >&#169; CarRent, All Right Reserved</p>
    </div >
    </>
  )
}

export default Footer