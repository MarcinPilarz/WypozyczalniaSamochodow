import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import StartSection from './components/StartSection';
import AboutUsSection from './components/AboutUsSection';
import CarSection from './components/CarSection';
import Footer from './components/Footer';
import ASection from './components/ASection';
import { BrowserRouter, Routes, Route , Link} from "react-router-dom";
import Home from './components/Home';
import BMWSection from './components/BMWSection';
import TSection from './components/TSection';
import ContactSection from './components/ContactSection';
import NoPage from './components/404';
import ToyotaSection from './components/ToyotaSection';
import VolvoSection from './components/VolvoSection';
import CookieSection from './components/Cookie';
import UserPanel from './components/UserPanel';
import CarTable from './components/CarTable';
//import ASection from './components/ASection';
import React, { useEffect, useState } from 'react';
function App() {
  const [idKlienta, setIdKlienta] = useState(null);
  const [isUserLoggedIn, setIsUserLoggedIn] = useState(false);

  useEffect(() => {
    const storedIdKlienta = localStorage.getItem('idKlienta');
    if (storedIdKlienta) {
      setIdKlienta(storedIdKlienta);
      setIsUserLoggedIn(true);
    } else {
      setIsUserLoggedIn(false);
    }
  }, []);
  return (
    <BrowserRouter>
      
   

  
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path="/User" element={<UserPanel />} />
        <Route path="/BMW" element={<BMWSection />} />
        <Route path='/Audi' element={<ASection idKlienta={idKlienta}/>}/>
        <Route path='/Tesla' element={<TSection/>}/>
        <Route path='/Toyota' element={<ToyotaSection/>}/>
        <Route path='/Volvo' element={<VolvoSection/>}/>
        <Route path="/about" element={<AboutUsSection />} />
        <Route path="/cars" element={<CarSection />} />
        <Route path='/Cookies' element={<CookieSection/>}/>
        <Route path="/car-details/:carName" element={<BMWSection />} />
        <Route path='/Contact' element={<ContactSection/>}/>
        <Route path="/add-car" element={<CarTable />} />
        <Route path="*" element={<NoPage/>} />

       
      </Routes>
      {/* {isUserLoggedIn && <NavBar idKlienta={idKlienta} />} */}
      {/* <Footer/> */}
    </BrowserRouter>
  );
}


export default App;
