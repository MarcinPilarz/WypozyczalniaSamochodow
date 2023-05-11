import React from 'react';
import '../App.css';
import NavBar from './NavBar';
import StartSection from './StartSection';
import AboutUsSection from './AboutUsSection';
import CarSection from './CarSection';
import Footer from './Footer';





function Home() {
     return (
        <> 
        <NavBar />
          <StartSection />
          <AboutUsSection />
            <CarSection/>
            <Footer/>
            </>
        
     )
}

export default Home