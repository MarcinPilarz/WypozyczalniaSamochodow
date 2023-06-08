
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
//import base64Img from 'base64-img';

function ASection() {

  const [cars, setCars] = useState([]);
  const [branches, setBranches] = useState([]);

  useEffect(() => {
    fetchCarsFromSpring();
    fetchBranchesFromSpring();
  }, []);

  const fetchCarsFromSpring = async () => {
    try {
      const response = await axios.get('http://localhost:8080/samochod'); 
      setCars(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  // const getBase64Image = (car) => {
  //   const base64Data = base64Img.base64Sync(car.zdjecie);
  //   return `data:image/jpeg;base64,${base64Data}`;
  // };
  
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
    idKlienta: '',
    idSamochodu: '',
    idOddzialWypozyczenia: '',
    idOddzialOddania: '',
    terminWypozyczenia: '',
    terminOddania: '',
  });

  const fetchBranchesFromSpring = async () => {
    try {
      const response = await axios.get('http://localhost:8080/oddzial');
      setBranches(response.data);
    } catch (error) {
      console.error(error);
    }
  };

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


  const sendRentalData = async () => {
    try {
      const {
        idKlienta,
        idSamochodu,
        idOddzialWypozyczenia,
        idOddzialOddania,
        terminWypozyczenia,
        terminOddania,
      } = rentalFormData;

      await axios.post(
        'http://localhost:8080/wypozyczenie/nowe',
        null,
        {
          params: {
            idKlienta,
            idSamochodu,
            idOddzialWypozyczenia,
            idOddzialOddania,
            terminWypozyczenia,
            terminOddania,
          },
        }
      );

      setRentalFormData({
        idKlienta: '',
        idSamochodu: '',
        idOddzialWypozyczenia: '',
        idOddzialOddania: '',
        terminWypozyczenia: '',
        terminOddania: '',
      });
      setRentalFormVisible(false);
      alert('Formularz został wysłany');
    } catch (error) {
      console.error(error);
    }
  };

  const getDetailsButtonText = (boxId) => {
    return expandedBoxes.includes(boxId) ? 'Zwiń szczegóły' : 'Wyświetl szczegóły';
  };


    return(
      <>
      <NavBar/>
     
        {/* <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>AUDI</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className="box">
            <h3> e-tron</h3>
            <img src="img/etrontrans2.png" alt="" />
            <span>399 PLN</span>
            <a href="#" id='111' className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3>Q8 e-tron</h3>
            <img src="img/q8etrontrans.png" alt="" />
            <span>1099 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
          <div className="box">
            <h3> RS e-tron GT</h3>
            <img src="img/rsetrontrans.png" alt="" />
            <span>1049 PLN</span>
            <a href="#" className="btn">Wynajmij</a>
            <a href="#" className="details">Wyświetl szczegóły</a>
          </div>
        </div>
      </section> */}
      
<section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>AUDI</h2>
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
                  <input 
                  className="datepicker" 
                  type="date"
                  name="terminWypozyczenia"
                  value={rentalFormData.terminWypozyczenia}
                  onChange={handleFormInputChange}
                  />
                  <p className="popup-input-headers">Miejsce odbioru</p>
                  <select
                  name="idOddzialWypozyczenia"
                   value={rentalFormData.idOddzialWypozyczenia}
                    onChange={handleFormInputChange}
>
                    <option value="">Wybierz oddział</option>
                      {branches.map((branch) => (
                     <option key={branch.idOddzial} value={branch.idOddzial}>
                       {branch.nazwaOddzial}
                      </option>
                      ))}
                    </select>
                  <p className="popup-input-headers">Data zwrotu</p>
                  <input
                      type="date"
                      name="terminOddania"
                      value={rentalFormData.terminOddania}
                      onChange={handleFormInputChange}
                    />

                  <p className="popup-input-headers">Miejsce zwrotu</p>
                  <select
                   name="idOddzialOddania"
                     value={rentalFormData.idOddzialOddania}
                     onChange={handleFormInputChange}
                    >
                     <option value="">Wybierz oddział</option>
                      {branches.map((branch) => (
                   <option key={branch.idOddzial} value={branch.idOddzial}>
                     {branch.nazwaOddzial}
                    </option>
                      ))}
                    </select>
                  <p className="popup-input-headers">Dodatkowe informacje</p>
                  <textarea type="text" placeholder=""></textarea>
                   <button className="popup-inputs-button" onClick={sendRentalData}>
                    Zapisz i prześlij
                  </button>
                </div>
              </div>

            </div> : ""}
        </div>
        <div className="car-details-container container">
          {filteredCarsByBrandId(1).map((car) => (
            <div key={car.idSamochodu} className={`box ${expandedBoxes.includes(car.idSamochodu) ? 'expanded' : ''}`}>
              <h3>{car.modelSamochodu.nazwa}</h3>
              <img src={`data:image/jpeg;base64,${car.zdjecie}`} alt="" />
              <span>{car.cenaSamochodu} PLN</span>
              {expandedBoxes.includes(car.idSamochodu) && (
                <div className="additional-details">
                  <p>Moc silnika: {car.moc_silnika}</p>
                  <p>Pojemność baterii: {car.pojemnosc_baterii}</p>
                  <p>Rok produkcji: {car.rokProdukcji}</p>
                  <p>Kolor samochodu: {car.kolor_samochodu}</p>
                  <p>Ilość drzwi: {car.ilosc_drzwi}</p>
                </div>
              )}
              <a href="#" id="111" className="btn" onClick={() => handleRentClick(car.idSamochodu)}>
                Wynajmij
              </a>
              <a href="#" className="details" onClick={() => handleDetailsClick(car.idSamochodu)}>
                {getDetailsButtonText(car.idSamochodu)}
              </a>
            </div>
          ))}
        </div>
      </section>
      <Footer/>
      </>
    )
}

export default ASection