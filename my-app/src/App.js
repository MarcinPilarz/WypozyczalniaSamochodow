import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import StartSection from './components/StartSection';
import AboutUsSection from './components/AboutUsSection';
import CarSection from './components/CarSection';
import Footer from './components/Footer';


import { BrowserRouter, Routes, Route , Link} from "react-router-dom";
import Home from './components/Home';
import BMWSection from './components/BMWSection';
function App() {
  return (
    <BrowserRouter>
      
 

  
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path="/1" element={<BMWSection />} />
        <Route path="/about" element={<AboutUsSection />} />
        <Route path="/cars" element={<CarSection />} />
        <Route path="/car-details/:carName" element={<BMWSection />} />
      </Routes>
     
    </BrowserRouter>
  );
}


export default App;
