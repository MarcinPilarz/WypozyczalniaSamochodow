
import '../App.css';
import NavBar from './NavBar';
import Footer from './Footer';
import React, { useEffect, useState } from 'react';
import Modal from 'react-modal';

function BMWSection() {
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

  const handleRentClick = (carName) => {
    setRentalFormData({ ...rentalFormData, carName });
    setRentalFormVisible(true);
  };

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

  return (
    <>
      <NavBar />

      <section className="car-details" id="car-details">
        <div className="car-details-heading" id="111">
          <h2 style={{ margin: '30px' }}>BMW</h2>
          <p>Elektryczne</p>
        </div>
        <div className="car-details-container container">
          <div className={`box ${expandedBoxes.includes('box1') ? 'expanded' : ''}`}>
            <h3>I3</h3>
            <img src="img/bmw-i3 transpppp.png" alt="" />
            <span>199 PLN</span>
            {expandedBoxes.includes('box1') && (
              <div className="additional-details">
                <p>Moc silnika:</p>
                <p>Pojemność baterii:</p>
                <p>Rok produkcji:</p>
                <p>Kolor samochodu:</p>
                <p>Ilość drzwi:</p>
              </div>
            )}
            <a href="#" id="111" className="btn" onClick={() => handleRentClick('I3')}>
              Wynajmij
            </a>
            <a href="#" className="details" onClick={() => handleDetailsClick('box1')}>
              {getDetailsButtonText('box1')}
              </a>
          </div>
          <div className={`box ${expandedBoxes.includes('box3') ? 'expanded' : ''}`}>
            <h3>IX</h3>
            <img src="img/ix_trans-removebg-preview.png" alt="" />
            <span>700 PLN</span>
            {expandedBoxes.includes('box3') && (
              <div className="additional-details">
                <p>Moc silnika:</p>
                <p>Pojemność baterii:</p>
                <p>Rok produkcji:</p>
                <p>Kolor samochodu:</p>
                <p>Ilość drzwi:</p>
              </div>
            )}
            <a href="#" id="111" className="btn" onClick={() => handleRentClick('IX')}>
              Wynajmij
            </a>
            <a href="#" className="details" onClick={() => handleDetailsClick('box3')}>
              {getDetailsButtonText('box3')}
            </a>
          </div>
          <div className={`box ${expandedBoxes.includes('box2') ? 'expanded' : ''}`}>
            <h3>I8</h3>
            <img src="img/abmw trans.png" alt="" />
            <span>1099 PLN</span>
            {expandedBoxes.includes('box2') && (
              <div className="additional-details">
                <p>Moc silnika:</p>
                <p>Pojemność baterii:</p>
                <p>Rok produkcji:</p>
                <p>Kolor samochodu:</p>
                <p>Ilość drzwi:</p>
              </div>
            )}
            <a href="#" className="btn" onClick={() => handleRentClick('I8')}>
              Wynajmij
            </a>
            <a href="#" className="details" onClick={() => handleDetailsClick('box2')}>
              {getDetailsButtonText('box2')}
            </a>
          </div>
        </div>
      </section>

      {/* <Modal 
        isOpen={rentalFormVisible}
        onRequestClose={() => setRentalFormVisible(false)}
        contentLabel="Formularz wynajmu"
      >
        <div class="modal">
        <h2>Formularz wynajmu</h2>
        <form onSubmit={handleFormSubmit}>
          <label htmlFor="fullName">Imię i nazwisko:</label>
          <input
            type="text"
            id="fullName"
            name="fullName"
            value={rentalFormData.fullName}
            onChange={handleFormInputChange}
            required
          />

          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={rentalFormData.email}
            onChange={handleFormInputChange}
            required
          />

          <label htmlFor="phone">Numer telefonu:</label>
          <input
            type="text"
            id="phone"
            name="phone"
            value={rentalFormData.phone}
            onChange={handleFormInputChange}
            required
          />

          <input type="submit" value="Wyślij" />
        </form>
        </div>
      </Modal> */}

      <Footer />
    </>
  );
}

export default BMWSection;