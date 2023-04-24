import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import StartSection from './components/StartSection';
import AboutUsSection from './components/AboutUsSection';
import CarSection from './components/CarSection';
import Footer from './components/Footer';
import CarDetailsSection from './components/CarDetailsSection';
function App() {
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

export default App;
