import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import StartSection from './components/StartSection';
import AboutUsSection from './components/AboutUsSection';
import CarSection from './components/CarSection';
import Footer from './components/Footer';
import CarDetailsSection from './components/CarDetailsSection';
import { BrowserRouter, Routes, Route , Link} from "react-router-dom";
function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <StartSection />
    <AboutUsSection />
    {/* <CarDetailsSection /> */}
    <CarSection/>

    <nav>
        <Link to="/"> Home </Link>
        <Link to="login"> Login </Link>
        <Link to="products/search"> Products </Link>
      </nav>
      <Routes>
        <Route path="/1" element={<CarDetailsSection />} />
        <Route path="/about" element={<AboutUsSection />} />
        <Route path="/cars" element={<CarSection />} />
        <Route path="/car-details/:carName" element={<CarDetailsSection />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}


export default App;
