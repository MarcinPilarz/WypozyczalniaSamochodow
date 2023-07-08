
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
//import base64Img from 'base64-img';

/**
 * Komponent ASection - sekcja wyświetlająca samochody (Audi) i formularz wynajmu.
 */
function ASection() {

  const [cars, setCars] = useState([]);
  const [branches, setBranches] = useState([]);
  const idKlienta = parseInt(localStorage.getItem('idKlienta'));
  useEffect(() => {
    fetchCarsFromSpring();
    fetchBranchesFromSpring();
  }, []);
  const [selectedCarId, setSelectedCarId] = useState(null);
  const [sortByPriceAsc, setSortByPriceAsc] = useState(false);

  /**
 * Pobiera szczegóły samochodów z serwera Spring.
 */
  const fetchCarsFromSpring = async () => {
    try {
      const response = await axios.get('http://localhost:8080/samochod'); 
      const carsData = response.data.map((car) => ({
        ...car,
        czyWypozyczony: car.czyWypozyczony === 'true',
      }));
      setCars(response.data);
      //console.log(carsData);
      //setCars(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  // const getBase64Image = (car) => {
  //   const base64Data = base64Img.base64Sync(car.zdjecie);
  //   return `data:image/jpeg;base64,${base64Data}`;
  // };
  
  /**
 * Filtruje samochody na podstawie identyfikatora marki.
 * @param {number} brandId - Identyfikator marki.
 * @returns {Array} - Tablica samochodów spełniających kryteria filtrowania.
 */
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
    idKlienta: idKlienta || '', // Ustawienie wartości początkowej na idKlienta z localStorage lub pustą wartość, jeśli nie ma wartości w localStorage
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
  
  /**
 * Obsługuje kliknięcie przycisku "Wynajmij".
 * @param {number} carId - Identyfikator samochodu.
 */
  const handleRentClick = (carId) => {
    setRentalFormData({ ...rentalFormData, idSamochodu: carId });
    setPop(!popup);
  }

  const closePopUp = () => {
    setPop(false)
  }
  const handleFormInputChange = (e) => {
    const { name, value } = e.target;
    setRentalFormData({ ...rentalFormData, [name]: value });
  };


 
  // const handleFormSubmit = (e) => {
  //   e.preventDefault();
  //   // Przetwarzanie danych z formularza
  //   console.log(rentalFormData);
  //   // Możesz dodać tutaj kod do wysłania danych lub innych operacji
  //   setRentalFormVisible(false);
  //   setRentalFormData({
  //     carName: '',
  //     fullName: '',
  //     email: '',
  //     phone: '',
  //   });
  //   alert('Formularz został wysłany');
  // };

  const handleFormSubmit = (e) => {
    e.preventDefault();
    // Przetwarzanie danych z formularza
    console.log(rentalFormData);
    // Możesz dodać tutaj kod do wysłania danych lub innych operacji
    setRentalFormVisible(false);
    setRentalFormData({
      idKlienta: idKlienta || '', // Ustawienie wartości początkowej na idKlienta z localStorage lub pustą wartość, jeśli nie ma wartości w localStorage
      idSamochodu: selectedCarId, 
      idOddzialWypozyczenia: '',
      idOddzialOddania: '',
      terminWypozyczenia: '',
      terminOddania: '',
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
      console.log("idKlienta:", idKlienta); // Dodaj tę linię
      console.log("idSamochodu:", idSamochodu); // Dodaj tę linię
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
        idKlienta: idKlienta || '', // Ustawienie wartości początkowej na idKlienta z localStorage lub pustą wartość, jeśli nie ma wartości w localStorage
        idSamochodu: selectedCarId, 
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

  const fetchCars = async () => {
    try {
      const endpoint = sortByPriceAsc ? '/sortowanie/Cena' : '/sortowanie/Cena/malejaco';
      const response = await axios.get(`http://localhost:8080${endpoint}`);
      setCars(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const handleSortByPrice = async () => {
    setSortByPriceAsc(!sortByPriceAsc);
    fetchCars();
  };

    return(
      <>
      <NavBar/>     
<section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>AUDI</h2>
          <p>Elektryczne</p>
        </div>
        <button className='sort-button' onClick={handleSortByPrice}>
        {sortByPriceAsc ? 'Sortuj rosnąco' : 'Sortuj malejąco'}
      </button>
        <div>
          {popup ?
            <div className="popup-container">
              <div className="popup">
                <div className="popup-header">
                  <h3 className="popup-header-text">Formularz wynajmu</h3>
                  <button className="close-btn" onClick={closePopUp}>X</button>
                </div>

                <input
  type="hidden"
  name="idKlienta"
  value={rentalFormData.idKlienta || ''}
  readOnly
/>
              <input
                type="hidden"
                name="idSamochodu"
                value={rentalFormData.idSamochodu || ''}
                readOnly
                />
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
              {/* <p>Wypożyczony: {car.czyWypozyczony.toString()}</p> */}
              {expandedBoxes.includes(car.idSamochodu) && (
                <div className="additional-details">
                  <p>Moc silnika: {car.moc_silnika}</p>
                  <p>Pojemność baterii: {car.pojemnosc_baterii}</p>
                  <p>Rok produkcji: {car.rokProdukcji}</p>
                  <p>Kolor samochodu: {car.kolor_samochodu}</p>
                  <p>Ilość drzwi: {car.ilosc_drzwi}</p>
                </div>
              )}
             {car.czyWypozyczony ? (
  <a href="#" id="111" className="btn btn-gray disabled-link">
    Wynajęty
  </a>
) : (
  <a href="#" id="111" className="btn btn-blue" onClick={() => handleRentClick(car.idSamochodu)}>
    Wynajmij
  </a>
)}
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