
import './App.css';
import NavBar from './components/NavBar';
import StartSection from './components/StartSection';
import AboutUsSection from './components/AboutUsSection';
import CarSection from './components/CarSection';
import Footer from './components/Footer';

import React from "react";




function Home() {
  return (
    <>
    <NavBar />
    <StartSection />
    <AboutUsSection />
    {/* <CarDetailsSection /> */}
    <CarSection/>
    <Footer/>
    </>
  );
}

export default Home;
