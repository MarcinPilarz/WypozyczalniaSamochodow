
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function TSection() {
  
  
  
    const [cars, setCars] = useState([]);
  
  
    useEffect(() => {
      fetchCarsFromSpring();
    }, []);
  
    const fetchCarsFromSpring = async () => {
      try {
        const response = await axios.get('http://localhost:8080/samochod'); 
        setCars(response.data);
      } catch (error) {
        console.error(error);
      }
    };
  
    
    const filteredCarsByBrandId = (brandId) => {
      
      //
      return cars.filter((car) => car.marka.idMarka === brandId);
    };
    useEffect(() => {
      window.scrollTo(0, 0);
    }, []);
  
    
    const [expandedBoxes, setExpandedBoxes] = useState([]);
    const [rentalFormVisible, setRentalFormVisible] = useState(false);
    const [rentalFormData, setRentalFormData] = useState({
      carName: '',
      fullName: '',
      email: '',
      phone: '',
    });
  
    const handleDetailsClick = (boxId) => {
      if (expandedBoxes.includes(boxId)) {
        setExpandedBoxes(expandedBoxes.filter((box) => box !== boxId));
      } else {
        setExpandedBoxes([...expandedBoxes, boxId]);
      }
    };
    const [popup, setPop] = useState(false);
  
    const handleRentClick = () => {
      setPop(!popup);
    }
    const closePopUp = () => {
      setPop(false)
    }
    const handleFormInputChange = (e) => {
      const { name, value } = e.target;
      setRentalFormData({ ...rentalFormData, [name]: value });
    };
  
    const handleFormSubmit = (e) => {
      e.preventDefault();
      // Przetwarzanie danych z formularza
      console.log(rentalFormData);
      // Możesz dodać tutaj kod do wysłania danych lub innych operacji
      setRentalFormVisible(false);
      setRentalFormData({
        carName: '',
        fullName: '',
        email: '',
        phone: '',
      });
      alert('Formularz został wysłany');
    };
  
    const getDetailsButtonText = (boxId) => {
      return expandedBoxes.includes(boxId) ? 'Zwiń szczegóły' : 'Wyświetl szczegóły';
    };

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
    return(
      <>
      <NavBar/>
     
        {/* <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>Tesla</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3> Model 3</h3>
            <img src="img/model3trans2-removebg-preview.png" alt="" />
            <span>399 PLN</span>
            <a href="#" id='111' className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3>Model S</h3>
            <img src="img/teslastrans-removebg-preview.png" alt="" />
            <span>499 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3> Model X</h3>
            <img src="img/xtrans.png" alt="" />
            <span>399 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
        </div>
      </section> */}

<section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>TESLA</h2>
          <p>Elektryczne</p>
        </div>
        <div>
          {popup ?
            <div className="popup-container">
              <div className="popup">
                <div className="popup-header">
                  <h3 className="popup-header-text">Formularz wynajmu</h3>
                  <button className="close-btn" onClick={closePopUp}>X</button>
                </div>
                <div className="popup-inputs-container">
                  <p className="popup-input-headers">Data wynajmu</p>
                  <input className="datepicker" type="date"></input>
                  <p className="popup-input-headers">Miejsce odbioru</p>
                  <input type="text" placeholder="Podaj miejsce odbioru pojazdu"></input>
                  <p className="popup-input-headers">Data zwrotu</p>
                  <input type="date"></input>

                  <p className="popup-input-headers">Miejsce zwrotu</p>
                  <input type="text" placeholder="Podaj miejsce zwrotu pojazdu"></input>
                  <p className="popup-input-headers">Dodatkowe informacje</p>
                  <textarea type="text" placeholder=""></textarea>
                  <button className="popup-inputs-button">Zapisz i prześlij</button>
                </div>
              </div>

            </div> : ""}
        </div>
        <div className="car-details-container container">
          {filteredCarsByBrandId(4).map((car) => (
            <div key={car.id} className={`box ${expandedBoxes.includes(car.id) ? 'expanded' : ''}`}>
              <h3>{car.modelSamochodu.nazwa}</h3>
              <img src="img/bmw-i3 transpppp.png" alt="" />
              <span>{car.cenaSamochodu} PLN</span>
              {expandedBoxes.includes(car.id) && (
                <div className="additional-details">
                  <p>Moc silnika: {car.moc_silnika}</p>
                  <p>Pojemność baterii: {car.pojemnosc_baterii}</p>
                  <p>Rok produkcji: {car.rokProdukcji}</p>
                  <p>Kolor samochodu: {car.kolor_samochodu}</p>
                  <p>Ilość drzwi: {car.ilosc_drzwi}</p>
                </div>
              )}
              <a href="#" id="111" className="btn" onClick={() => handleRentClick(car.model)}>
                Wynajmij
              </a>
              <a href="#" className="details" onClick={() => handleDetailsClick(car.id)}>
                {getDetailsButtonText(car.id)}
              </a>
            </div>
          ))}
        </div>
      </section>
      <Footer/>
      </>
    )
}

export default TSection