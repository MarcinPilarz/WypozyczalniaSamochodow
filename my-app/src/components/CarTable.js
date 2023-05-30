import React, { useState, useEffect } from 'react';
import "../CarTable.css";

const CarTable = () => {
  const [cars, setCars] = useState([]);
  const [formData, setFormData] = useState({
    pojemnosc_baterii: '',
    ilosc_drzwi: '',
    kolor_samochodu: '',
    moc_silnika: '',
    rokProdukcji: '',
    cenaSamochodu: '',
    oddzial: '',
    modelSamochodu: '',
    marka: ''
  });
  const [oddzialList, setOddzialList] = useState([]);
  const [modelSamochoduList, setModelSamochoduList] = useState([]);
  const [markaList, setMarkaList] = useState([]);
  const [editCarId, setEditCarId] = useState(null);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch('http://localhost:8080/samochod');
      const data = await response.json();
      setCars(data);

      const oddzialResponse = await fetch('http://localhost:8080/oddzial');
      const oddzialData = await oddzialResponse.json();
      setOddzialList(oddzialData);

      const modelSamochoduResponse = await fetch('http://localhost:8080/model');
      const modelSamochoduData = await modelSamochoduResponse.json();
      setModelSamochoduList(modelSamochoduData);

      const markaResponse = await fetch('http://localhost:8080/marka');
      const markaData = await markaResponse.json();
      setMarkaList(markaData);
    } catch (error) {
      console.error(error);
    }
  };

  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/samochod', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          pojemnosc_baterii: formData.pojemnosc_baterii,
          ilosc_drzwi: formData.ilosc_drzwi,
          kolor_samochodu: formData.kolor_samochodu,
          moc_silnika: formData.moc_silnika,
          rokProdukcji: formData.rokProdukcji,
          cenaSamochodu: formData.cenaSamochodu,
          czyWypozyczony: true,
          zdjecie: '',
          klienci: [],
          oddzial: {
            idOddzial: formData.oddzial,
            nazwaOddzial: ''
          },
          ubezpieczenia: [],
          modelSamochodu: {
            id: formData.modelSamochodu,
            nazwaModelu: '',
            rokProdukcji: ''
          },
          marka: {
            idMarka: formData.marka,
            nazwaMarka: ''
          }
        })
      });

      if (response.ok) {
        fetchData();
        setFormData({
          pojemnosc_baterii: '',
          ilosc_drzwi: '',
          kolor_samochodu: '',
          moc_silnika: '',
          rokProdukcji: '',
          cenaSamochodu: '',
          oddzial: '',
          modelSamochodu: '',
          marka: ''
        });
      }
    } catch (error) {
      console.error(error);
    }
  };

  const deleteCar = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/samochod?id=${id}`, {
        method: 'DELETE'
      });

      if (response.ok) {
        fetchData();
      }
    } catch (error) {
      console.error(error);
    }
  };

  const editCar = (id) => {
    setEditCarId(id);
    const carToEdit = cars.find((car) => car.idSamochodu === id);
    setFormData({
      pojemnosc_baterii: carToEdit.pojemnosc_baterii,
      ilosc_drzwi: carToEdit.ilosc_drzwi,
      kolor_samochodu: carToEdit.kolor_samochodu,
      moc_silnika: carToEdit.moc_silnika,
      rokProdukcji: carToEdit.rokProdukcji,
      cenaSamochodu: carToEdit.cenaSamochodu,
      oddzial: carToEdit.oddzial.idOddzial,
      modelSamochodu: carToEdit.modelSamochodu.id,
      marka: carToEdit.marka.idMarka
    });
  };

  const updateCar = async () => {
    try {
      const response = await fetch(`http://localhost:8080/samochod?id=${editCarId}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          pojemnosc_baterii: formData.pojemnosc_baterii,
          ilosc_drzwi: formData.ilosc_drzwi,
          kolor_samochodu: formData.kolor_samochodu,
          moc_silnika: formData.moc_silnika,
          rokProdukcji: formData.rokProdukcji,
          cenaSamochodu: formData.cenaSamochodu,
          czyWypozyczony: true,
          zdjecie: '',
          klienci: [],
          oddzial: {
            idOddzial: formData.oddzial,
            nazwaOddzial: ''
          },
          ubezpieczenia: [],
          modelSamochodu: {
            id: formData.modelSamochodu,
            nazwaModelu: '',
            rokProdukcji: ''
          },
          marka: {
            idMarka: formData.marka,
            nazwaMarka: ''
          }
        })
      });

      if (response.ok) {
        fetchData();
        setEditCarId(null);
        setFormData({
          pojemnosc_baterii: '',
          ilosc_drzwi: '',
          kolor_samochodu: '',
          moc_silnika: '',
          rokProdukcji: '',
          cenaSamochodu: '',
          oddzial: '',
          modelSamochodu: '',
          marka: ''
        });
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <table className="car-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Pojemność baterii</th>
            <th>Ilość drzwi</th>
            <th>Kolor samochodu</th>
            <th>Moc silnika</th>
            <th>Rok produkcji</th>
            <th>Cena samochodu</th>
            <th>Oddział</th>
            <th>Model samochodu</th>
            <th>Marka</th>
            <th>Akcje</th>
          </tr>
        </thead>
        <tbody>
          {cars.map((car) => (
            <tr key={car.idSamochodu}>
              <td>{car.idSamochodu}</td>
              <td>{car.pojemnosc_baterii}</td>
              <td>{car.ilosc_drzwi}</td>
              <td>{car.kolor_samochodu}</td>
              <td>{car.moc_silnika}</td>
              <td>{car.rokProdukcji}</td>
              <td>{car.cenaSamochodu}</td>
              <td>{car.oddzial.nazwaOddzial}</td>
              <td>{car.modelSamochodu.nazwaModelu}</td>
              <td>{car.marka.nazwaMarka}</td>
              <td>
                {editCarId === car.idSamochodu ? (
                  <>
                    <button onClick={updateCar}>Zapisz</button>
                    <button onClick={() => setEditCarId(null)}>Anuluj</button>
                  </>
                ) : (
                  <>
                    <button onClick={() => editCar(car.idSamochodu)}>Edytuj</button>
                    <button onClick={() => deleteCar(car.idSamochodu)}>Usuń</button>
                  </>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <form onSubmit={handleFormSubmit}>
        <label>
          Pojemność baterii:
          <input type="text" name="pojemnosc_baterii" value={formData.pojemnosc_baterii} onChange={handleInputChange} />
        </label>
        <label>
          Ilość drzwi:
          <input type="text" name="ilosc_drzwi" value={formData.ilosc_drzwi} onChange={handleInputChange} />
        </label>
        <label>
          Kolor samochodu:
          <input type="text" name="kolor_samochodu" value={formData.kolor_samochodu} onChange={handleInputChange} />
        </label>
        <label>
          Moc silnika:
          <input type="text" name="moc_silnika" value={formData.moc_silnika} onChange={handleInputChange} />
        </label>
        <label>
          Rok produkcji:
          <input type="text" name="rokProdukcji" value={formData.rokProdukcji} onChange={handleInputChange} />
        </label>
        <label>
          Cena samochodu:
          <input type="text" name="cenaSamochodu" value={formData.cenaSamochodu} onChange={handleInputChange} />
        </label>
        <label>
          Oddział:
          <select name="oddzial" value={formData.oddzial} onChange={handleInputChange}>
            <option value="">Wybierz oddział</option>
            {oddzialList.map((oddzial) => (
              <option key={oddzial.idOddzial} value={oddzial.idOddzial}>
                {oddzial.nazwaOddzial}
              </option>
            ))}
          </select>
        </label>
        <label>
          Model samochodu:
          <select name="modelSamochodu" value={formData.modelSamochodu} onChange={handleInputChange}>
            <option value="">Wybierz model samochodu</option>
            {modelSamochoduList.map((model) => (
              <option key={model.id} value={model.id}>
                {model.nazwaModelu}
              </option>
            ))}
          </select>
        </label>
        <label>
          Marka:
          <select name="marka" value={formData.marka} onChange={handleInputChange}>
            <option value="">Wybierz markę</option>
            {markaList.map((marka) => (
              <option key={marka.idMarka} value={marka.idMarka}>
                {marka.nazwaMarka}
              </option>
            ))}
          </select>
        </label>
        <button type="submit">Dodaj</button>
      </form>
    </div>
  );
};

export default CarTable;
