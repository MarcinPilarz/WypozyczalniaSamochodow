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
function App() {
  return (
    <BrowserRouter>
      
 

  
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path="/BMW" element={<BMWSection />} />
        <Route path='/Audi' element={<ASection/>}/>
        <Route path='/Tesla' element={<TSection/>}/>
        <Route path='/Toyota' element={<ToyotaSection/>}/>
        <Route path='/Volvo' element={<VolvoSection/>}/>
        <Route path="/about" element={<AboutUsSection />} />
        <Route path="/cars" element={<CarSection />} />
        <Route path="/car-details/:carName" element={<BMWSection />} />
        <Route path='/Contact' element={<ContactSection/>}/>
        <Route path="*" element={<NoPage/>} />

      </Routes>
     
    </BrowserRouter>
  );
}


export default App;
